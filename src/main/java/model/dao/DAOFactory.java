	package model.dao;
	
	import java.sql.Connection;
	
	public class DAOFactory {
		//métodos estáticos para criar uma instância com a conexão fornecida
	    public static UsuarioDAO getUsuarioDAO(Connection conn) {
	        return new UsuarioDAO(conn); //retorna um objeto de UsuarioDAO usando a conexão estabelecida
	    }
	
	    public static PedidoDAO getPedidoDAO(Connection conn) {
	        return new PedidoDAO(conn); //retorna um objeto de PedidoDAO usando a conexão estabelecida
	    }
	}
