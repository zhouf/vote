<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.vote.util.ResultUtil" %>
<%@ page import="com.vote.entity.Result" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

List<Result> rList = ResultUtil.getResult();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Android vote demo</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link rel="stylesheet" type="text/css" href="styles.css">
  </head>
  
  <body>
    <h2>在线投票</h2>
    <hr/>
    
    <table align="center" width="300" border="1">
    	<caption>投票结果如下</caption>
    	<tr>
    		<th>选项</th>
    		<th>计数</th>
    	</tr>
    	<%for(Result r : rList){%>
    	<tr>
    		<td><%=r.getLabel()%></td>
    		<td><%=r.getCount()%></td>
    	</tr>
    	<%}%>
    </table>
    
    <!-- <a class="btn" href="vote.jsp">我要投票</a>  -->
  </body>
</html>
