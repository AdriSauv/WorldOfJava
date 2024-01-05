package fr.adsa.actions;

import fr.adsa.interfaces.IAttaque;
import fr.adsa.interfaces.ICombattant;

public class Attaque implements IAttaque{
    public int degats;
    public double chanceToucher;
    public String nom;

    public Attaque(String nom, int degats, double chanceToucher) {
        this.degats = degats;
        this.nom = nom;
        this.chanceToucher = chanceToucher;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    @Override
    public double getChanceToucher() {
        return chanceToucher;
    }

    @Override
    public void setChanceToucher(double chanceToucher) {
        this.chanceToucher = chanceToucher;
    }

    @Override
    public int lancerAttaque(ICombattant lanceur, ICombattant cible) {
        int randInt = (int) (Math.random() * 100);
        int damage = 0;
        if (randInt <= this.chanceToucher){
            damage = this.degats;
            System.out.println(lanceur.getNom() + " attaque " + cible.getNom() +
                    " avec " + this.nom + " et lui inflige " + this.degats + " degats");
            System.out.println(cible.getNom() + " a " + (cible.getPdv()-damage) + " pdv");
        } else {
            System.out.println(lanceur.getNom() + " attaque " + cible.getNom() + " avec " + this.nom + " mais rate son attaque");
        }
        return damage;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Attaque{");
        sb.append("degats=").append(degats);
        sb.append(", chanceToucher=").append(chanceToucher);
        sb.append(", nom='").append(nom).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
