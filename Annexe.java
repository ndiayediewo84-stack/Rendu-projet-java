package source;



import java.util.ArrayList;
import java.util.List;

public class Annexe {
    private int idAnnexe;
    private String nom;
    private String adresse;
    private List<Vehicule> vehicules; // Relation "Possède" de l'UML (1..4)

    public Annexe(int id, String nom, String adresse) {
        this.idAnnexe = id;
        this.nom = nom;
        this.adresse = adresse;
        this.vehicules = new ArrayList<>();
    }

    // Méthodes demandées dans l'UML
    public void ajouterVehicule(Vehicule v) {
        if (vehicules.size() < 4) { // Respect de la multiplicité 1..4 de ton UML
            vehicules.add(v);
        } else {
            System.out.println("Erreur : Cette annexe a déjà le nombre maximum de véhicules.");
        }
    }

    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    // Getters
    public String getNom() { return nom; }
    public int getIdAnnexe() { return idAnnexe; }
}