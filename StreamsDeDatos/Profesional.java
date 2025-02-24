package StreamsDeDatos;

public class Profesional {
    String nombre;
    int edad;
    char genero;
    int tipoProfesional;

    public Profesional(String nombre, int edad, char genero, int tipoProfesional) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.tipoProfesional = tipoProfesional;
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

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getTipoProfesional() {
        return tipoProfesional;
    }

    public void setTipoProfesional(int tipoProfesional) {
        this.tipoProfesional = tipoProfesional;
    }

    @Override
    public String toString() {
        return "Profesional{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", genero=" + genero +
                ", tipoProfesional=" + tipoProfesional +
                '}';
    }
}
