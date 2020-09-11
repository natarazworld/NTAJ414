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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
 CREATE  PROCEDURE `p_GET_PRODS_BY_NAMES`(in name1 varchar(10), in name2 varchar(10))
BEGIN
    SELECT PID,PNAME,PRICE,QTY FROM PRODUCT WHERE PNAME IN(name1,name2);
END
*/

public class CsProcedureMySQLTest8 {
   private static final String CALL_PROCEDURE_QUERY="{CALL p_GET_PRODS_BY_NAMES(?,?) }";
	public static void main(String[] args) {
		Scanner sc=null;
	     String name1=null,name2=null;
		Connection con=null;
		CallableStatement cs=null;
		ResultSet rs=null;
		boolean flag=false;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter Product name1::");
				name1=sc.next();  
				System.out.println("Enter Product name2::");
				name2=sc.next();
			}
			//establish the connection with Db s/w
			 con=DriverManager.getConnection("jdbc:mysql:///ntaj414db","root", "root");
			 //create CallableSTatwement object
			 if(con!=null)
			    cs=con.prepareCall(CALL_PROCEDURE_QUERY);
			 //set values to IN params
			 if(cs!=null) { 
				 cs.setString(1,name1);
				 cs.setString(2,name2);
				 
			 }
			 
			 //execute /call PL/SQL procedure
			 if(cs!=null)
				 cs.execute();
			 
			 //gather results from OUT params
			 if(cs!=null) {
			     rs=cs.getResultSet();
			     //process the ResultObject
			     if(rs!=null) {
			    	 while(rs.next()) {
			    		 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getFloat(3)+"  "+rs.getFloat(4));
			    		 flag=true;
			    	 }//while
			     }//if
			      if(flag)
			    	  System.out.println("record found and displayed");
			      else
			    	  System.out.println("Records not found");
			    
			 }//if
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
