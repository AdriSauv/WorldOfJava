package fr.adsa.classes;

import fr.adsa.actions.Attaque;
import fr.adsa.interfaces.IAttaque;

import java.util.ArrayList;
import java.util.List;

public class Mage extends Classe{
    public Mage() {
        super("Mage", attaques());
    }

    private static List<IAttaque> attaques(){
        List<IAttaque> attaques = new ArrayList<>();
        Attaque eclair = new Attaque("Eclair", 13, 80);
        attaques.add(eclair);
        Attaque bouleDeFeu = new Attaque("Boule de feu", 15, 70);
        attaques.add(bouleDeFeu);
        Attaque armageddon = new Attaque("Armageddon", 100, 10);
        attaques.add(armageddon);
        return attaques;
    }
}
