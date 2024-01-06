package fr.adsa.monstres;

import fr.adsa.actions.Attaque;
import fr.adsa.interfaces.IAttaque;

import java.util.ArrayList;
import java.util.List;

public class Commun extends Monstre {

    static String[] noms = {"Rat", "Chauve-souris", "Loup", "Sanglier", "Araignée"};

    public Commun() {
        super(noms[(int) (Math.random() * noms.length)], attaques());
    }

    private static List<IAttaque> attaques(){
        List<IAttaque> attaques = new ArrayList<>();
        Attaque morsure = new Attaque("Morsure", 5, 90);
        attaques.add(morsure);
        Attaque griffe = new Attaque("Griffe", 3, 100);
        attaques.add(griffe);
        return attaques;
    }
}