package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TransferMoneyTxMgmtTest {

	public static void main(String[] args) {
		Scanner sc=null;
		int srcAcno=0, destAcno=0;
		float amt=0.0f;
		Connection con=null;
		Statement st=null;
		int result[]=null;
		boolean flag=false;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("enter source account number::");
				srcAcno=sc.nextInt();
				System.out.println("Enter destination Acno::");
				destAcno=sc.nextInt();
				System.out.println("enter amount to transfer::");
				amt=sc.nextFloat();
			}
			// estalblish the the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			//create Statement object
			if(con!=null)
				st=con.createStatement();
			//begin Tx
			if(con!=null)
				con.setAutoCommit(false);
			//add withdraw , deposite queries to the batch
			if(st!=null) {
				//for withdraw operation
				st.addBatch("UPDATE  JDBC_BANKACCOUNT SET BALANCE=BALANCE-"+amt+ "WHERE ACNO="+srcAcno);
				//for deposiste operation
				st.addBatch("UPDATE  JDBC_BANKACCOUNT SET BALANCE=BALANCE+"+amt+ "WHERE ACNO="+destAcno);
			}
			 //execut batch
			if(st!=null) 
				result=st.executeBatch();
			
			//process the results
			for(int i=0;i<result.length;++i) {
				if(result[i]==0) {
					flag=true;   //when things are not done properly
					break;
				}//if
			}//for
		}//try
		catch(SQLException se) {
			flag=true;
			se.printStackTrace();
		}
		catch(Exception e) {
			flag=true;
			e.printStackTrace();
		}
		finally {
			try {
			  //perform TxMgmt
			   if(flag==true) {
				   con.rollback();
				   System.out.println("Tx is rolled back :: Money not transfered");
			   }
			   else {
				   con.commit();
				   System.out.println("Tx is committed :: Money  transfered");
			   }
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			//close jdbc objs
			try {
				if(st!=null)
					st.close();
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
