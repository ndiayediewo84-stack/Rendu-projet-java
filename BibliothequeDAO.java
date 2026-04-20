package source;


import java.sql.*;

public class BibliothequeDAO {
    public void sauvegarderMembre(Membre m) {
        String sql = "INSERT INTO Membre (nom, prenom, email) VALUES (?, ?, ?)";
        try (Connection conn = ConnexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, m.getNom());
            ps.setString(2, m.getPrenom());
            ps.setString(3, m.getEmail());
            ps.executeUpdate();
            System.out.println("[DB] Succès : Membre enregistré.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void enregistrerEmprunt(int idM, int idE, String debut, String fin) {
        String sql = "INSERT INTO Emprunt (idMembre, idExemplaire, dateEmprunt, dateRetourPrevue) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idM); ps.setInt(2, idE);
            ps.setDate(3, Date.valueOf(debut)); ps.setDate(4, Date.valueOf(fin));
            ps.executeUpdate();
            System.out.println("[DB] Succès : Emprunt persisté.");
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
