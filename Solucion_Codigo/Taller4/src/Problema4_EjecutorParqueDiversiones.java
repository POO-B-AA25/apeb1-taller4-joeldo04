
import java.util.Scanner;

public class Problema4_EjecutorParqueDiversiones {
   
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] nombres = {"Daniel", "Lucia", "Carlos", "Ana", "Sofia", "Pedro"};
        String[] apellidos = {"Abad", "Perez", "Ramirez", "Lozano", "Gomez", "Ramirez"};
        int[] edades = {10, 12, 14, 16, 18, 20, 21, 22, 25};
        int[] alturas = {155, 158, 150, 160, 170, 175, 180};

        while (true) {
            String nombreCompleto = nombres[(int) Math.floor(Math.random() * nombres.length)]
                                  + " "
                                  + apellidos[(int) Math.floor(Math.random() * apellidos.length)];
            int edad = edades[(int) Math.floor(Math.random() * edades.length)];
            int altura = alturas[(int) Math.floor(Math.random() * alturas.length)];

            Visitante visitante = new Visitante(nombreCompleto, edad, altura);
            ParqueDiversiones juego = new ParqueDiversiones(15, 160, visitante);

            juego.determinarAcceso();
            System.out.println(juego);

            System.out.print("Desea generar otro visitante? (s/n): ");
            char opcion = scanner.next().toLowerCase().charAt(0);
            if (opcion != 's') {
                System.out.println("Gracias por usar este Sistema");
            }
        }

    }
}


class Visitante {
    
    public String nombre;
    public int edad;
    public int altura;
    public boolean acceso;

    public Visitante() {
    }

    public Visitante(String nombre, int edad, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.acceso = false; 
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getAltura() {
        return altura;
    }

    public boolean getAcceso() {
        return acceso;
    }

    public void setAcceso(boolean acceso) {
        this.acceso = acceso;
    }

    @Override
    public String toString() {
        return "Visitante\nnombre = " + nombre + "\nedad = " + edad
                + "\naltura = " 
                + altura + "\nacceso = " + acceso;
    }
}
class ParqueDiversiones {
    public int edadMinima;
    public int alturaMinima;
    public Visitante visitante;

    public ParqueDiversiones() {
    }

    public ParqueDiversiones(int edadMinima, int alturaMinima, Visitante visitante) {
        this.edadMinima = edadMinima;
        this.alturaMinima = alturaMinima;
        this.visitante = visitante;
    }

    public boolean determinarAcceso() {
        boolean acceso = visitante.getEdad() >= edadMinima && visitante.getAltura() >= alturaMinima;
        visitante.setAcceso(acceso);
        return acceso;
    }

    @Override
    public String toString() {
        return "Parque Diversiones:\nvisitante = " + visitante.toString();
    }
}