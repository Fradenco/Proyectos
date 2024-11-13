package mutualista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Paciente {
    
    private String ci;       
    private String nombreyapellido;
    private String celular;
    private String contrasena;

    // Constructor completo
    public Paciente(String ci, String nombreyapellido, String celular, String contrasena) {
        
        this.ci = ci;
        this.nombreyapellido = nombreyapellido;
        this.celular = celular;
        this.contrasena = contrasena;
    }
    
    public String getCi() {
        return ci;
    }
    
    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombreyApellido() {
        return nombreyapellido;
    }

    public void setNombreyApellido(String nombreyapellido) {
        this.nombreyapellido = nombreyapellido;
    }
    
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public boolean registrarPaciente(String nombreyapellido, String telefono, String cedula, String contrasena){
        
        String sql = "INSERT INTO paciente (cedula_paciente, nombreyapellido, telefono, contraseña) values (?, ?, ?, ?)";
        
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