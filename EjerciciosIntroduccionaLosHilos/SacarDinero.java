public class SacarDinero extends Thread {
    private Cuenta cuenta;

    public SacarDinero(Cuenta cuenta, String nombre) {
        super(nombre);
        this.cuenta = cuenta;
    }
    @Override
    public void run() {
        for (int i = 0; i<4 ; i++){
        cuenta.retirarDinero(22, getName());}
    }
}
