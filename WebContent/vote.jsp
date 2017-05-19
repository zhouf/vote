<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.vote.util.VoteUtil" %>
<%@ page import="com.vote.entity.VoteItem" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

List<VoteItem> voteList = VoteUtil.getVoteItems();
%>

<%-- 这是一个为移动端开发的投票界面 --%>
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
    <table width="100%" border="0">
    	<caption>请投票</caption>
    	<%for(VoteItem v : voteList){%>
    	<tr>
    		<th>
    			<a class="btn" href="WebVote?r=<%=v.getId()%>"><%=v.getLabel()%></a>
    		</th>
    	</tr>
    	<%}%>
    </table>
  </body>
</html>
