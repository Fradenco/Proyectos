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
    
    public void insertar(Paciente p){
        try {
            sql = con.createStatement();
           sql.executeUpdate("INSERT INTO paciente (nombreyapellido, fechadenacimiento, cedula, celular, correo, contrasena) VALUES ('" + p.getNombreyApellido() + "', " + p.get() + ", " + p.getCi() + ", " + p.getCelular() + ", '" + p.getCorreo() + "', '" + p.getContrasena() + "')");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
   
    
}