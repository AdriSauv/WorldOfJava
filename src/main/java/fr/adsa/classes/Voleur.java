package fr.adsa.classes;

import fr.adsa.actions.Attaque;
import fr.adsa.interfaces.IAttaque;

import java.util.ArrayList;
import java.util.List;

public class Voleur extends Classe{
    public Voleur() {
        super("Voleur", attaques());
    }

    private static List<IAttaque> attaques(){
        List<IAttaque> attaques = new ArrayList<>();
        Attaque larcon = new Attaque("Larçon", 13, 80);
        attaques.add(larcon);
        Attaque coupDeDague = new Attaque("Coup de dague", 15, 70);
        attaques.add(coupDeDague);
        Attaque guillotine = new Attaque("Guillotine", 100, 10);
        attaques.add(guillotine);

        return attaques;
    }


}
