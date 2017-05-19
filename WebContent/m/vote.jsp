<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.vote.util.VoteUtil" %>
<%@ page import="com.vote.entity.VoteItem" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

List<VoteItem> voteList = VoteUtil.getVoteItems();
%>

<%-- 这是一个为移动端开发的投票界面 --%>

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
    
    <form action="../MobileVote" method="post">
    <%for(VoteItem v : voteList){%>
	    <input type="submit" name="r" value="<%=v.getLabel()%>">
    <%}%>
	</form>
  </body>
</html>
