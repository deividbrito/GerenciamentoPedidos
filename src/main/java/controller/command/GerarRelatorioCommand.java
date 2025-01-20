package controller.command;

//imports
import model.dao.PedidoDAO;
import model.Pedido;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.List;
import util.DatabaseConnection;

public class GerarRelatorioCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
    	//obtém "nomeCLiente"
        String nomeCliente = request.getParameter("nomeCliente");

        //conecta ao banco de dados
        try (Connection conn = DatabaseConnection.getConnection()) {
            PedidoDAO pedidoDAO = new PedidoDAO(conn); //instancia DAO
            List<Pedido> pedidos = pedidoDAO.listarPorCliente(nomeCliente); //consulta pedidos filtrados por cliente

            request.setAttribute("pedidos", pedidos);
            request.getRequestDispatcher("relatorio.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
