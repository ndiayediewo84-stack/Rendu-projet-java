package source;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDB {
    // Informations de connexion (XAMPP par défaut)
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_biblio";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            // ÉTAPE CRUCIALE : On enregistre le pilote MySQL qui est dans le fichier .jar
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("ERREUR : Le pilote MySQL est introuvable. Vérifie que le fichier .jar est bien présent !");
            e.printStackTrace();
        }
        
        // On établit la connexion vers ta base 'gestion_biblio'
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}