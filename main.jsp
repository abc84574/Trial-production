<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, model.Tweet, java.util.List" %>
<%
// セッションスコープに保存されたユーザー情報を取得(Login.java)
User loginUser = (User) session.getAttribute("loginUser");

// アプリケーションスコープに保存されたTweetリストを取得
List<Tweet> tweetList = (List<Tweet>) application.getAttribute("tweetList");

// リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat</title>
</head>
<body>
<h1>Chatメイン</h1>
<p><%= loginUser.getName() %>さん、ログイン中</p>

<!-- Logoutサーブレットへのリンク -->
<p><a href="/chat/Logout">ログアウト</a></p>

<!-- Mainサーブレットへのリンク -->
<p><a href="/chat/Main">更新</a></p>

<!-- Mainサーブレットへpostリクエスト -->
<form action="/chat/Main" method="post">
<input type="text" name="text">
<input type="submit" value="投稿">
</form>

<% if(errorMsg != null) { %>
<p><%=errorMsg %></p>
<% } %>
<% for(Tweet tweet : tweetList) { %>
	<p><%=tweet.getUserName() %>:<%=tweet.getText() %></p>
<% } %>
</body>
</html>