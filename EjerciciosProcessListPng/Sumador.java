import java.util.Scanner;

public class Sumador {

    public static void Sumar(int num1, int num2){
        int sumar = 0;
        for (int i = num1; i<=num2; i++){
            sumar +=i;
        }
        System.out.println("La suma del intervalor de " + num1 + " y " + num2 + " es: " + sumar);
    }

    public static void main(String[] args) {
       // System.out.println("Dime un numero: ");
        int n1 =  Integer.parseInt(args[0]);
   //     System.out.println("Dime otro numero: ");
        int n2 = Integer.parseInt(args[1]);
        Sumar(n1,n2);
    }
}
