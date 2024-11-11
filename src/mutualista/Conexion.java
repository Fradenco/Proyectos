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
    
    public void insertar(Paciente p) {
    String sql = "INSERT INTO paciente (nombreyapellido, cedula, celular, contrasena) VALUES (?, ?, ?, ?)";
    
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setString(1, p.getNombreyApellido());
        stmt.setString(2, p.getCi());
        stmt.setString(3, p.getCelular());
        stmt.setString(4, p.getContrasena());
        
        stmt.executeUpdate();
            System.out.println("Paciente registrado correctamente.");

    } catch (SQLException ex) {
        System.out.println("Error al insertar paciente: " + ex.getMessage());
    }
}  
}