package model.dao;


import model.Transacao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {
    private final String URL = "jdbc:mysql://localhost:3306/financeiro";
    private final String USER = "root";
    private final String PASSWORD = "";

    public List<Transacao> listar() {
        List<Transacao> transacoes = new ArrayList<>();
        String sql = "SELECT * FROM transacoes";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Transacao t = new Transacao();
                t.setId(rs.getInt("id"));
                t.setDescricao(rs.getString("descricao"));
                t.setValor(rs.getDouble("valor"));
                t.setTipo(rs.getString("tipo"));
                t.setCategoria(rs.getString("categoria"));
                t.setData(rs.getString("data"));
                transacoes.add(t);
                System.out.print(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transacoes;
    }
}
