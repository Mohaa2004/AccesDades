package model;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;

public class UserManager {
    // Lista de usuarios
    private List<User> users;
    
    // Constructor
    public UserManager() {
        this.users = leerUsuarios();
    }

    // Metodo para agregar un usuario a un fichero 
    public void guardarUsuarios(List<User> users) {
        // Permitimos escribir en el fichero usando oos y lo creamos con FileOutputStream
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.dat"))) {
            oos.writeObject(users); 
        } catch (Exception e) {
            // Si hay un error, lo mostramos por pantalla
            e.printStackTrace();
        }
    }

    //Metodo para leer los usuarios de nuestro archivo users.dat
    public List<User> leerUsuarios() {
        // Intentamos leer los usuarios del fichero users.dat
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users.dat"))) {
            // Si hay usuarios en el fichero, los leemos y los devolvemos 
            // Hacemos un casting para pasarlo a la lista de users
            users = (List<User>) ois.readObject();
            return users;
        } catch (Exception e) { 
            // Si no hay usuarios en el fichero, devolvemos una lista vacia
            return new ArrayList<>();
        }
    }

    // Metodo para registrar usuarios 
    public void registrarUsuario(User nuevoUsuario){
        // Creamos la lista para guardar los usuarios
        List<User> users = leerUsuarios();
        users.add(nuevoUsuario);
        guardarUsuarios(users);
    }

    // Metodo para buscar usuario

    public User buscarUsuario(String usuario){
        // Metemos todos los usuarios en una lista
        List<User> users = leerUsuarios();
        // Recorremos la lista de usuarios y comprobamos si el usuario existe
        for(User user : users){
            if(user.getUser().equals(usuario)){
                return user;
            }
        }
        return null;
    }

    // Metodo para verificar si el usuario existe y la contraseña es correcta
    public boolean verificarUsuario(String usuario, String password){
        User user = buscarUsuario(usuario);
        if(user != null && user.getPassword().equals(password)){
            return true;
        }
        return false;
    }
    
}