package mutualista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Paciente {
    
    private String cedula_paciente;       
    private String nombreyapellido;
    private String telefono;
    private String contrasena;

    // Constructor completo
    public Paciente(String cedula_paciente, String nombreyapellido, String telefono, String contrasena) {
        
        this.cedula_paciente = cedula_paciente;
        this.nombreyapellido = nombreyapellido;
        this.telefono = telefono;
        this.contrasena = contrasena;
    }
    
    public String getCedula_paciente() {
        return cedula_paciente;
    }
    
    public void setCedula_paciente(String cedula_paciente) {
        this.cedula_paciente = cedula_paciente;
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
    
    public boolean registrarPaciente(String nombreyapellido, String telefono, String cedula_paciente, String contrasena){
        
        String sql = "INSERT INTO paciente (nombreyapellido, telefono, cedula_paciente, contrasena) values (?, ?, ?, ?)";
        
        Conexion c = new Conexion();
        c.conectar();
        PreparedStatement pst;
        Connection conectar = c.con;
        
        try{
            pst = conectar.prepareStatement(sql);
            pst.setString(2, nombreyapellido);
            pst.setString(3, telefono);
            pst.setString(1, cedula_paciente);
            pst.setString(4, contrasena);
            
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
}