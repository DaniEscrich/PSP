import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ejer304 {
    public static void main(String[] args) {
        URL url;
        StringBuilder contenidoHtml = new StringBuilder();

        try {
            url = new URL("https://elpais.com/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        try (InputStream is = url.openStream();
             BufferedReader in = new BufferedReader(new InputStreamReader(is))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                contenidoHtml.append(inputLine).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String h2Pattern = "<h2.*?>(.*?)</h2>";
        Pattern patron = Pattern.compile(h2Pattern);
        Matcher matcher = patron.matcher(contenidoHtml.toString());

        while (matcher.find()) {
            System.out.println(matcher);
        }
    }
}
