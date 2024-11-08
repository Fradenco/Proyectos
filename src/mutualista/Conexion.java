package mutualista;
import java.sql.SQLException;
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
    String sql = "INSERT INTO paciente (nombreyapellido, fechadenacimiento, cedula, celular, correo, contrasena) VALUES (?, ?, ?, ?, ?, ?)";
    
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setString(1, p.getNombreyApellido());
        stmt.setString(2, p.getFechadeNacimiento()); // Si es java.sql.Date
        stmt.setString(3, p.getCi());
        stmt.setString(4, p.getCelular());
        stmt.setString(5, p.getCorreo());
        stmt.setString(6, p.getContrasena());

        stmt.executeUpdate();
    } catch (SQLException ex) {
        System.out.println("Error al insertar paciente: " + ex.getMessage());
    }
}  
}