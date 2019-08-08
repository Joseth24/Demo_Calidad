package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection cn;

    public void conectar() throws ClassNotFoundException, SQLException {
        try {
            if (cn == null) {
                Class.forName("com.mysql.jdbc.Driver");
                cn = DriverManager.getConnection("jdbc:mysql://35.212.104.237:3306/JCASTILLA", "root", "daniel123");
                System.out.println("Conectado");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error");
            throw e;
        }
    }

    public void cerrar() throws SQLException { // PARA CERRAR LA CONEXION
        if (cn != null) {
            if (cn.isClosed() == false) {
                cn.close();
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            Conexion dao = new Conexion();
            dao.conectar();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }
//GETTER AND SETTERS

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

}
