<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml"  prefix="x"%>

<c:import var="doc" url="orders.xml"/>

<x:parse var="pdoc" doc="${doc}"/>

<b> displaying all orders</b> <br>
<x:forEach var="ord"  select="$pdoc/orders/order">
      item name :: <x:out select="$ord/name"/> <br>
      item price :: <x:out select="$ord/price"/> <br>
</x:forEach>

<b> displaying all orders whose price>=10000</b> <br>
<x:forEach var="ord"  select="$pdoc/orders/order">
  <x:if  select="$ord/price >=10000" >
      item name :: <x:out select="$ord/name"/> <br>
      item price :: <x:out select="$ord/price"/> <br>
  </x:if>      
</x:forEach>

