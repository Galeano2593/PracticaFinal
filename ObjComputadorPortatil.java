public class ObjComputadorPortatil {
    private String serial;
    private String marca;
    private double tamano;
    private double precio;
    private String sistemaOperativo;
    private String procesador;
    
    public ObjComputadorPortatil() {}
    
   
    public String getSerial() { return serial; }
    public void setSerial(String serial) { this.serial = serial; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public double getTamano() { return tamano; }
    public void setTamano(double tamano) { this.tamano = tamano; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public String getSistemaOperativo() { return sistemaOperativo; }
    public void setSistemaOperativo(String sistemaOperativo) { this.sistemaOperativo = sistemaOperativo; }
    public String getProcesador() { return procesador; }
    public void setProcesador(String procesador) { this.procesador = procesador; }
    
    @Override
    public String toString() {
        return "Serial: " + serial + ", Marca: " + marca + ", Tamaño: " + tamano + 
               " pulgadas, Precio: $" + precio + ", SO: " + sistemaOperativo + 
               ", Procesador: " + procesador;
    }
}