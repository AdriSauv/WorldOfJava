package fr.adsa.monde;

import fr.adsa.model.Monstre;
import fr.adsa.model.Personnage;

import java.util.Random;
import java.util.Scanner;

public class Monde {
    public static Personnage createPersonnage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom du personnage : ");
        String nom = sc.nextLine();
        return new Personnage(nom, 100, 10);
    }

    public static String[] fName = {"Goblin", "Orc", "Troll", "Golem", "Dragon"};
    public static String[] lName = {"de feu", "de glace", "de terre", "de lave", "de foudre"};

    public static Monstre createMonstre() {
        String nom = fName[new Random().nextInt(fName.length)] + " " + lName[new Random().nextInt(lName.length)];
        return new Monstre(nom, 100, 10);
    }

    //Récupere les infos du personnage et les affiche
    public static void afficherInfos(Personnage personnage) {
        System.out.println("Le personnage " + personnage.getNom() + " a " + personnage.getPdv() + " pdv et " + personnage.getDegats() + " de degats");
    }

    //Récupere les infos du monstre et les affiche
    public static void afficherInfos(Monstre monstre) {
        System.out.println("Le monstre " + monstre.getNom() + " a " + monstre.getPdv() + " pdv et " + monstre.getDegats() + " de degats");
    }
}
