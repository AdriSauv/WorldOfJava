package fr.adsa.model;

import fr.adsa.abstrait.Combattant;
import fr.adsa.classes.Classe;
import fr.adsa.classes.Mage;
import fr.adsa.interfaces.ICombattant;

import java.util.Scanner;

/**
 * classe abstraite Personnage qui contient un nom, des pdv et une classe
 * elle implemente la classe abstraite Combattant
 * elle contient les methodes attaquer et estMort
 */
public class Personnage extends Combattant {

    private Classe classe;

    public Personnage(String nom, int pdv, Classe classe) {
        super(nom, pdv);
        this.classe = classe;
    }

    //Constructeur pour les tests
    public Personnage(String nom, int pdv){
        super(nom, pdv);
    }

    public Personnage(String nom, int pdv, int degats, Classe classe) {
        super(nom, pdv, degats);
        this.classe = classe;
    }

    @Override
    public void attaquer(ICombattant cible) {
        Scanner sc = new Scanner(System.in);
        int choix = 0;
        System.out.println("Veuillez choisir une attaque : ");
        for (int i = 0; i < classe.getAttaques().size(); i++) {
            System.out.println(i + " - " + classe.getAttaques().get(i).getNom());
        }
        choix = sc.nextInt();
        classe.getAttaques().get(choix).lancerAttaque(this, cible);
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        String sb = "Personnage{" + "nom='" + nom + '\'' +
                ", pdv=" + pdv +
                ", classe=" + classe +
                '}';
        return sb;
    }
}
