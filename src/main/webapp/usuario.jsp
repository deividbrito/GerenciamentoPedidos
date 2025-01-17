<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil do Usuário</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Perfil do Usuário</h1>
        
        <c:if test="${not empty usuario}">
            <form action="controller?action=editarUsuario" method="post">
                <input type="hidden" name="idusuario" value="${usuario.id}">

                <label for="nome">Nome:</label>
                <input type="text" id="nome" name="nome" value="${usuario.nome}" required><br><br>

                <label for="email">E-mail:</label>
                <input type="email" id="email" name="email" value="${usuario.email}" required><br><br>

                <label for="telefone">Telefone:</label>
                <input type="text" id="telefone" name="telefone" value="${usuario.telefone}" required><br><br>

                <label for="senha">Nova Senha:</label>
                <input type="password" id="senha" name="senha"><br><br>

                <label for="confirmarSenha">Confirmar Nova Senha:</label>
                <input type="password" id="confirmarSenha" name="confirmarSenha"><br><br>

                <input type="submit" value="Salvar Alterações">
            </form>

            <a href="controller?action=logout">Sair</a>
        </c:if>
        
        <c:if test="${empty usuario}">
            <p>Você não está autenticado. <a href="index.jsp">Faça o login</a>.</p>
        </c:if>
    </div>
</body>
</html>
