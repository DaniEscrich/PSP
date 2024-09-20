import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ej2_2 {
    public static void calcularmedia (ArrayList<Integer>numerosAleatorios){
        int suma = 0;
        for (int numeros:numerosAleatorios){
            suma +=numeros;
        }
        double media = (double) suma/numerosAleatorios.size();
        System.out.println("La media es: " + media);
    }
    public static void calcularsuma (ArrayList<Integer>numerosAleatorios){
        int suma = 0;
        for (int numeros:numerosAleatorios){
            suma +=numeros;
        }
        System.out.println("La suma es: " + suma);
    }
    public static void main(String[] args) {
        ArrayList<Integer> numerosAleatorios = new ArrayList<>();
        Random numerosRandoms = new Random();
        int tamanyoArray = numerosRandoms.nextInt(20)+1;
        for (int i = 0; i<tamanyoArray; i++){
            numerosAleatorios.add(numerosRandoms.nextInt(100));
        }
        System.out.println(numerosAleatorios);
        calcularmedia(numerosAleatorios);
        calcularsuma(numerosAleatorios);
        System.out.println("El valor máximo: " + Collections.max(numerosAleatorios));
        System.out.println("El valor máximo: " + Collections.min(numerosAleatorios));
    }
}
