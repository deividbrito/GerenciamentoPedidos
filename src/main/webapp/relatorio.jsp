<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Relatório de Pedidos</title>

	   <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 100%;
            max-width: 900px;
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

        h2 {
            font-size: 22px;
            color: #333;
            margin-bottom: 15px;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        form label {
            font-size: 16px;
            margin-bottom: 5px;
        }

        form input[type="text"] {
            font-size: 16px;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 100%;
        }

        form input[type="submit"] {
            background-color: #007BFF;
            color: white;
            cursor: pointer;
            font-size: 16px;
        }

        form input[type="submit"]:hover {
            background-color: #0056b3;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 30px;
        }

        table th, table td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }

        table th {
            background-color: #007BFF;
            color: white;
        }

        a {
            color: #007BFF;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Relatório de Pedidos</h1>
        
        <h2>Buscar Pedidos de um Cliente</h2>
        <form action="controller?action=gerarRelatorio" method="post">
            <label for="cliente">Cliente:</label>
            <input type="text" id="cliente" name="cliente" placeholder="Digite o nome do cliente" required><br><br>
            <input type="submit" value="Gerar Relatório">
        </form>

        <h2>Todos os Pedidos</h2>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nome Cliente</th>
                <th>Endereço de Entrega</th>
                <th>Valor</th>
                <th>Descrição</th>
            </tr>
            <c:forEach var="pedido" items="${pedidos}">
                <tr>
                    <td>${pedido.idPedido}</td>
                    <td>${pedido.nomeCliente}</td>
                    <td>${pedido.enderecoEntrega}</td>
                    <td>${pedido.valor}</td>
                    <td>${pedido.descricao}</td>
                </tr>
            </c:forEach>
        </table>

        <h2>Pedidos do Cliente Específico</h2>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nome Cliente</th>
                <th>Endereço de Entrega</th>
                <th>Valor</th>
                <th>Descrição</th>
            </tr>
            <c:forEach var="pedido" items="${pedidosCliente}">
                <tr>
                    <td>${pedido.idPedido}</td>
                    <td>${pedido.nomeCliente}</td>
                    <td>${pedido.enderecoEntrega}</td>
                    <td>${pedido.valor}</td>
                    <td>${pedido.descricao}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
