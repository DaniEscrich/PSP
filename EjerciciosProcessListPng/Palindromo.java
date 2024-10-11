import java.io.*;

public class Palindromo {
    public static void pasarCadenaAMayusculas(String cadena) {
        System.out.println(cadena.toUpperCase());
    }

    public static void adivinarSiEsPalindromo(String cadena) throws IOException {
        File directorioPalindromo = new File("dirPalindromo.txt");
        File directorioNoPalindromo = new File("dirNoPalindromo.txt");
        File directorioTodos = new File("dirTodos.txt");


        String cadenaInvertida = new StringBuilder(cadena).reverse().toString();
        if (cadenaInvertida.equals(cadena)) {
            try (FileWriter fw = new FileWriter(directorioPalindromo, true);
                 BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write("La cadena " + cadena + " es un Palindromo\n");
            }

            try (FileWriter fw2 = new FileWriter(directorioTodos, true);
                 BufferedWriter bw2 = new BufferedWriter(fw2)) {
                bw2.write("La cadena " + cadena + " es un Palindromo\n");
            }
        } else {
            try (FileWriter fw1 = new FileWriter(directorioNoPalindromo, true);
                 BufferedWriter bw1 = new BufferedWriter(fw1)) {
                bw1.write("La cadena " + cadena + " no es un Palindromo\n");
            }
            try (FileWriter fw2 = new FileWriter(directorioTodos, true);
                 BufferedWriter bw2 = new BufferedWriter(fw2)) {
                bw2.write("La cadena " + cadena + " no es un Palindromo\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String cadena = args[0];
        pasarCadenaAMayusculas(cadena);
        String cadena2 = args[1];
        adivinarSiEsPalindromo(cadena2);
    }
}

