package source;

public class Vehicule {
    private String immat;
    private boolean dispo = true;
    public Vehicule(String i) { this.immat = i; }
    public void effectuerLivraison() {
        if (!dispo) throw new IllegalStateException("Véhicule occupé");
        System.out.println("[LOGISTIQUE] Livraison en cours : " + immat);
        this.dispo = false;
    }
}
