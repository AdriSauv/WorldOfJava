package fr.adsa.model;

import fr.adsa.abstrait.Combattant;
import fr.adsa.classes.Classe;
import fr.adsa.interfaces.ICombattant;

/**
 * classe abstraite Personnage qui contient un nom, des pdv, des degats
 */
public class Personnage extends Combattant {

    public Classe classe;
    public Personnage(String nom, int pdv, int degats, Classe classe) {
        super(nom, pdv, degats);
        this.classe = classe;
    }

    @Override
    public void attaquer(ICombattant cible) {
        cible.defendre(this.classe.getAttaques().lancerAttaque(this, cible));
        System.out.println(cible.getNom() + " a " + cible.getPdv() + " pdv");
    }
}
