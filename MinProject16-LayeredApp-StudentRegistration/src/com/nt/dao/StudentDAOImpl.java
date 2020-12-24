package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements IStudentDAO {
	private  static final String   INSERT_LAYERED_STUDENT="INSERT INTO LAYERED_STUDENT VALUES(SNO_SEQ. NEXTVAL,?,?,?,?,?)";
    
	private  DataSource ds;
	public StudentDAOImpl()throws Exception {
		//create InitialContext obj
		InitialContext ic=new InitialContext();
		//get DataSource obj from Jndi registry throug  lookup method
		 ds=(DataSource) ic.lookup("java:/comp/env/DsJndi");
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
		//return the reult
		return result;
	}
	
	//helper methods
	private Connection  getPooledJdbcConnection()throws Exception {
		//get Pooled jdbc con object through DataSource object ref
		Connection con=ds.getConnection();
		 return con;
	}

}
