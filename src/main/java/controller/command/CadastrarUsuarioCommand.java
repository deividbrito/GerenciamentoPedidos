package controller.command;

//imports
import model.Usuario;
import model.dao.UsuarioDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import util.DatabaseConnection;

public class CadastrarUsuarioCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
    	//obtém login e senha
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        //cria novo usuario com os dados fornecidos
        Usuario usuario = new Usuario(login, senha);

        //se conecta ao banco
        try (Connection conn = DatabaseConnection.getConnection()) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(conn); //instancia DAO
            usuarioDAO.inserir(usuario); // chama método que insere usuario no banco
            response.sendRedirect("home.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
