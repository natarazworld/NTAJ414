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

/*CREATE  PROCEDURE `P_GET_PROD_DETAILS_BY_PID`(in id int,out name varchar(10),
                                                                                                  out rate float,out qnt float )
BEGIN
   select pname,price,qty into name,rate,qnt from product where pid=id;
END
*/

public class CsProcedureMySQLTest7 {
   private static final String CALL_PROCEDURE_QUERY="{CALL P_GET_PROD_DETAILS_BY_PID(?,?,?,?) }";
	public static void main(String[] args) {
		Scanner sc=null;
		int pid=0;
		Connection con=null;
		CallableStatement cs=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter Product id::");
				pid=sc.nextInt();  
			}
			//establish the connection with Db s/w
			 con=DriverManager.getConnection("jdbc:mysql:///ntaj414db","root", "root");
			 //create CallableSTatwement object
			 if(con!=null)
			    cs=con.prepareCall(CALL_PROCEDURE_QUERY);
			 
			 //register OUT params with JDBC types
			 if(cs!=null) {
				 cs.registerOutParameter(2,Types.VARCHAR);
				 cs.registerOutParameter(3,Types.FLOAT);
				 cs.registerOutParameter(4,Types.FLOAT);
			 }
			 //set values to IN params
			 if(cs!=null) 
				 cs.setInt(1,pid);
			 
			 //execute /call PL/SQL procedure
			 if(cs!=null)
				 cs.execute();
			 
			 //gather results from OUT params
			 if(cs!=null) {
			    System.out.println("prod name ::"+cs.getString(2));
			    System.out.println("prod price ::"+cs.getFloat(3));
			    System.out.println("prod Qty ::"+cs.getFloat(4));
			    
			 }
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
