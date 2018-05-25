package com.blackdeath.amazonviewer.model;

import java.util.ArrayList;

public class Serie extends Film {

	private int id;
	private int sessionQuantity;
	private ArrayList<Chapter> chapters;

	public Serie(String title, String genre, String creator, int duration, int sessionQuantity) {
		super(title, genre, creator, duration);
		this.sessionQuantity = sessionQuantity;
	}

	public int getId() {
		return id;
	}

	public int getSessionQuantity() {
		return sessionQuantity;
	}

	public void setSessionQuantity(int sessionQuantity) {
		this.sessionQuantity = sessionQuantity;
	}

	public ArrayList<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(ArrayList<Chapter> chapters) {
		this.chapters = chapters;
	}

	public static ArrayList<Serie> makeSeriesList() {
		ArrayList<Serie> series = new ArrayList<>();

		Serie lost = new Serie("Lost", "Ciencia Ficción", "J.J. Abrams", 43, 6);
		lost.setChapters(Chapter.makeLostChapters(lost));
		series.add(lost);

		Serie blackMirror = new Serie("Black Mirror", "Ciencia Ficción", "Charlie Brooker", 44, 4);
		blackMirror.setChapters(Chapter.makeBlackMirrorChapters(blackMirror));

		series.add(blackMirror);

		return series;
	}

	@Override
	public void view() {
		setViewed(true);
	}

	@Override
	public String toString() {
		return "\n :: SERIE ::" + "\n Title: " + getTitle() + "\n Genre: " + getGenre() + "\n Year: " + getYear()
				+ "\n Creator: " + getCreator() + "\n Duration: " + getDuration() + "\n Session Quantity: "
				+ getSessionQuantity();
	}

}
