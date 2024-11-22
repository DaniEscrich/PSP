import java.util.Scanner;

public class HiloEjemplo1 extends Thread implements Runnable{

    public void run(){
        for (int i = 0; i<3; i++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getName() + ": Nº " + i);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantos hilos quieres? ");
        int numHilos = sc.nextInt();
        for (int i = 0; i<numHilos; i++){
            HiloEjemplo1 a = new HiloEjemplo1();
            a.start();
        }
    }
}
