package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/reporturl")
public class ReportGenerationServlet extends HttpServlet {
	private  static final String  GET_PROFILES_QUERY="SELECT  PID,PNAME,PADDRS,RESUME,PHOTO FROM  PERSON_PROFILE";
	@Resource(name="DsJndi")
	private DataSource ds;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  //get PrintWriter 
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//establish the connection
		try(Connection con=ds.getConnection()){
			try(PreparedStatement ps=con.prepareStatement(GET_PROFILES_QUERY)){
				try(ResultSet rs=ps.executeQuery(GET_PROFILES_QUERY)){
					//display  ResultSet records as html  table conent (report)
					pw.println("<h1 style='color:blue;text-align:center'> Report Generation </h1>");
					pw.println("<table align='center' bgcolor='cyan'>");
					pw.println("<tr><th> PID </th> <th> PNAME </th> <th>PADDRS</th> <th> RESUME </th> <th> PHOTO </th> </tr>");
					while(rs.next()) {
						pw.println("<tr>");
						   pw.println("<td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td><a href='downloadurl?id="+rs.getInt(1)+"&type=resume'> download </a></td> <td><a href='downloadurl?id="+rs.getInt(1)+"&type=photo'> download </a></td>");
						pw.println("</tr>");
					}//while
					pw.println("</table>");
				}//try3
			}//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//close stream
		pw.close();
	
	}//doGet(-,-)
	

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
