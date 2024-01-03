package fr.adsa.factory;

import fr.adsa.model.Personnage;

import java.util.Scanner;

/**
 * classe personnage factory qui permet de creer des personnages avec ses attributs
 * Demander à l'utilisateur de saisir le nom du personnage
 * @return personnage
 */
public class PersonnageFactory {
    public static Personnage createPersonnage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom du personnage : ");
        String nom = sc.nextLine();
        return new Personnage(nom, 100, 10);
    }

    //Récupere les infos du personnage et les affiche
    public static void afficherInfosPersonnage(Personnage personnage) {
        System.out.println("Le personnage " + personnage.getNom() + " a " + personnage.getPdv() + " pdv et " + personnage.getDegats() + " de degats");
    }

}
