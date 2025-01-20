<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manutenção de Pedidos</title>
    
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

        form {
            display: flex;
            flex-direction: column;
        }

        form label {
            font-size: 16px;
            margin-bottom: 5px;
        }

        form input, form textarea {
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

        h2 {
            font-size: 22px;
            color: #333;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Manutenção de Pedidos</h1>
        <form action="controller?action=manterPedido" method="post">
            <input type="hidden" name="idpedido" value="${pedido.idPedido}">
            <label for="nomeCliente">Nome do Cliente:</label>
            <input type="text" id="nomeCliente" name="nomeCliente" value="${pedido.nomeCliente}" required><br><br>

            <label for="enderecoEntrega">Endereço de Entrega:</label>
            <input type="text" id="enderecoEntrega" name="enderecoEntrega" value="${pedido.enderecoEntrega}" required><br><br>

            <label for="valor">Valor:</label>
            <input type="number" id="valor" name="valor" value="${pedido.valor}" step="0.01" required><br><br>

            <label for="descricao">Descrição:</label>
            <textarea id="descricao" name="descricao">${pedido.descricao}</textarea><br><br>

            <input type="submit" value="Salvar Pedido">
        </form>

        <h2>Pedidos Existentes</h2>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nome Cliente</th>
                <th>Endereço de Entrega</th>
                <th>Valor</th>
                <th>Descrição</th>
                <th>Ações</th>
            </tr>
            <c:forEach var="pedido" items="${pedidos}">
                <tr>
                    <td>${pedido.idPedido}</td>
                    <td>${pedido.nomeCliente}</td>
                    <td>${pedido.enderecoEntrega}</td>
                    <td>${pedido.valor}</td>
                    <td>${pedido.descricao}</td>
                    <td>
                        <a href="controller?action=manterPedido&idpedido=${pedido.idPedido}">Editar</a> |
                        <a href="controller?action=deletarPedido&idpedido=${pedido.idPedido}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
