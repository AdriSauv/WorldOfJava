package fr.adsa.monde;

import fr.adsa.actions.BasicAttaque;
import fr.adsa.classes.Classe;
import fr.adsa.interfaces.ICombattant;
import fr.adsa.model.Monstre;
import fr.adsa.model.Personnage;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Monde {

    //Liste de classes
    public static Classe[] classes = {
            new Classe("Guerrier", List.of(new BasicAttaque(10))),
            new Classe("Mage", List.of(new BasicAttaque(10))),
            new Classe("Archer", List.of(new BasicAttaque(10))),
            new Classe("Voleur", List.of(new BasicAttaque(10)))
    };
    public static Personnage createPersonnage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom du personnage : ");
        String nom = sc.nextLine();
        System.out.println("Veuillez choisir une classe : ");
        for (int i = 0; i < classes.length; i++) {
            System.out.println(i + " - " + classes[i].getNom());
        }
        int choix = sc.nextInt();
        Classe classe = classes[choix];
        return new Personnage(nom, 100, 10, classe);
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

    //Creation d'une méthode combat qui prend en parametre un personnage et un monstre à tour de role
    public static void combat(ICombattant personnage, ICombattant monstre) {
        while (personnage.getPdv() > 0 && monstre.getPdv() > 0) {
            boolean turn = new Random().nextBoolean();
            if (turn) {
                personnage.attaquer(monstre);
            } else {
                monstre.attaquer(personnage);
            }
        }
        if (personnage.getPdv() <= 0) {
            System.out.println("Le personnage est mort");
        } else {
            System.out.println("Le monstre est mort");
        }
    }
}
