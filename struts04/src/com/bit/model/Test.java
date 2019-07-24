package com.bit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String driver="oracle.jdbc.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String user="scott";
	private String password="tiger";
	
	private void getMethod() {
		try {
			Class.forName(driver);
			conn=DriverManager.get
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
