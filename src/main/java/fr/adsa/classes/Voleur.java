package fr.adsa.classes;

import fr.adsa.actions.BasicAttaque;
import fr.adsa.interfaces.IAttaque;

import java.util.ArrayList;
import java.util.List;

public class Voleur extends Classe{
    public Voleur() {
        super("Voleur", attaques());
    }

    private static List<IAttaque> attaques(){
        List<IAttaque> attaques = new ArrayList<>();
        BasicAttaque larcon = new BasicAttaque("Larçon", 13, 80);
        attaques.add(larcon);
        BasicAttaque coupDeDague = new BasicAttaque("Coup de dague", 15, 70);
        attaques.add(coupDeDague);
        BasicAttaque guillotine = new BasicAttaque("Guillotine", 100, 10);
        attaques.add(guillotine);

        return attaques;
    }


}
