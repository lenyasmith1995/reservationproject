<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Контактные данные</title>
</head>
<body>
	<h1>Контактные данные</h1>
	<form action="/reservation/create" method="POST"> 
		Имя:
		<input type="text" name="clientname">
		<br>
		<br>
		Телефон: +7
		(
		<input type="text" name="clientphone1">
		)
		<input type="text" name="clientphone2">
		<br>
		<br>
		<label>Комментарий:</label>
		<input type="text" name="clientcomment">
		<br>
		<br>
		<input type="submit" value="Забронировать">	
	</form>
</body>
</html>