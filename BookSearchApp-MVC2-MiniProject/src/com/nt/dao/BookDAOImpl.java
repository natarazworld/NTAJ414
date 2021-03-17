package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.BookDetailsBO;

public class BookDAOImpl implements BookDAO {
   private static final String GET_BOOKS_BY_CATEGORY="SELECT BOOKID,BOOKNAME,CATEGORY,AUTHOR,PRICE,STATUS  FROM BOOKS_INFO WHERE CATEGORY=?";  
	@Override
	public List<BookDetailsBO> getBooksByCategory(String category)throws Exception {
		List<BookDetailsBO> listBO=null;
		try(Connection con=getPooledConnection();
				PreparedStatement ps=con.prepareStatement(GET_BOOKS_BY_CATEGORY))  {
			        //set  value to query params
			        ps.setString(1,category);
			        //execute the query
			        try(ResultSet rs=ps.executeQuery()){
			        	//copy the records of RS to ArrayList as BO class objects
			        	listBO=new ArrayList();
			        	while(rs.next()) {
			        		BookDetailsBO  bo=new BookDetailsBO();
			        		bo.setBookId(rs.getInt(1));
			        		bo.setBookName(rs.getString(2));
			        		bo.setCategory(rs.getString(3));;
			        		bo.setAuthor(rs.getString(4));
			        		bo.setPrice(rs.getFloat(5));
			        		bo.setStatus(rs.getString(6));
			        		listBO.add(bo);
			        	}//while
			        }///try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listBO;
	}//method
	
	private Connection getPooledConnection() throws Exception{
		 //create InitialContext object
		InitialContext ic=new InitialContext();
		//get DataSource object from JndiRegistry
		DataSource ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		//get Pooled jdbc con object
		Connection con=ds.getConnection();
		return con;
	}//method

}//class
