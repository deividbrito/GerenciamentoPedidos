package controller.command;

//imports
import model.Pedido;
import model.dao.PedidoDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import util.DatabaseConnection;

public class ManterPedidoCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
    	//obtém parametro "acao", que pode ser = incluir / excluir / alterar
        String acao = request.getParameter("acao");
        
        //abre conexão com banco
        try (Connection conn = DatabaseConnection.getConnection()) {
            PedidoDAO pedidoDAO = new PedidoDAO(conn); //instancia do DAO
            
            //verifica se acao = incluir
            if ("incluir".equals(acao)) {
            	//caso seja incluir, cria um novo pedido
                String nomeCliente = request.getParameter("nomeCliente");
                String enderecoEntrega = request.getParameter("enderecoEntrega");
                double valor = Double.parseDouble(request.getParameter("valor"));
                String descricao = request.getParameter("descricao");

                //criando novo objeto com os dados
                Pedido pedido = new Pedido(0, nomeCliente, enderecoEntrega, valor, descricao);
                pedidoDAO.inserir(pedido); //insere no banco
                response.sendRedirect("pedidos.jsp");

            } else if ("excluir".equals(acao)) {
            	//caso seja excluir, deleta um pedido
                int idPedido = Integer.parseInt(request.getParameter("idPedido"));
                pedidoDAO.deletar(idPedido); //deleta o pedido com base no id
                response.sendRedirect("pedidos.jsp");

            } else if ("alterar".equals(acao)) {
            	//caso seja alterar, altera um pedido
                int idPedido = Integer.parseInt(request.getParameter("idPedido"));
                String nomeCliente = request.getParameter("nomeCliente");
                String enderecoEntrega = request.getParameter("enderecoEntrega");
                double valor = Double.parseDouble(request.getParameter("valor"));
                String descricao = request.getParameter("descricao");

                //cria novo objeto com os dados preenchidos
                Pedido pedido = new Pedido(idPedido, nomeCliente, enderecoEntrega, valor, descricao);
                pedidoDAO.atualizar(pedido); //atualiza o pedido no banco com o novo objeto
                response.sendRedirect("pedidos.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
