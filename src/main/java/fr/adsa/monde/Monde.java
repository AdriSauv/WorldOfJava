package fr.adsa.monde;

import fr.adsa.abstrait.Combattant;
import fr.adsa.classes.Classe;
import fr.adsa.classes.Mage;
import fr.adsa.classes.Voleur;
import fr.adsa.model.Ennemie;
import fr.adsa.model.Groupe;
import fr.adsa.model.Personnage;
import fr.adsa.monstres.Commun;
import fr.adsa.monstres.Rarity;

import java.util.*;

import static java.lang.Thread.sleep;

public class Monde {
    static Scanner sc = new Scanner(System.in);
    public static Map<String, Classe> classeDictionnaire = new HashMap<>();
    public static Map<String, Rarity> monstreDictionary = new HashMap<>();

    // creer des classes et les ajouter dans le dictionnaire
    public static Map<String, Classe> getDictionnaire(){
        if(classeDictionnaire.isEmpty()){
            Classe mage = new Mage();
            classeDictionnaire.put(mage.getNom(), mage);
            Classe voleur = new Voleur();
            classeDictionnaire.put(voleur.getNom(), voleur);
        }
        return classeDictionnaire;
    }

    // creer des monstres et les ajouter dans le dictionnaire
    public static Map<String, Rarity> getMonstreDictionnaire(){
        if(monstreDictionary.isEmpty()){
            Rarity commun = new Commun();
            monstreDictionary.put(commun.getNom(), commun);
        }
        return monstreDictionary;
    }

    public static Classe getClasse(String nom) {
        return classeDictionnaire.get(nom);
    }

    public static Rarity getMonstre(String nom) {
        return monstreDictionary.get(nom);
    }

    public static Personnage personnageFactory() {
        getDictionnaire();
        System.out.println("------------- Création du personnage -------------");
        System.out.println("Nom du personnage : ");
        sc.nextLine();
        String nom = sc.nextLine();

        System.out.println("Choisir une classe : ");
        for (String key : classeDictionnaire.keySet()) {
            System.out.println(key);
        }
        String classe = sc.nextLine();
        Classe classeChoisie = getClasse(classe);
        return new Personnage(nom, 100, classeChoisie);

    }

    public static Ennemie ennemieFactory(){
        getMonstreDictionnaire();
        // Création aléatoire d'un ennemie
        int random = randomInt(monstreDictionary.size());
        String nom = (String) monstreDictionary.keySet().toArray()[random];
        Rarity rarity = getMonstre(nom);
        return new Ennemie(nom, 100, rarity);
    }

    //Récupere les infos du personnage et les affiches
    public static void afficherInfos(Combattant combattant){
        System.out.println(combattant);
    }

    //Creation d'une méthode combat qui prend en parametre un personnage et un monstre à tour de role
    public static void combat(Personnage personnage, Ennemie monstre) throws InterruptedException {
        while (!personnage.estMort() && !monstre.estMort()) {
            personnage.attaquer(monstre);
            sleep(2000);
            // check si le monstre est mort
            if (monstre.estMort()) {
                break;
            } else {
                monstre.attaquer(personnage);
                sleep(2000);
            }
        }
        if (personnage.estMort()) {
            System.out.println( personnage.getNom() + " est mort. " + monstre.getNom() + " a gagné");
        } else {
            System.out.println( monstre.getNom() + " est mort. " + personnage.getNom() + " a gagné");
        }
    }

    public static Groupe createPersonnageGroupe(int nbPersonnages) {
        Groupe groupe = new Groupe();
        for (int i = 0; i < nbPersonnages; i++) {
            Personnage personnage = personnageFactory();
            groupe.addCombattant(personnage);
        }
        return groupe;
    }

    public static int randomInt(int borneMax) {
        return new Random().nextInt(borneMax);
    }

    public static void menu() throws InterruptedException {
        System.out.println("|------------ Menu ------------|");
        System.out.println("| 1 - Combat 1v1                |");
        System.out.println("| 2 - Combat de groupe          |");
        System.out.println("| 3 - Mode Donjon               |");
        System.out.println("| 4 - Informations              |");
        System.out.println("| 5 - Quitter                   |");
        System.out.println("|-------------------------------|");
        System.out.println("Choix : ");

        int choix = sc.nextInt();
        switch (choix){
            case 1:
                combat1v1();
                break;
            case 2:
                combatGroupe();
                break;
            case 3:
                donjon();
                break;
            case 4:
                informations();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Veuillez saisir un nombre entre 1 et 5");
                menu();
                break;
        }

    }

    public static void combat1v1() throws InterruptedException {
        Personnage p = personnageFactory();
        Ennemie monstre = ennemieFactory();
        afficherInfos(p);
        afficherInfos(monstre);
        combat(p, monstre);
    }

    public static void combatGroupe(){
        //TODO
    }

    public static void donjon(){
        //TODO
    }

    /**
     * Affiche les informations sur les classes disponibles ainsi que leurs attaques
     * infos sur les différentes raretés des monstres
     * @return void
     */
    public static void informations(){
        //TODO
    }
}
