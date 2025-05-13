import java.util.Scanner;

public class Problema3_EjecutorAutoBus {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String nombre[] = {"Alejandro", "Esther", "Jhoan", "Carlos", "Agustin", "Nicolas"};
        String apellido[] = {"Torres", "Jaramillo", "Fuentes", "Rios", "Sanchez", "Carrillo"};
        String ruta[] = {"Miraflores", "Pitas", "La banda", "Argelia", "Terminal", "Ciudad Victoria"};
        int grado[] = {1, 2, 3, 4, 5, 6, 7,};
        boolean estado[] = {true, false};
        String listaEstudiantesAceptados = "", listaEstudiantesRechazados = "";
        char opcionAborda = 'S';
        while (opcionAborda == 'S' || opcionAborda == 's') {
            String nombreEst = nombre[(int) Math.floor(Math.random() * 
            nombre.length)] + " " + apellido[(int) Math.floor(Math.random() * apellido.length)];
            String rutaEst = ruta[(int) Math.floor(Math.random() * ruta.length)];
            String rutaBus = ruta[(int) Math.floor(Math.random() * ruta.length)];
            int gradoEst = grado[(int) Math.floor(Math.random() * grado.length)];
            boolean estadoEst = estado[(int) Math.floor(Math.random() * estado.length)];

            Estudiante estudiante = new Estudiante(nombreEst, rutaEst, gradoEst, estadoEst);
            AutoBus autobus = new AutoBus(rutaBus, estudiante);
            
            System.out.println("Estudiante generado: " + estudiante);
            System.out.println("Autobus generado: " + autobus);
            
            if (autobus.determinarEstado()) {
                listaEstudiantesAceptados += estudiante.toString() + "\n";
            } else {
                listaEstudiantesRechazados += estudiante.toString() + "\n";
            }

            System.out.print("Desea ingresar otro estudiante(S/N)?: ");
            opcionAborda = scanner.next().charAt(0);
        }
        System.out.println();
        System.out.println("ESTUDIANTES ACEPTADOS\n" + listaEstudiantesAceptados);
        System.out.println("ESTUDIANTES RECHAZADOS\n" + listaEstudiantesRechazados);
    }

}

class AutoBus {

    public String ruta;
    public Estudiante estudiante;
    public boolean estado;

    public AutoBus() {
    }

    public AutoBus(String ruta, Estudiante estudiante) {
        this.ruta = ruta;
        this.estudiante = estudiante;
    }

    public boolean determinarEstado() {
        this.estado = (this.ruta.equals(this.estudiante.ruta) && (this.estudiante.estadoPermiso)) 
                ? true : false;
        return this.estado;
    }

    @Override
    public String toString() {
        return "AutoBus\n" + "ruta = " + ruta + "\nestudiante = " + estudiante
                + "\nestado = " + estado;
    }

}

class Estudiante {

    public String nombre;
    public String ruta;
    public int grado;
    public boolean estadoPermiso;

    public Estudiante() {
    }

    public Estudiante(String nombre, String ruta, int grado, boolean estadoPermiso) {
        this.nombre = nombre;
        this.ruta = ruta;
        this.grado = grado;
        this.estadoPermiso = estadoPermiso;
                
    }

    @Override
    public String toString() {
        return "Estudiante\n" + "nombre = " + nombre + "\nruta = " + ruta 
            + "\ngrado = " + grado + "\nestadoPermiso = " + estadoPermiso;
    }
}