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
        do {
            System.out.println("--- INICIAR SESIÓN ---");
            System.out.print("Ingresa el nombre de usuario: ");
            user = sc.nextLine();
            System.out.print("Ingresa la contraseña: ");
            password = sc.nextLine();
            usuario = userManager.buscarUsuario(user);
            if (usuario == null || !usuario.getPassword().equals(password)) {
                System.out.println("Usuario o contraseña incorrectos. Inténtalo de nuevo.");
            }
        } while (usuario == null || !usuario.getPassword().equals(password));
        System.out.println("¡Inicio de sesión exitoso!");
        postLoginMenu(usuario);
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