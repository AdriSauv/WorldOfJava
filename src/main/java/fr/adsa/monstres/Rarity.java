package fr.adsa.monstres;

import fr.adsa.interfaces.IAttaque;

import java.util.ArrayList;
import java.util.List;

public class Rarity {
    private String nom;
    private List<IAttaque> attaques = new ArrayList<>();

    public Rarity(String nom, List<IAttaque> attaques) {
        this.nom = nom;
        this.attaques = attaques;
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

    @Override
    public String toString() {
        String str = nom;
        return str;
    }
}
