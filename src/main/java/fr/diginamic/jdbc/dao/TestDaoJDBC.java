package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.util.List;

public class TestDaoJDBC {
    public static void main(String[] args) {

        FournisseurDao dao = new FournisseurDaoJDBC2();
        // Ajouter
        Fournisseur nouveau = new Fournisseur("France de matériaux");
        // Il n'est pas trié correctement lors de l'affichage
        Fournisseur nouveau2 = new Fournisseur("L'Espace Création");
        dao.insert(nouveau);
        dao.insert(nouveau2);
        System.out.println("Fournisseur " + "'" + nouveau.getNom() + "'" + " inséré");
        System.out.println("Fournisseur " + "'" + nouveau2.getNom() + "'" + " inséré");

        // Voir
        System.out.println("\nListe après insertion : \n");
        List<Fournisseur> fournisseurs = dao.extraire();
        for (Fournisseur fournisseur : fournisseurs) {
            System.out.println(fournisseur);
        }

        // Modifier
        int modification = dao.update("France de matériaux", "France matériaux");
        System.out.print("Modification !\n" + modification);

        fournisseurs = dao.extraire();
        for (Fournisseur fournisseur : fournisseurs) {
            System.out.println(fournisseur);
        }

        // Supprimer
        Fournisseur aSupprimer = new Fournisseur("France matériaux");
        Fournisseur aSupprimer2 = new Fournisseur("L'espace Création");
        boolean suppr = dao.delete(aSupprimer);
        boolean suppr2 = dao.delete(aSupprimer2);
        System.out.println("Le fournisseur '" + aSupprimer.getNom()  + "' à bien été supprimé ? : " + suppr);


        // Voir tout
        fournisseurs = dao.extraire();
        System.out.print("Affichage final\n");
        for (Fournisseur fournisseur : fournisseurs) {
            System.out.println(fournisseur);
        }

    }
}
