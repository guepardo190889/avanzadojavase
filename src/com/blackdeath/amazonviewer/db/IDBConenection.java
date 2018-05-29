package com.blackdeath.amazonviewer.db;

import static com.blackdeath.amazonviewer.db.DataBase.DB;
import static com.blackdeath.amazonviewer.db.DataBase.PASSWORD;
import static com.blackdeath.amazonviewer.db.DataBase.URL;
import static com.blackdeath.amazonviewer.db.DataBase.USER;

import java.sql.Connection;
import java.sql.DriverManager;

public interface IDBConenection {

	@SuppressWarnings("finally")
	default Connection connectToDB() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL + DB, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return connection;
		}
	}
}
