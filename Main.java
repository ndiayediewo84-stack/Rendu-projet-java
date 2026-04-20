package source;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BibliothequeDAO dao = new BibliothequeDAO();
        boolean continuer = true;

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║     SYSTÈME DE GESTION BIBLIOTHÈQUE  ║");
        System.out.println("╚══════════════════════════════════════╝");

        while (continuer) {
            System.out.println("\n┌──────────────── MENU ────────────────┐");
            System.out.println("│  1. Ajouter un membre                │");
            System.out.println("│  2. Enregistrer un emprunt           │");
            System.out.println("│  3. Vérifier conditions de conservation│");
            System.out.println("│  4. Effectuer une livraison          │");
            System.out.println("│  0. Quitter                          │");
            System.out.println("└──────────────────────────────────────┘");
            System.out.print("Votre choix : ");

            int choix = -1;
            try {
                choix = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("⚠ Veuillez entrer un nombre valide.");
                continue;
            }

            switch (choix) {

                case 1:
                    System.out.println("\n--- Ajout d'un membre ---");
                    System.out.print("Nom       : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom    : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Email     : ");
                    String email = scanner.nextLine();

                    Membre membre = new Membre(nom, prenom, email);
                    dao.sauvegarderMembre(membre);
                    System.out.println("✔ Membre " + prenom + " " + nom + " ajouté avec succès !");
                    break;

                case 2:
                    System.out.println("\n--- Enregistrement d'un emprunt ---");
                    System.out.print("ID Membre    : ");
                    int idMembre = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("ID Livre     : ");
                    int idLivre = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Date emprunt (AAAA-MM-JJ) : ");
                    String dateEmprunt = scanner.nextLine();
                    System.out.print("Date retour  (AAAA-MM-JJ) : ");
                    String dateRetour = scanner.nextLine();

                    dao.enregistrerEmprunt(idMembre, idLivre, dateEmprunt, dateRetour);
                    System.out.println("✔ Emprunt enregistré avec succès !");
                    break;

                case 3:
                    System.out.println("\n--- Vérification des conditions de conservation ---");
                    System.out.print("Température (°C) : ");
                    double temperature = Double.parseDouble(scanner.nextLine().trim());
                    System.out.print("Humidité    (%)  : ");
                    double humidite = Double.parseDouble(scanner.nextLine().trim());

                    CapteurConservation capteur = new CapteurConservation(temperature, humidite);
                    capteur.verifierConditions();
                    break;

                case 4:
                    System.out.println("\n--- Effectuer une livraison ---");
                    System.out.print("Immatriculation du véhicule : ");
                    String immat = scanner.nextLine();

                    Vehicule vehicule = new Vehicule(immat);
                    vehicule.effectuerLivraison();
                    break;

                case 0:
                    System.out.println("\n--- FIN DU SYSTÈME. À bientôt ! ---");
                    continuer = false;
                    break;

                default:
                    System.out.println("⚠ Choix invalide. Veuillez choisir entre 0 et 4.");
            }
        }

        scanner.close();
    }
}
