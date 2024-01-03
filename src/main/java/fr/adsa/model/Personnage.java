package fr.adsa.model;

import fr.adsa.abstrait.Combattant;

/**
 * classe abstraite Personnage qui contient un nom, des pdv, des degats
 */
public class Personnage extends Combattant {
    public Personnage(String nom, int pdv, int degats) {
        super(nom, pdv, degats);
    }

}
