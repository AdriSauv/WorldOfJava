package fr.adsa;

import fr.adsa.model.Personnage;
import fr.adsa.monde.Monde;

public class Main {
    public static void main(String[] args) {
        Monde m = new Monde();
        Personnage hero = m.createPersonnage();
        m.afficherInfos(hero);
    }
}