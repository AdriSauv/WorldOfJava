package fr.adsa;

import fr.adsa.factory.PersonnageFactory;
import fr.adsa.model.Personnage;

public class Main {
    public static void main(String[] args) {
        System.out.println("App started");
        Personnage hero = PersonnageFactory.createPersonnage();
        // afficher les infos du personnage
        System.out.println("Le personnage " + hero.getNom() + " a " + hero.getPdv() + " pdv et " + hero.getDegats() + " de degats");

    }
}