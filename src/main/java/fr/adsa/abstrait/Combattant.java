package fr.adsa.abstrait;

import fr.adsa.interfaces.ICombattant;

public abstract class Combattant implements ICombattant {
    public String nom;
    public int pdv;
    public int degats;

    public Combattant(String nom, int pdv, int degats) {
        this.nom = nom;
        this.pdv = pdv;
        this.degats = degats;
    }

    @Override
    public void attaquer(ICombattant cible) {
        System.out.println(this.nom + " attaque " + cible.getNom());
        cible.defendre(this.degats);
        System.out.println(cible.getNom() + " a " + cible.getPdv() + " pdv");
    }

    @Override
    public void defendre(int degats) {
        System.out.println(this.nom + " se defend");
        this.pdv -= degats;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPdv() {
        return pdv;
    }

    public void setPdv(int pdv) {
        this.pdv = pdv;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Combattant{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", pdv=").append(pdv);
        sb.append(", degats=").append(degats);
        sb.append('}');
        return sb.toString();
    }
}
