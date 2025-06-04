public class ObjEstudianteDiseno {
    private String cedula;
    private String nombre;
    private String apellido;
    private int  telefono;
    private String modalidad;
    private int asignaturas;
    private String serial;
    
    public ObjEstudianteDiseno() {}
    
    
    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public int  getTelefono() { return telefono; }
    public void setTelefono(int telefono) { this.telefono = telefono; }
    public String getModalidad() { return modalidad; }
    public void setModalidad(String modalidad) { this.modalidad = modalidad; }
    public int getAsignaturas() { return asignaturas; }
    public void setAsignaturas(int asignaturas) { this.asignaturas = asignaturas; }
    public String getSerial() { return serial; }
    public void setSerial(String serial) { this.serial = serial; }
    
    @Override
    public String toString() {
        return "Cédula: " + cedula + ", Nombre: " + nombre + " " + apellido + 
               ", Teléfono: " + telefono + ", Modalidad: " + modalidad + 
               ", Asignaturas: " + asignaturas + ", Serial Tableta: " + serial;
    }
}