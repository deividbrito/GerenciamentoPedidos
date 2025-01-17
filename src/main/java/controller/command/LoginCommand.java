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
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        try (Connection conn = DatabaseConnection.getConnection()) { 
            UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
            Usuario usuario = usuarioDAO.autenticar(login, senha);

            if (usuario != null) {
                request.getSession().setAttribute("usuario", usuario);
                response.sendRedirect("home.jsp");
            } else {
                request.setAttribute("erro", "Login ou senha inválidos");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
