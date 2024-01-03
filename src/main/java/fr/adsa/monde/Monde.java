package fr.adsa.monde;

import fr.adsa.abstrait.Combattant;
import fr.adsa.actions.BasicAttaque;
import fr.adsa.classes.Classe;
import fr.adsa.classes.Mage;
import fr.adsa.interfaces.ICombattant;
import fr.adsa.model.Monstre;
import fr.adsa.model.Personnage;

import java.util.*;

public class Monde {
    public static Map<String, Classe> dictionnaire = new HashMap<>();
    public static String[] fName = {"Goblin", "Orc", "Troll", "Golem", "Dragon"};
    public static String[] lName = {"de feu", "de glace", "de terre", "de lave", "de foudre"};

    // creer des classes et les ajouter dans le dictionnaire
    public static Map<String, Classe> getDictionnaire(){
        dictionnaire.put("Mage", new Mage());
        return dictionnaire;
    }

    public static Classe getClasse(String nom) {
        return dictionnaire.get(nom);
    }

    public static Personnage createPersonnage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom du personnage : ");
        String nom = sc.nextLine();
        System.out.println("Veuillez choisir une classe : ");

        return new Personnage();
    }



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
