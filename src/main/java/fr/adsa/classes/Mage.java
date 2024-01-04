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
        BasicAttaque eclair = new BasicAttaque("Eclair", 13, 80);
        attaques.add(eclair);
        BasicAttaque bouleDeFeu = new BasicAttaque("Boule de feu", 15, 70);
        attaques.add(bouleDeFeu);
        BasicAttaque armageddon = new BasicAttaque("Armageddon", 100, 10);
        attaques.add(armageddon);
        return attaques;
    }
}
