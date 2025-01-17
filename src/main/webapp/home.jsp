<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página Principal</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Bem-vindo, ${usuario.login}!</h1>
        <ul>
            <li><a href="controller?action=manterPedido">Manter Pedidos</a></li>
            <li><a href="controller?action=gerarRelatorio">Gerar Relatório</a></li>
            <li><a href="controller?action=logout">Sair</a></li>
        </ul>
    </div>
</body>
</html>
