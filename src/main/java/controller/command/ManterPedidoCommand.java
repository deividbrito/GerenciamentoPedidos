package controller.command;

import model.Pedido;
import model.dao.PedidoDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import util.DatabaseConnection;

public class ManterPedidoCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String acao = request.getParameter("acao");
        try (Connection conn = DatabaseConnection.getConnection()) {
            PedidoDAO pedidoDAO = new PedidoDAO(conn);
            
            if ("incluir".equals(acao)) {
                String nomeCliente = request.getParameter("nomeCliente");
                String enderecoEntrega = request.getParameter("enderecoEntrega");
                double valor = Double.parseDouble(request.getParameter("valor"));
                String descricao = request.getParameter("descricao");

                Pedido pedido = new Pedido(0, nomeCliente, enderecoEntrega, valor, descricao);
                pedidoDAO.inserir(pedido);
                response.sendRedirect("pedidos.jsp");

            } else if ("excluir".equals(acao)) {
                int idPedido = Integer.parseInt(request.getParameter("idPedido"));
                pedidoDAO.deletar(idPedido);
                response.sendRedirect("pedidos.jsp");

            } else if ("alterar".equals(acao)) {
                int idPedido = Integer.parseInt(request.getParameter("idPedido"));
                String nomeCliente = request.getParameter("nomeCliente");
                String enderecoEntrega = request.getParameter("enderecoEntrega");
                double valor = Double.parseDouble(request.getParameter("valor"));
                String descricao = request.getParameter("descricao");

                Pedido pedido = new Pedido(idPedido, nomeCliente, enderecoEntrega, valor, descricao);
                pedidoDAO.atualizar(pedido);
                response.sendRedirect("pedidos.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
