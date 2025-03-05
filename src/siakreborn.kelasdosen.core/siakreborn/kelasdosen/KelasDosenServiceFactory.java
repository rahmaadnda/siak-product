package siakreborn.kelasdosen;

import siakreborn.kelasdosen.core.KelasDosenService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class KelasDosenServiceFactory {
  private static final Logger LOGGER = Logger.getLogger(KelasDosenServiceFactory.class.getName());

  public KelasDosenServiceFactory() {

  }

  public static KelasDosenService createKelasDosenService(String fullyQualifiedName, Object... base) {
    KelasDosenService record = null;
    if (true) {
      try {
        Class<?> clz = Class.forName(fullyQualifiedName);
        Constructor<?> constructor = clz.getDeclaredConstructors()[0];
        record = (KelasDosenService) constructor.newInstance(base);
      } catch (IllegalArgumentException e) {
        LOGGER.severe("Failed to create instance of KelasDosenService.");
        LOGGER.severe("Given FQN: " + fullyQualifiedName);
        LOGGER.severe("Failed to run: Check your constructor argument");
        System.exit(20);
      } catch (ClassCastException e) {
        LOGGER.severe("Failed to create instance of KelasDosenService.");
        LOGGER.severe("Given FQN: " + fullyQualifiedName);
        LOGGER.severe("Failed to cast the object");
        System.exit(30);
      } catch (ClassNotFoundException e) {
        LOGGER.severe("Failed to create instance of KelasDosenService.");
        LOGGER.severe("Given FQN: " + fullyQualifiedName);
        LOGGER.severe("Decorator can't be applied to the object");
        System.exit(40);
      } catch (Exception e) {
        LOGGER.severe("Failed to create instance of KelasDosenService.");
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
