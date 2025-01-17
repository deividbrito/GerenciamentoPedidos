<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Relatório de Pedidos</title>
    <link rel="stylesheet" href="styles.css">
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
