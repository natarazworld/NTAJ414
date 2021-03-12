<%@page  import="java.beans.*" %>

<h1 style="color:red;text-align:center"> get_values .jsp </h1>

<!-- Create or Locate java bean class object -->
<jsp:useBean id="st" class="com.nt.beans.Student" scope="session"/>

<!-- Read and display bean propery values -->
    <b>Sno== <jsp:getProperty property="sno" name="st"/></b> <br>
    <b>Sname== <jsp:getProperty property="sname" name="st"/></b> <br>
    <b>avg== <jsp:getProperty property="avg" name="st"/></b> <br>
     
 