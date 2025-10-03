import java.io.*;
import java.util.Scanner;

public class ex51 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            RandomAccessFile f = new RandomAccessFile("paisos.dat", "rw");
            int registre = 100;

            System.out.print("Index del pais: ");
            int i = sc.nextInt();
            sc.nextLine();

            f.seek(i * registre);

            String nom = f.readUTF();
            String codi = f.readUTF();
            long poblacio = f.readLong();
            String capital = f.readUTF();

            System.out.print("Camp a modificar (nom/codi/poblacio/capital): ");
            String camp = sc.nextLine();

            System.out.print("Nou valor: ");
            String valor = sc.nextLine();

            if (camp.equalsIgnoreCase("nom")) {
                nom = valor;
            } else if (camp.equalsIgnoreCase("codi")) {
                codi = valor;
            } else if (camp.equalsIgnoreCase("poblacio")) {
                poblacio = Long.parseLong(valor);
            } else if (camp.equalsIgnoreCase("capital")) {
                capital = valor;
            }

            f.seek(i * registre);
            f.writeUTF(nom);
            f.writeUTF(codi);
            f.writeLong(poblacio);
            f.writeUTF(capital);

            System.out.println("Modificat");
            f.close();

        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
