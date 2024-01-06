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
    public void setDegats(double degats) {
        this.degats = (int) degats;
    }

    @Override
    public int lancerAttaque(ICombattant lanceur, ICombattant cible) {
        if (toucheAttaque()) {
            int damage = calculerDegats(lanceur);
            afficherResultat(lanceur, cible, damage);
            return damage;
        } else {
            afficherRate(lanceur, cible);
            return 0;
        }
    }

    public boolean toucheAttaque() {
        int randInt = (int) (Math.random() * 100);
        return randInt <= this.chanceToucher;
    }

    public int calculerDegats(ICombattant lanceur) {
        double randomCrit = Math.random() * 100;
        if (randomCrit <= lanceur.getCrit()) {
            // Critical hit
            System.out.println("Coup critique !");
            return (int) (this.degats * (1 + lanceur.getCritDamage() / 100));
        } else {
            // Normal hit
            return this.degats;
        }
    }

    public void afficherResultat(ICombattant lanceur, ICombattant cible, int damage) {
        System.out.println(lanceur.getNom() + " attaque " + cible.getNom() + " avec " + this.nom + " et inflige " + damage + " degats");
        cible.defendre(damage);
        System.out.println(cible.getNom() + " a " + cible.getPdv() + " pdv");
    }

    public void afficherRate(ICombattant lanceur, ICombattant cible) {
        System.out.println(lanceur.getNom() + " attaque " + cible.getNom() + " avec " + this.nom + " mais rate son attaque");
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
