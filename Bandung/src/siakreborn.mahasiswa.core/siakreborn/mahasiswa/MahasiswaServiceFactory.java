package siakreborn.mahasiswa;

import siakreborn.mahasiswa.core.MahasiswaService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class MahasiswaServiceFactory {
  private static final Logger LOGGER = Logger.getLogger(MahasiswaServiceFactory.class.getName());

  public MahasiswaServiceFactory() {

  }

  public static MahasiswaService createMahasiswaService(String fullyQualifiedName, Object... base) {
    MahasiswaService record = null;
    if (true) {
      try {
        Class<?> clz = Class.forName(fullyQualifiedName);
        Constructor<?> constructor = clz.getDeclaredConstructors()[0];
        record = (MahasiswaService) constructor.newInstance(base);
      } catch (IllegalArgumentException e) {
        LOGGER.severe("Failed to create instance of MahasiswaService.");
        LOGGER.severe("Given FQN: " + fullyQualifiedName);
        LOGGER.severe("Failed to run: Check your constructor argument");
        System.exit(20);
      } catch (ClassCastException e) {
        LOGGER.severe("Failed to create instance of MahasiswaService.");
        LOGGER.severe("Given FQN: " + fullyQualifiedName);
        LOGGER.severe("Failed to cast the object");
        System.exit(30);
      } catch (ClassNotFoundException e) {
        LOGGER.severe("Failed to create instance of MahasiswaService.");
        LOGGER.severe("Given FQN: " + fullyQualifiedName);
        LOGGER.severe("Decorator can't be applied to the object");
        System.exit(40);
      } catch (Exception e) {
        LOGGER.severe("Failed to create instance of MahasiswaService.");
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
