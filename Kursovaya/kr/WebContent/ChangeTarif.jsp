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

ul {
	list-style: none;
	margin: 0 0 0 0;
	padding: 0;
	margin-top: 40px;
	font-family: "Roboto", sans-serif;
	text-align: center;
	font-size: 25px;
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

.form {
	background: #FFFFFF;
	width: 250px;
	margin: 2em;
	padding: 1em;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

.allTarifes {
	display: flex;
	flex-direction: row;
	flex-wrap: wrap;
	margin: 2em;
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

h1, h2 {
	font-family: "Roboto", sans-serif;
	text-align: center;
}

input {
	font-family: "Roboto", sans-serif;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 10px;
	box-sizing: border-box;
	font-size: 14px;
}

.form input[type="submit"]:hover, .form input[type="submit"]:active,
	.form input[type="submit"]:focus {
	background: #43A047;
}

.form .first p {
	font-family: "Roboto", sans-serif;
	font-size: 14px;
	margin: 0;
}
</style>
<title>Изменить тариф</title>
</head>
<body>
	<div class="page">
		<div class="header">
			<ul>
				<li><a href="MainPage.html">Главная страница</a></li>
				<li><a href="AdminAccount.jsp">Администратор</a></li>
				<li><a href="/kr/NewTarif">Добавить тариф</a></li>
				<li><a href="/kr/DeleteTarif">Удалить тариф</a></li>
				<li><a href="/kr/AdminFeedback">Ответить на вопросы</a></li>
				<li><a href="/kr/Logout">Выйти</a></li>
			</ul>
		</div>
		<div class="content">
			<div class="allTarifes">
				<c:forEach items="${TarifList}" var="cell">
					<div class="form">
						<form action="/kr/ChangeTarif" method="POST" class="first"
							id="first">
							<p>ID тарифа</p>
							<input type="text" name="id" placeholder="ID тарифа" readonly
								value=<c:out value="${cell.ID}"/>>
							<p>Название тарифа</p>
							<input type="text" name="name"
								placeholder="Название нового тарифа" required
								value=<c:out value="${cell.name}" />>
							<p>Скорость в мегабитах</p>
							<input type="number" name="speed"
								placeholder="Скорость нового тарифа в мегабитах" required
								min="1" value=<c:out value="${cell.speed}"/>>
							<p>Цена тарифа</p>
							<input type="number" name="price"
								placeholder="Цена нового тарифа в рублях" required min="1"
								value=<c:out value="${cell.price}"/>> <input
								type="submit" value="отправить" />
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