import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPObjetoCliente1 {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 12345;

        try (Socket servidor = new Socket(host, puerto)) {
            System.out.println("Conectado al servidor.");

            ObjectInputStream in = new ObjectInputStream(servidor.getInputStream());
            Persona persona = (Persona) in.readObject();
            System.out.println("Objeto recibido del servidor: " + persona);

            persona.setNombre("Daniel");
            persona.setEdad(22);
            System.out.println("Enviando objeto modificado al servidor: " + persona);

            ObjectOutputStream out = new ObjectOutputStream(servidor.getOutputStream());
            out.writeObject(persona);
            out.flush();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}