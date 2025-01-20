<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página Principal</title>
	 <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 100%;
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        h1 {
            text-align: center;
            color: #333;
            font-size: 28px;
            margin-bottom: 20px;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        ul li {
            margin: 10px 0;
        }

        ul li a {
            text-decoration: none;
            color: #007BFF;
            font-size: 18px;
            transition: color 0.3s;
        }

        ul li a:hover {
            color: #0056b3;
        }

        li a:last-child {
            color: #dc3545;
        }

        li a:last-child:hover {
            color: #bd2130;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Bem-vindo, ${usuario.login}!</h1>
        <ul>
            <li><a href="controller?action=manterPedido">Manter Pedidos</a></li>
            <li><a href="controller?action=gerarRelatorio">Gerar Relatório</a></li>
            <li><a href="cadastro.jsp">Cadastrar Usuário</a></li>
            <li><a href="controller?action=logout">Sair</a></li>
        </ul>
    </div>
</body>
</html>
