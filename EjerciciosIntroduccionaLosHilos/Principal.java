public class Principal extends Thread{
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(100);
        SacarDinero a = new SacarDinero(cuenta,"Juan");
        SacarDinero b = new SacarDinero(cuenta,"Pepe");
        SacarDinero c = new SacarDinero(cuenta,"Pedro");
        a.start();
        b.start();
        c.start();
    }
}
