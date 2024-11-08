package mutualista;
public class Paciente {
    
    private int id;
    private String ci;       
    private String nombreyapellido;
    private String fechadenacimiento;
    private String celular;
    private String correo;
    private String contrasena;
    private String rol;

    // Constructor completo
    public Paciente(String ci, String nombreyapellido, String fechadenacimiento, String celular, String correo) {
        
        this.ci = ci;
        this.nombreyapellido = nombreyapellido;
        this.celular = celular;
        this.correo = correo;
        this.rol = rol;
    }
    
    public int getId(){
        return id;
    }
    
    public int setId(){
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

    public void setNombreyApellido(String nombre) {
        this.nombreyapellido = nombreyapellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getContrasena() {
        return contrasena;
    }
    
    public void setContrasena(String rol) {
        this.contrasena = contrasena;
    }
    public String getcontrsena() {
        return contrasena;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
}

