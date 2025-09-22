import java.io.*;
import java.util.Scanner;

public class exercici2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            FileOutputStream fos = new FileOutputStream("usertext.txt");
            while (true) {
                System.out.print("Introduce un texto (exit para salir): ");
                String linea = sc.nextLine();
                if (linea.equals("exit")) {
                    break;
                }
                fos.write((linea + "\n").getBytes());
            }
            fos.close();

            FileInputStream fis = new FileInputStream("usertext.txt");
            int b;
            System.out.println("\nContenido del archivo:");
            while ((b = fis.read()) != -1) {
                System.out.print((char) b);
            }
            fis.close();
        } catch (IOException e) {
            System.out.println("Error en el archivo");
        }
    }
}
