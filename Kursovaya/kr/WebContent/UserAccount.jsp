<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty email || empty password  || role!='user'}">
	<c:redirect url="/Auth" />
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
@import url(https://fonts.googleapis.com/css?family=Roboto:300);

.first {
	background: #FFFFFF;
	max-width: 360px;
	margin: 0 auto 100px;
	padding: 45px;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

input {
	font-family: "Roboto", sans-serif;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.form2 {
	background: #FFFFFF;
	width: 250px;
	margin: 1em;
	padding: 1em;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
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

.allTarifes {
	display: flex;
	flex-direction: row;
	flex-wrap: wrap;
	margin: 2em;
}

h1, h2 {
	font-family: "Roboto", sans-serif;
	text-align: center;
}

input[type="submit"]:hover, input[type="submit"]:active, input[type="submit"]:focus
	{
	background: #43A047;
}

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

.form2 .first2 p {
	font-family: "Roboto", sans-serif;
	font-size: 14px;
	margin: 0;
}
</style>
<title>Личный кабинет</title>
</head>
<body>
	<div class="page">
		<div class="header">
			<ul>
				<li><a href="MainPage.html">Главная страница</a></li>
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
			<div class="form">
				<form action="/kr/UserSearch" method="POST" class="first" id="first">
					<input type="search" name="name" placeholder="Поиск тарифа" /> <input
						type="submit" value="Искать" /> <input type="reset" />
				</form>
			</div>
			<div class="allTarifes">
				<c:forEach items="${TarifList}" var="cell">
					<div class="form2">
						<form action="/kr/AddUserTarif" method="POST" class="first2"
							id="first2">
							<input type="hidden" name="userEmail" readonly value="${email}" />
							<input type="hidden" name="userPassword" readonly
								value=<c:out value="${password}"/>> <input type="hidden"
								name="id" placeholder="ID тарифа" readonly
								value=<c:out value="${cell.ID}"/>>
							<p>Название тарифа</p>
							<input type="text" name="name"
								placeholder="Название нового тарифа" readonly
								value=<c:out value="${cell.name}" />>
							<p>Скорость в мегабитах</p>
							<input type="number" name="speed"
								placeholder="Скорость нового тарифа в мегабитах" readonly
								min="1" value=<c:out value="${cell.speed}"/>>
							<p>Цена тарифа</p>
							<input type="number" name="price"
								placeholder="Цена нового тарифа в рублях" readonly min="1"
								value=<c:out value="${cell.price}"/>> <input
								type="submit" value="отправить заявку" />
						</form>
					</div>
				</c:forEach>
			</div>
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