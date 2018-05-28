package com.blackdeath.amazonviewer.model;

/**
 * <h1>Film</h1> Film es una clase padre abstracta
 * <p>
 * Esta clase es la clase base de la familia Films y como es abstracta no pueden
 * crearse instancias.
 * 
 * Contiene el método abstracto {@code view()} que es obligatorio implementar
 * para todo aquel que pertenezca a la familia
 * 
 * 
 * @author Seth Luis
 * @version 1.0
 * @since 2018
 *
 */
public abstract class Film {
	private String title;
	private String genre;
	private String creator;
	private int duration;
	private short year;
	private boolean viewed;

	public Film(String title, String genre, String creator, int duration) {
		super();
		this.title = title;
		this.genre = genre;
		this.creator = creator;
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public String isViewed() {
		return viewed ? "Sí" : "No";
	}

	public boolean getIsViewed() {
		return viewed;
	}

	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}

	/**
	 * {@code view()} es un método abstracto obligatorio de implementar
	 */
	public abstract void view();

	public void play() {
		for (int i = 0; i < 100_000; i++) {
			System.out.println("........................................");
		}
	}

}
