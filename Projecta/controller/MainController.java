import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("--- MENÚ PRINCIPAL ---");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    LoginController.login();
                    break;
                case 2:
                    RegisterController.registrar();
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicación. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
            System.out.println();
        } while (option != 3);
        scanner.close();
    }
}