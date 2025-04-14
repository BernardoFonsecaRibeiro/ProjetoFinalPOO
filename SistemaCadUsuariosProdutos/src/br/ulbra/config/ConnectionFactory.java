package br.ulbra.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.jdbc.Driver"; //Driver JDBC
    
    private static final String URL1 = "jdbc:mysql://localhost:3306/bdprojeto";// Url do banco de dados
    private static final String USER1 = "root"; //Login e senha do banco de dados
    private static final String PASS1 = "";
    
    private static final String URL2 = "jdbc:mysql://localhost:3306/produto";
    private static final String USER2 = "root";
    private static final String PASS2 = "";

     public static Connection getConnectionBanco1() throws SQLException {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL1, USER1, PASS1);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro Banco 1: " + ex.getMessage());
            return null;
        }
    }

    public static Connection getConnectionBanco2() throws SQLException {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL2, USER2, PASS2);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro Banco 2: " + ex.getMessage());
            return null;
        }
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        closeConnection(con, stmt);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
