import java.util.ArrayList;

public class ej2_1 {
    public static void main(String[] args) {
        ArrayList<String> Companyeros = new ArrayList<String>();
        Companyeros.add("Dani");
        Companyeros.add("Ivan");
        Companyeros.add("Mario");
        Companyeros.add("Raul");
        Companyeros.add("Lucas");
        Companyeros.add("Kevin");

        for (String recorrerCompanyeros : Companyeros){
            System.out.println(recorrerCompanyeros);
        }

        }
    }

