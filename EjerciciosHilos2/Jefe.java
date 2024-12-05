
class Empleado extends Thread{
    String nombre;
    Saludo saludo;
    boolean esJefe;

    public Empleado(String nombre, Saludo saludo, boolean esJefe) {
        this.nombre = nombre;
        this.saludo = saludo;
        this.esJefe = esJefe;
    }

    @Override
    public void run() {
        if (esJefe){
            saludo.SaludoJefe(nombre);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else {
            saludo.SaludoEmpleado(nombre);
        }
    }
}
class Saludo{
    public synchronized void SaludoEmpleado(String nombre){
        try {
            wait();
            System.out.println( nombre + " Hola Jefe");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized void SaludoJefe(String nom){
        System.out.println( nom + " Hola Empleados");
        notifyAll();
    }


}

public class Jefe {
    public static void main(String[] args) {
        Saludo s1 = new Saludo();
        Empleado e1 = new Empleado("Matias",s1,false);
        Empleado e2 = new Empleado("Lucas",s1,false);
        Empleado e3 = new Empleado("Jefe",s1,true);
        Empleado e4 = new Empleado("Jeremay",s1,false);
        e1.start();
        e2.start();
        e3.start();
        e4.start();
    }
}
