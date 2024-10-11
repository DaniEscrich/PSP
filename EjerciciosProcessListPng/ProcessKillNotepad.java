import java.io.IOException;


public class ProcessKillNotepad {
    public static void main(String[] args) throws InterruptedException, IOException {
        ProcessBuilder pb = new ProcessBuilder("kwrite");
            Process p = pb.start();
            Thread.sleep(10000);
            p.destroy();

    }
}
