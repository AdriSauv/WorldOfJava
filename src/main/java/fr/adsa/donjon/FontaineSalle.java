package fr.adsa.donjon;

import fr.adsa.interfaces.ICombattant;

public class FontaineSalle implements Salle{
    /**
     * Methode qui va permettre au combattant d'entrer dans la salle
     * FontaineSalle est une salle qui permet de regenerer la vie de tous les combattants
     * @param combattant Combattant qui va entrer dans la salle
     */
    @Override
    public void entrer(ICombattant combattant) {
        combattant.soin(100);
    }
}
