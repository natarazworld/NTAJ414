package com.nt.jdbc;

import java.sql.CallableStatement;


/*Create or replace procedure P_AUTHENTICATION(user in varchar2,
        pass in varchar2,
        result out varchar2)
as 
cnt number;
begin
select count(*) into cnt from userinfo where uname=user and pwd=pass;
if(cnt<>0)then
result:='VALID CREDENTIALS';
else
result:='INVALID CREDENTIALS';
end if;
end;
/
*/


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsProcedureTest3 {
   private static final String CALL_PROCEDURE_QUERY="{CALL P_AUTHENTICATION(?,?,?) }";
	public static void main(String[] args) {
		Scanner sc=null;
		String user=null,pass=null;
		Connection con=null;
		CallableStatement cs=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter username::");
				user=sc.nextLine();  
				System.out.println("enter password::");
				pass=sc.nextLine();
			}
			//establish the connection with Db s/w
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
			 //create CallableSTatwement object
			 if(con!=null)
			    cs=con.prepareCall(CALL_PROCEDURE_QUERY);
			 
			 //register OUT params with JDBC types
			 if(cs!=null) {
				 cs.registerOutParameter(3,Types.VARCHAR);
			 }
			 //set values to IN params
			 if(cs!=null) {
				 cs.setString(1,user);
				 cs.setString(2,pass);
			 }
			 //execute /call PL/SQL procedure
			 if(cs!=null)
				 cs.execute();
			 
			 //gather results from OUT params
			 if(cs!=null) {
			    System.out.println("result is ::"+cs.getString(3));
			 }
		}//try
		catch(SQLException se) {
			if(se.getErrorCode()==1403)
				  System.out.println("No Procedure found with that name");
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
