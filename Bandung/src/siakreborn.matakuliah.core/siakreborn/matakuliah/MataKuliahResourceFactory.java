package siakreborn.matakuliah;

import siakreborn.matakuliah.core.MataKuliahResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class MataKuliahResourceFactory{
    private static final Logger LOGGER = Logger.getLogger(MataKuliahFactory.class.getName());

    public MataKuliahResourceFactory()
    {

    }

    public static MataKuliahResource createMataKuliahResource(String fullyQualifiedName, Object ... base)
    {
        MataKuliahResource record = null;
        if(true){
            try {
                Class<?> clz = Class.forName(fullyQualifiedName);
                Constructor<?> constructor = clz.getDeclaredConstructors()[0];
                System.out.println(constructor.toString());
                record = (MataKuliahResource) constructor.newInstance(base);
            } 
            catch (IllegalArgumentException e)
            {
                LOGGER.severe("Failed to create instance of MataKuliah.");
                LOGGER.severe("Given FQN: " + fullyQualifiedName);
                LOGGER.severe("Failed to run: Check your constructor argument");
                System.exit(20);
            }
            catch (ClassCastException e)
            {   LOGGER.severe("Failed to create instance of MataKuliah.");
                LOGGER.severe("Given FQN: " + fullyQualifiedName);
                LOGGER.severe("Failed to cast the object");
                System.exit(30);
            }
            catch (ClassNotFoundException e)
            {
                LOGGER.severe("Failed to create instance of MataKuliah.");
                LOGGER.severe("Given FQN: " + fullyQualifiedName);
                LOGGER.severe("Decorator can't be applied to the object");
                System.exit(40);
            }
            catch (Exception e)
            {
                LOGGER.severe("Failed to create instance of MataKuliah.");
                LOGGER.severe("Given FQN: " + fullyQualifiedName);
                System.exit(50);
            }
        }   else
        {
            System.out.println("Config Fail");
            System.exit(10);
        }
        return record;
    }
}
