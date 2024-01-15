package fr.adsa.donjon;

import fr.adsa.interfaces.ICombattant;

/**
 * Interface Salle qui va implémenter une methode Entrer(ICombattant combattant)
 */
public interface Salle {
    /**
     * Methode qui va permettre au combattant d'entrer dans la salle
     * @param combattant Combattant qui va entrer dans la salle
     */
    void entrer(ICombattant combattant);
}
