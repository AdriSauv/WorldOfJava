package fr.adsa.effetsBonus;

import fr.adsa.enums.Rarity;
import fr.adsa.model.Personnage;

public class AttackBonus extends AbstractBonus{

    public AttackBonus(Rarity rarity){
        super("Bonus d'attaque", "Augmente l'attaque du personnage", getBonus(rarity), rarity);
    }
    /**
     * @param personnage  : le personnage qui va recevoir le bonus
     */
    @Override
    public void applyBonus(Personnage personnage) {
        
    }

    private static double getBonus(Rarity rarity){
        switch(rarity){
            case COMMUN:
                return 0.05;
            case RARE:
                return 0.12;
            case LEGENDAIRE:
                return 0.16;
            default:
                return 0;
        }
    }
}
