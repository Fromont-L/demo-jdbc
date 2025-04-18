package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FournisseurDaoJDBC2 implements FournisseurDao {

    private final static String URL = "jdbc:mysql://localhost:3306/tp-diginamic";
    private final static String USER = "root";
    private final static String MDP = "";

    @Override
    public List<Fournisseur> extraire() {
        List<Fournisseur> fournisseurs = new ArrayList<>();

        String sql = "SELECT * FROM fournisseur";
        try {
            Connection connection = DriverManager.getConnection(URL,USER, MDP);
            System.out.println("Connexion à : " + connection.getCatalog());
            //Sélectionner tous les fournisseurs
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            ResultSet curseur = prepStmt.executeQuery();

            while (curseur.next()) {
                int id = curseur.getInt("ID");
                String nom = curseur.getString("NOM");
                fournisseurs.add(new Fournisseur(id, nom));
            }
            System.out.println("Liste des fournisseurs : \n" + fournisseurs.toString() + "\n");
        } catch (SQLException e) {
            System.err.println("Ah ! : " + e.getMessage());
        }
        return fournisseurs;
    }

    @Override
    public void insert(Fournisseur fournisseur) {

        String sql = "INSERT INTO fournisseur (NOM) VALUES (?)";

        try (Connection connection = DriverManager.getConnection(URL,USER, MDP);
             PreparedStatement prepStmt = connection.prepareStatement(sql)) {
            prepStmt.setString(1, fournisseur.getNom());
            prepStmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public int update(String ancienNom, String nouveauNom) {
        String sql = "UPDATE fournisseur SET NOM = ? WHERE NOM = ?";
        int lignesModif = 0;

        try (Connection connection = DriverManager.getConnection(URL,USER, MDP);
             PreparedStatement prepStmt = connection.prepareStatement(sql)) {
            prepStmt.setString(1, nouveauNom);
            prepStmt.setString(2, ancienNom);

            lignesModif = prepStmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return lignesModif;
    }

    @Override
    public boolean delete(Fournisseur fournisseur) {
        String sql = "DELETE FROM fournisseur WHERE NOM = ?";
        boolean suppr = false;

        try (Connection connection = DriverManager.getConnection(URL, USER, MDP);
             PreparedStatement prepStmt = connection.prepareStatement(sql)) {
            prepStmt.setString(1, fournisseur.getNom());
            int resultat = prepStmt.executeUpdate();
            suppr = resultat > 0;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return suppr;
    }
}
