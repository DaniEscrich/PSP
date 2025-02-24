package ComunicacionesEnRedUDP.Primeros;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
    public static void main(String[] args) throws IOException {
        final int puertoCliente = 12345;
        byte[] buffer = new byte[1024];
        int contador = 0;
        System.out.println("Iniciado el servidor UDP");
        DatagramPacket recibo = new DatagramPacket(buffer, buffer.
                length);
        DatagramSocket socketUDP = new DatagramSocket(12345);
        socketUDP.receive(recibo);
        String mensaje = new String(recibo.getData(), 0,recibo.getLength()).trim();
        for (int i = 0; i<mensaje.length(); i++){
            if(mensaje.charAt(i) == 'a'){
                contador ++;
            }
        }
        System.out.println("Servidor recibe " + mensaje);
        System.out.println("Enviando numero de apariciones de la letra 'a':" + contador);

        String mensaje2 = "" + contador;
        InetAddress destino = InetAddress.getByName("localhost");//
        buffer = mensaje2.getBytes();
        DatagramPacket envio = new DatagramPacket(buffer, buffer.length,destino, puertoCliente);
        socketUDP.send(envio);

        socketUDP.close();
    }

}
