
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.util.Scanner;

public class exercici4 {

    public static void main(String[] args) {
        String file = "secret.bin";
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el codigo: ");
        int codigo = sc.nextInt();

        boolean encontrado = false;
        boolean finalizado = false;

        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            while (!encontrado || !finalizado) {
                try {
                    int codigoEncontrado = dis.readInt();
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < 3; i++) {
                        stringBuilder.append(dis.readChar());
                    }
                    if (codigo == codigoEncontrado) {
                        System.out.println("Codigo encontrado" + stringBuilder);
                        encontrado = true;
                    } else {
                        System.out.println("Codigo no encontrado");
                    }
                } catch (EOFException e) {
                    finalizado = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
