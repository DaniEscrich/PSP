import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introduce una dirección email: ");
            String input = reader.readLine();

            ProcessBuilder pb = new ProcessBuilder("java", "ValidaMail", input);
            pb.directory(new File("/home/danescali/IdeaProjects/ProcessListPNG/src/"));
            pb.redirectErrorStream(true);
            Process process = pb.start();

            BufferedReader processOutput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = processOutput.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
