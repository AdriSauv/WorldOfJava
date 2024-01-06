package fr.adsa.model;

import fr.adsa.abstrait.Combattant;
import fr.adsa.interfaces.ICombattant;
import fr.adsa.monstres.Rarity;

public class Ennemie extends Combattant {

    private Rarity rarity;

    public Ennemie(String nom, int pdv, Rarity rarity) {
        super(nom, pdv);
        this.rarity = rarity;
    }

    @Override
    public void attaquer(ICombattant cible) {
        int choix = (int) (Math.random() * rarity.getAttaques().size());
        rarity.getAttaques().get(choix).lancerAttaque(this, cible);
    }
}
