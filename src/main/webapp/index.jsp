<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Transacao"%>
<html>
<head>
<title>Transações</title>
<link rel="stylesheet" href="style/estilo.css">
</head>
<body>
	<h1>Transações</h1>
	<a href="adicionar.jsp">Adicionar Nova Transação</a>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Descrição</th>
			<th>Valor</th>
			<th>Tipo</th>
			<th>Categoria</th>
			<th>Data</th>
			<th>Ações</th>
		</tr>
		<%
		List<Transacao> transacoes = (List<Transacao>) request.getAttribute("transacoes");
		if (transacoes != null) {
			for (Transacao t : transacoes) {
		%>
		<tr>
			<td><%=t.getId()%></td>
			<td><%=t.getDescricao()%></td>
			<td><%=t.getValor()%></td>
			<td><%=t.getTipo()%></td>
			<td><%=t.getCategoria()%></td>
			<td><%=t.getData()%></td>
			<td><a href="excluir?id=<%=t.getId()%>">Excluir</a></td>
		</tr>
		<%
		}
		}
		%>
	</table>

	<form action="resumo" method="get">
		<button type="submit">Ver Resumo</button>
	</form>
</body>
</html>
