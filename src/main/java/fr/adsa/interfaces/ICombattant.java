package fr.adsa.interfaces;

import fr.adsa.classes.Classe;

import java.util.Map;

public interface ICombattant {
    void attaquer(ICombattant cible);
    void defendre(int degats);
    void soin(int soin);

    // Getters et setters
    String getNom();
    int getDegats();
    int getPdv();
    void setNom(String nom);
    void setDegats(int degats);
    void setPdv(int pdv);
    boolean estMort();
    double getCrit();
    double getCritDamage();
}
