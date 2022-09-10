<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" import="ex.*" %>
<% Employee employee = new Employee("0001", "湊 雄輔"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>練習4-1</title>
</head>
<body>
<p>IDは<%= employee.getId() %>、名前は<%= employee.getName() %>です</p>
</body>
</html>
