package source;

public class Livre {
    private String isbn, titre, auteur;
    private int annee;

    public Livre(String isbn, String titre, String auteur, int annee) {
        if (annee > 2026) throw new IllegalArgumentException("Année invalide");
        this.isbn = isbn; this.titre = titre; this.auteur = auteur; this.annee = annee;
    }
    public String getIsbn() { return isbn; }
    @Override
    public String toString() { return titre + " (" + auteur + ")"; }
}