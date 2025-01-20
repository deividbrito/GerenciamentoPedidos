package controller.command;

import model.Usuario;
import model.dao.UsuarioDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import util.DatabaseConnection;

public class LoginCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
    	//obtém login e senha
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        //conexão com o banco
        try (Connection conn = DatabaseConnection.getConnection()) { 
            UsuarioDAO usuarioDAO = new UsuarioDAO(conn); //instanciando DAO
            Usuario usuario = usuarioDAO.autenticar(login, senha); //autenticando o usuário

            if (usuario != null) {
            	//se autenticação for sucesso
                request.getSession().setAttribute("usuario", usuario);
                response.sendRedirect("home.jsp");
            } else {
            	//se autenticação falhar
                request.setAttribute("erro", "Login ou senha inválidos");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
