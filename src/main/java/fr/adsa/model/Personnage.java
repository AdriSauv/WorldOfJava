package fr.adsa.model;

import fr.adsa.abstrait.Combattant;
import fr.adsa.classes.Classe;
import fr.adsa.interfaces.ICombattant;

/**
 * classe abstraite Personnage qui contient un nom, des pdv, des degats
 */
public class Personnage extends Combattant {

    private Classe classe;

    public Personnage() {
        super();
    }

    public Personnage(String nom, int pdv, Classe classe) {
        super(nom, pdv);
        this.classe = classe;
    }

    @Override
    public void attaquer(ICombattant cible) {
        cible.defendre(this.classe.getAttaques().lancerAttaque(this, cible));
        System.out.println(cible.getNom() + " a " + cible.getPdv() + " pdv");
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Personnage{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", pdv=").append(pdv);
        sb.append(", degats=").append(degats);
        sb.append(", classe=").append(classe);
        sb.append('}');
        return sb.toString();
    }
}
