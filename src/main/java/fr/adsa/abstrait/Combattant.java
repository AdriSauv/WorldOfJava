package fr.adsa.abstrait;

public abstract class Combattant {
    public String nom;
    public int pdv;
    public int degats;

    public Combattant(String nom, int pdv, int degats) {
        this.nom = nom;
        this.pdv = pdv;
        this.degats = degats;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPdv() {
        return pdv;
    }

    public void setPdv(int pdv) {
        this.pdv = pdv;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Combattant{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", pdv=").append(pdv);
        sb.append(", degats=").append(degats);
        sb.append('}');
        return sb.toString();
    }
}
