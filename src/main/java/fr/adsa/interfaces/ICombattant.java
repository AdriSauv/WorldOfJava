package fr.adsa.interfaces;

import fr.adsa.classes.Classe;

import java.util.Map;

public interface ICombattant {
    public void attaquer(ICombattant cible);
    public void defendre(int degats);

    // Getters et setters
    public String getNom();
    public int getDegats();
    public int getPdv();
    public void setNom(String nom);
    public void setDegats(int degats);
    public void setPdv(int pdv);
    public boolean estMort();
}
