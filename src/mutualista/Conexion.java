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
        conectar();
        try {
            return sql.executeQuery(consulta);
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar consulta: " + ex.getMessage());
            return null;
        }
    }

    // Método para insertar un nuevo paciente en la base de datos
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
    
    public boolean esCedulaDuplicada(String cedulaPaciente) {
        conectar(); // Asegura que la conexión esté establecida
        String sql = "SELECT COUNT(*) FROM paciente WHERE cedula_paciente = ?";
        
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cedulaPaciente);
            ResultSet rs = stmt.executeQuery();
        
            // Si el resultado es mayor a 0, significa que la cédula ya está registrada
            if (rs.next() && rs.getInt(1) > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al verificar cédula duplicada: " + ex.getMessage());
        }
        return false;
    }
    
    public void registrarPaciente(Paciente paciente) {
        // Verifica si la cédula ya está en uso
        if (esCedulaDuplicada(paciente.getCedula_paciente())) {
            System.out.println("Error: La cédula ya está registrada.");
            return;
        }

        // Si no está duplicada, procede a insertar el paciente
        insertar(paciente);
        System.out.println("Paciente registrado correctamente.");
    }

    // Método para obtener todas las citas de la base de datos
    public ResultSet getCitas() {
        conectar();
        String consulta = "SELECT * FROM citas"; // Ajusta la consulta según tus necesidades
        try {
            return sql.executeQuery(consulta); // Ejecuta la consulta y retorna el ResultSet
        } catch (SQLException ex) {
            System.out.println("Error al obtener citas: " + ex.getMessage());
            return null; // Retorna null en caso de error
        }
    }
    
    public String iniciarSesion(String cedula, String contrasena) {
    conectar(); // Asegura que la conexión esté establecida
    
    String sqlPaciente = "SELECT 'paciente' AS tipo FROM paciente WHERE cedula_paciente = ? AND contrasena = ?";
    String sqlMedico = "SELECT 'medico' AS tipo FROM medico WHERE cedula_medico = ? AND contrasena = ?";
    String sqlAdministrativo = "SELECT 'administrativo' AS tipo FROM administrativo WHERE cedula_administrativo = ? AND contrasena = ?";
    
    try {
        // Verifica si es un paciente
        if (verificarUsuario(cedula, contrasena, sqlPaciente)) {
            return "paciente";
        }
        
        // Verifica si es un médico
        if (verificarUsuario(cedula, contrasena, sqlMedico)) {
            return "medico";
        }
        
        // Verifica si es administrativo
        if (verificarUsuario(cedula, contrasena, sqlAdministrativo)) {
            return "administrativo";
        }
        
    } catch (SQLException ex) {
        System.out.println("Error al verificar el inicio de sesión: " + ex.getMessage());
    }
    
    return "invalido"; // Retorna "invalido" si no se encuentra el usuario
}

// Método auxiliar para verificar el usuario en la base de datos
private boolean verificarUsuario(String cedula, String contrasena, String sql) throws SQLException {
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setString(1, cedula);
        stmt.setString(2, contrasena);
        ResultSet rs = stmt.executeQuery();
        return rs.next(); // Retorna true si se encontró un resultado
    }
}


}