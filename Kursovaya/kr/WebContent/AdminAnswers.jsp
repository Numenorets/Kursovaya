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

.form .first {
	background: #FFFFFF;
	max-width: 600px;
	margin: 0 auto 100px;
	padding: 45px;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

.form .first textarea {
	font-family: "Roboto", sans-serif;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

textarea {
	resize: none;
	height: 120px;
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

td, th {
	font-family: "Roboto", sans-serif;
	text-align: center;
	font-size: 25px;
}

h1, h2 {
	font-family: "Roboto", sans-serif;
	text-align: center;
}

table {
	margin: 0 auto;
}

td {
	word-break: break-all;
	width: 15em;
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

.form input[type="submit"]:hover, .form input[type="submit"]:active,
	.form input[type="submit"]:focus {
	background: #43A047;
}
</style>
<title>Вопросы пользователей</title>
</head>
<body>
<body>
	<div class="page">
		<div class="header">
			<ul>
				<li><a href="MainPage.html">Главная страница</a></li>
				<li><a href="/kr/NewTarif">Добавить тариф</a></li>
				<li><a href="/kr/ChangeTarif">Изменить тариф</a></li>
				<li><a href="/kr/DeleteTarif">Удалить тариф</a></li>
				<li><a href="/kr/Logout">Выйти</a></li>
			</ul>
		</div>
		<div class="content">
			<div class="form">
				<h1>Ответить на вопросы</h1>
				<form action="/kr/AdminFeedback" method="POST" class="first"
					id="first">
					<input type="number" name="numberQuestion"
						placeholder="номер вопроса" required min="0" />
					<textarea placeholder="Ответ" name="Answer" required></textarea>
					<input type="submit" value="отправить" />
				</form>
			</div>
			<table>
				<th>номер вопроса</th>
				<th>имя</th>
				<th>email</th>
				<th>вопрос</th>
				<th>ответ</th>
				<c:forEach items="${feedbackList}" var="cell">
					<tr>
						<td align="center"><c:out value="${cell.ID}" /></td>
						<td align="center"><c:out value="${cell.name}" /></td>
						<td align="center"><c:out value="${cell.email}" /></td>
						<td align="center"><c:out value="${cell.question}" /></td>
						<td align="center"><c:out value="${cell.answer}" /></td>
					<tr>
				</c:forEach>
			</table>
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
</body>
</html>