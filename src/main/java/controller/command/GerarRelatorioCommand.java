package controller.command;

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
        String nomeCliente = request.getParameter("nomeCliente");

        try (Connection conn = DatabaseConnection.getConnection()) {
            PedidoDAO pedidoDAO = new PedidoDAO(conn);
            List<Pedido> pedidos = pedidoDAO.listarPorCliente(nomeCliente);

            request.setAttribute("pedidos", pedidos);
            request.getRequestDispatcher("relatorio.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
