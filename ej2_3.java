import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ej2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> Palabras = new ArrayList<String>();
        for (int i = 0; i<10 ; i++){
            System.out.println("Dime una palabra: ");
            String palabra = sc.next();
            Palabras.add(palabra);
        }
        Collections.sort(Palabras);
        System.out.println("Lista 10 Palabras: ");
        for (String recorrerPalabras : Palabras){
            System.out.print(recorrerPalabras + " ");
        }

    }
}
