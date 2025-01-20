package util;

//imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//classe que gerencia conexão com banco de dados
public class DatabaseConnection {

	//constantes para armazenar informações de conexão
    private static final String URL = "jdbc:mysql://localhost:3306/novo_banco";  
    private static final String USER = "root";  
    private static final String PASSWORD = "Deivid10%"; 

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Erro ao conectar ao banco de dados", e);
        }
    }
}
