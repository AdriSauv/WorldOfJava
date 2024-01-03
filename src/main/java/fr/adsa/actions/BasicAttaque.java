package fr.adsa.actions;

import fr.adsa.interfaces.IAttaque;
import fr.adsa.interfaces.ICombattant;

public class BasicAttaque implements IAttaque{
    public int degats;
    public double chanceToucher;

    public BasicAttaque(int degats){
        this.degats = degats;
        this.chanceToucher = 90;
    }

    @Override
    public int lancerAttaque(ICombattant lanceur, ICombattant cible) {
        int randInt = (int) (Math.random() * 100);
        int damage = 0;
        if (randInt <= this.chanceToucher){
            damage = this.degats;
            System.out.println(lanceur.getNom() + " attaque " + cible.getNom() + " et lui inflige " + damage + " degats");
        } else {
            System.out.println(lanceur.getNom() + " attaque " + cible.getNom() + " mais rate son attaque");
        }
        return damage;
    }

    @Override
    public String getNom() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public double getChanceToucher() {
        return 0;
    }

    @Override
    public void setNom(String nom) {

    }

    @Override
    public void setDescription(String description) {

    }

    @Override
    public void setChanceToucher(double chanceToucher) {

    }
}
