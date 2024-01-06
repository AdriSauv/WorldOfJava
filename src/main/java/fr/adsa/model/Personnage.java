package fr.adsa.model;

import fr.adsa.abstrait.Combattant;
import fr.adsa.classes.Classe;
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

    @Override
    public boolean estMort() {
        return this.pdv <= 0;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Personnage{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", pdv=").append(pdv);
        sb.append(", classe=").append(classe);
        sb.append('}');
        return sb.toString();
    }
}
