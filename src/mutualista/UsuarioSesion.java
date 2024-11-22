package mutualista;

public class UsuarioSesion {
    private static String cedula;
    private static String rol;
    private static String idMedico;

    // Métodos para establecer y obtener la cédula
    public static void setCedula(String cedulaLogueada) {
        cedula = cedulaLogueada;
    }

    public static String getCedula() {
        return cedula;
    }

    // Métodos para establecer y obtener el rol (opcional)
    public static void setRol(String rolLogueado) {
        rol = rolLogueado;
    }

    public static String getRol() {
        return rol;
    }
    
    public static void setIdMedico(String id) {
        idMedico = id;
    }

    public static String getIdMedico() {
        return idMedico;
    }
}
