import java.util.Scanner;

public class Problema2_EjecutorEmpleado {

    public static Scanner scanner = new Scanner(System.in);
    public static String[] arreglonombres = new String[100];
    public static double[] arreglosalario = new double[100];
    public static int[] arregloedad = new int[100];
    public static int contador = 0;

    public static void main(String[] args) {

        String nombres[] = {"Javier", "Joel", "Eduardo", "Roxana", "Valentina", "Maria"};
        String apellidos[] = {"Arias", "Lopez", "Castillo", "Ochoa", "Abad", "Velasquez"};
        double salarios[] = {350.0, 499.0, 799.0, 1200.0, 800.0, 550.0};
        int edades[] = {28, 35, 26, 42, 38, 25, 41};
        String empleadosCambioSalario = "";
        char seleccion = 'S';
        double sumasalarios;
        int opcion;

        do {
            System.out.println("1. Agregar un empleado");
            System.out.println("2. Mostrar informacion de empleados registrados");
            System.out.println("3. Calcular aumento de salario");
            System.out.println("4. Salir ");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            if (opcion < 1 || opcion > 4) {
                System.out.println("No existe esa opcion");
            }
            switch (opcion) {
                case 1 -> {

                    while (seleccion == 'S' || seleccion == 's') {
                        if (contador >= arreglonombres.length) {
                            System.out.println("Capacidad máxima alcanzada.");
                            break;
                        }

                        String nombreEm = nombres[(int) Math.floor(Math.random()
                        * nombres.length)] + " " + apellidos[(int) 
                        Math.floor(Math.random() * apellidos.length)];
                        double salarioEm = salarios[(int) Math.floor(Math.random()
                        * salarios.length)]; int edadEm = edades[(int) Math.floor
                        (Math.random() * edades.length)];

                        arreglonombres[contador] = nombreEm;
                        arreglosalario[contador] = salarioEm;
                        arregloedad[contador] = edadEm;

                        Empleado empleado = new Empleado(nombreEm, salarioEm, edadEm);
                        System.out.println("Empleado agregado:\n" + empleado.mostrarInformacion());
                        contador++;

                        System.out.print("Desea agregar un empleado mas? (s/n): ");
                        seleccion = scanner.next().charAt(0);
                    }

                }

                case 2 -> {
                    if (contador == 0) {
                        System.out.println("No hay empleados registrados.");
                    } else {
                        System.out.println("Información de los empleados:");
                        for (int i = 0; i < contador; i++) {
                            Empleado empleado = new Empleado(arreglonombres[i], 
                                    arreglosalario[i], arregloedad[i]);
                            System.out.println(empleado.mostrarInformacion());
                        }
                    }
                }

                case 3 -> {
                    if (contador == 0) {
                        System.out.println("No hay empleados para calcular aumento.");
                    } else {
                        System.out.println("Aumento Salarial");
                        System.out.print("Ingrese el porcentaje de aumento: ");
                        double porcentajedeAumento = scanner.nextDouble();
                        sumasalarios = 0;
                        for (int i = 0; i < contador; i++) {
                            sumasalarios += arreglosalario[i];
                        }
                        double promediosalarios = sumasalarios / contador;
                        for (int i = 0; i < contador; i++) {
                            if (arreglosalario[i] < promediosalarios) {
                                double nuevoSalario = arreglosalario[i] + 
                                (arreglosalario[i] * (porcentajedeAumento / 100));
                                arreglosalario[i] = nuevoSalario;
                                Empleado empleado = new Empleado
                                (arreglonombres[i], nuevoSalario, arregloedad[i]);
                                empleadosCambioSalario += 
                               empleado.mostrarInformacion() + "\n";
                            }
                        }
                        System.out.println("Empleados con cambio de salario:\n" 
                                + empleadosCambioSalario);
                    }
                }
            }
        } while (opcion != 4);

    }

}

class Empleado {

    public String nombre;
    public double salario;
    public int edad;

    public Empleado() {}

    public Empleado(String nombre, double salario, int edad) {
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
    }

    public String mostrarInformacion() {
        return "Empleado" + "\nnombre = " + nombre + "\nsalario = " + salario 
                + "\nedad = " + edad;
    }

}

