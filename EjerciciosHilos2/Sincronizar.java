class Contador{
    int valor;
    public Contador(int valor){
        this.valor = valor;
    }
    public void incrementar(){
        valor++;
    }
    public void decrementar(){
        valor--;
    }
    public int getValor(){
        return valor;
    }
}

public class Sincronizar {
    public static void main(String[] args) throws InterruptedException {
        Contador c = new Contador(100);

        Thread incr = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (c){
                for (int i=0 ; i< 100; i++){
                    c.incrementar();
                    System.out.println("Incrementando..." + c.getValor());
                }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }System.out.println("Incremento final: " + c.getValor());
            }
            });

        Thread decr = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (c){
                    for (int i=0 ; i< 100; i++){
                        c.decrementar();
                        System.out.println("Decrementando..." + c.getValor());
                    }try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }System.out.println("Decremento final: " + c.getValor());
            }
    });
        incr.start();
        decr.start();

        incr.join();
        decr.join();
        System.out.println("Resultado Final : " + c.getValor());
    }
}
