import java.io.*;

public class Menu extends Thread {
    public static void main(String[] args) {
        String menu = "menu.txt";
        String primer = "primeros.txt";
        String segund = "segundos.txt";
        String tercer = "postres.txt";

        Thread primero = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                        BufferedReader leer = new BufferedReader(new FileReader(menu));
                        BufferedWriter escribir = new BufferedWriter(new FileWriter(primer));
                    String linea;
                    while ((linea = leer.readLine()) != null) {
                        if (linea.startsWith("1-")) {
                            String lineaBuena = linea.substring(2).trim();
                            escribir.write(lineaBuena);
                            escribir.newLine();
                            escribir.flush();
                            System.out.println("El hilo1 " + " escribe... " + lineaBuena);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread segundo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedReader leer = new BufferedReader(new FileReader(menu));
                    BufferedWriter escribir = new BufferedWriter(new FileWriter(segund));
                    String linea;
                    while ((linea = leer.readLine()) != null) {
                        if (linea.startsWith("2-")) {
                            String lineaBuena = linea.substring(2).trim();
                            escribir.write(lineaBuena);
                            escribir.newLine();
                            escribir.flush();
                            System.out.println("El hilo2 " + " escribe... " + lineaBuena);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread tercero = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedReader leer = new BufferedReader(new FileReader(menu));
                    BufferedWriter escribir = new BufferedWriter(new FileWriter(tercer));
                    String linea;
                    while ((linea = leer.readLine()) != null) {
                        if (linea.startsWith("3-")) {
                            String lineaBuena = linea.substring(2).trim();
                            escribir.write(lineaBuena);
                            escribir.newLine();
                            escribir.flush();
                            System.out.println("El hilo3 " + " escribe... " + lineaBuena);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        primero.start();
        segundo.start();
        tercero.start();

    }
}

