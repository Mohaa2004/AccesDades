import model.User;
import model.UserManager;
import java.util.Scanner;

public class RegisterController {
    public static void registrar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- REGISTRO DE USUARIO ---");
        System.out.print("Ingrese su nombre completo: ");
        String name = sc.nextLine();
        System.out.print("Ingrese el nombre de usuario: ");
        String user = sc.nextLine();
        System.out.print("Ingrese la contraseña: ");
        String password = sc.nextLine();
        System.out.print("Ingrese el dinero inicial: ");
        int dinero = sc.nextInt();
        sc.nextLine();
        User nuevoUsuario = new User(name, user, password, dinero);
        UserManager userManager = new UserManager();
        if (userManager.buscarUsuario(user) != null) {
            System.out.println("El nombre de usuario ya existe. Intente con otro.");
        } else {
            userManager.registrarUsuario(nuevoUsuario);
            System.out.println("¡Usuario registrado exitosamente!");
        }
    }
}