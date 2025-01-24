import java.io.*;
import java.net.*;

class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public String toString() {
        return "Persona [Nombre: " + nombre + ", Edad: " + edad + "]";
    }
}

public class TCPObjetoServidor1 {
    public static void main(String[] args) {
        int puerto = 12345;
        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado. Esperando conexión...");

            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado.");

            Persona persona = new Persona("Dani", 20);
            System.out.println("Enviando objeto al cliente: " + persona);

            ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
            out.writeObject(persona);
            out.flush();

            ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
            Persona personaModificada = (Persona) in.readObject();
            System.out.println("Objeto recibido del cliente: " + personaModificada);

            cliente.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}