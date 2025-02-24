package SeguridadGeneracionHash;

import java.io.*;
import java.security.MessageDigest;

public class RecibirHash {
    public static void main(String[] args) {
     try {
         FileInputStream filein = new FileInputStream("Datos.dat");
         ObjectInputStream objectIn = new ObjectInputStream(filein);
         DataObject receivedObject = (DataObject) objectIn.readObject();

         MessageDigest md = MessageDigest.getInstance("SHA-256");
         byte[] newhash = md.digest(receivedObject.datos.getBytes());
         if (MessageDigest.isEqual(receivedObject.hash, newhash)) {
             System.out.println("Integridad verificada: El archivo no ha sido modificado.");
         } else {
             System.out.println("ERROR: El archivo ha sido alterado.");
         }

     }catch (Exception e){
         e.printStackTrace();
     }
    }
}
