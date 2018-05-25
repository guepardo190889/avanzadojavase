package com.blackdeath.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Magazine extends Publication {
	private int id;

	public Magazine(String title, Date edititionDate, String editorial) {
		super(title, edititionDate, editorial);
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		String magazineDetail = "\n :: MAGAZINE ::" + "\n Title: " + getTitle() + "\n Editition Date: " + getEdititionDate()
				+ "\n Editorial: " + getEditorial() + "\n Authors: ";

		for (int i = 0; i < getAuthors().length; i++) {
			magazineDetail += "\t" + getAuthors()[i];
		}

		return magazineDetail;
	}

	public static ArrayList<Magazine> makeMagazineList() {
		ArrayList<Magazine> magazines = new ArrayList<>();
		String[] authors = new String[3];
		for (int i = 0; i < 3; i++) {
			authors[i] = "author " + i;
		}
		for (int i = 1; i <= 5; i++) {
			magazines.add(new Magazine("Magazine " + i, new Date(), "Editorial " + i));
		}

		return magazines;
	}

}
