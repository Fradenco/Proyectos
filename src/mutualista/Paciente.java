package mutualista;
public class Paciente {
    
    private int id;
    private String ci;       
    private String nombreyapellido;
    private String celular;
    private String contrasena;
    private String rol;

    // Constructor completo
    public Paciente(String ci, String nombreyapellido, String celular, String contrsena) {
        
        this.ci = ci;
        this.nombreyapellido = nombreyapellido;
        this.celular = celular;
        this.contrasena = contrasena;
        this.rol = rol;
    }
    
    public int getId(){
        return id;
    }
    
    public int setId(int id){
        return id;
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
    
    public String getContrsena() {
        return contrasena;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public String getRol() {
        return rol;
    }
}

