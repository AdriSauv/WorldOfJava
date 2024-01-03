package fr.adsa.classes;

import fr.adsa.actions.BasicAttaque;
import fr.adsa.interfaces.IAttaque;

import java.util.ArrayList;
import java.util.List;

public class Classe {
    public String nom;
    public List<IAttaque> attaques = new ArrayList<IAttaque>();

    public Classe(String nom){
        this.nom = nom;
        this.attaques.add(new BasicAttaque(10));
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<IAttaque> getAttaques() {
        return attaques;
    }

    public void setAttaques(List<IAttaque> attaques) {
        this.attaques = attaques;
    }
}
