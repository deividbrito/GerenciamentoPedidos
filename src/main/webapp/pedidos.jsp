<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manutenção de Pedidos</title>
    <link rel="stylesheet" href="styles.css">
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
