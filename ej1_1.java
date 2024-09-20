import java.util.Scanner;

public class ej1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime una posicion del tablero para que empiece el alfil");
        String posicion = sc.next();
        int posicion1 = posicion.charAt(0) - 96;
        int posicion2 = Integer.parseInt(String.valueOf(posicion.charAt(1)));

        System.out.println(posicion1 + "" + posicion2);
        System.out.println("Posiciones donde puede moverse el alfil: ");

        for (int f=1; f<=8 ; f++){
            for (int c= 1; c<=8 ; c++){
                if (Math.abs(posicion1-f) == Math.abs(posicion2-c)){
                    System.out.println((char)(Math.abs(f) + 96) + " " +  Math.abs(c));
                }
            }
        }

    }
}