package com.blackdeath.amazonviewer.dao;

import static com.blackdeath.amazonviewer.db.DataBase.ID_USUARIO;
import static com.blackdeath.amazonviewer.db.DataBase.T_MOVIE;
import static com.blackdeath.amazonviewer.db.DataBase.T_MOVIE_CREATOR;
import static com.blackdeath.amazonviewer.db.DataBase.T_MOVIE_DURATION;
import static com.blackdeath.amazonviewer.db.DataBase.T_MOVIE_GENRE;
import static com.blackdeath.amazonviewer.db.DataBase.T_MOVIE_ID;
import static com.blackdeath.amazonviewer.db.DataBase.T_MOVIE_TITLE;
import static com.blackdeath.amazonviewer.db.DataBase.T_MOVIE_YEAR;
import static com.blackdeath.amazonviewer.db.DataBase.T_VIEWED;
import static com.blackdeath.amazonviewer.db.DataBase.T_VIEWED_DATE_VIEWED;
import static com.blackdeath.amazonviewer.db.DataBase.T_VIEWED_ID_ELEMENT;
import static com.blackdeath.amazonviewer.db.DataBase.T_VIEWED_ID_MATERIAL;
import static com.blackdeath.amazonviewer.db.DataBase.T_VIEWED_ID_USER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.blackdeath.amazonviewer.db.IDBConenection;
import com.blackdeath.amazonviewer.enums.Material;
import com.blackdeath.amazonviewer.model.Movie;

public interface IMovieDAO extends IDBConenection {

	default Movie setMovieViewed(Movie movie) {
		try (Connection conn = connectToDB()) {
			String query = "INSERT INTO " + T_VIEWED + " (" + T_VIEWED_ID_MATERIAL + "," + T_VIEWED_ID_ELEMENT + ","
					+ T_VIEWED_ID_USER + "," + T_VIEWED_DATE_VIEWED + ") VALUES (?,?,?,?);";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Material.MOVIE.getTipo());
			ps.setInt(2, movie.getId());
			ps.setInt(3, ID_USUARIO);
			ps.setTimestamp(4, new Timestamp(new Date().getTime()));

			// System.out.println("query: " + ps.toString());

			if (ps.executeUpdate() > 0) {
				System.out.println("Se marcó en visto");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movie;
	}

	default ArrayList<Movie> read() {
		ArrayList<Movie> movies = new ArrayList<>();

		try (Connection connection = connectToDB()) {
			String query = "SELECT * FROM " + T_MOVIE;

			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Movie movie = new Movie(rs.getString(T_MOVIE_TITLE), rs.getString(T_MOVIE_GENRE),
						rs.getString(T_MOVIE_CREATOR), rs.getInt(T_MOVIE_DURATION), rs.getShort(T_MOVIE_YEAR));
				movie.setId(rs.getInt(T_MOVIE_ID));
				movie.setViewed(getMovieViewed(ps, connection, movie.getId()));

				movies.add(movie);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return movies;
	}

	default ArrayList<Movie> getMoviesViewedByDate(Date date) {
		ArrayList<Movie> movies = new ArrayList<>();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		String fechaBase = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-"
				+ cal.get(Calendar.DAY_OF_MONTH);

		try (Connection connection = connectToDB()) {
			StringBuilder query = new StringBuilder();
			query.append("SELECT * ");
			query.append("FROM ").append(T_VIEWED).append(" v ");
			query.append("LEFT JOIN ").append(T_MOVIE).append(" m ON m.").append(T_MOVIE_ID).append("=").append("v.")
					.append(T_VIEWED_ID_ELEMENT);
			query.append(" WHERE v.").append(T_VIEWED_ID_MATERIAL).append("=").append(Material.MOVIE.getTipo());
			query.append(" AND v.").append(T_VIEWED_ID_USER).append("=").append(ID_USUARIO);
			query.append(" AND v.").append(T_VIEWED_DATE_VIEWED).append(">?");
			query.append(" AND v.").append(T_VIEWED_DATE_VIEWED).append("<?");

			PreparedStatement ps = connection.prepareStatement(query.toString());
			ps.setString(1, fechaBase + " 00:00:00");
			ps.setString(2, fechaBase + " 23:59:59");

			// System.out.println("query: " + ps.toString());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Movie movie = new Movie(rs.getString("m." + T_MOVIE_TITLE), rs.getString("m." + T_MOVIE_GENRE),
						rs.getString("m." + T_MOVIE_CREATOR), rs.getInt("m." + T_MOVIE_DURATION),
						rs.getShort("m." + T_MOVIE_YEAR));
				movie.setId(rs.getInt("m." + T_MOVIE_ID));
				movie.setViewed(getMovieViewed(ps, connection, movie.getId()));

				movies.add(movie);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return movies;
	}

	private boolean getMovieViewed(PreparedStatement ps, Connection conn, int id_movie) {
		boolean viewed = false;

		String query = "SELECT * FROM " + T_VIEWED + " WHERE " + T_VIEWED_ID_MATERIAL + "= ? " + " AND "
				+ T_VIEWED_ID_ELEMENT + "= ?" + " AND " + T_VIEWED_ID_USER + "= ?";

		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, Material.MOVIE.getTipo());
			ps.setInt(2, id_movie);
			ps.setInt(3, ID_USUARIO);

			// System.out.println("query: " + ps.toString());

			rs = ps.executeQuery();

			viewed = rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return viewed;
	}

}
