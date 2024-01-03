package fr.adsa;

import fr.adsa.model.Monstre;
import fr.adsa.model.Personnage;
import fr.adsa.monde.Monde;

public class Main {
    public static void main(String[] args) {
        Monde m = new Monde();
        Personnage p = m.createPersonnage();
        Monstre monstre = m.createMonstre();
        m.afficherInfos(p);
        m.afficherInfos(monstre);

        m.combat(p, monstre);

    }
}