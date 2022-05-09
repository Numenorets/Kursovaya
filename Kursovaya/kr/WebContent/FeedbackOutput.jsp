<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Ответы на вопросы</title>
<meta charset="utf-8" />
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

li {
	display: inline;
	padding: 15px;
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

h1 {
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
</style>
</head>
<body>

	<div class="page">
		<div class="header">
			<ul>
				<li><a href="MainPage.html">Главная страница</a></li>
				<li><a href="/kr/Auth">Войти</a></li>
				<li><a href="/kr/RegUser">Регистрация</a></li>
				<li><a href="/kr/Feedback">Обратная связь</a></li>
				<li><a href="/kr/FeedbackOutput">Заданные вопросы</a></li>
			</ul>
		</div>
		<div class="content">
			<h1 align="center">Вопросы</h1>
			<table>
				<th>номер вопроса</th>
				<th>имя спрашивающего</th>
				<th>вопрос</th>
				<th>ответ</th>
				<c:forEach items="${feedbackList}" var="cell">
					<tr>
						<td align="center"><c:out value="${cell.ID}" /></td>
						<td align="center"><c:out value="${cell.name}" /></td>
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
</html>