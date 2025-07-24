<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*"%>

<%
Map<String, Object> resumoMap = (Map<String, Object>) request.getAttribute("resumoMap");

Map<String, Double> receitas = (Map<String, Double>) resumoMap.get("totalReceitasPorCategoria");
Map<String, Double> despesas = (Map<String, Double>) resumoMap.get("totalDespesasPorCategoria");
double saldo = ((Number) resumoMap.get("saldo")).doubleValue();
%>

<html>
<head>
<title>Resumo Financeiro</title>
<link rel="stylesheet" href="style/estilo.css">
</head>
<body>
	<h1>Resumo Financeiro</h1>

	<h2>Receitas por Categoria</h2>
	<ul>
		<%
		if (receitas != null && !receitas.isEmpty()) {
			for (Map.Entry<String, Double> entry : receitas.entrySet()) {
		%>
		<li><%=entry.getKey()%>: R$ <%=String.format("%.2f", entry.getValue())%></li>
		<%
		}
		} else {
		%>
		<li>Nenhuma receita registrada</li>
		<%
		}
		%>
	</ul>

	<h2>Despesas por Categoria</h2>
	<ul>
		<%
		if (despesas != null && !despesas.isEmpty()) {
			for (Map.Entry<String, Double> entry : despesas.entrySet()) {
		%>
		<li><%=entry.getKey()%>: R$ <%=String.format("%.2f", entry.getValue())%></li>
		<%
		}
		} else {
		%>
		<li>Nenhuma despesa registrada</li>
		<%
		}
		%>
	</ul>

	<h2>Saldo Total</h2>
	<p style="font-weight: bold; color: <%=saldo < 0 ? "red" : "green"%>">
		R$
		<%=String.format("%.2f", saldo)%>
	</p>

	<form action="index" method="get" style="margin-top: 20px;">
		<button type="submit">Voltar</button>
	</form>
</body>
</html>
