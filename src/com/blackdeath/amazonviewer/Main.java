package com.blackdeath.amazonviewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.blackdeath.amazonviewer.model.Book;
import com.blackdeath.amazonviewer.model.Chapter;
import com.blackdeath.amazonviewer.model.Magazine;
import com.blackdeath.amazonviewer.model.Movie;
import com.blackdeath.amazonviewer.model.Serie;
import com.blackdeath.amazonviewer.util.AmazonUtil;
import com.blackdeath.makereport.Report;

/**
 * <H1>AmazonViewer</h1> AmazonViewer es un programa que permite veisualiza
 * Movies, Series, Bookes y Maagazines. También te permite generar reportes
 * generales y con la fecha del día.
 * <p>
 * Existen algunas reglas como que todos elementos peuden ser visualizados o
 * leídos a excepción d elos Magazines.
 * 
 * @author Seth Luis
 * @version 1.0
 * @since 2018
 *
 */
public class Main {

	private static ArrayList<Movie> movies = new ArrayList<>();
	private static ArrayList<Serie> series = Serie.makeSeriesList();
	private static ArrayList<Book> books = Book.makeBooksList();
	private static ArrayList<Magazine> magazines = Magazine.makeMagazineList();

	public static void main(String[] args) {
		showMenu();
	}

	public static void showMenu() {
		int exit = 1;
		do {
			System.out.println("BIENVENIDOS AMAZON VIEWER");
			System.out.println("");
			System.out.println("Selecciona el número de la opción deseada");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("3. Books");
			System.out.println("4. Magazines");
			System.out.println("5. Report");
			System.out.println("6. Report Today");
			System.out.println("0. Exit");

			// Leer la respuesta del usuario
			int response = AmazonUtil.validaRespuestaMenu(0, 6);

			switch (response) {
			case 0:
				// salir
				exit = 0;
				break;
			case 1:
				showMovies();
				break;
			case 2:
				showSeries();
				break;
			case 3:
				showBooks();
				break;
			case 4:
				showMagazines();
				break;
			case 5:
				makeReport();
				break;
			case 6:
				makeReport(new Date());
				break;

			default:
				System.out.println();
				System.out.println("....¡¡¡Selecciona una opción!!!....");
				System.out.println();
				break;
			}

		} while (exit != 0);
	}

	public static void showMovies() {
		if (movies == null || movies.isEmpty()) {
			movies = Movie.makeMoviesList();
		}

		int exit = 1;

		do {
			System.out.println();
			System.out.println(":: MOVIES ::");
			System.out.println();

			for (int i = 0; i < movies.size(); i++) {
				System.out
						.println((i + 1) + ". " + movies.get(i).getTitle() + " - Viewed: " + movies.get(i).isViewed());
			}

			System.out.println("0. Regresar al Menú");
			System.out.println();

			int respuesta = AmazonUtil.validaRespuestaMenu(0, movies.size());

			if (0 == respuesta) {
				exit = 0;
				showMenu();
				break;
			} else if (respuesta > 0) {
				Movie movieSelected = movies.get(respuesta - 1);
				movieSelected.view();
			}
		} while (exit != 0);
	}

	public static void showSeries() {
		int exit = 1;

		do {
			System.out.println();
			System.out.println(":: SERIES ::");
			System.out.println();

			for (int i = 0; i < series.size(); i++) {
				System.out
						.println((i + 1) + ". " + series.get(i).getTitle() + " - Viewed: " + series.get(i).isViewed());
			}

			System.out.println("0. Regresar al Menú");
			System.out.println();

			int respuesta = AmazonUtil.validaRespuestaMenu(0, series.size());

			if (0 == respuesta) {
				exit = 0;
				showMenu();
				break;
			} else if (respuesta > 0) {
				Serie serieSelected = series.get(respuesta - 1);
				showChapters(serieSelected.getChapters());
			}
		} while (exit != 0);
	}

