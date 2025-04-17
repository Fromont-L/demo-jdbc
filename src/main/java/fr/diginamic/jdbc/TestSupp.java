package fr.diginamic.jdbc;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;

public class TestSupp {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tp-diginamic";
        String utilisateur = "root";
        String mdp = "";

        try {
            Connection connection = DriverManager.getConnection(url,utilisateur, mdp);
            Statement stmt = connection.createStatement();
            System.out.println("Connexion à : " + connection.getCatalog());

            // Ajouter des lignes
            int r1 = stmt.executeUpdate("INSERT INTO fournisseur (NOM) VALUES ('Vive le bois')");
            int r2 = stmt.executeUpdate("INSERT INTO fournisseur (NOM) VALUES ('Dubois et du bois')");
            int r3 = stmt.executeUpdate("INSERT INTO fournisseur (NOM) VALUES ('Gueule de bois')");
            int r4 = stmt.executeUpdate("INSERT INTO fournisseur (NOM) VALUES ('Bois ! Bois ! Bois')");
            int r5 = stmt.executeUpdate("INSERT INTO fournisseur (NOM) VALUES ('Yaya')");

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

// Créer une table Fournisseur.
//Insérer des lignes.

//Rechercher un fournisseur par nom :
//
//Demande à l’utilisateur de saisir un nom (ou une partie du nom) du fournisseur.
//
//Recherche dans la base de données tous les fournisseurs dont le nom contient cette chaîne (utilise LIKE).
//
//Affiche les résultats.
//
//
//Rechercher un fournisseur par ID :
//
//Demande à l’utilisateur de saisir un ID.
//
//Requête SQL : SELECT * FROM fournisseur WHERE id = ?
//
//Si le fournisseur existe, affiche ses infos, sinon affiche "Aucun fournisseur trouvé".
//
//
//Insérer plusieurs fournisseurs :
//
//Demande à l’utilisateur combien de fournisseurs il souhaite ajouter.
//
//Pour chacun, demander le nom, puis insérer dans la base.
//
//
//Supprimer tous les fournisseurs contenant un mot :
//
//Demande à l’utilisateur un mot-clé.
//
//Supprime tous les fournisseurs dont le nom contient ce mot.
    }
}
