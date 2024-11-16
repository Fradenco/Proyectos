package mutualista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Usuario {
    
    private String cedula;       
    private String nombreyapellido;
    private String telefono;
    private String contrasena;
    private String rol;

    // Constructor completo
    public Usuario(String cedula, String nombreyapellido, String telefono, String contrasena, String rol) {
        
        this.cedula = cedula;
        this.nombreyapellido = nombreyapellido;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.rol = rol;
    }
    
    public String getCedula() {
        return cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreyApellido() {
        return nombreyapellido;
    }

    public void setNombreyApellido(String nombreyapellido) {
        this.nombreyapellido = nombreyapellido;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public String getRol() {
        return rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public boolean registrarUsuario(String cedula, String nombreyapellido, String telefono, String contrasena, String rol){
        
        String sql = "INSERT INTO usuario (cedula, nombreyapellido, telefono, contrasena, rol) values (?, ?, ?, ?, ?)";
        
        Conexion c = new Conexion();
        c.conectar();
        PreparedStatement pst;
        Connection conectar = c.con;
        
        try{
            pst = conectar.prepareStatement(sql);
            pst.setString(1, cedula);
            pst.setString(2, nombreyapellido);
            pst.setString(3, telefono);
            pst.setString(4, contrasena);
            pst.setString(5, rol);
            
            int i = pst.executeUpdate();
            if(i != 0){
                JOptionPane.showMessageDialog(null, "Los datos se han guardado");
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
    
    private void registrarPaciente(String cedula, String nombreyapellido, String telefono, String contrasena) {
    Conexion c = new Conexion();
    c.conectar();

    // Paso 1: Registrar en la tabla usuarios
    c.insertarUsuario(cedula, nombreyapellido, telefono, contrasena, "paciente");

    // Paso 2: Registrar en la tabla paciente
    c.insertarPaciente(cedula);
}
    
    public class Medico extends Usuario {
        private String especialidad;
    
        public Medico(String cedula, String nombreyapellido, String telefono, String contrasena, String especialidad) {
            super(cedula, nombreyapellido, telefono, contrasena, "medico");
            this.especialidad = especialidad;
        }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
    private void registrarMedico(String cedula, String nombreyapellido, String telefono, String contrasena, String especialidad) {
        Conexion c = new Conexion();
        c.conectar();

    // Paso 1: Registrar en la tabla usuarios
        c.insertarUsuario(cedula, nombreyapellido, telefono, contrasena, "medico");

    // Paso 2: Registrar en la tabla medico
        c.insertarMedico(cedula, especialidad);
}
}