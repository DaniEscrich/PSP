import java.io.*;
import java.util.*;

public class ejer305 {
    public static void main(String[] args) {
        String ficheroPrincipal = "superheroes.txt";
        String marvelFile = "marvel.html";
        String dcFile = "dcweb.html";

        List<String[]> superheroes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ficheroPrincipal))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] dcheroes = linea.split(";");
                if (dcheroes.length == 4) {
                    superheroes.add(dcheroes);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            generarFicherosHtml(superheroes, marvelFile, "M", new String[]{"Captain America", "Spiderman", "IronMan", "Thor", "Hulk"});
            generarFicherosHtml(superheroes, dcFile, "D", new String[]{"Batman", "Flash", "Superman", "Wonder woman", "Aquaman"});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generarFicherosHtml(List<String[]> superheroes, String nombreFichero, String prefijo, String[] nombreSuperheroes) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreFichero))) {
            writer.write("<html><head><title>Superheroes</title></head><body>");
            writer.write("<table border='1'>");
            writer.write("<tr><th>Nombre</th><th>Identidad Secreta</th><th>Descripción</th></tr>");

            for (String[] recorrer : superheroes) {
                if (recorrer[0].startsWith(prefijo) && Arrays.asList(nombreSuperheroes).contains(recorrer[1])) {
                    writer.write("<tr>");
                    writer.write("<td>" + recorrer[1] + "</td>");
                    writer.write("<td>" + recorrer[2] + "</td>");
                    writer.write("<td>" + recorrer[3] + "</td>");
                    writer.write("</tr>");
                }
            }

            writer.write("</table>");
            writer.write("</body></html>");
        }
    }
}
