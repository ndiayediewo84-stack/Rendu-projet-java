package source;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprunt {
    private LocalDate dateEmprunt, dateRetourPrevue, dateRetourEff;

    public boolean estEnRetard() {
        LocalDate fin = (dateRetourEff != null) ? dateRetourEff : LocalDate.now();
        return fin.isAfter(dateRetourPrevue);
    }

    public int joursDeRetard() {
        if (!estEnRetard()) return 0;
        LocalDate fin = (dateRetourEff != null) ? dateRetourEff : LocalDate.now();
        return (int) ChronoUnit.DAYS.between(dateRetourPrevue, fin);
    }

    public void retourner() { 
        this.dateRetourEff = LocalDate.now(); 
        System.out.println("[LOG] Livre retourné. Retard : " + joursDeRetard() + " jours.");
    }
    
    public double calculerAmende() { return joursDeRetard() * 500; } // Logique Caisse
}