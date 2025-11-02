import model.User;
import model.UserManager;
import java.util.Scanner;

public class LoginController {
    public static void login() {
        Scanner sc = new Scanner(System.in);
        String user;
        String password;
        UserManager userManager = new UserManager();
        User usuario = null;
        // Nuevo menú para permitir registrar o volver atrás desde la pantalla de login
        while (true) {
            System.out.println("--- INICIAR SESIÓN ---");
            System.out.println("1. Ingresar credenciales");
            System.out.println("2. Registrarse");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Opción inválida. Intente de nuevo.");
                System.out.println();
                continue;
            }

            if (opcion == 1) {
                System.out.print("Ingresa el nombre de usuario: ");
                user = sc.nextLine();
                System.out.print("Ingresa la contraseña: ");
                password = sc.nextLine();
                usuario = userManager.buscarUsuario(user);
                if (usuario == null || !usuario.getPassword().equals(password)) {
                    System.out.println("Usuario o contraseña incorrectos. Inténtalo de nuevo.");
                    System.out.println();
                    continue; // volver al menú de login
                }
                System.out.println("¡Inicio de sesión exitoso!");
                postLoginMenu(usuario);
                break; // después de cerrar sesión, volvemos al menú principal
            } else if (opcion == 2) {
                // Llamamos al registrador y al volver seguimos en el menú de login
                RegisterController.registrar();
                System.out.println();
            } else if (opcion == 3) {
                // Volver al menú principal
                System.out.println("Volviendo al menú principal...");
                System.out.println();
                break;
            } else {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
                System.out.println();
            }
        }
    }

    public static void postLoginMenu(User usuario) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("--- MENÚ USUARIO ---");
            System.out.println("1. Jugar");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    GameController.jugar(usuario);
                    break;
                case 2:
                    System.out.println("Sesión cerrada. Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
            System.out.println();
        } while (opcion != 2);
    }
}