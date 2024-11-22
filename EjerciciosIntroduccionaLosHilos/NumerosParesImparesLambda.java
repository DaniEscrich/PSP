import java.util.Random;

public class NumerosParesImparesLambda extends Thread {
    public static void main(String[] args) {
        Random r = new Random();
        Thread primero = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    int numero = r.nextInt(100) + 1;
                    if (numero % 2 == 0) {
                        System.out.println("Par: " + numero);
                    }
                }
            }
        });
        Thread segundo = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    int numero = r.nextInt(100) + 1;
                    if (numero % 2 != 0) {
                        System.out.println("Impar: " + numero);
                    }
                }
            }
        });
        primero.start();
        segundo.start();

    }
}


