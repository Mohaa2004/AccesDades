import model.User;
import model.UserManager;
import java.util.*;

public class GameController {
    public static void jugar(User usuario) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- JUGAR BLACKJACK ---");
        System.out.println("Bienvenido, " + usuario.getName() + "! Dinero disponible: " + usuario.getDinero());
        int dineroDisponible = usuario.getDinero();
        int apuesta = 0;
        do {
            System.out.print("¿Cuánto dinero desea apostar? (mínimo 1, máximo " + dineroDisponible + "): ");
            apuesta = sc.nextInt();
            sc.nextLine();
            if (apuesta < 1 || apuesta > dineroDisponible) {
                System.out.println("Apuesta inválida. Intente de nuevo.");
            }
        } while (apuesta < 1 || apuesta > dineroDisponible);

        // Baraja y cartas
        List<Integer> baraja = crearBaraja();
        Collections.shuffle(baraja);
        List<Integer> manoJugador = new ArrayList<>();
        List<Integer> manoBanca = new ArrayList<>();

        // Reparto inicial
        manoJugador.add(baraja.remove(0));
        manoJugador.add(baraja.remove(0));
        manoBanca.add(baraja.remove(0));
        manoBanca.add(baraja.remove(0));

        System.out.println("Tus cartas: " + manoJugador + " (Total: " + sumaMano(manoJugador) + ")");
        System.out.println("Carta visible de la banca: " + manoBanca.get(0));

        // Turno del jugador
        boolean jugadorPlantado = false;
        while (!jugadorPlantado && sumaMano(manoJugador) < 21) {
            System.out.print("¿Quieres pedir carta (1) o plantarte (2)? ");
            int opcion = sc.nextInt();
            sc.nextLine();
            if (opcion == 1) {
                manoJugador.add(baraja.remove(0));
                System.out.println("Tus cartas: " + manoJugador + " (Total: " + sumaMano(manoJugador) + ")");
            } else if (opcion == 2) {
                jugadorPlantado = true;
            } else {
                System.out.println("Opción inválida.");
            }
        }

        // Turno de la banca
        System.out.println("Cartas de la banca: " + manoBanca + " (Total: " + sumaMano(manoBanca) + ")");
        while (sumaMano(manoBanca) < 17) {
            manoBanca.add(baraja.remove(0));
            System.out.println("La banca pide carta. Cartas: " + manoBanca + " (Total: " + sumaMano(manoBanca) + ")");
        }

        // Resultado
        int totalJugador = sumaMano(manoJugador);
        int totalBanca = sumaMano(manoBanca);
        if (totalJugador > 21) {
            System.out.println("Te has pasado de 21. Pierdes la apuesta.");
            usuario.setDinero(dineroDisponible - apuesta);
        } else if (totalBanca > 21 || totalJugador > totalBanca) {
            System.out.println("¡Has ganado! Ganas " + apuesta + " euros.");
            usuario.setDinero(dineroDisponible + apuesta);
        } else if (totalJugador == totalBanca) {
            System.out.println("Empate. Recuperas tu apuesta.");
            // Dinero no cambia
        } else {
            System.out.println("La banca gana. Pierdes la apuesta.");
            usuario.setDinero(dineroDisponible - apuesta);
        }
        System.out.println("Dinero actual: " + usuario.getDinero());
        // Guardar cambios en el usuario
        UserManager userManager = new UserManager();
        userManager.registrarUsuario(usuario);
        System.out.println("Fin de la partida. Volviendo al menú usuario...");
    }

    private static List<Integer> crearBaraja() {
        List<Integer> baraja = new ArrayList<>();
        for (int i = 1; i <= 13; i++) { 
            for (int j = 0; j < 4; j++) { 
                baraja.add(i);
            }
        }
        return baraja;
    }

    private static int sumaMano(List<Integer> mano) {
        int suma = 0;
        int ases = 0;
        for (int carta : mano) {
            if (carta > 10) {
                suma += 10;
            } else if (carta == 1) {
                suma += 11;
                ases++;
            } else {
                suma += carta;
            }
        }
        while (suma > 21 && ases > 0) {
            suma -= 10;
            ases--;
        }
        return suma;
    }
}