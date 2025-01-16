import java.io.DataInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPejemplo1Cliente {
    static final String Host = "localhost";
    static final int Puerto=2000;
    public static void main( String[] arg ) {
        InputStream entrada = null;
        try{
// Me conecto al servidor en un detrminado puerto
            Socket sCliente = new Socket( Host, Puerto );
            entrada = sCliente.getInputStream();
            DataInputStream flujoEntrada= new DataInputStream(entrada);
            System.out.println("Recibiendo del CLIENTE : " + "\n" + flujoEntrada.readUTF() );

// TAREAS QUE REALIZA EL CLIENTE
            InetAddress i = sCliente.getInetAddress();
            System.out.println("Host Remoto: "+i.getHostName());
            System.out.println("IP Host Remoto: "+i.getHostAddress());
// Cierro el socket
            sCliente.close();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }
}