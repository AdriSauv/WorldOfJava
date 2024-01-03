package fr.adsa.model;

/**
 * classe Personnage qui contient un nom, des pdv, des degats
 */
public class Personnage {
    private String nom;
    private int pdv;
    private int degats;

    /**
     * Constructeur de la classe Personnage
     * @param nom
     * @param pdv
     * @param degats
     */
    public Personnage(String nom, int pdv, int degats) {
        this.nom = nom;
        this.pdv = pdv;
        this.degats = degats;
    }

    /**
     * getter du nom
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * setter du nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getter des pdv
     * @return pdv
     */
    public int getPdv() {
        return pdv;
    }

    /**
     * setter des pdv
     * @param pdv
     */
    public void setPdv(int pdv) {
        this.pdv = pdv;
    }

    /**
     * getter des degats
     * @return degats
     */
    public int getDegats() {
        return degats;
    }

    /**
     * setter des degats
     * @param degats
     */
    public void setDegats(int degats) {
        this.degats = degats;
    }

    /**
     * methode qui permet d'attaquer un personnage
     * @param personnage
     */
    public void attaquer(Personnage personnage) {
        personnage.setPdv(personnage.getPdv() - this.degats);
    }

    /**
     * methode qui permet de savoir si un personnage est mort
     * @return true si le personnage est mort, false sinon
     */
    public boolean estMort() {
        return this.pdv <= 0;
    }

    /**
     * methode qui permet d'afficher les informations d'un personnage
     * @return les informations d'un personnage
     */
    @Override
    public String toString() {
        return "Personnage{" +
                "nom='" + nom + '\'' +
                ", pdv=" + pdv +
                ", degats=" + degats +
                '}';
    }
}
