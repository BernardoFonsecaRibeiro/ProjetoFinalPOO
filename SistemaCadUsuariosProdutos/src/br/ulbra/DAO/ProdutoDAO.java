package br.ulbra.DAO;

import br.ulbra.config.ConnectionFactory;
import br.ulbra.entity.Produto;
import br.ulbra.entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProdutoDAO {

    Connection con;

    public ProdutoDAO() throws SQLException {
        con = ConnectionFactory.getConnectionBanco2();
    }

    public void save(Produto p) {

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO produto(nomeProd, dataCadProd, categoriaProd, valorUnitProd, quantEstoqueProd  ) VALUES (?,?,?,?,?)");

            stmt.setString(1, p.getNomeProd());
            stmt.setString(2, p.getCategoriaProd());
            stmt.setString(3, p.getDataCadProd());
            stmt.setDouble(4, p.getValorUnitProd());
            stmt.setInt(5, p.getQuantEstoqueProd());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto Salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<Produto> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produto = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto prod = new Produto();
                prod.setpkidprod(rs.getInt("pkidprod"));
                prod.setNomeProd(rs.getString("nomeProd"));
                prod.setDataCadProd(rs.getString("DataCadProd"));
                prod.setCategoriaProd(rs.getString("CategoriaProd"));
                prod.setValorUnitProd(rs.getDouble("ValorUnitProd"));
                prod.setQuantEstoqueProd(rs.getInt("QuantEstoqueProd"));
                produto.add(prod);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Produto>) produto;
    }

    public void contarProdutos() {
        int quant = read().size();
        JOptionPane.showMessageDialog(null, "você possui " + quant + " produtos em sua lista!");
    }

}
