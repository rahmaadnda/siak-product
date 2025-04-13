package siakreborn.observer.alumni;

import java.util.*;

import siakreborn.observer.ObserverFactory;
import siakreborn.observer.core.ObserverServiceDecorator;
import siakreborn.observer.core.ObserverServiceComponent;
import siakreborn.observer.core.Observer;
import siakreborn.observer.core.ObserverDecorator;

import siakreborn.mahasiswa.core.Mahasiswa;
import siakreborn.mahasiswa.core.MahasiswaService;
import siakreborn.mahasiswa.core.MahasiswaServiceImpl;

import vmj.routing.route.exceptions.NotFoundException;
import vmj.auth.model.core.*;
import vmj.auth.model.utils.*;

public class ObserverServiceImpl extends ObserverServiceDecorator {
  private ObserverFactory observerFactory = new ObserverFactory();
  private MahasiswaService mahasiswaService = new MahasiswaServiceImpl();

  public ObserverServiceImpl(ObserverServiceComponent record) {
    super(record);
  }

  public List<Observer> saveObserver(HashMap<String, Object> body) {
    String idMahasiswaStr = (String) body.get("idMahasiswa");
    if (idMahasiswaStr == null) {
        throw new NotFoundException("idMahasiswa tidak ditemukan");
    }
    UUID idMahasiswa = UUID.fromString(idMahasiswaStr);
    Mahasiswa mahasiswa = mahasiswaService.getMahasiswa(idMahasiswa);

    String nama = body.get("nama") != null ? (String) body.get("nama") : "";
    String email = body.get("email") != null ? (String) body.get("email") : "";
    String portofolioUrl = body.get("portofolioUrl") != null ? (String) body.get("portofolioUrl") : "";
    String linkedinUrl = body.get("linkediniUrl") != null ? (String) body.get("linkedinUrl") : "";
    String npm = body.get("npm") != null ? (String) body.get("npm") : "";
    int tahunLulus = body.get("tahunLulus") != null ? Integer.parseInt((String) body.get("tahunLulus")) : 0;
    String pekerjaan = body.get("pekerjaan") != null ? (String) body.get("pekerjaan") : "";
    String tempatKerja = body.get("tempatKerja") != null ? (String) body.get("tempatKerja") : "";
    boolean isPublic = body.get("isPublic") != null && Boolean.parseBoolean((String) body.get("isPublic"));

    Observer observer = observerFactory.createObserver("siakreborn.observer.core.ObserverImpl", nama, email);
    Observer observerAlumni = observerFactory.createObserver("siakreborn.observer.alumni.ObserverImpl", observer, mahasiswa, portofolioUrl,
                                linkedinUrl, npm, tahunLulus, pekerjaan, tempatKerja, isPublic);

    observerRepository.saveObject(observer);
    observerRepository.saveObject(observerAlumni);
    return getAllObserver();
  }

  public Observer updateObserver(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String nama = (String) body.get("nama");
    String email = (String) body.get("email");
    String portofolioUrl = (String) body.get("portofolioUrl");
    String linkedinUrl = (String) body.get("linkedinUrl");
    String npm = (String) body.get("npm");
    int tahunLulus = body.get("tahunLulus") != null ? Integer.parseInt((String) body.get("tahunLulus")) : 0;
    String pekerjaan = (String) body.get("pekerjaan");
    String tempatKerja = (String) body.get("tempatKerja");
    String isPublicStr = (String) body.get("isPublic");
    boolean isPublic = Boolean.parseBoolean(isPublicStr);

    Observer savedObserver = observerRepository.getObject(id);
    UUID recordObserverId = (((ObserverDecorator) savedObserver).getRecord()).getId();
    Observer observer = observerFactory.createObserver("siakreborn.observer.core.ObserverImpl", recordObserverId, nama,
        email);
    Observer observerAlumni = observerFactory.createObserver("siakreborn.observer.alumni.ObserverImpl", id, observer, ((ObserverImpl) savedObserver).getMahasiswa(), portofolioUrl,
                                linkedinUrl, npm, tahunLulus, pekerjaan, tempatKerja, isPublic);

    observerRepository.updateObject(observer);
    observerRepository.updateObject(observerAlumni);
    observer = observerRepository.getObject(id);

    return observer;
  }

  public Observer getObserver(UUID id) {
    return record.getObserver(id);
  }

  public Observer getObserverByEmail(String email) {
    List<Observer> observerList = getAllObserver();
    for (Observer observer : observerList) {
      if (observer.getEmail().equals(email)) {
        return observer;
      }
    }
    throw new NotFoundException("alumni tidak ditemukan");
  }

  public List<Observer> getAllObserver() {
    List<Observer> observerList = observerRepository.getAllObject("observer_alumni");
    return observerList;
  }

  public List<Observer> getAllObserverPublic() {
    List<Observer> observerList = observerRepository.getListObject("observer_alumni", "isPublic", true);
    return observerList;
  }

  public List<Observer> deleteObserver(UUID id) {
    observerRepository.deleteObject(id);
    return getAllObserver();
  }

