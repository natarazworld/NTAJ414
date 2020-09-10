package com.nt.jdbc;

import java.sql.CallableStatement;

/*create or replace procedure p_getEmpDetails_By_No(no in number,
        name out varchar2,
        desg out varchar2,
        sal out number)
as 
begin
select ename,job,e.sal into name,desg,sal from emp e where empno=no; 
end;
/
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsProcedureTest2 {
   private static final String CALL_PROCEDURE_QUERY="{CALL P_GETEMPDETAILS_BY_NO(?,?,?,?) }";
	public static void main(String[] args) {
		Scanner sc=null;
		int no=0;
		Connection con=null;
		CallableStatement cs=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("enter employee number:: ");
				no=sc.nextInt();
			}
			//establish the connection with Db s/w
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
			 //create CallableSTatwement object
			 if(con!=null)
			    cs=con.prepareCall(CALL_PROCEDURE_QUERY);
			 //register OUT params with JDBC types
			 if(cs!=null) {
				 cs.registerOutParameter(2,Types.VARCHAR);
				 cs.registerOutParameter(3,Types.VARCHAR);
				 cs.registerOutParameter(4,Types.FLOAT);
			 }
			 //set values to IN params
			 if(cs!=null)
				 cs.setInt(1,no);
			 //execute /call PL/SQL procedure
			 if(cs!=null)
				 cs.execute();
			 //gather results from OUT params
			 if(cs!=null) {
				 System.out.println(" emp  Name ::"+cs.getString(2));
				 System.out.println("Emp desg::"+cs.getString(3));
				 System.out.println("Emp salary ::"+cs.getFloat(4));
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
