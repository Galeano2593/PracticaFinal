public class ObjTabletaGrafica {
    private String serial;
    private String marca;
    private double tamano;
    private double precio;
    private String almacenamiento;
    private double peso;
    
    public ObjTabletaGrafica() {}
    
   
    public String getSerial() { return serial; }
    public void setSerial(String serial) { this.serial = serial; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public double getTamano() { return tamano; }
    public void setTamano(double tamano) { this.tamano = tamano; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public String getAlmacenamiento() { return almacenamiento; }
    public void setAlmacenamiento(String almacenamiento) { this.almacenamiento = almacenamiento; }
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
    
    @Override
    public String toString() {
        return "Serial: " + serial + ", Marca: " + marca + ", Tamaño: " + tamano + 
               " pulgadas, Precio: $" + precio + ", Almacenamiento: " + almacenamiento + 
               ", Peso: " + peso + " kg";
    }
}