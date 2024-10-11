import java.io.IOException;

public class VisitaWeb {
    public static void main(String[] args) {
        String cadena  = args[0];
        String[] separarWebs = cadena.split("@");
        try {
            if (separarWebs.length == 1) {
                new ProcessBuilder("firefox", separarWebs[0]).start();
            } else if (separarWebs.length == 2) {
                new ProcessBuilder("firefox", "-new-tab", separarWebs[0], "-new-tab", separarWebs[1]).start();
            } else if (separarWebs.length == 3) {
                new ProcessBuilder("firefox", "-new-tab", separarWebs[0], "-new-tab", separarWebs[1], "-new-tab", separarWebs[2]).start();
            } else {
                System.out.println("Número de webs no adecuado");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
