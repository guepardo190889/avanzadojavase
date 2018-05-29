package com.blackdeath.amazonviewer.db;

public class DataBase {
	public static final String URL = "jdbc:mysql://localhost:3306/";
	public static final String DB = "amazonviewer";
	public static final String USER = "amazonviewer";
	public static final String PASSWORD = "amazonviewer";

	public static final String T_MOVIE = "movie";
	public static final String T_MOVIE_ID = "id";
	public static final String T_MOVIE_TITLE = "title";
	public static final String T_MOVIE_GENRE = "genre";
	public static final String T_MOVIE_CREATOR = "creator";
	public static final String T_MOVIE_DURATION = "duration";
	public static final String T_MOVIE_YEAR = "year";
	
	public static final String T_MATERIAL = "material";
	public static final String T_MATERIAL_ID = "id";
	public static final String T_MATERIAL_NAME = "name";
	public static final int [] ID_MATERIAL = {1,2,3,4,5}; 
	
	public static final String T_USER = "user";
	public static final String T_USER_ID = "id";
	public static final String T_USER_NAME = "name";
	public static final int ID_USUARIO = 1;
	
	public static final String T_VIEWED = "viewed";
	public static final String T_VIEWED_ID = "id";
	public static final String T_VIEWED_ID_ELEMENT = "id_element";
	public static final String T_VIEWED_ID_MATERIAL = "id_material";
	public static final String T_VIEWED_ID_USER = "id_user";
	
	public static final String T_BOOK = "book";
	public static final String T_BOOK_ID = "id";
	public static final String T_BOOK_TITLE = "title";
	public static final String T_BOOK_EDITITION_DATE = "editition_date";
	public static final String T_BOOK_EDITORIAL = "editorial";
	public static final String T_BOOK_ISBN = "isbn";
	public static final String T_BOOK_READED = "readed";
	public static final String T_BOOK_TIME_READED = "time_readed";
	
}
