package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.util.List;

public class TestDaoJDBC {
    public static void main(String[] args) {

        FournisseurDao dao = new FournisseurDaoJDBC();
        // Ajouter
        Fournisseur nouveau = new Fournisseur("NOM BIEN VISIBLE");
        dao.insert(nouveau);
        System.out.println("Fournisseur " + "'" + nouveau.getNom() + "'" + " inséré");

        // Voir
        System.out.println("\nListe après insertion : \n");
        List<Fournisseur> fournisseurs = dao.extraire();
        for (Fournisseur fournisseur : fournisseurs) {
            System.out.println(fournisseur);
        }

        // Modifier
        int modification = dao.update("NOM BIEN VISIBLE", "Thermite");
        System.out.print("Modification");

        fournisseurs = dao.extraire();
        for (Fournisseur fournisseur : fournisseurs) {
            System.out.println(fournisseur);
        }

        // Supprimer
        Fournisseur aSupprimer = new Fournisseur("Thermite");
        boolean suppr = dao.delete(aSupprimer);
        System.out.println(suppr);


        // Voir tout
        fournisseurs = dao.extraire();
        System.out.print("Affichage final\n");
        for (Fournisseur fournisseur : fournisseurs) {
            System.out.println(fournisseur);
        }

    }
}
