import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class Lanzador {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("java","Sumador.java","1","9");
        pb.directory(new File("/home/danescali/IdeaProjects/ProcessListPNG/src"));
        Process p=pb.start();
        try{
            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read()) != -1)
                System.out.print((char) c);
            is.close();
        }catch(Exception e) {
            e.getMessage();
        }
    }
}