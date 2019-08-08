package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.RegistroM;

public class RegistroD extends Conexion {

    public void Registrar(RegistroM regisro) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO REGISTRO(DNI,NOMBRE,CORREO,FECHA_NAC) VALUES(?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, regisro.getDNI());
            ps.setString(2, regisro.getNOMBRE());
            ps.setString(3, regisro.getCORREO());
            ps.setString(4, regisro.getFECHA_NAC());
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    public List<RegistroM> listar() throws Exception {
        List<RegistroM> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM REGISTRO";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                RegistroM registro = new RegistroM();
                registro.setID_REGISTRO(rs.getString("ID_REGISTRO"));
                registro.setDNI(rs.getString("DNI"));
                registro.setNOMBRE(rs.getString("NOMBRE"));
                registro.setCORREO(rs.getString("CORREO"));
                registro.setFECHA_NAC(rs.getString("FECHA_NAC"));
                lista.add(registro);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }

}
