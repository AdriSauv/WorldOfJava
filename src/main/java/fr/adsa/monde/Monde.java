package fr.adsa.monde;

import fr.adsa.abstrait.Combattant;
import fr.adsa.actions.BasicAttaque;
import fr.adsa.classes.Classe;
import fr.adsa.classes.Mage;
import fr.adsa.classes.Voleur;
import fr.adsa.interfaces.ICombattant;
import fr.adsa.model.Groupe;
import fr.adsa.model.Monstre;
import fr.adsa.model.Personnage;

import java.util.*;

import static java.lang.Thread.sleep;

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
            Classe voleur = new Voleur();
            dictionnaire.put(voleur.getNom(), voleur);
        }
        return dictionnaire;
    }

    public static Classe getClasse(String nom) {
        return dictionnaire.get(nom);
    }

    public static Personnage personnageFactory() {
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

    public static Monstre monstreFactory() {
        String nom = fName[new Random().nextInt(fName.length)] + " " + lName[new Random().nextInt(lName.length)];
        return new Monstre(nom, 100, 10);
    }

    //Récupere les infos du personnage et les affiches
    public static void afficherInfos(Combattant combattant){
        System.out.println(combattant);
    }

    //Creation d'une méthode combat qui prend en parametre un personnage et un monstre à tour de role
    public static void combat(Personnage personnage, Monstre monstre) throws InterruptedException {
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

    //Initialiser une liste de 15 monstres
    public static void initMonstres(){
        for(int i = 0; i < 30; i++){
            monstres.add(monstreFactory());
        }
    }

    public static Groupe createMonstreGroupe(int nbMonstres) {
        initMonstres();
        Groupe groupe = new Groupe();
        for (int i = 0; i < nbMonstres; i++) {
            groupe.addCombattant(monstreFactory());
        }
        return groupe;
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
        System.out.println("| 3 - Combat 1vAll              |");
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

    public static void combat1v1() throws InterruptedException {
        Personnage p = personnageFactory();
        Monstre monstre = monstreFactory();
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
        Personnage p = personnageFactory();
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
