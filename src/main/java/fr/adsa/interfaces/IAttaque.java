package fr.adsa.interfaces;

public interface IAttaque {
    public int lancerAttaque(ICombattant lanceur, ICombattant cible);

    //Getteurs et setteurs
    public String getNom();
    public double getChanceToucher();
    public void setNom(String nom);
    public void setChanceToucher(double chanceToucher);
    public void setDegats(double degats);
    public int getDegats();
}
