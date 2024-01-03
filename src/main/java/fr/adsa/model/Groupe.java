package fr.adsa.model;

import fr.adsa.interfaces.ICombattant;

import java.util.List;

public class Groupe implements ICombattant {

    private List<ICombattant> combattants;

    //méthode addCombattant qui ajoute un combattant au groupe
    public void addCombattant(ICombattant combattant) {
        combattants.add(combattant);
    }

    @Override
    public void attaquer(ICombattant cible) {
        //choisi un combattant au hasard
        int random = (int) (Math.random() * combattants.size());
        ICombattant combattant = combattants.get(random);
        combattant.attaquer(cible);
    }

    @Override
    public void defendre(int degats) {
        //choisi un combattant au hasard
        int random = (int) (Math.random() * combattants.size());
        ICombattant combattant = combattants.get(random);
        combattant.defendre(degats);
    }

    @Override
    public String getNom() {
        return null;
    }

    @Override
    public int getDegats() {
        return 0;
    }

    @Override
    public int getPdv() {
        return 0;
    }

    @Override
    public void setNom(String nom) {

    }

    @Override
    public void setDegats(int degats) {

    }

    @Override
    public void setPdv(int pdv) {

    }

    //methode est mort qui verifie si tous les combattants du groupe sont morts
    @Override
    public boolean estMort() {
        for(ICombattant combattant : combattants){
            if(!combattant.estMort()){
                return false;
            }
        }
        return true;
    }
}
