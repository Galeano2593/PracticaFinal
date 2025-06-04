import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Metodos m = new Metodos();
        Scanner sc  = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMENÚ PRINCIPAL:");
            System.out.println("1. Estudiantes de Ingeniería");
            System.out.println("2. Estudiantes de Diseño");
            System.out.println("3. Imprimir inventario total");
            System.out.println("4. Salir del programa");
            
            while (true) {
                System.out.print("Seleccione una opción (1-4): ");
                if (sc .hasNextInt()) {
                    opcion = sc .nextInt();
                    sc .nextLine(); 
                    if (opcion >= 1 && opcion <= 4) {
                        break;
                    } else {
                        System.out.println("Error: Por favor ingrese un número entre 1 y 4.");
                    }
                } else {
                    System.out.println("Error: Por favor ingrese un número válido.");
                    sc .nextLine();
                }
            }

            switch (opcion) {
                case 1:
                    while (!m.menuIngenieria()); 
                    break;
                case 2:
                    while (!m.menuDiseno()); 
                    break;
                case 3:
                    System.out.println(m.imprimirInventarioTotal());
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
            }
        } while (opcion != 4);
        sc .close();
    }
}