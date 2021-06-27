<%@ page language="java" contentType="text/html; charset=UTF-8" import="ex.Employee"
    pageEncoding="UTF-8"%>
<% Employee emp = new Employee("0001", "湊 雄輔"); %>
<!DOCTYPE html>
<html>
<body>
<% for(int i = 1; i <= 10; i++){ 
	if( i % 3 == 1) {
	%>
	<p style="color: red">IDは<%= emp.getId() %>、名前は<%= emp.getName() %>です</p>
	<% } else {  %>
	<p>IDは<%= emp.getId() %>、名前は<%= emp.getName() %>です</p>
	<% }
	} %>
</body>
</html>
