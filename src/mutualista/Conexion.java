package mutualista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;

public class Conexion {

    Connection con;
    Statement sql;
    ResultSet resultado;

    public void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mutualista", "root", "");
            sql = con.createStatement();
            System.out.println("Conectado Correctamente");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

    }
    
    public ResultSet ejecutarConsulta(String consulta) {
        try {
            return sql.executeQuery(consulta);
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar consulta: " + ex.getMessage());
            return null;
        }
    }

    
    public void insertar(Paciente p) {
        String sql = "INSERT INTO paciente (nombreyapellido, cedula_paciente, telefono, contrasena) VALUES (?, ?, ?, ?)";
    
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, p.getNombreyApellido());
            stmt.setString(2, p.getCedula_paciente());
            stmt.setString(3, p.getTelefono());
            stmt.setString(4, p.getContrasena());
        
            stmt.executeUpdate();
            System.out.println("Paciente registrado correctamente.");

        } catch (SQLException ex) {
            System.out.println("Error al insertar paciente: " + ex.getMessage());
        }
    }
    
    public ResultSet getCitas() {
        String consulta = "SELECT * FROM citas"; // Ajusta la consulta según tus necesidades
        try {
            return sql.executeQuery(consulta); // Ejecuta la consulta y retorna el ResultSet
        } catch (SQLException ex) {
            System.out.println("Error al obtener citas: " + ex.getMessage());
            return null; // Retorna null en caso de error
        }
    }

}