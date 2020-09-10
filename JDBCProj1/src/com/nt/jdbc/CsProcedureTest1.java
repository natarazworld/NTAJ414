package com.nt.jdbc;

/*create or replace procedure p_first(x in number ,y in number , z out number)
as
begin
   z:=x+y;
end;*/

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsProcedureTest1 {
  private static final String CALL_PROCEDURE_QUERY="{ CALL P_FIRST(?,?,?) }";
	public static void main(String[] args) {
		Scanner sc=null;
		int x=0,y=0;
		Connection con=null;
		CallableStatement cs=null;
		try {
		 sc=new Scanner(System.in);	
		if(sc!=null) {
			System.out.println("enter first value ::");
			x=sc.nextInt();
			System.out.println("enter second value ::");
			y=sc.nextInt();
		}
		//establish the cconnection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		//create CallableStatement object
		if(con!=null)
			cs=con.prepareCall(CALL_PROCEDURE_QUERY);
		//register  OUT params with JDBC types
		if(cs!=null)
			cs.registerOutParameter(3,Types.INTEGER);
		//set vlaues to IN params
		if(cs!=null) {
			cs.setInt(1,x);
			cs.setInt(2,y);
		}
		//call PL/SQL procedure
		if(cs!=null)
			cs.execute();
		//gather results from OUT params
		if(cs!=null) 
			System.out.println("Sum is ::"+cs.getInt(3));

	}//try
   catch(SQLException se) {
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
