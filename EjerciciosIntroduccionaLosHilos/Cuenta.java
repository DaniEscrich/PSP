public class Cuenta{
    private static int saldo = 50;
    public Cuenta(int saldo) {
        this.saldo = saldo;
    }



    public static int getSaldo() {
        return saldo;
    }

    public static void setSaldo(int saldo) {
        Cuenta.saldo = saldo;
    }

    public void restar(int cantidad){
    setSaldo(saldo - cantidad);
    }

    public void retirarDinero(int cantidad, String nom){
        if (saldo>=cantidad){
            restar(cantidad);
            System.out.println(nom + " VA A RETIRAR SALDO (ACTUAL ES: " + getSaldo() +")");
        }
        else {
            System.out.println(nom + " No puede retirar dinero, NO HAY SALDO(" + getSaldo() + ")");
        }
    }

}