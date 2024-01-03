package fr.adsa.classes;

import fr.adsa.actions.BasicAttaque;
import fr.adsa.interfaces.IAttaque;

import java.util.ArrayList;
import java.util.List;

public class Mage extends Classe{
    public Mage() {
        super("Mage", attaques());
    }

    private static List<IAttaque> attaques(){
        List<IAttaque> attaques = new ArrayList<>();
        BasicAttaque eclair = new BasicAttaque("Eclair", "Un eclair de foudre", 13, 80);
        attaques.add(eclair);
        BasicAttaque bouleDeFeu = new BasicAttaque("Boule de feu", "Une boule de feu", 15, 70);
        attaques.add(bouleDeFeu);
        BasicAttaque armageddon = new BasicAttaque("Armageddon", "Un sort de fin du monde", 100, 10);
        attaques.add(armageddon);
        return attaques;
    }
}
