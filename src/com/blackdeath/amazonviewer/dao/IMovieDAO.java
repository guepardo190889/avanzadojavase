package com.blackdeath.amazonviewer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.blackdeath.amazonviewer.db.IDBConenection;
import com.blackdeath.amazonviewer.model.Movie;

import static com.blackdeath.amazonviewer.db.DataBase.*;

public interface IMovieDAO extends IDBConenection {

	default Movie setMovieViewed(Movie movie) {
		try (Connection conn = connectToDB()) {
			String query = "INSERT INTO " + T_VIEWED + " (" + T_VIEWED_ID_MATERIAL + "," + T_VIEWED_ID_ELEMENT + ","
					+ T_VIEWED_ID_USER + ") VALUES (?,?,?);";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, ID_MATERIAL[0]);
			ps.setInt(2, movie.getId());
			ps.setInt(3, ID_USUARIO);

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
			// TODO: handle exception
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
			ps.setInt(1, ID_MATERIAL[0]);
			ps.setInt(2, id_movie);
			ps.setInt(3, ID_USUARIO);

			rs = ps.executeQuery();

			viewed = rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return viewed;
	}

}
