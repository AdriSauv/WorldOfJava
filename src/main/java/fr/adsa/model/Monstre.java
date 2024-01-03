package fr.adsa.model;

import fr.adsa.abstrait.Combattant;

public class Monstre extends Combattant {
    public Monstre(String nom, int pdv, int degats) {
        super(nom, pdv, degats);
    }

    @Override
    public boolean estMort() {
        return false;
    }
}
