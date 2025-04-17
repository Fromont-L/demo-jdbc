package fr.diginamic.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnexionJDBC {
    public static void main(String[] args) {

        // [PROTOCOLE(jdbc)]:[SOUS-PROTOCOLE(mysql)]:[COMPLEMENTS(//localhost:3306/nom-bdd)]
        String url1 = "jdbc:mysql://localhost:3306/tp-diginamic";
        String url2 = "jdbc:mysql://localhost:3306/tp-diginamic-garage";
        String utilisateur = "root";
        String mdp = "";

        try {

            Connection connection = DriverManager.getConnection(url1,utilisateur, mdp);
            System.out.println("Connexion à : " + connection.getCatalog());

            connection.close();
            System.out.println("Adieu");


            Connection connection2 = DriverManager.getConnection(url2,utilisateur, mdp);
            System.out.println("Connexion à : " + connection2);

            connection2.close();
            System.out.println("Adieu 2");

        } catch (SQLException e) {
            System.err.println("Erreur de connexion : " + e.getMessage());
        }

    }
}
