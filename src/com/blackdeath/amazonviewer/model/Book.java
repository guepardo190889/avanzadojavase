package com.blackdeath.amazonviewer.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.blackdeath.amazonviewer.util.AmazonUtil;

public class Book extends Publication implements IVisualizable {
	private int id;
	private String isbn;
	private boolean readed;
	private int timeReaded;
	private ArrayList<Page> pages;

	public Book(String title, Date edititionDate, String editorial, String[] authors, ArrayList<Page> pages) {
		super(title, edititionDate, editorial);
		setAuthors(authors);
		this.pages = pages;
	}

	public int getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean getIsReaded() {
		return readed;
	}

	public String isReaded() {
		return readed ? "Sí" : "No";
	}

	public void setReaded(boolean readed) {
		this.readed = readed;
	}

	public int getTimeReaded() {
		return timeReaded;
	}

	public void setTimeReaded(int timeReaded) {
		this.timeReaded = timeReaded;
	}

	@Override
	public Date startToSee(Date dateI) {
		return dateI;
	}

	@Override
	public void stopToSee(Date dateI, Date dateF) {
		Calendar calI = Calendar.getInstance();
		calI.setTime(dateI);

		Calendar calF = Calendar.getInstance();
		calF.setTime(dateF);

		if (calF.getTimeInMillis() > calI.getTimeInMillis()) {
			setTimeReaded((int) ((calF.getTimeInMillis() - calI.getTimeInMillis()) / 1_000));
		} else {
			setTimeReaded(0);
		}
	}

	public ArrayList<Page> getPages() {
		return pages;
	}

	public void setPages(ArrayList<Page> pages) {
		this.pages = pages;
	}

	public static ArrayList<Book> makeBooksList() {
		ArrayList<Book> books = new ArrayList<>();

		ArrayList<Page> pages = new ArrayList<>();
		int pagina = 0;
		for (int i = 0; i < 3; i++) {
			pagina = i + 1;
			pages.add(new Book.Page(pagina, "El contenido de la página " + i));
		}

		books.add(new Book("Scrum. El arte de hacer el doble de trabajo en la mitad de tiempo", new Date(), "Gandhi",
				new String[] { "Jeff Sutherland" }, pages));
		books.add(new Book("Pequeño cerdo capitalista", new Date(), "Gandhi", new String[] { "Sofía Macías" }, pages));
		books.add(
				new Book("Padre rico padre pobre", new Date(), "Gandhi", new String[] { "Robert T. Kiyosaki" }, pages));

		return books;
	}

	public void view() {
		setReaded(true);
		Date dateI = startToSee(new Date());

		int i = 0;

		do {
			System.out.println("...............");
			System.out.println("Page " + getPages().get(i).getNumber());
			System.out.println(getPages().get(i).getContent());
			System.out.println("...............");

			if (i != 0) {
				System.out.println("1.- Página anterior");
			}

			if (i < getPages().size() - 1) {
				System.out.println("2.- Página siguiente");
			}

			System.out.println("0.- Cerrar libro");
			System.out.println("");

			int respuesta = AmazonUtil.validaRespuestaMenu(0, 2);

			if (respuesta == 1) {
				i--;
			} else if (respuesta == 2) {
				i++;
			} else if (i == 0) {
				break;
			}

		} while (i < getPages().size());

		stopToSee(dateI, new Date());

		System.out.println();
		System.out.println("Leíste: " + toString());
		System.out.println("Por: " + getTimeReaded() + " milisegundos");
	}

	@Override
	public String toString() {
		String bookDetail = "\n :: BOOK ::" + "\n Title: " + getTitle() + "\n Editition Date: " + getEdititionDate()
				+ "\n Editorial: " + getEditorial() + "\n ISBN: " + getIsbn() + "\n Authors: ";

		for (int i = 0; i < getAuthors().length; i++) {
			bookDetail += "\t" + getAuthors()[i];
		}

		return bookDetail;
	}

	public static class Page {
		private int id;
		private int number;
		private String content;

		public Page(int number, String content) {
			super();
			this.number = number;
			this.content = content;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

	}

}
