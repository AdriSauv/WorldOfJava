package fr.adsa.monde;

import fr.adsa.model.Personnage;

import java.util.Scanner;

public class Monde {
    public static Personnage createPersonnage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom du personnage : ");
        String nom = sc.nextLine();
        return new Personnage(nom, 100, 10);
    }
}