	public static void showChapters(ArrayList<Chapter> chapters) {
		int exit = 1;
		do {
			System.out.println();
			System.out.println(":: CHAPTERS ::");
			System.out.println();

			for (int i = 0; i < chapters.size(); i++) {
				System.out.println(
						(i + 1) + ". " + chapters.get(i).getTitle() + " - Viewed: " + chapters.get(i).isViewed());
			}

			System.out.println("0. Regresar a Series");
			System.out.println();

			int respuesta = AmazonUtil.validaRespuestaMenu(0, chapters.size());

			if (0 == respuesta) {
				exit = 0;
				showSeries();
				break;
			} else if (respuesta > 0) {
				Chapter chapterSelected = chapters.get(respuesta - 1);
				chapterSelected.view();
			}
		} while (exit != 0);
	}

	public static void showBooks() {
		int exit = 1;

		do {
			System.out.println();
			System.out.println(":: BOOKS ::");
			System.out.println();

			for (int i = 0; i < books.size(); i++) {
				System.out.println((i + 1) + ". " + books.get(i).getTitle() + " - Readed: " + books.get(i).isReaded());
			}

			System.out.println("0. Regresar al Menú");
			System.out.println();

			int respuesta = AmazonUtil.validaRespuestaMenu(0, books.size());

			if (0 == respuesta) {
				exit = 0;
				showMenu();
				break;
			} else if (respuesta > 0) {
				Book bookSelected = books.get(respuesta - 1);
				bookSelected.view();
			}
		} while (exit != 0);
	}

	public static void showMagazines() {
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: MAGAZINES ::");
			System.out.println();

			for (int i = 0; i < magazines.size(); i++) {
				System.out.println(i + 1 + ". " + magazines.get(i).getTitle());
			}

			System.out.println("0. Regresar al Menu");
			System.out.println();

			int respuesta = AmazonUtil.validaRespuestaMenu(0, magazines.size());

			if (respuesta == 0) {
				exit = 0;
				showMenu();
				break;
			}

		} while (exit != 0);
	}

	public static void makeReport() {
		if (movies == null || movies.isEmpty()) {
			movies = Movie.makeMoviesList();
		}

		if (series == null || series.isEmpty()) {
			series = Serie.makeSeriesList();
		}

		if (books == null || books.isEmpty()) {
			books = Book.makeBooksList();
		}

		Report report = new Report();
		report.setNameFile("reporte");
		report.setTitle(":: VISTOS ::");
		report.setExtension("txt");

		StringBuilder contentReport = new StringBuilder();

		contentReport.append(getDataContentReport(movies, series, books));

		report.setContent(contentReport.toString());
		report.makeReport();

		System.out.println("Reporte Generado");
		System.out.println();
	}

	public static void makeReport(Date date) {
		Movie movie = new Movie();
		ArrayList<Movie> movies = movie.getMoviesViewedByDate(date);
		ArrayList<Serie> series = new ArrayList<>();
		ArrayList<Book> books = new ArrayList<>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-h-m-s-S");
		SimpleDateFormat dfNameDays = new SimpleDateFormat("E, W MMM Y");

		Report report = new Report();
		report.setNameFile("reporte" + sdf.format(date));
		report.setTitle(":: VISTOS ::");
		report.setExtension("txt");

		StringBuilder contentReport = new StringBuilder();
		contentReport.append("Date: ").append(dfNameDays.format(date)).append("\n\n\n");
		contentReport.append(getDataContentReport(movies, series, books));

		report.setContent(contentReport.toString());
		report.makeReport();

		System.out.println("Reporte Generado");
		System.out.println();
	}

	private static String getDataContentReport(ArrayList<Movie> movies, ArrayList<Serie> series,
			ArrayList<Book> books) {
		StringBuilder sb = new StringBuilder();

		if (movies != null && !movies.isEmpty()) {
			for (Movie movie : movies) {
				if (movie.getIsViewed()) {
					sb.append(movie.toString()).append("\n");
				}
			}
		}

		if (series != null && !series.isEmpty()) {
			for (Serie serie : series) {
				ArrayList<Chapter> chapters = serie.getChapters();
				for (Chapter chapter : chapters) {
					if (chapter.getIsViewed()) {
						sb.append(chapter.toString()).append("\n");
					}
				}
			}
		}

		if (books != null && !books.isEmpty()) {
			for (Book book : books) {
				if (book.getIsReaded()) {
					sb.append(book.toString()).append("\n");
				}
			}
		}

		return sb.toString();
	}

}
