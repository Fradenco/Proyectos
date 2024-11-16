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
    ////////////////////////////////////////////////////////////////////////////
    public Connection getConexion() {
        if (con == null) {
            conectar(); // Llama a conectar() si la conexión aún no está establecida
        }
        return con;
    }
    ////////////////////////////////////////////////////////////////////////////
    public ResultSet ejecutarConsulta(String consulta) {
        conectar();
        try {
            return sql.executeQuery(consulta);
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar consulta: " + ex.getMessage());
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public void insertarUsuario(String cedula, String nombreyapellido, String telefono, String contrasena, String rol) {
        String sql = "INSERT INTO usuarios (cedula, nombreyapellido, telefono, contrasena, rol) VALUES (?, ?, ?, ?, ?)";
        conectar();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cedula);
            stmt.setString(2, nombreyapellido);
            stmt.setString(3, telefono);
            stmt.setString(4, contrasena);
            stmt.setString(5, rol);
            stmt.executeUpdate();
            System.out.println("Usuario registrado correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al insertar usuario: " + ex.getMessage());
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    // Método para insertar un nuevo paciente en la base de datos
    public void insertarPaciente(String cedula) {
        insertarEnTablaEspecifica("paciente", cedula);
    }
    ////////////////////////////////////////////////////////////////////////////
    // Método para insertar un nuevo medico en la base de datos
    public void insertarMedico(String cedula, String especialidad) {
        String sql = "INSERT INTO medico (cedula, especialidad) VALUES (?, ?)";
        conectar();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cedula);
            stmt.setString(2, especialidad);
            stmt.executeUpdate();
            System.out.println("Medico registrado correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al insertar medico: " + ex.getMessage());
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    // Método para insertar un nuevo administrador en la base de datos
    public void insertarAdministrativo(String cedula) {
        insertarEnTablaEspecifica("administrativo", cedula);
    }
    ////////////////////////////////////////////////////////////////////////////
    private void insertarEnTablaEspecifica(String tabla, String cedula) {
        String sql = "INSERT INTO " + tabla + " (cedula) VALUES (?)";
        conectar();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cedula);
            stmt.executeUpdate();
            System.out.println("Registro en tabla " + tabla + " realizado correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al insertar en " + tabla + ": " + ex.getMessage());
        }
    }
    ////////////////////////////////////////////////////////////////////////////    
    // Verifica si una cédula ya está registrada en la tabla usuarios
    public boolean esCedulaDuplicada(String cedula) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE cedula = ?";
        conectar();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cedula);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0; // Retorna true si la cédula ya existe
        } catch (SQLException ex) {
            System.out.println("Error al verificar cédula duplicada: " + ex.getMessage());
            return false;
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public void registrarUsuario(String cedula, String nombreyapellido, String telefono, String contrasena, String rol, String especialidad) {
    conectar();

    // Verificar si la cédula ya está registrada
    if (esCedulaDuplicada(cedula)) {
        System.out.println("Error: La cédula ya está registrada.");
        return;
    }

    // Paso 1: Registrar en la tabla usuarios
    insertarUsuario(cedula, nombreyapellido, telefono, contrasena, rol);

    // Paso 2: Registrar en la tabla específica según el rol
    switch (rol) {
        case "paciente":
            insertarPaciente(cedula);
            break;
        case "medico":
            if (especialidad != null && !especialidad.isEmpty()) {
                insertarMedico(cedula, especialidad);
            } else {
                System.out.println("Error: La especialidad es obligatoria para un médico.");
                return;
            }
            break;
        case "administrativo":
            insertarAdministrativo(cedula);
            break;
        default:
            System.out.println("Error: Rol desconocido.");
            return;
    }

    System.out.println(rol.substring(0, 1).toUpperCase() + rol.substring(1) + " registrado correctamente.");
}

    ////////////////////////////////////////////////////////////////////////////
    // Método para obtener todas las citas de la base de datos
    public ResultSet getCitas() {
        conectar();
        String consulta = "SELECT * FROM agenda_citas"; // Ajusta la consulta según tus necesidades
        try {
            return sql.executeQuery(consulta); // Ejecuta la consulta y retorna el ResultSet
        } catch (SQLException ex) {
            System.out.println("Error al obtener citas: " + ex.getMessage());
            return null; // Retorna null en caso de error
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public String iniciarSesion(String cedula, String contrasena) {
        conectar(); // Asegura que la conexión esté establecida
    
        String sql = "SELECT rol FROM usuarios WHERE cedula = ? AND contrasena = ?";
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setString(1, cedula);
        stmt.setString(2, contrasena);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getString("rol"); // Retorna el rol del usuario
        }
    } catch (SQLException ex) {
        System.out.println("Error al verificar el inicio de sesión: " + ex.getMessage());
    }
    return "invalido"; // Retorna "invalido" si no se encuentra el usuario
    }
    ////////////////////////////////////////////////////////////////////////////
// Método auxiliar para verificar el usuario en la base de datos
    private boolean verificarUsuario(String cedula, String contrasena, String sql) throws SQLException {
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cedula);
            stmt.setString(2, contrasena);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Retorna true si se encontró un resultado
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    public void cerrarConexion() {
        if (con != null) {
           try {
                con.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}