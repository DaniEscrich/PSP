public class Simple1 extends Thread {
    private static int contador = 0;

    public void run() {
        for (int i = 0; i < 1000; i++) {
            contador++;
        }
    }
    public static void main(String[] args) {
        Thread[] hilos = new Thread[5];
        for (int i = 0; i < 5; i++) {
            hilos[i] = new Simple1();
            hilos[i].start();
        }
        System.out.println("Contador Final: " + contador);
    }
}
