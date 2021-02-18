

<%!  public void  jspInit(){
	         /*     System.out.println("dbuser name::"+config.getInitParameter("dbuser"));
	              System.out.println("dbpwd name::"+application.getInitParameter("dbpwd")); */
	              
	              // use servlet api and get access to sServletContext ,SevletConfig objs  using additional ref variables 
	              ServletConfig cg=getServletConfig();  
	              ServletContext sc=getServletContext();
	              System.out.println("dbuser name::"+cg.getInitParameter("dbuser"));
	              System.out.println("dbpwd name::"+sc.getInitParameter("dbpwd"));
	              
	              //Class.forName("java.util.Date");
	              
             }%>
             
             <h1 style="color:red;text-align:Cetner"> WElcome to jsp  pages </h1>
             
             init param (dbuser ) value:: <%=config.getInitParameter("dbuser") %> <br>
             context param (dbpwd ) value:: <%=application.getInitParameter("dbpwd") %> <br>
             <%  Class.forName("java.util.Date");
                      System.out.println("driver loaded");
             %>