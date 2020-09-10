package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

/*CREATE OR REPLACE FUNCTION FX_GET_STUD_DETAILS_BY_SNO 
(
  NO IN NUMBER 
, NAME OUT VARCHAR2 
, ADDRS OUT VARCHAR2 
) RETURN FLOAT AS
    PERFORMENCE FLOAT;
BEGIN
  
  SELECT SNAME,SADD,AVG INTO NAME,ADDRS,PERFORMENCE  FROM STUDENT WHERE SNO=NO;
  
  return  PERFORMENCE;
  
END;
*/

public class CsFunctionTest5 {
	  private static final  String CALL_FUNCTION_QUERY="{ ?=call FX_GET_STUD_DETAILS_BY_SNO(?,?,?)}";
	public static void main(String[] args) {
		Scanner sc=null;
		int no=0;
		Connection con=null;
		CallableStatement cs=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
			   System.out.println("Enter student number::");
			   no=sc.nextInt();
			}//if
			
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			//create JDBc CallableStatement object
			if(con!=null)
				cs=con.prepareCall(CALL_FUNCTION_QUERY);
			
			if(cs!=null) {
				//register OUT,RETURN params with JDBC data types
				cs.registerOutParameter(1,Types.FLOAT); //return param
				cs.registerOutParameter(3,Types.VARCHAR); //out param
				cs.registerOutParameter(4,Types.VARCHAR); //out param
				
				//set values to IN params
				cs.setInt(2,no);
				
				//call PL/SQL Function
				cs.execute();
				
				//gather results from OUT params,RETURN params
				System.out.println("Student name::"+cs.getString(3));  //OUT param
				System.out.println("Student Addrs::"+cs.getString(4));  //OUT param
				System.out.println("Student avg::"+cs.getFloat(1));  //return param
				
				
				
			}//if
			}///try
			catch(SQLException se) {
				if(se.getErrorCode()==1403)
					  System.out.println("No Function found with that name or no data found");
				   se.printStackTrace();
			   }
			  catch(Exception e) {
				  e.printStackTrace();
			  }
					finally {
						//close jdbc objs
						try {
							if(cs!=null)
								cs.close();
						}
						catch(SQLException se) {
							se.printStackTrace();
						}
						
						try {
							if(con!=null)
								con.close();
						}
						catch(SQLException se) {
							se.printStackTrace();
						}
						
						try {
							if(sc!=null)
								sc.close();
						}
						catch(Exception e) {
							e.printStackTrace();
						}
					}//finally	
		
	}//main
}//class
