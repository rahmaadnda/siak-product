package siakreborn.komponenpenilaian;

import siakreborn.komponenpenilaian.core.KomponenPenilaianResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class KomponenPenilaianResourceFactory{
    private static final Logger LOGGER = Logger.getLogger(KomponenPenilaianFactory.class.getName());

    public KomponenPenilaianResourceFactory()
    {

    }

    public static KomponenPenilaianResource createKomponenPenilaianResource(String fullyQualifiedName, Object ... base)
    {
        KomponenPenilaianResource record = null;
        if (true) {
            try {
                Class<?> clz = Class.forName(fullyQualifiedName);
                Constructor<?> constructor = clz.getDeclaredConstructors()[0];
                record = (KomponenPenilaianResource) constructor.newInstance(base);
            } 
            catch (IllegalArgumentException e)
            {
                LOGGER.severe("Failed to create instance of KomponenPenilaian.");
                LOGGER.severe("Given FQN: " + fullyQualifiedName);
                LOGGER.severe("Failed to run: Check your constructor argument");
                System.exit(20);
            }
            catch (ClassCastException e)
            {   LOGGER.severe("Failed to create instance of KomponenPenilaian.");
                LOGGER.severe("Given FQN: " + fullyQualifiedName);
                LOGGER.severe("Failed to cast the object");
                System.exit(30);
            }
            catch (ClassNotFoundException e)
            {
                LOGGER.severe("Failed to create instance of KomponenPenilaian.");
                LOGGER.severe("Given FQN: " + fullyQualifiedName);
                LOGGER.severe("Decorator can't be applied to the object");
                System.exit(40);
            }
            catch (Exception e)
            {
                LOGGER.severe("Failed to create instance of KomponenPenilaian.");
                LOGGER.severe("Given FQN: " + fullyQualifiedName);
                System.exit(50);
            }
        } else {
            System.out.println("Config Fail");
            System.exit(10);
        }
        return record;
    }

}
