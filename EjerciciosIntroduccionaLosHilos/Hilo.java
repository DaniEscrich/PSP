public class Hilo extends Thread implements Runnable{
    public Hilo(String nom){
        super(nom);
    }

    public void run(){
        for (int i = 1; i<10; i++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getName() + ": Nº " + i);
        }
    }

    public static void main(String[] args) {
        Hilo a = new Hilo("Pepe");
        a.start();
        Hilo b = new Hilo("Mario");
        b.start();
    }
}
