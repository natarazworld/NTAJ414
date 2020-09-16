package com.nt.jdbc;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ScrollFrame_GUIFE extends JFrame implements ActionListener {
	private static final String  GET_STUDENTS_QUERY="SELECT SNO,SNAME,SADD,AVG FROM  STUDENT";
    private  JLabel lno,lname,ladd,lavg, lmsg=null;
    private  JTextField  tno,tname,taddrs,tavg;
    private  JButton  bFirst,bNext,bLast,bPrevious;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
	 //constructor
	public ScrollFrame_GUIFE() {
		System.out.println("ScrollFrame_GUIFE.0-param constructor");
		setTitle("GUI -ScrollFrame");
		setLayout(new FlowLayout());  // default Layout is BorderLayout
		setSize(300,300);
		//add comps
		lno=new JLabel(" student number");
		add(lno);
		tno=new JTextField(10);
		add(tno);
		
		lname=new JLabel(" student name");
		add(lname);  // add the comp to framewindow
		tname=new JTextField(10);
		add(tname);
		
		ladd=new JLabel(" student address");
		add(ladd);
		taddrs=new JTextField(10);
		add(taddrs);
		
		lavg=new JLabel(" student avg");
		add(lavg);
		tavg=new JTextField(10);
		add(tavg);
		
		bFirst=new JButton("first");
		add(bFirst);
		bNext=new JButton("next");
		add(bNext);
		bPrevious=new JButton("previous");
		add(bPrevious);
		bLast=new JButton("Last");
		add(bLast);
		// add ActionListner to 4 buttons  to handle ActionEvent (clicking on Button)
		bFirst.addActionListener(this);  //we are linking current class obj(this) as ActionListener to handle  Action Event on the button
		bNext.addActionListener(this);
		bPrevious.addActionListener(this);
		bLast.addActionListener(this);
		
		lmsg=new JLabel("");
		add(lmsg);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // When close frame window with (x) button the App will be terminated
		jdbcInitialize();
	}
	
	private  void jdbcInitialize() {  //private methods are usefull to seperate logics adn use with in a class
		System.out.println("ScrollFrame_GUIFE.jdbcInitialize()");
		try {
			//establuhs the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			//create PreparedStatement object
			ps=con.prepareStatement(GET_STUDENTS_QUERY,
					                                              ResultSet.TYPE_SCROLL_INSENSITIVE,
					                                              ResultSet.CONCUR_UPDATABLE);
			//create ScrollableResultSet object
			rs=ps.executeQuery();
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	 public static void main(String[] args) {
		 System.out.println("ScrollFrame_GUIFE.main(-)");
		   new   ScrollFrame_GUIFE(); //Anynomous object
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("ScrollFrame_GUIFE.actionPerformed(-)");
		var flag=false;   //java 10  feature  ---  Local variable type inference  (type is decied by compiler) 
		 // empty the label messages
		   lmsg.setText("");
		if(ae.getSource()==bFirst) {
			System.out.println("first button");
			try {
				rs.first();
				flag=true;
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}
			
		}
		else if(ae.getSource()==bNext) {
			System.out.println("next button");
			try {
				if(!rs.isLast()) {
			    	rs.next();
				   flag=true;
				}
				else {
					
					lmsg.setText("Do not click on next button, u r already in last record");
					lmsg.setForeground(Color.red);
				}
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}//catch
		}
		else if(ae.getSource()==bPrevious) {
			System.out.println("previous button");
			try {
				if(!rs.isFirst()) {
			    	rs.previous();
				 flag=true;
				}
				else {
					lmsg.setText("Do not click on previous button, u r already in first record");
					lmsg.setForeground(Color.red);
				}
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}//catch
		}
		else {
			System.out.println("Last button");
			try {
				rs.last();
				flag=true;
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}//catch
		}//else
		// set data to text boxes
		if(flag==true) {
			try {
			tno.setText(rs.getString(1));
			tname.setText(rs.getString(2));
			taddrs.setText(rs.getString(3));
			tavg.setText(rs.getString(4));
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
		}//if

	}//actionPerformed(-)

}//class
