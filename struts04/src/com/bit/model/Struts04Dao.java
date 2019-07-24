package com.bit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit.model.entity.Struts04Dto;

public class Struts04Dao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String driver="oracle.jdbc.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String user="scott";
	private String password="tiger";

	public Struts04Dao() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Struts04Dto> getList() {
		List<Struts04Dto> list = new ArrayList<Struts04Dto>();
		String sql="select num,sub,name,nalja from scott.struts04 order by num desc";
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())list.add(new Struts04Dto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4)));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public void close(){
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insetOne(String sub, String name, String content) {
		String sql="insert into struts04 values (struts04_seq.nextval, ?, ?, ?, sysdate)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, sub);
			pstmt.setString(2, name);
			pstmt.setString(3, content);
			int result=pstmt.executeUpdate();
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close();
		}
		
	}

	public void insetOne(Struts04Dto bean) {
		String sql="insert into struts04 values (struts04_seq.nextval, ?, ?, ?, sysdate)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bean.getSub());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getContent());
			int result=pstmt.executeUpdate();
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close();
		}
		
	}
}
