package controller.command;

import model.Usuario;
import model.dao.UsuarioDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import util.DatabaseConnection;

public class CadastrarUsuarioCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Usuario usuario = new Usuario(login, senha);

        try (Connection conn = DatabaseConnection.getConnection()) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
            usuarioDAO.inserir(usuario);
            response.sendRedirect("home.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
