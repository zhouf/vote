<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.vote.util.ResultUtil" %>
<%@ page import="com.vote.entity.Result" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

List<Result> rList = ResultUtil.getResult();
%>

<!DOCTYPE html> 
<html>
<head>
    <base href="<%=basePath%>">
	<title>Android vote demo</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="plug/jquery.mobile-1.4.2.min.css" />
	<script src="plug/jquery-1.11.0.min.js"></script>
	<script src="plug/jquery.mobile-1.4.2.min.js"></script>
</head>
  
  <body>
    <h2>在线投票</h2>
    <hr/>

    <ul data-role="listview">
    <%for(Result r : rList){%>
	    <li><%=r.getLabel()%>&nbsp;&nbsp;<%=r.getCount()%></li>
    <%}%>
	</ul>
  </body>
</html>
