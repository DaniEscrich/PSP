import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ProcessListPNG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indicame una ruta (por ejemplo, /micarpeta/fotos) y te indicare todas las imagenes PNG encontradas: ");
        String ruta = sc.nextLine();
        File directorio = new File(ruta);
        ProcessBuilder pb = new ProcessBuilder("bash","-c","ls");
        pb.directory(directorio);

            Process p = pb.start();

            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read()) != -1)

                System.out.print((char)c);
            is.close();
    }
}
