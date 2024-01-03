package fr.adsa.monde;

import fr.adsa.abstrait.Combattant;
import fr.adsa.actions.BasicAttaque;
import fr.adsa.classes.Classe;
import fr.adsa.classes.Mage;
import fr.adsa.interfaces.ICombattant;
import fr.adsa.model.Groupe;
import fr.adsa.model.Monstre;
import fr.adsa.model.Personnage;

import java.util.*;

public class Monde {
    static Scanner sc = new Scanner(System.in);
    public static Map<String, Classe> dictionnaire = new HashMap<>();
    public static List<Monstre> monstres = new ArrayList<>();
    public static String[] fName = {"Goblin", "Orc", "Troll", "Golem", "Dragon"};
    public static String[] lName = {"de feu", "de glace", "de terre", "de lave", "de foudre"};

    // creer des classes et les ajouter dans le dictionnaire
    public static Map<String, Classe> getDictionnaire(){
        if(dictionnaire.isEmpty()){
            Classe mage = new Mage();
            dictionnaire.put(mage.getNom(), mage);
        }
        return dictionnaire;
    }

    public static Classe getClasse(String nom) {
        return dictionnaire.get(nom);
    }

    public static Personnage createPersonnage() {
        getDictionnaire();
        System.out.println("Veuillez saisir le nom du personnage : ");
        sc.nextLine();
        String nom = sc.nextLine();

        System.out.println("Veuillez choisir une classe : ");
        for (String key : dictionnaire.keySet()) {
            System.out.println(key);
        }
        String classe = sc.nextLine();
        Classe classeChoisie = getClasse(classe);
        return new Personnage(nom, 100, classeChoisie);
    }

    public static Monstre createMonstre() {
        String nom = fName[new Random().nextInt(fName.length)] + " " + lName[new Random().nextInt(lName.length)];
        return new Monstre(nom, 100, 10);
    }

    //Récupere les infos du personnage et les affiche
    public static void afficherInfos(Combattant combattant){
        System.out.println(combattant);
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
        if (personnage.estMort()) {
            System.out.println( personnage.getNom() + " est mort. " + monstre.getNom() + " a gagné");
        } else {
            System.out.println( monstre.getNom() + " est mort. " + personnage.getNom() + " a gagné");
        }
    }

    public static Groupe createMonstreGroupe(int nbMonstres) {
        Groupe groupe = new Groupe();
        for (int i = 0; i < nbMonstres; i++) {
            groupe.addCombattant(createMonstre());
        }
        return groupe;
    }

    public static Groupe createPersonnageGroupe(int nbPersonnages) {
        Groupe groupe = new Groupe();
        for (int i = 0; i < nbPersonnages; i++) {
            groupe.addCombattant(createPersonnage());
        }
        return groupe;
    }

    public static void menu(){
        System.out.println("|------------ Menu ------------|");
        System.out.println("| 1 - Combat 1v1                |");
        System.out.println("| 2 - Combat de groupe          |");
        System.out.println("| 3 - Combat 1vAll              |");
        System.out.println("| 4 - Informations              |");
        System.out.println("| 5 - Quitter                   |");
        System.out.println("|-------------------------------|");
        System.out.println("Faite votre choix : ");

        int choix = sc.nextInt();
        switch (choix){
            case 1:
                combat1v1();
                break;
            case 2:
                combatGroupe();
                break;
            case 3:
                combat1vAll();
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

    public static void combat1v1(){
        Personnage p = createPersonnage();
        Monstre monstre = createMonstre();
        afficherInfos(p);
        afficherInfos(monstre);
        combat(p, monstre);
    }

    public static void combatGroupe(){
        System.out.println("Combien de personnages voulez-vous créer ?");
        int nbPersonnages = sc.nextInt();
        Groupe groupePersonnages = createPersonnageGroupe(nbPersonnages);
        System.out.println("Combien de monstres voulez-vous créer ?");
        int nbMonstres = sc.nextInt();
        Groupe groupeMonstres = createMonstreGroupe(nbMonstres);
        while (!groupePersonnages.estMort() && !groupeMonstres.estMort()) {
            boolean turn = new Random().nextBoolean();
            if (turn) {
                groupePersonnages.attaquer(groupeMonstres);
            } else {
                groupeMonstres.attaquer(groupePersonnages);
            }
        }
        if (groupePersonnages.estMort()) {
            System.out.println("Les personnages sont morts. Les monstres ont gagné");
        } else {
            System.out.println("Les monstres sont morts. Les personnages ont gagné");
        }
    }

    public static void combat1vAll(){
        Personnage p = createPersonnage();
        System.out.println("Combien de monstres voulez-vous créer ?");
        int nbMonstres = sc.nextInt();
        Groupe groupeMonstres = createMonstreGroupe(nbMonstres);
        afficherInfos(p);
        while (!p.estMort() && !groupeMonstres.estMort()) {
            boolean turn = new Random().nextBoolean();
            if (turn) {
                p.attaquer(groupeMonstres);
            } else {
                groupeMonstres.attaquer(p);
            }
        }
        if (p.estMort()) {
            System.out.println("Le personnage est mort. Les monstres ont gagné");
        } else {
            System.out.println("Les monstres sont morts. Le personnage a gagné");
        }
    }

    /**
     * Affiche les informations sur les classes disponibles
     * les attaques disponibles selon la classe
     * et les monstres
     * @return void
     */
    public static void informations(){
        System.out.println("Informations : ");
        System.out.println("Classes disponibles : ");
        for (String key : dictionnaire.keySet()) {
            System.out.println(key);
        }
        System.out.println("Attaques disponibles : ");
        for(String key : dictionnaire.keySet()){
            System.out.println(key + " : " + dictionnaire.get(key).getAttaques());
        }
    }
}
