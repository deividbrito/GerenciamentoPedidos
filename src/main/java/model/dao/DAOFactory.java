package model.dao;

import java.sql.Connection;

public class DAOFactory {
    public static UsuarioDAO getUsuarioDAO(Connection conn) {
        return new UsuarioDAO(conn);
    }

    public static PedidoDAO getPedidoDAO(Connection conn) {
        return new PedidoDAO(conn);
    }
}
