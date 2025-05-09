package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FournisseurDaoJDBC implements FournisseurDao {

    private final static String URL = "jdbc:mysql://localhost:3306/tp-diginamic";
    private final static String USER = "root";
    private final static String MDP = "";

    @Override
    public List<Fournisseur> extraire() {
        List<Fournisseur> fournisseurs = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(URL,USER, MDP);
            Statement stmt = connection.createStatement();
            // System.out.println("Connexion à : " + connection.getCatalog());
            //Sélectionner tous les fournisseurs
            ResultSet curseur = stmt.executeQuery("SELECT * FROM fournisseur");

            while (curseur.next()) {
                int id = curseur.getInt("ID");
                String nom = curseur.getString("NOM");
                fournisseurs.add(new Fournisseur(id, nom));
            }
            curseur.close();
            stmt.close();
            connection.close();
            System.out.println("Liste des fournisseurs : \n" + fournisseurs.toString() + "\n");
        } catch (SQLException e) {
            System.err.println("Ah ! : " + e.getMessage());
        }
        return fournisseurs;
    }

    @Override
    public void insert(Fournisseur fournisseur) {

        try (Connection connection = DriverManager.getConnection(URL,USER, MDP);
            Statement stmt = connection.createStatement()) {

            stmt.executeUpdate("INSERT INTO fournisseur (NOM) VALUES ('" + fournisseur.getNom() + "') ");



        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public int update(String ancienNom, String nouveauNom) {
        int lignesModif = 0;

        try (Connection connection = DriverManager.getConnection(URL,USER, MDP);
             Statement stmt = connection.createStatement()) {


            lignesModif = stmt.executeUpdate("UPDATE fournisseur SET NOM = '" + nouveauNom + "' WHERE NOM = '" + ancienNom + "'");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return lignesModif;
    }

    @Override
    public boolean delete(Fournisseur fournisseur) {
        boolean suppr = false;

        try (Connection connection = DriverManager.getConnection(URL, USER, MDP);
            Statement stmt = connection.createStatement()) {
            int resultat = stmt.executeUpdate("DELETE FROM fournisseur WHERE NOM = '" + fournisseur.getNom() + "'");
            suppr = resultat > 0;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return suppr;
    }
}
