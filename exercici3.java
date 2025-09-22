
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Random;

public class exercici3 {

    public static void main(String[] args) {
        String archivo = "secret.bin";
        Random random = new Random();

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(archivo))) {
            int numRandom = random.nextInt(3) + 1;

            for (int i = 0; i < 10; i++) {
                dos.writeInt(numRandom);

                StringBuilder secret = new StringBuilder();
                for (int j = 0; j < 3; j++) {
                    char word = (char) ('a' + random.nextInt(26));
                    dos.writeChar(word);
                    secret.append(word);
                }

                System.out.println(numRandom + ":" + secret);   
                numRandom += random.nextInt(3) + 1;
            }

            System.out.println("Archivo generado correctamente: " + archivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
