package fr.diginamic.jdbc;

import java.sql.*;

public class TestDelete {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tp-diginamic";
        String utilisateur = "root";
        String mdp = "";


        try {


            Connection connection = DriverManager.getConnection(url,utilisateur, mdp);
            Statement stmt = connection.createStatement();
            System.out.println("Connexion à : " + connection.getCatalog());

            //Supprimer un fournisseur
            int nb = stmt.executeUpdate("DELETE FROM fournisseur WHERE NOM='La Maison de la peinture'");

            ResultSet curseur = stmt.executeQuery("SELECT * FROM fournisseur");


            while (curseur.next()) {
                int id = curseur.getInt("ID");
                String nom = curseur.getString("NOM");
                System.out.println("ID : " + id + " NOM : " +  nom);
            }
            curseur.close();
            stmt.close();
            connection.close();

            System.out.println("Adieu");
        } catch (SQLException e) {
            System.err.println("Ah ! : " + e.getMessage());
        }
    }
}
