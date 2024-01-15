package fr.adsa;

import fr.adsa.classes.Mage;
import fr.adsa.model.Personnage;
import fr.adsa.monde.Monde;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Monde.menu();
        Personnage p1 = new Personnage("p1",100);
        p1.soin(100);
    }
}