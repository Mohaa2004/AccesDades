import java.io.*;
import java.util.Scanner;

public class exercici1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre del archivo: ");
        String nombreArchivo = sc.nextLine();
        int contador = 0;
        try {
            FileInputStream fis = new FileInputStream(nombreArchivo);
            int b;
            while ((b = fis.read()) != -1) {
                if (b == 'a' || b == 'A') {
                    contador++;
                }
            }
            fis.close();
            System.out.println("El archivo tiene " + contador + " letras 'a'.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }
}
