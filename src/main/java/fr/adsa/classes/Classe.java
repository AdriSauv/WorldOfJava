package fr.adsa.classes;

import fr.adsa.actions.BasicAttaque;
import fr.adsa.interfaces.IAttaque;

import java.util.List;

public class Classe {
    public String nom;
    // liste d'attaque de la classe, qui comprend juste BasicAttaque pour l'instant
    public List<IAttaque> attaques = List.of(new BasicAttaque(10));

    public Classe(String nom, List<IAttaque> attaques) {
        this.nom = nom;
        this.attaques = attaques;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // recupere une attaque de la liste d'attaque aléatoirement
    public IAttaque getAttaques() {
        return attaques.get((int) (Math.random() * attaques.size()));
    }

    public void setAttaques(List<IAttaque> attaques) {
        this.attaques = attaques;
    }
}
