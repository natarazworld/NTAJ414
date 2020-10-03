package com.nt.jdbc;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.Predicate;

import oracle.jdbc.rowset.OracleFilteredRowSet;



public class FilteredRowSetDemo {

	public static void main(String[] args) {
		try(OracleFilteredRowSet frs=new  OracleFilteredRowSet()){
			  frs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			  frs.setUsername("system");
			  frs.setPassword("manager");
			  frs.setCommand("SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM  EMP ");
			  frs.setFilter(new Filter1("ENAME","S"));
			 frs.execute();
			
			 //process rowset
			 while(frs.next()) {
				 System.out.println(frs.getInt(1)+"  "+frs.getString(2)+"  "+frs.getString(3)+"  "+frs.getFloat(4)+" "+frs.getInt(5));
			 }
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}//main
		private static class Filter1 implements  Predicate{
			private  String colName;
			private  String condData;
			
             // alt +shift +s ,o  --> generates constructor
			public Filter1(String colName, String condData) {
				this.colName = colName;
				this.condData = condData;
			}

			@Override
			public boolean evaluate(RowSet rs) {
				System.out.println("FilteredRowSetDemo.Filter1.evaluate(-)");
				try {
			     String colValue=rs.getString(colName);
				 if(colValue.startsWith(condData))
					  return true;
				 else
					 return false;
				}
				catch(SQLException se) {
					//se.printStackTrace();
					return false;
				}
			}

			@Override
			public boolean evaluate(Object value, int column) throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean evaluate(Object value, String columnName) throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}
			
		}

	
}//class
