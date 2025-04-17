package fr.diginamic.props;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfigurationProps {
    public static void main(String[] args) {

        Properties properties = new Properties();

        try (InputStream input = TestConfigurationProps.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Fichier config.properties introuvable !");
                return;
            }

            properties.load(input);

            // Afficher le premier paramètre
            System.out.println("URL: " + properties.getProperty("db.url"));

            // Afficher toutes les paires clé/valeur
            for (String key : properties.stringPropertyNames()) {
                System.out.println(key + " = " + properties.getProperty(key));
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}