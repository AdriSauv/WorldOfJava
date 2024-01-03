package fr.adsa.abstrait;

import fr.adsa.interfaces.ICombattant;

public abstract class Combattant implements ICombattant {
    public String nom;
    public int pdv;
    public int degats;

    public Combattant() {
    }

    public Combattant(String nom, int pdv) {
        this.nom = nom;
        this.pdv = pdv;
    }

    public Combattant(String nom, int pdv, int degats) {
        this.nom = nom;
        this.pdv = pdv;
        this.degats = degats;
    }


    // methode attaquer qui utilise le getAttaque de la classe classe
    @Override
    public void attaquer(ICombattant cible) {
        cible.defendre(this.degats);
        System.out.println(this.nom + " attaque " + cible.getNom() + " et lui inflige " + this.degats + " degats");
        System.out.println(cible.getNom() + " a " + cible.getPdv() + " pdv");
    }

    public void defendre(int degats){
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

    public boolean estMort(){
        return this.pdv <= 0;
    }
}
