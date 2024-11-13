package mutualista;
public class Medico {
    
    private String ci;       
    private String nombreyapellido;
    private String celular;
    private String contrasena;

    // Constructor completo
    public Medico(String ci, String nombreyapellido, String celular, String contrasena) {
        
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
}
