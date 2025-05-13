import java.util.Scanner;

public class Problema5_EjecutorGimnasio {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        String[] nombres = {"Abraham", "Luis", "Carlos", "Alejandra", "Sofia", "Jorge"};
        String[] ejercicios = {"Cardio", "Fuerza", "Estiramiento", "Resistencia", "Yoga"};
        boolean[] completados = {true, false};

        int totalClientes = 0;
        int totalCompletados = 0;
        int sumaDuracion = 0;

        String resumenClientes = ""; 
        char opcion;

        do {         
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver clientes registrados");
            System.out.println("3. Ver resumen gimnasio");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.next().charAt(0);

            switch (opcion) {
                case '1':
                    String nombre = nombres[(int) Math.floor(Math.random() * nombres.length)];
                    String tipo = ejercicios[(int) Math.floor(Math.random() * ejercicios.length)];
                    int duracion = (int) Math.floor(Math.random() * 61) + 20; 
                    boolean completo = completados[(int) Math.floor(Math.random() * completados.length)];

                    Cliente cliente = new Cliente(nombre, tipo, duracion, completo);
                    System.out.println("\nCliente registrado:");
                    System.out.println(cliente);

                    totalClientes++;
                    sumaDuracion += duracion;
                    if (completo) totalCompletados++;
                    resumenClientes += "\n" + cliente + "\n";
                    break;

                case '2':
                    if (resumenClientes.isEmpty()) {
                        System.out.println("\nNo hay clientes registrados aún.");
                    } else {
                        System.out.println("CLIENTES REGISTRADOS");
                        System.out.println(resumenClientes);
                    }
                    break;

                case '3':
                    System.out.println("Total de clientes registrados: " + totalClientes);
                    System.out.println("Completaron rutina: " + totalCompletados);
                    if (totalClientes > 0) {
                        double promedio = (double) sumaDuracion / totalClientes;
                        System.out.printf("Promedio de duracion: %.2f min\n", promedio);
                    } else {
                        System.out.println("No se registraron clientes.");
                    }
                    break;

                default:
                    System.out.println("No existe esta opcion");
            }

        } while (opcion != '3');

    }
}

class Cliente {
    public String nombre;
    public String tipoEjercicio;
    public int duracion;
    public boolean cumplimiento;

    public Cliente(String nombre, String tipo, int duracion, boolean completado) {
        this.nombre = nombre;
        this.tipoEjercicio = tipo;
        this.duracion = duracion;
        this.cumplimiento = completado;
    }

    @Override
    public String toString() {
        return "nombre = " + nombre +
               "\ntipoEjercicio = " + tipoEjercicio +
               "\nduracion = " + duracion + " min" +
               "\ncumplimiento = " + (cumplimiento );
    }
}
