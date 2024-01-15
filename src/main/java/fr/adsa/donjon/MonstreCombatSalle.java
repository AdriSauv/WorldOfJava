package fr.adsa.donjon;

import fr.adsa.interfaces.ICombattant;

public class MonstreCombatSalle implements Salle{
    /**
     * Methode qui va permettre au combattant d'entrer dans la salle
     * MonstreCombatSalle est une salle qui permet de combattre un monstre
     * @param combattant Combattant qui va entrer dans la salle
     */
    @Override
    public void entrer(ICombattant combattant) {
        combattant.attaquer(combattant);
    }
}
