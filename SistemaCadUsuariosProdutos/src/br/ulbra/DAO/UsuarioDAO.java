package br.ulbra.DAO;

import br.ulbra.config.ConnectionFactory;
import br.ulbra.entity.Usuario;
import br.ulbra.view.FrmDashBoard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Connection con;

    public UsuarioDAO() throws SQLException {
        con = ConnectionFactory.getConnectionBanco1();
    }

    public boolean checkLogin(String email, String senha) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM bdprojeto WHERE emailUsu = ? and senhaUsu = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {
                check = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;

    }

    public void save(Usuario u) {

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO bdprojeto(nomeusu, emailusu,"
                    + " senhausu, foneusu,cpfusu,cepusu,logradourousu, numerousu,"
                    + "bairrousu,cidadeusu,estadousu ) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

            stmt.setString(1, u.getNomeusu());
            stmt.setString(2, u.getEmailusu());
            stmt.setString(3, u.getSenhausu());
            stmt.setString(4, u.getFoneusu());
            stmt.setString(5, u.getCpfusu());
            stmt.setString(6, u.getCepusu());
            stmt.setString(7, u.getLogradourousu());
            stmt.setString(8, u.getNumerousu());
            stmt.setString(9, u.getBairrousu());
            stmt.setString(10, u.getCidadeusu());
            stmt.setString(11, u.getEstadousu());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário Salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<Usuario> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> usuario = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM bdprojeto");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario us = new Usuario();
                us.setPkidusu(rs.getInt("pkidusu"));
                us.setNomeusu(rs.getString("nomeusu"));
                us.setEmailusu(rs.getString("emailusu"));
                us.setFoneusu(rs.getString("foneusu"));
                us.setCepusu(rs.getString("cepusu"));
                usuario.add(us);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Usuario>) usuario;
    }

}
