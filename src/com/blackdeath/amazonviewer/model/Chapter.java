package com.blackdeath.amazonviewer.model;

import java.util.ArrayList;

public class Chapter extends Movie {

	private int id;
	private int sessionNumber;
	private Serie serie;

	public Chapter(String title, String genre, String creator, int duration, short year, int sessionNumber,
			Serie serie) {
		super(title, genre, creator, duration, year);
		this.setSessionNumber(sessionNumber);
		this.setSerie(serie);
	}

	@Override
	public int getId() {
		return this.id;
	}

	public int getSessionNumber() {
		return sessionNumber;
	}

	public void setSessionNumber(int sessionNumber) {
		this.sessionNumber = sessionNumber;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public static ArrayList<Chapter> makeLostChapters(Serie serie) {
		ArrayList<Chapter> chapters = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			chapters.add(
					new Chapter("Chapter" + i, "Ciencia Ficción", "Creator" + i, (45 + i), (short) 2004, 1, serie));
		}

		return chapters;
	}

	public static ArrayList<Chapter> makeBlackMirrorChapters(Serie serie) {
		ArrayList<Chapter> chapters = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			chapters.add(
					new Chapter("Chapter" + i, "Ciencia Ficción", "Creator" + i, (45 + i), (short) 2004, 1, serie));
		}

		return chapters;
	}

	@Override
	public void view() {
		super.view();

		ArrayList<Chapter> chapters = getSerie().getChapters();

		int chapterViewedCounter = 0;

		for (Chapter chapter : chapters) {
			if (chapter.getIsViewed()) {
				chapterViewedCounter++;
			}
		}

		if (chapterViewedCounter == chapters.size()) {
			getSerie().view();
		}

	}

	@Override
	public String toString() {
		return "\n :: CHAPTER ::" + "\n Title: " + getTitle() + "\n Genre: " + getGenre() + "\n Year: " + getYear()
				+ "\n Creator: " + getCreator() + "\n Duration: " + getDuration();
	}

}
