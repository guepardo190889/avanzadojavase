package com.blackdeath.amazonviewer.enums;

/**
 * @author Seth Luis
 *
 */
public enum Material {
	MOVIE(1), SERIE(2), CHAPTER(3), BOOK(4), MAGAZINE(5);

	private int tipo;

	private Material(int tipo) {
		this.tipo = tipo;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
