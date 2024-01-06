package fr.adsa.abstrait;

import fr.adsa.interfaces.ICombattant;

public abstract class Combattant implements ICombattant {
    public String nom;
    public int pdv;
    public int degats;
    public double crit;
    public double critDamage;

    public Combattant() {
    }

    public Combattant(String nom, int pdv, int degats) {
        this.nom = nom;
        this.pdv = pdv;
        this.degats = degats;
    }

    public Combattant(String nom, int pdv) {
        this.nom = nom;
        this.pdv = pdv;
        this.crit = 15.0;
        this.critDamage = 50.0;
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

    public double getCrit() {
        return crit;
    }

    public void setCrit(double crit) {
        this.crit = crit;
    }

    public double getCritDamage() {
        return critDamage;
    }

    public void setCritDamage(double critDamage) {
        this.critDamage = critDamage;
    }

    @Override
    public String toString() {
        String sb = "Combattant{" + "nom='" + nom + '\'' +
                ", pdv=" + pdv +
                ", degats=" + degats +
                '}';
        return sb;
    }

}
