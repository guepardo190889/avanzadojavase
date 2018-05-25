package com.blackdeath.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Hereda de {@link Film} Implementa {@link IVisualizable}}
 * 
 * @author Seth Luis
 *
 */
public class Movie extends Film implements IVisualizable {

	private int id;
	private int timeViewed;

	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		setYear(year);
	}

	public int getId() {
		return id;
	}

	public int getTimeViewed() {
		return timeViewed;
	}

	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date startToSee(Date dateI) {
		return dateI;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stopToSee(Date dateI, Date dateF) {
		if (dateF.getTime() > dateI.getTime()) {
			setTimeViewed((int) (dateF.getTime() - dateI.getTime()));
		} else {
			setTimeViewed(0);
		}
	}

	public static ArrayList<Movie> makeMoviesList() {
		ArrayList<Movie> movies = new ArrayList<>();
		movies.add(new Movie("El juego de Ender", "Ciencia Ficción", "Gavin Hood", 114, (short) 2013));
		movies.add(new Movie("Titanes del Pacífico", "Ciencia Ficción", "Guillermo del Toro", 132, (short) 2013));
		movies.add(new Movie("Interestelar ", "Ciencia Ficción", "Christopher Nolan", 169, (short) 2014));
		movies.add(new Movie("Contacto", "Ciencia Ficción", "Robert Zemeckis", 149, (short) 1997));
		movies.add(new Movie("Coherence", "Ciencia Ficción, Suspenso", "James Ward Byrkit", 89, (short) 2013));
		movies.add(new Movie("El Origen", "Drama, Suspenso, Acción", "Christopher Nolan", 148, (short) 2010));
		movies.add(new Movie("Wall-E", "Ciencia Ficción", "Andrew Stanton", 98, (short) 2008));
		movies.add(new Movie("Matrix", "Ciencia Ficción", "Hermanos Wachowski", 136, (short) 1999));
		movies.add(new Movie("Avatar", "Ciencia Ficción", "James Cameron", 162, (short) 2009));
		movies.add(new Movie("A.I. Inteligencia Artificial", "Ciencia Ficción", "Steven Spielberg", 146, (short) 2001));
		movies.add(new Movie("Prometheus", "Ciencia Ficción", "Ridley Scott", 124, (short) 2012));
		movies.add(new Movie("Minority Report", "Ciencia Ficción", "Steven Spielberg", 145, (short) 2002));
		movies.add(new Movie("El quinto elemento", "Ciencia Ficción", "Luc Besson", 127, (short) 1997));
		movies.add(new Movie("Yo, robot ", "Ciencia Ficción", "Alex Proyas", 115, (short) 2004));

		return movies;
	}

	@Override
	public String toString() {
		return "\n :: MOVIE ::" + "\n Title: " + getTitle() + "\n Genre: " + getGenre() + "\n Year: " + getYear()
				+ "\n Creator: " + getCreator() + "\n Duration: " + getDuration();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void view() {
		setViewed(true);

		Date dateI = startToSee(new Date());
		play();
		stopToSee(dateI, new Date());

		System.out.println();
		System.out.println("Viste: " + toString());
		System.out.println("Por: " + getTimeViewed() + " milisegundos");
	}

}
