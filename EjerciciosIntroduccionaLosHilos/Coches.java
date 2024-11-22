import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Coches {
    static class Coche extends Thread {
        private int numero;
        private String marca;
        private int distanciaTotal;

        public Coche(int numero, String marca) {
            this.numero = numero;
            this.marca = marca;
            this.distanciaTotal = 0;
        }

        @Override
        public void run() {
            Random r = new Random();
            while (distanciaTotal < 500) {
                int distanciaAleatoria = r.nextInt(100);
                distanciaTotal += distanciaAleatoria;
                try {
                    Thread.sleep(200);
                    System.out.println(marca + "(" + numero + ") lleva recorrido " + distanciaTotal + "km!");

                    if (distanciaTotal >= 500) {
                        System.out.println("El " + marca + "(" + numero + ") ha finalizado al recorrer " + distanciaTotal + "km.");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca numero de coches a competir: ");
        int numCoches = sc.nextInt();
        ArrayList<Coche> coches = new ArrayList<>();

        for (int i = 0; i < numCoches; i++) {
            System.out.print("Introduzca la marca del coche " + (i + 1) + ": ");
            String marca = sc.next();
            Coche coche = new Coche(i + 1, marca);
            coches.add(coche);
        }
        System.out.println("\n¡La carrera ha comenzado!\n");
        for (Coche coche : coches) {
            coche.start();
        }
        System.out.println("\n¡La carrera ha finalizado!");
    }
}
