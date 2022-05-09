<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty email || empty password  || role!='admin'}">
	<c:redirect url="/Auth" />
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
@import url(https://fonts.googleapis.com/css?family=Roboto:300);

h1 {
	font-family: "Roboto", sans-serif;
	text-align: center;
}

ul {
	list-style: none;
	margin: 0 0 0 0;
	padding: 0;
	margin-top: 40px;
	font-family: "Roboto", sans-serif;
	text-align: center;
	font-size: 25px;
}

li {
	display: inline;
	padding: 15px;
}

a {
	text-decoration: none;
}

li:hover {
	background-color: #bcfdbf;
}

.page {
	display: flex;
	flex-direction: column;
	flex-wrap: wrap;
	align-items: center;
	justify-content: center;
	font-family: "Roboto", sans-serif;
	text-align: center;
}

.footer {
	margin-top: 2em;
}

.footer p {
	margin: 0px;
}
</style>
<title>Личный кабинет</title>
</head>
<body>
	<div class="page">
		<div class="header">
			<ul>
				<li><a href="MainPage.html">Главная страница</a></li>
				<li><a href="/kr/AdminFeedback">Ответить на вопросы</a></li>
				<li><a href="/kr/NewTarif">Добавить тариф</a></li>
				<li><a href="/kr/ChangeTarif">Изменить тариф</a></li>
				<li><a href="/kr/DeleteTarif">Удалить тариф</a></li>
				<li><a href="/kr/Logout">Выйти</a></li>
			</ul>
		</div>
		<div class="content">
			<%
			Cookie cookie = null;
			Cookie[] cookies = null;
			cookies = request.getCookies();
			String Username = "";
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					cookie = cookies[i];
					if (cookie.getName().equals("name")) {
				Username = cookie.getValue().toString();
				break;
					}
				}
			}
			%>
			<h1 align="center">
				Добро пожаловать,
				<%=Username%></h1>
		</div>
		<div class="footer">
			<p>© 2022 Коновалов Эльдар, ИФСТ-31</p>
			<p>
				По интересующим вопросам пишите на <a
					href="mailto:eldar.konovalov@mail.ru">eldar.konovalov@mail.ru</a>
			</p>
		</div>
	</div>
</body>
</html>