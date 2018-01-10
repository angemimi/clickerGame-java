<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pageName = (String)request.getAttribute("pageName");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Miner clicker</title>
		<link rel="stylesheet" href="assets/bootstrap/bootstrap.css">
		<script type="text/javascript" src="js/util/jquery.js"></script>
		<script type="text/javascript" src="js/util/bootbox.min.js"></script>
		<script type="text/javascript" src="js/util/bootstrap/bootstrap.js"></script>
	</head>
	<body>
		<jsp:include page="component/nav.jsp"></jsp:include>
		<jsp:include page="component/${pageName}.jsp"></jsp:include>
	</body>
</html>