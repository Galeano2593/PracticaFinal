public class ObjEstudianteIngenieria {
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private int semestre;
    private double promedio;
    private String serial;
    
    public ObjEstudianteIngenieria() {}
    
   
    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public int getSemestre() { return semestre; }
    public void setSemestre(int semestre) { this.semestre = semestre; }
    public double getPromedio() { return promedio; }
    public void setPromedio(double promedio) { this.promedio = promedio; }
    public String getSerial() { return serial; }
    public void setSerial(String serial) { this.serial = serial; }
    
    @Override
    public String toString() {
        return "Cédula: " + cedula + ", Nombre: " + nombre + " " + apellido + 
               ", Teléfono: " + telefono + ", Semestre: " + semestre + 
               ", Promedio: " + promedio + ", Serial Computador: " + serial;
    }
}