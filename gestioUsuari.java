import java.io.*;
import java.util.Scanner;

public class gestioUsuari {
	public static class User implements Serializable {
		String nom;
		String pass;

		public User(String nom, String pass) {
			this.nom = nom;
			this.pass = pass;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introdueix el nom: ");
		String nom = sc.nextLine();
		System.out.print("Introdueix la contra: ");
		String pass = sc.nextLine();

		String fitxer = nom + ".usr";
		File arxiu = new File(fitxer);

		if (arxiu.exists()) {
			
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arxiu))) {
				User usuari = (User) ois.readObject();
				if (usuari.pass.equals(pass)) {
					System.out.println("Accés correcte al sistema");
				} else {
					System.out.println("Accés no concedit: La contrasenya no és correcta");
				}
			} catch (Exception e) {
				System.out.println("Error llegint l'usuari.");
			}
		} else {
			System.out.println("No s'ha trobat l'usuari, vols registrar-te? (si/no)");
			String resposta = sc.nextLine().trim().toLowerCase();
			if (resposta.equals("si")) {
				User nouUsuari = new User(nom, pass);
				try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arxiu))) {
					oos.writeObject(nouUsuari);
					System.out.println("Usuari registrat correctament.");
				} catch (Exception e) {
					System.out.println("Error al registrar l'usuari.");
				}
			} else {
				System.out.println("Registre cancel·lat.");
			}
		}
	}
}
