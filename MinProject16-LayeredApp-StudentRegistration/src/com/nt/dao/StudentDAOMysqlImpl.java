package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAOMysqlImpl implements IStudentDAO {
	private  static final String   INSERT_LAYERED_STUDENT="INSERT INTO LAYERED_STUDENT(SNAME,SADD,TOTAL,AVG,RESULT) VALUES(?,?,?,?,?)";
    
	private  DataSource ds;
	public StudentDAOMysqlImpl()throws Exception {
		System.out.println("StudentDAOMysqlImpl.0-param constructor");
		//create InitialContext obj
		InitialContext ic=new InitialContext();
		//get DataSource obj from Jndi registry throug  lookup method
		 ds=(DataSource) ic.lookup("java:/comp/env/DsJndi-mysql");
	}
	
	@Override
	public int insert(StudentBO bo) throws Exception {
		//get Pooled jdbc con object
		Connection con=getPooledJdbcConnection();
		//get Jdbc PreparedStatement object
		PreparedStatement ps=con.prepareStatement(INSERT_LAYERED_STUDENT);
		//set values to query params
		ps.setString(1,bo.getSname());
		ps.setString(2,bo.getSadd());
		ps.setInt(3,bo.getTotal());
		ps.setFloat(4,bo.getAvg());
		ps.setString(5,bo.getResult());
		
		
		//execute the quey
		int result=ps.executeUpdate();
		//close jdbc objs
		 ps.close();
		 con.close();
		//return the reult
		return result;
	}//method
	
	//helper methods
	private Connection  getPooledJdbcConnection()throws Exception {
		//get Pooled jdbc con object through DataSource object ref
		Connection con=ds.getConnection();
		 return con;
	}//method

}//class
