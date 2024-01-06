package fr.adsa.model;

import fr.adsa.abstrait.Combattant;
import fr.adsa.monstres.Monstre;

public class Ennemie extends Combattant {

    private Monstre rarity;

    public Ennemie(String nom, int pdv, Monstre rarity) {
        super(nom, pdv);
        this.rarity = rarity;
    }

    @Override
    public boolean estMort() {
        return false;
    }
}