  public Observer verify(HashMap<String, Object> body) {
    String nama = (String) body.get("nama");
		String npm = (String) body.get("npm");
    
    List<Observer> alumniList = getAllObserver();
    Observer result = null;

    for (Observer alumni : alumniList) {
        if (alumni.getNama().equals(nama) && ((ObserverImpl) alumni).getNpm().equals(npm)) {
            result = alumni;
            break;
        }
    }
    return result;
  }

  public List<HashMap<String, Object>> getAllTahunLulus() {
    List<Observer> alumniList = observerRepository.getAllObject("observer_alumni");
    Set<Integer> uniqueTahunLulusSet = new HashSet<>();
    for (Observer alumni : alumniList) {
        uniqueTahunLulusSet.add(((ObserverImpl) alumni).getTahunLulus());
    }

    List<Integer> uniqueTahunLulusList = new ArrayList<>(uniqueTahunLulusSet);
    return transformTahunLulusListToHashMap(uniqueTahunLulusList);
  }

  private List<HashMap<String, Object>> transformTahunLulusListToHashMap(List<Integer> tahunLulusList) {
      List<HashMap<String, Object>> tahunLulusHashMapList = new ArrayList<>();
      
      for (Integer tahunLulus : tahunLulusList) {
          HashMap<String, Object> map = new HashMap<>();
          map.put("name", tahunLulus);
          tahunLulusHashMapList.add(map);
      }

      return tahunLulusHashMapList;
  }

  public HashMap<String, Object> createAkunAlumni(String emailAlumni, String emailMahasiswa) {
    // get object alumni yang terhubung dengan mahasiswa
    Mahasiswa mahasiswa = mahasiswaService.getMahasiswaByEmail(emailMahasiswa);
    List<Observer> alumniList = getAllObserver();
    Observer alumni = null;
    for (Observer observer : alumniList) {
      if (((ObserverImpl) observer).getMahasiswa().getId().equals(mahasiswa.getId())) {
        alumni = observer;
        break;
      }
    }
    ((ObserverImpl) alumni).setEmail(emailAlumni);
    observerRepository.updateObject(alumni);

    createAkun(emailAlumni, alumni.getNama(), "Alumni");

    HashMap<String, Object> akun = new HashMap<>();
    akun.put("nama", alumni.getNama());
    akun.put("email", emailAlumni);
    akun.put("password", "123456");
    return akun;
  }

  private void createAkun(String emailAlumni, String nama, String roleName) {
    UUID authUserId = UUID.randomUUID();
    UUID authRoleId = getAuthRoleByName(roleName);
    UUID authUserRoleId = UUID.randomUUID();

    observerRepository.executeQuery(session -> {
      // insert into auth_user_comp
      session.createNativeQuery("INSERT INTO auth_user_comp (id) VALUES (:id)")
        .setParameter("id", authUserId)
        .executeUpdate();

      // insert into auth_user_impl
      session.createNativeQuery("INSERT INTO auth_user_impl (id,allowedPermissions,name,email) VALUES (:id,:allowedPermissions,:name,:email)")
        .setParameter("id", authUserId)
        .setParameter("allowedPermissions", "")
        .setParameter("name", nama)
        .setParameter("email", emailAlumni)
        .executeUpdate();

      // insert into auth_user_passworded
      session.createNativeQuery("INSERT INTO auth_user_passworded (id,password,user_id) VALUES (:id,:password,:user_id)")
        .setParameter("id", authUserId)
        .setParameter("password", "349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b")
        .setParameter("user_id", authUserId)
        .executeUpdate();

      // insert into auth_user_role_comp
      session.createNativeQuery("INSERT INTO auth_user_role_comp (id) VALUES (:id)")
        .setParameter("id", authUserRoleId)
        .executeUpdate();

      // insert into auth_user_role_impl
      session.createNativeQuery("INSERT INTO auth_user_role_impl (id,authRole,authUser) VALUES (:id,:authRole,:authUser)")
        .setParameter("id", authUserRoleId)
        .setParameter("authRole", authRoleId)
        .setParameter("authUser", authUserId)
        .executeUpdate();
    });
  }

  private UUID getAuthRoleByName(String name) {
    final String[] idHolder = new String[1];
    observerRepository.executeQuery(session -> {
      String sql = "SELECT CAST(ari.id AS VARCHAR) FROM auth_role_impl ari WHERE ari.name = :name";
      Object result = session.createNativeQuery(sql)
                        .setParameter("name", name)
                        .getSingleResult();
      idHolder[0] = (String) result;
    });

    return UUID.fromString(idHolder[0]);
  }

  public HashMap<String, Object> getAkunAlumniCreated(String email) {
    User user = AccountUtils.getUserByEmail(email);
    if (user == null) {
      throw new NotFoundException("Akun alumni tidak ditemukan");
    }
    HashMap<String, Object> akun = new HashMap<>();
    akun.put("nama", user.getName());
    akun.put("email", email);
    akun.put("password", "123456");
    return akun;
  }
}
