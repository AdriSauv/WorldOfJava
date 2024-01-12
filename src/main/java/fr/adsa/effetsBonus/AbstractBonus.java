package fr.adsa.effetsBonus;

import fr.adsa.enums.Rarity;
import fr.adsa.model.Personnage;

/**
 * Classe Bonus.AbstractBonus qui va contenir des attributs communs a tous les bonus
 * nom, description, effet
 */
public abstract class AbstractBonus {
    private String nom;
    private String descritpion;

    private double effet;
    private Rarity rarity;

    public AbstractBonus(){

    }

    public AbstractBonus(String nom, String descritpion, double effet, Rarity rarity) {
        this.nom = nom;
        this.descritpion = descritpion;
        this.effet = effet;
        this.rarity = rarity;
    }

    public abstract void applyBonus(Personnage personnage);
}
