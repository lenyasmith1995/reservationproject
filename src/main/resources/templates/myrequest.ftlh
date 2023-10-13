<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Бронирование стола</title>
</head>
<body>

	<h1>Бронирование стола</h1>
	<form action="/request/create" method="POST">
	
		Укажите дату:
			<input type="date" 
			id="start" 
			name="inputdate" 
			value="2018-07-22" 
			min="2018-01-01" max="2018-12-31" 
			required pattern="\d{4}-\d{2}-\d{2} /"
			required />
			<br>
			<br>
		
		Укажите время:
			<input type="time" 
			name="inputtime"
			required/>
			<br>
			<br>
		
		Количество персон:
			<input type="number" name="inputcounter" min="1" max="8" >
			<br>
			<br>
		<input type="submit" value="Далее">
		
	</form>
</body>
</html>