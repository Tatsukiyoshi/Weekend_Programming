<%@ page language="java" contentType="text/html; charset=UTF-8" import="ex.Employee"
    pageEncoding="UTF-8"%>
<% Employee emp = new Employee("0001", "湊 雄輔"); %>
<!DOCTYPE html>
<html>
<body>
<p>IDは<%= emp.getId() %>、名前は<%= emp.getName() %>です</p>
</body>
</html>
