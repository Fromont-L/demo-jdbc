package fr.diginamic.jdbc;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;

public class TestSelect {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tp-diginamic";
        String utilisateur = "root";
        String mdp = "";


        try {


            Connection connection = DriverManager.getConnection(url,utilisateur, mdp);
            Statement stmt = connection.createStatement();
            System.out.println("Connexion à : " + connection.getCatalog());

            //Sélectionner un fournisseur
            ResultSet curseur = stmt.executeQuery("SELECT * FROM fournisseur");

            ArrayList<Fournisseur> fournisseurs = new ArrayList<>();

            while (curseur.next()) {
                int id = curseur.getInt("ID");
                String nom = curseur.getString("NOM");

                Fournisseur fournisseurCourant = new Fournisseur(id, nom);
                fournisseurs.add(fournisseurCourant);




            }
            curseur.close();
            stmt.close();
            connection.close();

            System.out.println("Liste des fournisseurs : \n" + fournisseurs.toString() + "\n");
            System.out.println("Adieu");
        } catch (SQLException e) {
            System.err.println("Ah ! : " + e.getMessage());
        }
    }
}
