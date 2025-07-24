<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>Adicionar Transação</title>
<link rel="stylesheet" href="style/estilo.css">
</head>
<body>
	<h1>Nova Transação</h1>
	<form action="adicionar" method="post">
		Descrição: <input type="text" name="descricao" required><br>
		Valor: <input type="number" name="valor" step="0.01" required><br>
		Tipo: <select name="tipo">
			<option value="receita">Receita</option>
			<option value="despesa">Despesa</option>
		</select><br> Categoria: <input type="text" name="categoria" required><br>
		Data: <input type="date" name="data" required><br>
		<button type="submit">Adicionar</button>
	</form>
</body>
</html>
