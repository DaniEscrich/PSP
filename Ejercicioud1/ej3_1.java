import java.util.Scanner;

public class ej3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        boolean salir = false;
        do {
            try {
                contador ++;
                System.out.println("Ingresa un número entero: ");
                int numeroEntero = sc.nextInt();
                System.out.println("N " +contador +": " + numeroEntero);
            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto, debe ser un número entero. Por favor, inténtelo de nuevo." + "\n" + "N " + contador+ ": ");
                salir= true;
            }
        }while (salir!=true);


    }
}
