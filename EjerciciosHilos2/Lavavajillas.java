import java.util.ArrayList;

class Plato{
    int numeroPlato;

    public Plato(int numeroPlato) {
        this.numeroPlato = numeroPlato;
    }

    public int getNumeroPlato() {
        return numeroPlato;
    }
}
class PilaPlatos{
    private final ArrayList<Plato> platos = new ArrayList<>();
    int maximoPlatos = 5;

    public synchronized void lavar(int nuevoDato){
        while (platos.size() == maximoPlatos){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Plato p = new Plato(nuevoDato);
        maximoPlatos ++;
        platos.add(p);
        System.out.println("Plato lavado #" + p.getNumeroPlato() + ", total en la pila: " + platos.size());
        notifyAll();
    }
    public synchronized void secar(){
        while (platos.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        Plato plato = platos.remove(0);
        System.out.println("Plato Secado #" + plato.getNumeroPlato() + ", total en la pila: " + platos.size());
        notifyAll();
    }
}
class Friega extends Thread{
    private PilaPlatos pilaPlatos;

    public Friega(PilaPlatos pilaPlatos) {
        this.pilaPlatos = pilaPlatos;
    }

    @Override
    public void run() {
        for (int i = 0; i<=5; i ++){
            pilaPlatos.lavar(i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Seca extends Thread{
    private PilaPlatos pilaPlatos;

    public Seca(PilaPlatos pilaPlatos) {
        this.pilaPlatos = pilaPlatos;
    }

    @Override
    public void run() {
        for (int i = 0; i<=5; i++){
            pilaPlatos.secar();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Lavavajillas {
    public static void main(String[] args) {
        PilaPlatos pp = new PilaPlatos();
        Friega friega = new Friega(pp);
        Seca secar = new Seca(pp);
        friega.start();
        secar.start();
        try {
            friega.join();
            secar.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    }
