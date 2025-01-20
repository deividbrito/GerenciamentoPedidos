<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Usuário</title>
     <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }
        
        .container {
            width: 100%;
            max-width: 500px;
            margin: 50px auto;
            padding: 20px;
            background-color: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        h1 {
            text-align: center;
            color: #333;
            font-size: 24px;
            margin-bottom: 20px;
        }

        label {
            font-size: 16px;
            margin-bottom: 8px;
            display: block;
            color: #333;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            box-sizing: border-box;
        }

        input[type="text"]:focus, input[type="password"]:focus {
            border-color: #4CAF50;
            outline: none;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 12px;
            width: 100%;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        form > input[type="submit"] {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Cadastrar Usuário</h1>
        <form action="controller?action=cadastrarUsuario" method="post">
            <input type="hidden" name="command" value="CadastrarUsuarioCommand">

            <label for="login">Login</label>
            <input type="text" id="login" name="login" required><br><br>

            <label for="senha">Senha</label>
            <input type="password" id="senha" name="senha" required><br><br>

            <input type="submit" value="Cadastrar">
        </form>
    </div>
</body>
</html>
