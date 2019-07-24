package com.bit.model;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bit.model.entity.Bbs02Vo;

public class Bbs02DaoTest {
	Bbs02Dao dao;
	
	//JUnit test를 돌릴때 단 한번 실행할때 최초(첫번째)로 돌림 = 생성자
	//JUnit에선 생성자를 사용하지않고 BeforeClass를 처리함
	//Dao를 beforeClass에 생성할수도 있고 before() 메서드에서도 생성할 수 있는데
	//Dao객체를 beforeClass에 생성하게되면 최초 실행시 한개의 객체를 생성해 모든 test method에서 사용하게되고
	//before에 객체를 생성하게되면 test마다 새로운 객체를 생성하여 test method에서 사용하게된다
	//test하고자 하는 case에 따라 자신이 알맞게 사용하면 된다
	@BeforeClass
	public static void setUpBeforeClass(){
	}
	//JUnit의 모든 test가 실행되고 가장 마지막에 실행되어짐
	//Before와 After Class()는 모두 static으로 실행되어야함
	@AfterClass
	public static void tearDownAfterClass(){
	}
	
	//JUnit test를 할때 test마다 test를 실행하기 전 먼저 수행하고 test가 실행됨
	@Before
	public void setUp() throws SQLException{
		dao = new Bbs02Dao();
	}
	//JUnit test를 할때 test마다 test를 실행한 후에 수행함 
	@After
	public void tearDown(){
	}
	
	
//	@Test
//	public void testGetConnection(){
//		//test 클래스를 만들때 error를 try catch로 하게되면 오류를 회피하기 때문에 JUnit에서 오류를 잡아내지 못한다
//		//일반적인 상황이 아닌 이상 throw로 던지고 try catch는 안하는 편이 좋다
//		
//		try {
//			//동일 패키지라서 import안함
//			
//			Connection conn = dao.getConnection();
//			assertNotNull(conn);	//null이 아니면 성공
//		} catch (SQLException e) {
//			assertFalse(true);
//			//굳이 try catch를 사용해야할 상황에는 실패를 준다.
//		}
//		//Assert에서 테스트 가능한 종류
////		Assert.assertNull(dao);	//null이면 성공
////		Assert.assertEquals(1, 1);	//값이 같으면 성공
////		Assert.assertSame(1, 1);	//값이 같으면 성공
////		Assert.assertNotSame(1, 2);	//값이 다르면 성공
////		Assert.assertTrue(true);	//값이 true면 성공
////		Assert.assertFalse(false);	//값이 false면 성공
//		//반대면 실패
//	}
	@Test
	public void testInsertOne() throws SQLException{
		Bbs02Vo bean = new Bbs02Vo();
		bean.setName("test");
		bean.setSub("testSub");
		bean.setContent("testContent");
		Bbs02Dao dao= new Bbs02Dao();
		assertSame(1, dao.insertOne(bean));
		//첫번째 인자는 프로그래머가 기대하는 기대값, 두번째는 실제 결과값
	}
	@Test
	public void testSelectAll() throws SQLException{
		assertNotNull(dao.selectAll("test01"));
		assertTrue(dao.selectAll("test01").size()>0);
		assertSame(1, dao.selectAll("test01").size());
	}
	
}
