package fr.diginamic.xml;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.util.Iterator;

public class TestConfigurationXML {
    public static void main(String[] args) throws ConfigurationException {
        Configurations configs = new Configurations();

        XMLConfiguration config = configs.xml("config.xml");
        String nomBase = config.getString("database[@nom]");
        String host = config.getString("database.host");

        System.out.println(nomBase);

        Iterator<String> keys = config.getKeys();
        while (keys.hasNext()) {
            String key = keys.next();
            System.out.println(key + " = " + config.getString(key));
        }

    }
}
