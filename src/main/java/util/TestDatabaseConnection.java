package util;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDatabaseConnection {

	//classe de teste para verificar se a conexão com o banco de dados está funcionando
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            
            if (conn != null) {
                System.out.println("Conexão bem-sucedida ao banco de dados!");
            } else {
                System.out.println("Falha ao obter a conexão.");
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
