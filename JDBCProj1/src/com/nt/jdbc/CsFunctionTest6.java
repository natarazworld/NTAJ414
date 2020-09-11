package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

/*CREATE OR REPLACE FUNCTION FX_VIEW_DELETE_STUD_BY_SNO 
(
  NO IN NUMBER 
, STUDDETAILS OUT SYS_REFCURSOR 
) RETURN VARCHAR2 AS 
  CNT NUMBER(3);
  RESULT VARCHAR2(30);
BEGIN
    OPEN STUDDETAILS FOR
        SELECT SNO,SNAME,SADD,AVG FROM  STUDENT WHERE SNO=NO;
        
    DELETE FROM STUDENT WHERE SNO=NO;   
    cnt:=SQL%ROWCOUNT;
 
    IF    (CNT=1) THEN
         RESULT:='RECORD DELETED';
     ELSE
       RESULT:='RECORD NOT FOUND FOR DELETION';
    END IF;
       RETURN RESULT;
END; */

public class CsFunctionTest6 {
	  private static final  String CALL_FUNCTION_QUERY="{?=call FX_VIEW_DELETE_STUD_BY_SNO(?,?)  }";
	public static void main(String[] args) {
		Scanner sc=null;
		int no=0;
		Connection con=null;
		CallableStatement cs=null;
		ResultSet rs=null;
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
				cs.registerOutParameter(1, Types.VARCHAR);
				cs.registerOutParameter(3, OracleTypes.CURSOR);
				
				//set values to IN params
				cs.setInt(2,no);
				
				//call PL/SQL Function
				cs.execute();
				
				//gather results from OUT params,RETURN params
				rs=(ResultSet)cs.getObject(3); //out param
				if(rs!=null) {
					if(rs.next())
						 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
					else
						System.out.println("record not found");
				}//if
				
				System.out.println("Result ::"+cs.getString(1));  //return param
				
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
							if(rs!=null)
								rs.close();
						}
						catch(SQLException se) {
							se.printStackTrace();
						}
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
