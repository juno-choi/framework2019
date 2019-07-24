package com.bit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bit.framework.JdbcTemplate;
import com.bit.framework.TemplateQuerry;
import com.bit.model.entity.Bbs02Vo;

public class Bbs02Dao2 {
	public List getList() throws SQLException{
		String sql="select * from bbs02 order by num desc";
		JdbcTemplate template = new JdbcTemplate(){
			@Override
			public Object mapper(ResultSet rs) throws SQLException {
				Bbs02Vo bean = new Bbs02Vo();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setSub(rs.getString("sub"));
				bean.setNalja(rs.getDate("nalja"));
//				bean.setContent(rs.getString("content"));
				return bean;
			}
		};
		return template.executeQuery(sql, new Object[]{});
	}
	
	public Bbs02Vo getOne(int num) throws SQLException{
		String sql="select * from bbs02 where num=?";
		JdbcTemplate template = new JdbcTemplate(){
			@Override
			public Object mapper(ResultSet rs) throws SQLException {
				Bbs02Vo bean = new Bbs02Vo();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setSub(rs.getString("sub"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setContent(rs.getString("content"));
				return bean;
			}
		};
			return (Bbs02Vo) template.executeQuery(sql, new Object[]{num}).get(0);
			
	}
	
	public void addOne(Bbs02Vo bean) throws SQLException{
		String sql="insert into bbs02 values (bbs02_seq.nextval, ?,?,?,sysdate)";
		JdbcTemplate template = new JdbcTemplate(){
			@Override
			public Object mapper(ResultSet rs) throws SQLException {
				return null;
			}
		};
		template.executeQuery(sql, new Object[]{bean.getName(),bean.getSub(),bean.getContent()});
	}
	
	public int delOne(int num) throws SQLException{
		String sql="delete from bbs02 where num=?";
		JdbcTemplate template = new JdbcTemplate(){
			@Override
			public Object mapper(ResultSet rs) throws SQLException {
				return null;
			}
		
		};
		return template.executeUpdate(sql, new Object[]{num});
	}
	
	/////////////
	
	
	
}