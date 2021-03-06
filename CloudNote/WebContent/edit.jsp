<%@page import="com.seven.bean.ContextBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑笔记</title>
<link rel="stylesheet" href="css/supersized_edit.css">
<link rel="stylesheet" href="css/login_edit.css">
<link href="css/bootstrap_edit.min.css" rel="stylesheet">

<script src="js/jquery-1.8.2.min_edit.js"></script>
</head>

<body>
<script src="js/supersized.3.2.7.min_edit.js"></script>
<script src="js/supersized-init_edit.js"></script>

	<%
		String url = "";
		String title = "主题";
		String context = "内容";
		ContextBean bean = (ContextBean)session.getAttribute("notebean");
		if(bean==null)
			url = "./WriteServlet";
		else {
			url = "./OperationServlet";
			title = bean.getNoteTitle();
			context = bean.getNoteContext();
		}
		
	%>
	<div class="main_box">	
			<form name='f' action="<%out.print(url); %>" method="post">
				<input type="text" name="text" value="<%out.print(title); %>" size=85 style="background:none;"><br><br>
				<textarea name="textarea" rows="15" cols="87" style='background:none;'><%out.print(context); %></textarea><br>
				<input type="submit" value="发表" style='background:none;'>
			</form>
	</div>
	
</body>
</html>