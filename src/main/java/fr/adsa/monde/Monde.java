package fr.adsa.monde;

import fr.adsa.model.Personnage;

import java.util.Scanner;

public class Monde {
    public static Personnage createPersonnage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom du personnage : ");
        String nom = sc.nextLine();
        return new Personnage(nom, 100, 10);
    }

    //Récupere les infos du personnage et les affiche
    public static void afficherInfos(Personnage personnage) {
        System.out.println("Le personnage " + personnage.getNom() + " a " + personnage.getPdv() + " pdv et " + personnage.getDegats() + " de degats");
    }
}
