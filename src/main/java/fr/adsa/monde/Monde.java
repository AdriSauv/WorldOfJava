package fr.adsa.monde;

import fr.adsa.abstrait.Combattant;
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
    public static void afficherInfos(Combattant combattant){
        System.out.println("Nom : " + combattant.getNom());
        System.out.println("Pdv : " + combattant.getPdv());
        System.out.println("Degats : " + combattant.getDegats());
    }

    //Creation d'une méthode combat qui prend en parametre un personnage et un monstre à tour de role
    public static void combat(Personnage personnage, Monstre monstre) {
        while (personnage.getPdv() > 0 && monstre.getPdv() > 0) {
            boolean turn = new Random().nextBoolean();
            if (turn) {
                personnage.attaquer(monstre);
            } else {
                monstre.attaquer(personnage);
            }
        }
        if (personnage.getPdv() <= 0) {
            System.out.println( personnage.getNom() + " est mort. " + monstre.getNom() + " a gagné");
        } else {
            System.out.println( monstre.getNom() + " est mort. " + personnage.getNom() + " a gagné");
        }
    }
}
