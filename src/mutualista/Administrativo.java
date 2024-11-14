package mutualista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Administrativo {
    
    private String cedula_administrativo;       
    private String nombreyapellido;
    private String telefono;
    private String contrasena;
    private String rol;

    // Constructor completo
    public Administrativo(String cedula_administrativo, String nombreyapellido, String telefono, String contrasena, String rol) {
        
        this.cedula_administrativo = cedula_administrativo;
        this.nombreyapellido = nombreyapellido;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.rol = rol;
    }
    
    public String getCedula_administrativo() {
        return cedula_administrativo;
    }
    
    public void setCedula_administrativo(String cedula_administrativo) {
        this.cedula_administrativo = cedula_administrativo;
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
    
    public boolean registrarAdministrtivo(String nombreyapellido, String telefono, String cedula_administrativo, String contrasena, String rol){
        
        String sql = "INSERT INTO administrativo (nombreyapellido, telefono, cedula_administrativo, contrasena, rol) values (?, ?, ?, ?, ?)";
        
        Conexion c = new Conexion();
        c.conectar();
        PreparedStatement pst;
        Connection conectar = c.con;
        
        try{
            pst = conectar.prepareStatement(sql);
            pst.setString(2, nombreyapellido);
            pst.setString(3, telefono);
            pst.setString(1, cedula_administrativo);
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
}