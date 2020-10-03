package com.nt.jdbc;

import java.sql.SQLException;

import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleJoinRowSet;

public class JoinRowSetDemo {

	public static void main(String[] args) {
		try(OracleCachedRowSet crs1=new  OracleCachedRowSet();
				OracleCachedRowSet crs2=new  OracleCachedRowSet();
				OracleJoinRowSet jnRowset=new OracleJoinRowSet()){
			  crs1.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			  crs1.setUsername("system");
			  crs1.setPassword("manager");
			  crs1.setMatchColumn(5);
			  crs1.setCommand("SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM  EMP");
			 crs1.execute();
			
			  
			  crs2.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			  crs2.setUsername("system");
			  crs2.setPassword("manager");
			  crs2.setMatchColumn(1);
			  crs2.setCommand("SELECT DEPTNO,DNAME,LOC FROM DEPT");
			  crs2.execute();
			  
			  //add multiple cached rowsets to joinrowsets
			  jnRowset.addRowSet(crs2);
			  jnRowset.addRowSet(crs1);
			  
			  //process the JoinRowSet
			  while(jnRowset.next()) {
				  System.out.println(jnRowset.getInt(1)+"  "+jnRowset.getString(2)+"  "+jnRowset.getString(3)
				                                         +"  "+jnRowset.getString(4)+"  "+jnRowset.getString(5)+"  "
						                                    +jnRowset.getString(6)+"  "+jnRowset.getString(7));
			  }
          				
		}
		catch(SQLException se) {
			se.printStackTrace();
		}

	}//try
}//class
