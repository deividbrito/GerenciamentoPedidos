<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="styles.css"> <!-- Defina seu arquivo CSS -->
</head>
<body>
    <div class="container">
        <h1>Login</h1>
        <form action="controller" method="post">
            <label for="login">Login</label>
            <input type="text" id="login" name="login" required><br><br>

            <label for="senha">Senha</label>
            <input type="password" id="senha" name="senha" required><br><br>

            <input type="submit" value="Entrar">
        </form>
        <p style="color:red;">${erro}</p> <!-- Exibe erro, se houver -->
    </div>
</body>
</html>
