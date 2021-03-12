

<%@page import="com.nt.beans.*" %>

<h1 style="color:red;text-align:center"> set_values .jsp </h1>


  <!-- create /Locate Java bean class object -->
  <jsp:useBean id="st" class="com.nt.beans.Student"  scope="session"/>
  
  <!-- set values to bean properties -->
  <%-- <jsp:setProperty  name="st"   property="sno" value="1001"/>
  <jsp:setProperty name="st"  property="sname"  value="raja"/>
  <jsp:setProperty name="st"  property="avg"  value="67.89f"/>
  <br> --%>

  <!-- In order to set request param values as the bean property values we need to use param attribute of jsp:setProperty tags   -->
   <%-- <jsp:setProperty name="st"  property="sno"  param="stno"/>
   <jsp:setProperty name="st"  property="sname"  param="stname"/>
   <jsp:setProperty name="st"  property="avg"  param="stavg"/> --%>
   
   <!-- if Java bean property names and request param names are matching then we can use property="*"  in jsp:useBean tag -->
      <jsp:setProperty name="st"  property="*"/>
   
  
  <b> values are set set bean properties</b>