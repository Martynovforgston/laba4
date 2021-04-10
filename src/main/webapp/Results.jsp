<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Результат расчета объема конуса (расчет ведется в мм):</title>
</head>
<body>
<h1>Результат сложения</h1>
<h2>Ваши введеные данные:</h2>
<p><strong>Радиус основания конуса:</strong> ${first_result}</p>
<p><strong>Высота конуса:</strong> ${second_result}</p>
<p><strong>Результат расчета:</strong> ${result}</p>

<form action="${pageContext.request.contextPath}/Form.jsp">
    <input type="submit" name="sign" value="Назад">
    </form>

</body>
</html>