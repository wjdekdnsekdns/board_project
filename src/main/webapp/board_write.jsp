<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!-- JSTL사용 라이브러리 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
   
</head>
<body>
   
  	 <% 
    String userID = null;
    if (session.getAttribute("userID") != null){
        userID = (String) session.getAttribute("userID");
    }
    %>
    <nav class ="navbar navbar-default">
        <div class="navbar-header"> <!-- 홈페이지의 로고 -->
            <button type="button" class="navbar-toggle collapsed"
                data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                aria-expand="false">
                <span class ="icon-bar"></span> <!-- 줄였을때 옆에 짝대기 -->
                <span class ="icon-bar"></span>
                <span class ="icon-bar"></span>
            </button>
            <a class ="navbar-brand" href="mainpage">JSP 게시판 웹 사이트</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
            </ul>
            <%
            	if (userID == null){
            %>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                <a href="#" class = "dropdown-toggle"
                    data-toggle="dropdown" role ="button" 
                    aria-haspopup="true"
                    aria-expanded="false">접속하기<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="login.jsp">로그인</a></li>
                        <li><a href="join.jsp">회원가입</a></li>                    
                    </ul>
                </li>
            </ul>
            <%
            	}else{
            %>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                <a href="/bullteinboard/login.jsp" class = "dropdown-toggle"
                    data-toggle="dropdown" role ="button" 
                    aria-haspopup="true"
                    aria-expanded="false"><%=session.getAttribute("userName") %><span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="login.jsp">로그아웃</a></li>
                    </ul>
                </li>
            </ul>
            <% 
            	}
            %>
        </div>
    </nav>
    <div class= "container">
    	<div class= "row">
    		<form method="post" action="/bbs/mainpage?action=insert">
    			<table class= "table table-stripped" style= "text-align: center; boarder: 1px solid #dddddd">
	    	    	<thead>
		    	    	<tr>
		    	    		<th colspan= "2" style= "background-color: #eeeeee; text-align: center;">게시판 글쓰기 양식</th>
		    	    	</tr>
	    	    	</thead>
			    	<tbody>
			    	
			    		<tr>
			    			<td><input type="text" class="form-control" placeholder="글 제목"  name="subject" maxlength="50" ></td>
			    		</tr>
			    		<tr>
			    			<td><textarea class="form-control" placeholder="글 내용"  name="content" maxlength="2048" style= "height:350px" ></textarea></td>
			    		</tr>
			    		<tr>
			    			<td><input type="hidden" class="form-control" placeholder="글 제목"  name="userNum" maxlength="50" value="<%=session.getAttribute("userNum") %>"></td>
			    </tr>
			    	</tbody>
    	    	</table>
    	    	<input type="submit" class="btn btn-primary pull-right" value="글쓰기">
    	    	
    		</form>
    	    </div>
    </div>
       <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>