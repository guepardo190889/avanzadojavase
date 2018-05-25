package com.blackdeath.amazonviewer.model;

import java.util.ArrayList;

public class Chapter extends Movie {

	private int id;
	private int sessionNumber;

	public Chapter(String title, String genre, String creator, int duration, short year, int sessionNumber) {
		super(title, genre, creator, duration, year);
		this.sessionNumber = sessionNumber;
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

	@Override
	public String toString() {
		return "\n :: CHAPTER ::" + "\n Title: " + getTitle() + "\n Genre: " + getGenre() + "\n Year: " + getYear()
				+ "\n Creator: " + getCreator() + "\n Duration: " + getDuration();
	}

	public static ArrayList<Chapter> makeLostChapters() {
		ArrayList<Chapter> chapters = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			chapters.add(new Chapter("Chapter" + i, "Ciencia Ficción", "Creator" + i, (45 + i), (short) 2004, 1));
		}

		return chapters;
	}

	public static ArrayList<Chapter> makeBlackMirrorChapters() {
		ArrayList<Chapter> chapters = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			chapters.add(new Chapter("Chapter" + i, "Ciencia Ficción", "Creator" + i, (45 + i), (short) 2004, 1));
		}

		return chapters;
	}

}
