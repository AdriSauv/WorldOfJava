package fr.adsa.model;

import fr.adsa.abstrait.Combattant;
import fr.adsa.classes.Classe;

/**
 * classe abstraite Personnage qui contient un nom, des pdv, des degats
 */
public class Personnage extends Combattant {

    public Classe classe;
    public Personnage(String nom, int pdv, int degats, Classe classe) {
        super(nom, pdv, degats);
        this.classe = classe;
    }

}
