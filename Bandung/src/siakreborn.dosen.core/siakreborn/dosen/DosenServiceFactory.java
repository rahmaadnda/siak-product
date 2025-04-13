package siakreborn.dosen;

import siakreborn.dosen.core.DosenService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class DosenServiceFactory {
  private static final Logger LOGGER = Logger.getLogger(DosenServiceFactory.class.getName());

  public DosenServiceFactory() {

  }

  public static DosenService createDosenService(String fullyQualifiedName, Object... base) {
    DosenService record = null;
    if (true) {
      try {
        Class<?> clz = Class.forName(fullyQualifiedName);
        Constructor<?> constructor = clz.getDeclaredConstructors()[0];
        record = (DosenService) constructor.newInstance(base);
      } catch (IllegalArgumentException e) {
        LOGGER.severe("Failed to create instance of DosenService.");
        LOGGER.severe("Given FQN: " + fullyQualifiedName);
        LOGGER.severe("Failed to run: Check your constructor argument");
        System.exit(20);
      } catch (ClassCastException e) {
        LOGGER.severe("Failed to create instance of DosenService.");
        LOGGER.severe("Given FQN: " + fullyQualifiedName);
        LOGGER.severe("Failed to cast the object");
        System.exit(30);
      } catch (ClassNotFoundException e) {
        LOGGER.severe("Failed to create instance of DosenService.");
        LOGGER.severe("Given FQN: " + fullyQualifiedName);
        LOGGER.severe("Decorator can't be applied to the object");
        System.exit(40);
      } catch (Exception e) {
        LOGGER.severe("Failed to create instance of DosenService.");
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
