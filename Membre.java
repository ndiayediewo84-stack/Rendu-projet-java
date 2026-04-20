package source;

public class Membre {
    private String nom, prenom, email;
    public Membre(String n, String p, String e) { this.nom = n; this.prenom = p; this.email = e; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getEmail() { return email; }
    public String getNomComplet() { return prenom + " " + nom; }
}