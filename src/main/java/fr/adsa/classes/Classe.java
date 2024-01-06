package fr.adsa.classes;

import fr.adsa.interfaces.IAttaque;

import java.util.ArrayList;
import java.util.List;

public class Classe {
    public String nom;
    public List<IAttaque> attaques = new ArrayList<>();

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

    // Recupere les attaques de la classe
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
