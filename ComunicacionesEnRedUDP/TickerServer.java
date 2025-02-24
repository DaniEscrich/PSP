package ComunicacionesEnRedUDP.Segundos;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.HashMap;

public class TickerServer {
    public static void main(String[] args) throws IOException {
        ArrayList<String> butacas = new ArrayList<>();
        HashMap<String, Integer> reservas = new HashMap<>();
        ArrayList<String> listaEspera = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            butacas.add("LIBRE");
        }

        DatagramSocket socketUDP = new DatagramSocket(12345);
        System.out.println("Servidor UDP iniciado en el puerto 12345");

        byte[] buffer = new byte[1024];

        while (true) {
            DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(recibo);
            String mensaje = new String(recibo.getData(), 0, recibo.getLength()).trim();

            String[] partes = mensaje.split(":");
            String usuario = partes[0]; // Nombre del usuario
            String opcion = partes[1]; // Opción elegida

            System.out.println("Usuario " + usuario + " seleccionó opción " + opcion);
            String respuesta = "";

            switch (opcion) {
                case "1": // Listar butacas
                    for (int i = 0; i < butacas.size(); i++) {
                        respuesta += "Butaca " + (i + 1) + ": " + butacas.get(i) + "\n";
                    }
                    if (!listaEspera.isEmpty()) {
                        respuesta += "Lista de espera: " + listaEspera + "\n";
                    }
                    break;

                case "2": // Reservar butaca
                    if (reservas.containsKey(usuario)) {
                        respuesta = "Ya tienes una butaca reservada.";
                    } else if (butacas.contains("LIBRE")) {
                        int index = butacas.indexOf("LIBRE");
                        butacas.set(index, usuario);
                        reservas.put(usuario, index);
                        respuesta = "Butaca " + (index + 1) + " reservada para " + usuario;
                    } else {
                        listaEspera.add(usuario);
                        respuesta = "No hay butacas disponibles. Estás en lista de espera.";
                    }
                    break;

                case "3": // Anular butaca
                    if (reservas.containsKey(usuario)) {
                        int index = reservas.get(usuario);
                        reservas.remove(usuario);

                        if (!listaEspera.isEmpty()) {
                            String siguiente = listaEspera.remove(0);
                            butacas.set(index, siguiente);
                            reservas.put(siguiente, index);
                            respuesta = "Se ha anulado tu butaca y se ha asignado a " + siguiente;
                        } else {
                            butacas.set(index, "LIBRE");
                            respuesta = "Se ha anulado tu butaca y ahora está libre.";
                        }
                    } else {
                        respuesta = "No tienes ninguna butaca reservada.";
                    }
                    break;

                case "4": // Salir
                    respuesta = "Has salido.";
                    break;

                case "123": // Apagar servidor
                    respuesta = "Servidor apagado.";
                    byte[] bufferEnviar = respuesta.getBytes();
                    DatagramPacket paqueteEnviar = new DatagramPacket(bufferEnviar, bufferEnviar.length, recibo.getAddress(), recibo.getPort());
                    socketUDP.send(paqueteEnviar);
                    System.out.println("Servidor apagado.");
                    socketUDP.close();
                    return;
            }

            byte[] buffer2 = respuesta.getBytes();
            DatagramPacket envio = new DatagramPacket(buffer2, buffer2.length, recibo.getAddress(), recibo.getPort());
            socketUDP.send(envio);
        }
    }
}
