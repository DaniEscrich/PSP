import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.IOException;

public class LeerWeb {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introduce 3 páginas webs separadas por @ (www.uv.es@www.uji.es@www.ua.es):");
            String input = reader.readLine();

            ProcessBuilder pb = new ProcessBuilder("java", "VisitaWeb.java", input);
            pb.directory(new File("/home/danescali/IdeaProjects/ProcessListPNG/src"));
            pb.start();

        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
