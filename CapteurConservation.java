package source;

public class CapteurConservation {
    private double temp, hum;
    public CapteurConservation(double t, double h) { this.temp = t; this.hum = h; }
    public void verifierConditions() {
        if (temp > 25 || hum > 60) System.out.println("!!! ALERTE CONSERVATION !!!");
        else System.out.println("[CAPTEUR] Conditions OK (" + temp + "°C)");
    }
}
