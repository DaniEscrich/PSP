import java.util.Random;

public class ReservaEntradas extends Thread {
    public int entradasDisponibles;
    public int entradasVendidas;
    public int cliente;

    public int getCliente() {
        return cliente;
    }
    public void setCliente(int cliente) {
        this.cliente = cliente;
    }
    public int getEntradasVendidas() {
        return entradasVendidas;
    }
    public void setEntradasVendidas(int entradasVendidas) {
        this.entradasVendidas = entradasVendidas;
    }
    public int getEntradasDisponibles() {
        return entradasDisponibles;
    }
    public void setEntradasDisponibles(int entradasDisponibles) {
        this.entradasDisponibles = entradasDisponibles;
    }
    public ReservaEntradas(int entradasVendidas, int cliente) {
        this.entradasDisponibles = 100;
        this.entradasVendidas = entradasVendidas;
        this.cliente = cliente;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
        System.out.println(getEntradasVendidas() + " reservadas para Cliente " + getCliente());
    }
    public static void main(String[] args) {
        ReservaEntradas hilos;
        Random r = new Random();
        int sumar = 0;
        for (int i = 0 ; i < 10 ; i++){
            int contar = r.nextInt(10) + 1;
            hilos = new ReservaEntradas(contar,i + 1);
            hilos.start();
            sumar = contar + sumar;
        }
        System.out.println("Total entradas vendidas: " + sumar);
    }
}
