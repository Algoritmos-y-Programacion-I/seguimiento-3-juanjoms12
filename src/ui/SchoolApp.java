package ui;

import java.util.Scanner;
import java.time.LocalDate;
import model.SchoolController;

public class SchoolApp {

    private Scanner input;
    private SchoolController controller;


    public static void main(String[] args) {

        SchoolApp ui = new SchoolApp();
        ui.menu();

    }

    public SchoolApp() {
        input = new Scanner(System.in);
        controller = new SchoolController(); 
    }

    public void menu() {

        System.out.println("Bienvenido a Computaricemos");

        int option = 0;
        do {
            System.out.println("\naMenu Principal");
            System.out.println("--------------------------------------------------------");
            System.out.println("Digite alguna de las siguientes opciones");
            System.out.println("1) Registrar computador");
            System.out.println("2) Registrar incidente en computador");
            System.out.println("3) Consultar el computador con más incidentes");
            System.out.println("0) Salir del sistema");
            System.out.print("Seleccione una opción: ");
            option = input.nextInt();
            input.nextLine();


            switch (option) {
                case 1:
                    registrarComputador();
                    break;
                case 2:
                    registrarIncidenteEnComputador();
                    break;
                case 3:
                    consultarComputadorConMasIncidentes();
                    break;
                case 0:
                    System.out.println("\nGracias por usar nuestros servicios. Adios!");
                    break;
                default:
                    System.out.println("\nOpcion invalida. Intente nuevamente.");
                    break;
            }

        } while (option != 0);

    }

    public void registrarComputador() {
        
        System.out.println("\n=== Registro de computador ===");
        System.out.print("Ingrese el número serial: ");
        String SerialNumber = input.nextLine();

        System.out.print("¿Tiene próxima ventana activa? (true/false): ");
        boolean nextWindow = input.nextBoolean();

        System.out.print("Ingrese el número del piso (1-5): ");
        int floor = input.nextInt();
        input.nextLine(); 

        String mensaje = controller.agregarComputador(SerialNumber, nextWindow, floor);
        System.out.println(mensaje);

    }

    public void registrarIncidenteEnComputador() {

        System.out.println("\n=== Registro de incidente ===");
        System.out.print("Ingrese el número serial del computador: ");
        String SerialNumber = input.nextLine();

        System.out.print("Ingrese la descripción del incidente: ");
        String description = input.nextLine();

        System.out.print("¿El incidente fue solucionado? (true/false): ");
        boolean solution = input.nextBoolean();

        System.out.print("Ingrese las horas que tomó resolverlo: ");
        int solutionHours = input.nextInt();
        input.nextLine();

        LocalDate dateReport = LocalDate.now();

        String mensaje = controller.agregarIncidenteEnComputador(SerialNumber, dateReport, description, solution, solutionHours);
        System.out.println(mensaje);

    }

    public void consultarComputadorConMasIncidentes() {
        
        System.out.println("\n=== Listado de Computadores ===");
        System.out.println(controller.getComputerList());

    }

}
