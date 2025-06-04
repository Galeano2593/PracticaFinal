import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<ObjEstudianteIngenieria> estudiantesIngenieria = new ArrayList<>();
    private ArrayList<ObjEstudianteDiseno> estudiantesDiseno = new ArrayList<>();
    private ArrayList<ObjComputadorPortatil> computadores = new ArrayList<>();
    private ArrayList<ObjTabletaGrafica> tabletas = new ArrayList<>();

    
    public boolean menuIngenieria() {
        int opcion;
        
        do {
            System.out.println("\nMENÚ ESTUDIANTES DE INGENIERÍA:");
            System.out.println("1. Registrar préstamo de equipo");
            System.out.println("2. Modificar préstamo de equipo");
            System.out.println("3. Devolución de equipo");
            System.out.println("4. Buscar equipo");
            System.out.println("5. Volver al menú principal");
            
            opcion = validarEntero("Seleccione una opción (1-5): ", 1, 5);
            
            switch (opcion) {
                case 1:
                    return registrarPrestamoIngenieria();
                case 2:
                    return modificarPrestamoIngenieria();
                case 3:
                    return devolverEquipoIngenieria();
                case 4:
                    return buscarEquipoIngenieria();
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    return true;
            }
        } while (true);
    }

    public boolean menuDiseno() {
        int opcion;
        
        do {
            System.out.println("\nMENÚ ESTUDIANTES DE DISEÑO:");
            System.out.println("1. Registrar préstamo de equipo");
            System.out.println("2. Modificar préstamo de equipo");
            System.out.println("3. Devolución de equipo");
            System.out.println("4. Buscar equipo");
            System.out.println("5. Volver al menú principal");
            
            opcion = validarEntero("Seleccione una opción (1-5): ", 1, 5);
            
            switch (opcion) {
                case 1:
                    return registrarPrestamoDiseno();
                case 2:
                    return modificarPrestamoDiseno();
                case 3:
                    return devolverEquipoDiseno();
                case 4:
                    return buscarEquipoDiseno();
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    return true;
            }
        } while (true);
    }

    
    private boolean registrarPrestamoIngenieria() {
        System.out.println("\nREGISTRAR PRÉSTAMO PARA ESTUDIANTE DE INGENIERÍA");
        
        String cedula = validarCadena("Ingrese la cédula del estudiante: ", false);
        if (buscarEstudianteIngenieria(cedula) != null) {
            System.out.println("Error: Este estudiante ya tiene un equipo asignado.");
            return false;
        }
        
        ObjEstudianteIngenieria estudiante = new ObjEstudianteIngenieria();
        estudiante.setCedula(cedula);
        estudiante.setNombre(validarCadena("Ingrese el nombre: ", true));
        estudiante.setApellido(validarCadena("Ingrese el apellido: ", true));
        estudiante.setTelefono(validarCadena("Ingrese el teléfono: ", false));
        estudiante.setSemestre(validarEntero("Ingrese el semestre actual: ", 1, 10));
        estudiante.setPromedio(validarDouble("Ingrese el promedio acumulado: ", 0, 5));
        
        ObjComputadorPortatil computador = new ObjComputadorPortatil();
        computador.setSerial(validarCadena("Ingrese el serial del computador: ", false));
        computador.setMarca(validarCadena("Ingrese la marca del computador: ", true));
        computador.setTamano(validarDouble("Ingrese el tamaño en pulgadas: ", 10, 20));
        computador.setPrecio(validarDouble("Ingrese el precio: ", 0, 10000));
        computador.setSistemaOperativo(seleccionarSistemaOperativo());
        computador.setProcesador(seleccionarProcesador());
        
        estudiante.setSerial(computador.getSerial());
        estudiantesIngenieria.add(estudiante);
        computadores.add(computador);
        
        System.out.println("¡Préstamo registrado exitosamente!");
        return true;
    }

    private boolean registrarPrestamoDiseno() {
        System.out.println("\nREGISTRAR PRÉSTAMO PARA ESTUDIANTE DE DISEÑO");
        
        String cedula = validarCadena("Ingrese la cédula del estudiante: ", false);
        if (buscarEstudianteDiseno(cedula) != null) {
            System.out.println("Error: Este estudiante ya tiene un equipo asignado.");
            return false;
        }
        
        ObjEstudianteDiseno estudiante = new ObjEstudianteDiseno();
        estudiante.setCedula(cedula);
        estudiante.setNombre(validarCadena("Ingrese el nombre: ", true));
        estudiante.setApellido(validarCadena("Ingrese el apellido: ", true));
        estudiante.setTelefono(validarEntero("Ingrese el teléfono: ", 1,10));
        estudiante.setModalidad(validarModalidad());
        estudiante.setAsignaturas(validarEntero("Ingrese cantidad de asignaturas: ", 1, 10));
        
        ObjTabletaGrafica tableta = new ObjTabletaGrafica();
        tableta.setSerial(validarCadena("Ingrese el serial de la tableta: ", false));
        tableta.setMarca(validarCadena("Ingrese la marca de la tableta: ", true));
        tableta.setTamano(validarDouble("Ingrese el tamaño en pulgadas: ", 5, 15));
        tableta.setPrecio(validarDouble("Ingrese el precio: ", 0, 5000));
        tableta.setAlmacenamiento(seleccionarAlmacenamiento());
        tableta.setPeso(validarDouble("Ingrese el peso en kg: ", 0.1, 2));
        
        estudiante.setSerial(tableta.getSerial());
        estudiantesDiseno.add(estudiante);
        tabletas.add(tableta);
        
        System.out.println("¡Préstamo registrado exitosamente!");
        return true;
    }

    
    private ObjEstudianteIngenieria buscarEstudianteIngenieria(String cedula) {
        for (ObjEstudianteIngenieria estudiante : estudiantesIngenieria) {
            if (estudiante.getCedula().equalsIgnoreCase(cedula)) {
                return estudiante;
            }
        }
        return null;
    }

    private ObjEstudianteDiseno buscarEstudianteDiseno(String cedula) {
        for (ObjEstudianteDiseno estudiante : estudiantesDiseno) {
            if (estudiante.getCedula().equalsIgnoreCase(cedula)) {
                return estudiante;
            }
        }
        return null;
    }

   
    private boolean modificarPrestamoIngenieria() {
        System.out.println("\nMODIFICAR PRÉSTAMO DE INGENIERÍA");
        String cedula = validarCadena("Ingrese la cédula del estudiante: ", false);
        ObjEstudianteIngenieria estudiante = buscarEstudianteIngenieria(cedula);
        
        if (estudiante == null) {
            System.out.println("No se encontró un estudiante con esa cédula.");
            return false;
        }
        
        System.out.println("\nDatos actuales del estudiante:");
        System.out.println(estudiante.toString());
        
        System.out.println("\n¿Qué dato desea modificar?");
        System.out.println("1. Nombre");
        System.out.println("2. Apellido");
        System.out.println("3. Teléfono");
        System.out.println("4. Semestre");
        System.out.println("5. Promedio");
        System.out.println("6. Computador asignado");
        System.out.println("7. Cancelar");
        
        int opcion = validarEntero("Seleccione una opción (1-7): ", 1, 7);
        
        switch (opcion) {
            case 1:
                estudiante.setNombre(validarCadena("Nuevo nombre: ", true));
                break;
            case 2:
                estudiante.setApellido(validarCadena("Nuevo apellido: ", true));
                break;
            case 3:
                estudiante.setTelefono(validarCadena("Nuevo teléfono: ", false));
                break;
            case 4:
                estudiante.setSemestre(validarEntero("Nuevo semestre (1-10): ", 1, 10));
                break;
            case 5:
                estudiante.setPromedio(validarDouble("Nuevo promedio (0-5): ", 0, 5));
                break;
            case 6:
                return modificarComputador(estudiante.getSerial());
            case 7:
                System.out.println("Modificación cancelada.");
                return false;
        }
        
        System.out.println("¡Datos actualizados correctamente!");
        return true;
    }

    private boolean modificarComputador(String serial) {
        ObjComputadorPortatil computador = null;
        for (ObjComputadorPortatil c : computadores) {
            if (c.getSerial().equalsIgnoreCase(serial)) {
                computador = c;
                break;
            }
        }
        
        if (computador == null) {
            System.out.println("No se encontró el computador con serial: " + serial);
            return false;
        }
        
        System.out.println("\nDatos actuales del computador:");
        System.out.println(computador.toString());
        
        System.out.println("\n¿Qué dato desea modificar?");
        System.out.println("1. Marca");
        System.out.println("2. Tamaño");
        System.out.println("3. Precio");
        System.out.println("4. Sistema Operativo");
        System.out.println("5. Procesador");
        System.out.println("6. Cancelar");
        
        int opcion = validarEntero("Seleccione una opción (1-6): ", 1, 6);
        
        switch (opcion) {
            case 1:
                computador.setMarca(validarCadena("Nueva marca: ", true));
                break;
            case 2:
                computador.setTamano(validarDouble("Nuevo tamaño (10-20 pulgadas): ", 10, 20));
                break;
            case 3:
                computador.setPrecio(validarDouble("Nuevo precio: ", 0, 10000));
                break;
            case 4:
                computador.setSistemaOperativo(seleccionarSistemaOperativo());
                break;
            case 5:
                computador.setProcesador(seleccionarProcesador());
                break;
            case 6:
                System.out.println("Modificación cancelada.");
                return false;
        }
        
        System.out.println("¡Computador actualizado correctamente!");
        return true;
    }

    
    private boolean devolverEquipoIngenieria() {
        System.out.println("\nDEVOLUCIÓN DE EQUIPO DE INGENIERÍA");
        String cedula = validarCadena("Ingrese la cédula del estudiante: ", false);
        ObjEstudianteIngenieria estudiante = buscarEstudianteIngenieria(cedula);
        
        if (estudiante == null) {
            System.out.println("No se encontró un estudiante con esa cédula.");
            return false;
        }
        
        String serial = estudiante.getSerial();
        estudiantesIngenieria.remove(estudiante);
        
        ObjComputadorPortatil computadorAEliminar = null;
        for (ObjComputadorPortatil c : computadores) {
            if (c.getSerial().equalsIgnoreCase(serial)) {
                computadorAEliminar = c;
                break;
            }
        }
        
        if (computadorAEliminar != null) {
            computadores.remove(computadorAEliminar);
        }
        
        System.out.println("¡Equipo devuelto y registros eliminados correctamente!");
        return true;
    }

    
    private boolean buscarEquipoIngenieria() {
        System.out.println("\nBUSCAR EQUIPO DE INGENIERÍA");
        System.out.println("1. Buscar por cédula");
        System.out.println("2. Buscar por serial");
        System.out.println("3. Cancelar");
        
        int opcion = validarEntero("Seleccione una opción (1-3): ", 1, 3);
        
        if (opcion == 3) return false;
        
        if (opcion == 1) {
            String cedula = validarCadena("Ingrese la cédula del estudiante: ", false);
            ObjEstudianteIngenieria estudiante = buscarEstudianteIngenieria(cedula);
            
            if (estudiante == null) {
                System.out.println("No se encontró un estudiante con esa cédula.");
                return false;
            }
            
            System.out.println("\nDatos del estudiante:");
            System.out.println(estudiante.toString());
            
            for (ObjComputadorPortatil c : computadores) {
                if (c.getSerial().equalsIgnoreCase(estudiante.getSerial())) {
                    System.out.println("\nDatos del computador:");
                    System.out.println(c.toString());
                    return true;
                }
            }
            return false;
        } else {
            String serial = validarCadena("Ingrese el serial del computador: ", false);
            
            ObjComputadorPortatil computador = null;
            for (ObjComputadorPortatil c : computadores) {
                if (c.getSerial().equalsIgnoreCase(serial)) {
                    computador = c;
                    break;
                }
            }
            
            if (computador == null) {
                System.out.println("No se encontró un computador con ese serial.");
                return false;
            }
            
            System.out.println("\nDatos del computador:");
            System.out.println(computador.toString());
            
            for (ObjEstudianteIngenieria e : estudiantesIngenieria) {
                if (e.getSerial().equalsIgnoreCase(serial)) {
                    System.out.println("\nDatos del estudiante:");
                    System.out.println(e.toString());
                    return true;
                }
            }
            return true;
        }
    }

    private boolean modificarPrestamoDiseno() {
        System.out.println("\nMODIFICAR PRÉSTAMO DE DISEÑO");
        String cedula = validarCadena("Ingrese la cédula del estudiante: ", false);
        ObjEstudianteDiseno estudiante = buscarEstudianteDiseno(cedula);
        
        if (estudiante == null) {
            System.out.println("No se encontró un estudiante con esa cédula.");
            return false;
        }
        
        System.out.println("\nDatos actuales del estudiante:");
        System.out.println(estudiante.toString());
        
        System.out.println("\n¿Qué dato desea modificar?");
        System.out.println("1. Nombre");
        System.out.println("2. Apellido");
        System.out.println("3. Teléfono");
        System.out.println("4. Modalidad");
        System.out.println("5. Asignaturas");
        System.out.println("6. Tableta asignada");
        System.out.println("7. Cancelar");
        
        int opcion = validarEntero("Seleccione una opción (1-7): ", 1, 7);
        
        switch (opcion) {
            case 1:
                estudiante.setNombre(validarCadena("Nuevo nombre: ", true));
                break;
            case 2:
                estudiante.setApellido(validarCadena("Nuevo apellido: ", true));
                break;
            case 3:
                estudiante.setTelefono(validarEntero("Nuevo teléfono: ", 1,10   ));
                break;
            case 4:
                estudiante.setModalidad(validarModalidad());
                break;
            case 5:
                estudiante.setAsignaturas(validarEntero("Nueva cantidad de asignaturas (1-10): ", 1, 10));
                break;
            case 6:
                return modificarTableta(estudiante.getSerial());
            case 7:
                System.out.println("Modificación cancelada.");
                return false;
        }
        
        System.out.println("¡Datos actualizados correctamente!");
        return true;
    }
    
    private boolean modificarTableta(String serial) {
        ObjTabletaGrafica tableta = null;
        for (ObjTabletaGrafica t : tabletas) {
            if (t.getSerial().equalsIgnoreCase(serial)) {
                tableta = t;
                break;
            }
        }
        
        if (tableta == null) {
            System.out.println("No se encontró la tableta con serial: " + serial);
            return false;
        }
        
        System.out.println("\nDatos actuales de la tableta:");
        System.out.println(tableta.toString());
        
        System.out.println("\n¿Qué dato desea modificar?");
        System.out.println("1. Marca");
        System.out.println("2. Tamaño");
        System.out.println("3. Precio");
        System.out.println("4. Almacenamiento");
        System.out.println("5. Peso");
        System.out.println("6. Cancelar");
        
        int opcion = validarEntero("Seleccione una opción (1-6): ", 1, 6);
        
        switch (opcion) {
            case 1:
                tableta.setMarca(validarCadena("Nueva marca: ", true));
                break;
            case 2:
                tableta.setTamano(validarDouble("Nuevo tamaño (5-15 pulgadas): ", 5, 15));
                break;
            case 3:
                tableta.setPrecio(validarDouble("Nuevo precio: ", 0, 5000));
                break;
            case 4:
                tableta.setAlmacenamiento(seleccionarAlmacenamiento());
                break;
            case 5:
                tableta.setPeso(validarDouble("Nuevo peso (0.1-2 kg): ", 0.1, 2));
                break;
            case 6:
                System.out.println("Modificación cancelada.");
                return false;
        }
        
        System.out.println("¡Tableta actualizada correctamente!");
        return true;
    }
    
    private boolean devolverEquipoDiseno() {
        System.out.println("\nDEVOLUCIÓN DE EQUIPO DE DISEÑO");
        String cedula = validarCadena("Ingrese la cédula del estudiante: ", false);
        ObjEstudianteDiseno estudiante = buscarEstudianteDiseno(cedula);
        
        if (estudiante == null) {
            System.out.println("No se encontró un estudiante con esa cédula.");
            return false;
        }
        
        String serial = estudiante.getSerial();
        estudiantesDiseno.remove(estudiante);
        
        ObjTabletaGrafica tabletaAEliminar = null;
        for (ObjTabletaGrafica t : tabletas) {
            if (t.getSerial().equalsIgnoreCase(serial)) {
                tabletaAEliminar = t;
                break;
            }
        }
        
        if (tabletaAEliminar != null) {
            tabletas.remove(tabletaAEliminar);
        }
        
        System.out.println("¡Equipo devuelto y registros eliminados correctamente!");
        return true;
    }
    
    private boolean buscarEquipoDiseno() {
        System.out.println("\nBUSCAR EQUIPO DE DISEÑO");
        System.out.println("1. Buscar por cédula");
        System.out.println("2. Buscar por serial");
        System.out.println("3. Cancelar");
        
        int opcion = validarEntero("Seleccione una opción (1-3): ", 1, 3);
        
        if (opcion == 3) return false;
        
        if (opcion == 1) {
            String cedula = validarCadena("Ingrese la cédula del estudiante: ", false);
            ObjEstudianteDiseno estudiante = buscarEstudianteDiseno(cedula);
            
            if (estudiante == null) {
                System.out.println("No se encontró un estudiante con esa cédula.");
                return false;
            }
            
            System.out.println("\nDatos del estudiante:");
            System.out.println(estudiante.toString());
            
            for (ObjTabletaGrafica t : tabletas) {
                if (t.getSerial().equalsIgnoreCase(estudiante.getSerial())) {
                    System.out.println("\nDatos de la tableta:");
                    System.out.println(t.toString());
                    return true;
                }
            }
            return false;
        } else {
            String serial = validarCadena("Ingrese el serial de la tableta: ", false);
            
            ObjTabletaGrafica tableta = null;
            for (ObjTabletaGrafica t : tabletas) {
                if (t.getSerial().equalsIgnoreCase(serial)) {
                    tableta = t;
                    break;
                }
            }
            
            if (tableta == null) {
                System.out.println("No se encontró una tableta con ese serial.");
                return false;
            }
            
            System.out.println("\nDatos de la tableta:");
            System.out.println(tableta.toString());
            
            for (ObjEstudianteDiseno e : estudiantesDiseno) {
                if (e.getSerial().equalsIgnoreCase(serial)) {
                    System.out.println("\nDatos del estudiante:");
                    System.out.println(e.toString());
                    return true;
                }
            }
            return true;
        }
    }
    
  
    private int validarEntero(String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                int valor = sc.nextInt();
                sc.nextLine();
                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("Error: El valor debe estar entre " + min + " y " + max);
                }
            } else {
                System.out.println("Error: Por favor ingrese un número entero válido.");
                sc.nextLine();
            }
        }
    }
    
    private double validarDouble(String mensaje, double min, double max) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextDouble()) {
                double valor = sc.nextDouble();
                sc.nextLine();
                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("Error: El valor debe estar entre " + min + " y " + max);
                }
            } else {
                System.out.println("Error: Por favor ingrese un número válido.");
                sc.nextLine();
            }
        }
    }
    
    private String validarCadena(String mensaje, boolean soloLetras) {
        while (true) {
            System.out.print(mensaje);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                if (soloLetras) {
                    if (input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                        return input;
                    } else {
                        System.out.println("Error: Solo se permiten letras y espacios.");
                    }
                } else {
                    return input;
                }
            } else {
                System.out.println("Error: Este campo no puede estar vacío.");
            }
        }
    }
    
    private String seleccionarSistemaOperativo() {
        System.out.println("\nSELECCIONE EL SISTEMA OPERATIVO:");
        System.out.println("1. Windows 7");
        System.out.println("2. Windows 10");
        System.out.println("3. Windows 11");
        
        int opcion = validarEntero("Opción (1-3): ", 1, 3);
        
        switch (opcion) {
            case 1: return "Windows 7";
            case 2: return "Windows 10";
            case 3: return "Windows 11";
            default: return "Windows 10";
        }
    }
    
    private String seleccionarProcesador() {
        System.out.println("\nSELECCIONE EL PROCESADOR:");
        System.out.println("1. AMD Ryzen");
        System.out.println("2. Intel® Core™ i5");
        
        int opcion = validarEntero("Opción (1-2): ", 1, 2);
        
        switch (opcion) {
            case 1: return "AMD Ryzen";
            case 2: return "Intel® Core™ i5";
            default: return "Intel® Core™ i5";
        }
    }
    
    private String seleccionarAlmacenamiento() {
        System.out.println("\nSELECCIONE EL ALMACENAMIENTO:");
        System.out.println("1. 256 GB");
        System.out.println("2. 512 GB");
        System.out.println("3. 1 TB");
        
        int opcion = validarEntero("Opción (1-3): ", 1, 3);
        
        switch (opcion) {
            case 1: return "256 GB";
            case 2: return "512 GB";
            case 3: return "1 TB";
            default: return "256 GB";
        }
    }
    
    private String validarModalidad() {
        System.out.println("\nMODALIDAD DE ESTUDIO:");
        System.out.println("1. Virtual");
        System.out.println("2. Presencial");
        
        int opcion = validarEntero("Opción (1-2): ", 1, 2);
        
        switch (opcion) {
            case 1: return "Virtual";
            case 2: return "Presencial";
            default: return "Virtual";
        }
    }

    public String imprimirInventarioTotal() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("\nINVENTARIO TOTAL:\n");
        
        sb.append("\nESTUDIANTES DE INGENIERÍA:\n");
        for (ObjEstudianteIngenieria e : estudiantesIngenieria) {
            sb.append(e.toString()).append("\n");
        }
        
        sb.append("\nESTUDIANTES DE DISEÑO:\n");
        for (ObjEstudianteDiseno e : estudiantesDiseno) {
            sb.append(e.toString()).append("\n");
        }
        
        sb.append("\nCOMPUTADORES PORTÁTILES:\n");
        for (ObjComputadorPortatil c : computadores) {
            sb.append(c.toString()).append("\n");
        }
        
        sb.append("\nTABLETAS GRÁFICAS:\n");
        for (ObjTabletaGrafica t : tabletas) {
            sb.append(t.toString()).append("\n");
        }
        
        return sb.toString();
    }
}