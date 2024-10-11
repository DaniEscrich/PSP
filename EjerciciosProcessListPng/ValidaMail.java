public class ValidaMail {
    public static void main(String[] args) {
        try {
            String cadena  = args[0];
            if (!cadena.contains("@")) {
                System.err.println("El email no contiene una @!");
            }

            String[] identificador = cadena.split("@");
            if (identificador[1].isEmpty()) {
                System.err.println("No existe segundo identificador!");
            }
            if (identificador[0].length()<3) {
                System.err.println("El primer identificador ha de tener una longitud mínima de 3 caracteres!");
            }
            String dominio = identificador[1].substring(identificador[1].lastIndexOf("."));
            if (!dominio.equals(".com") && !dominio.equals(".es") && !dominio.equals(".org")) {
                System.err.println("El dominio no es ni com/es/org!");
            }
            System.out.println("Funciona correctamente");
        }catch (Exception e) {
            e.printStackTrace();

        }
    }
}

