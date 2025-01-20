package model.dao;

import model.Pedido;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    private Connection conn;

    //construtor que recebe conexão com banco
    public PedidoDAO(Connection conn) {
        this.conn = conn;
    }

    //método que insere pedido
    public void inserir(Pedido pedido) throws SQLException {
        String sql = "INSERT INTO pedidos (nomeCliente, enderecoEntrega, valor, descricao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, pedido.getNomeCliente());
            stmt.setString(2, pedido.getEnderecoEntrega());
            stmt.setDouble(3, pedido.getValor());
            stmt.setString(4, pedido.getDescricao());
            stmt.executeUpdate();
        }
    }

    //método que atualiza pedido
    public void atualizar(Pedido pedido) throws SQLException {
        String sql = "UPDATE pedidos SET nomeCliente = ?, enderecoEntrega = ?, valor = ?, descricao = ? WHERE idPedido = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pedido.getNomeCliente());
            stmt.setString(2, pedido.getEnderecoEntrega());
            stmt.setDouble(3, pedido.getValor());
            stmt.setString(4, pedido.getDescricao());
            stmt.setInt(5, pedido.getIdPedido());
            stmt.executeUpdate();
        }
    }

    //método para deletar pedido
    public void deletar(int idPedido) throws SQLException {
        String sql = "DELETE FROM pedidos WHERE idPedido = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPedido);
            stmt.executeUpdate();
        }
    }

    //método para listar os pedidos
    public List<Pedido> listarTodos() throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedidos";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                pedidos.add(mapPedido(rs));
            }
        }
        return pedidos;
    }

    //método para listar pedidos com base em cliente
    public List<Pedido> listarPorCliente(String nomeCliente) throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedidos WHERE nomeCliente LIKE ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nomeCliente + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    pedidos.add(mapPedido(rs));
                }
            }
        }
        return pedidos;
    }

    //método privado para mapear os dados de um ResultSet para um objeto Pedido
    private Pedido mapPedido(ResultSet rs) throws SQLException {
        Pedido pedido = new Pedido();
        pedido.setIdPedido(rs.getInt("idPedido"));
        pedido.setNomeCliente(rs.getString("nomeCliente"));
        pedido.setEnderecoEntrega(rs.getString("enderecoEntrega"));
        pedido.setValor(rs.getDouble("valor"));
        pedido.setDescricao(rs.getString("descricao"));
        return pedido;
    }
}
