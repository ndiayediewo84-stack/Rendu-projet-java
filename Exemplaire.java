package source;

public class Exemplaire {
    private int idExemplaire;
    private String etat; // ex: "Neuf", "Usé", "Abîmé"
    private boolean disponible;
    private Livre livre; // Relation vers la classe Livre
    private Annexe annexe; // Localisation physique

    public Exemplaire(int id, Livre livre, Annexe annexe) {
        this.idExemplaire = id;
        this.livre = livre;
        this.annexe = annexe;
        this.disponible = true; // Disponible par défaut
        this.etat = "Neuf";
    }

    // Méthodes demandées dans l'UML
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Getters
    public int getIdExemplaire() { return idExemplaire; }
    public Livre getLivre() { return livre; }
    public Annexe getAnnexe() { return annexe; }
    
    public void setEtat(String etat) {
        if(etat == null || etat.isEmpty()) throw new IllegalArgumentException("État invalide");
        this.etat = etat;
    }
}
