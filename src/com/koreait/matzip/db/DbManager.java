package com.koreait.matzip.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbManager {
	public static Connection getConn() throws Exception{
		String url = "jdbc:mysql://localhost:3306/matzip";
		String user = "root";
		String pw = "koreait2020";
		String className = "com.mysql.cj.jdbc.Driver";
		
		Class.forName(className);
		Connection conn = DriverManager.getConnection(url,user,pw);
		System.out.println("DB 연결 완료 !");
		return conn;
	}
}
