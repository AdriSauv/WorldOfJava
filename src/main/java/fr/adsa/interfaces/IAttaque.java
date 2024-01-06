package fr.adsa.interfaces;

public interface IAttaque {
    int lancerAttaque(ICombattant lanceur, ICombattant cible);
    boolean toucheAttaque();
    int calculerDegats(ICombattant lanceur);
    void afficherResultat(ICombattant lanceur, ICombattant cible, int damage);
    void afficherRate(ICombattant lanceur, ICombattant cible);

    //Getteurs et setteurs
    String getNom();
    double getChanceToucher();
    void setNom(String nom);
    void setChanceToucher(double chanceToucher);
    void setDegats(double degats);
    int getDegats();
}
