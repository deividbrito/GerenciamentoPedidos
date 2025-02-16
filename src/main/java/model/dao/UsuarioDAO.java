package model.dao;

import model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection conn;

    // construtor que recebe a conexão com o banco de dados
    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }

    // método para autenticar um usuário com base no login e senha
    public Usuario autenticar(String login, String senha) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, login);
            stmt.setString(2, senha);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapUsuario(rs);
                }
            }
        }
        return null;
    }

    // método para inserir um novo usuário no banco de dados
    public void inserir(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (login, senha) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.executeUpdate();
        }
    }

    // método para listar todos os usuários no banco de dados
    public List<Usuario> listar() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                usuarios.add(mapUsuario(rs));
            }
        }
        return usuarios;
    }

    // método privado para mapear os dados de um ResultSet para um objeto Usuario
    private Usuario mapUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setLogin(rs.getString("login"));
        usuario.setSenha(rs.getString("senha"));
        return usuario;
    }
}
