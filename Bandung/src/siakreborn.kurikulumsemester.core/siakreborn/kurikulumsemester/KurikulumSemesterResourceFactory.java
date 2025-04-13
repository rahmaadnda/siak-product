package siakreborn.kurikulumsemester;

import siakreborn.kurikulumsemester.core.KurikulumSemesterResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class KurikulumSemesterResourceFactory{
    private static final Logger LOGGER = Logger.getLogger(KurikulumSemesterFactory.class.getName());

    public KurikulumSemesterResourceFactory()
    {

    }

    public static KurikulumSemesterResource createKurikulumSemesterResource(String fullyQualifiedName, Object ... base)
    {
        KurikulumSemesterResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (KurikulumSemesterResource) constructor.newInstance(base);
        } 
        catch (IllegalArgumentException e)
        {
            LOGGER.severe("Failed to create instance of KurikulumSemester.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
            System.exit(20);
        }
        catch (ClassCastException e)
        {   LOGGER.severe("Failed to create instance of KurikulumSemester.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to cast the object");
            System.exit(30);
        }
        catch (ClassNotFoundException e)
        {
            LOGGER.severe("Failed to create instance of KurikulumSemester.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Decorator can't be applied to the object");
            System.exit(40);
        }
        catch (Exception e)
        {
            LOGGER.severe("Failed to create instance of KurikulumSemester.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(50);
        }
        return record;
    }

}
