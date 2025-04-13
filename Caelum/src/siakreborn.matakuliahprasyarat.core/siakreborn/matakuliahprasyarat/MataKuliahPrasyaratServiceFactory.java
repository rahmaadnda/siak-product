package siakreborn.matakuliahprasyarat;

import siakreborn.matakuliahprasyarat.core.MataKuliahPrasyaratService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class MataKuliahPrasyaratServiceFactory {
  private static final Logger LOGGER = Logger.getLogger(MataKuliahPrasyaratServiceFactory.class.getName());

  public MataKuliahPrasyaratServiceFactory() {

  }

  public static MataKuliahPrasyaratService createMataKuliahPrasyaratService(String fullyQualifiedName, Object... base) {
    MataKuliahPrasyaratService record = null;
    if (true) {
      try {
        Class<?> clz = Class.forName(fullyQualifiedName);
        Constructor<?> constructor = clz.getDeclaredConstructors()[0];
        record = (MataKuliahPrasyaratService) constructor.newInstance(base);
      } catch (IllegalArgumentException e) {
        LOGGER.severe("Failed to create instance of MataKuliahPrasyaratService.");
        LOGGER.severe("Given FQN: " + fullyQualifiedName);
        LOGGER.severe("Failed to run: Check your constructor argument");
        System.exit(20);
      } catch (ClassCastException e) {
        LOGGER.severe("Failed to create instance of MataKuliahPrasyaratService.");
        LOGGER.severe("Given FQN: " + fullyQualifiedName);
        LOGGER.severe("Failed to cast the object");
        System.exit(30);
      } catch (ClassNotFoundException e) {
        LOGGER.severe("Failed to create instance of MataKuliahPrasyaratService.");
        LOGGER.severe("Given FQN: " + fullyQualifiedName);
        LOGGER.severe("Decorator can't be applied to the object");
        System.exit(40);
      } catch (Exception e) {
        LOGGER.severe("Failed to create instance of MataKuliahPrasyaratService.");
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
