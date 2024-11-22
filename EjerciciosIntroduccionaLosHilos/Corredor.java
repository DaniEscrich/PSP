import java.util.Random;

public class Corredor extends Thread {
    private String nombre;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Corredor(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public void run() {
        Random r = new Random();
        for (int i = 0; i < 1500; i++) {
            try {
                Thread.sleep(r.nextInt(10));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println("El corredor "+ getNombre() + " ha terminado");
    }

    public static void main(String[] args) {
        String[] corredores = {"Hicham El Guerrouj", "Noah Ngeny", "Mohamed Farah", "Bernat Lagat", "Rashid Ramzi", "Ryan Gregson", "Fermin Cacho", "Teddy Flack"};
        Corredor hilos;
        for (String nombre : corredores) {
            hilos = new Corredor(nombre);
            hilos.start();
        }
    }
}