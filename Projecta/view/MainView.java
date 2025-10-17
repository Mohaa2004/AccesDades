package view;

import java.util.Scanner;

public class MainView {
    public static int mostrarMenuPrincipal() {
        System.out.println("==============================");
        System.out.println("      BLACKJACK - MENÚ PRINCIPAL");
        System.out.println("==============================");
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Registrarse");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }
}
