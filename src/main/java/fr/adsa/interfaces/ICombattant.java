package fr.adsa.interfaces;

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

}