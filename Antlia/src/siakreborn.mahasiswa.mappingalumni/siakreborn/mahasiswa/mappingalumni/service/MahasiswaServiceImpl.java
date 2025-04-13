package siakreborn.mahasiswa.mappingalumni;

import java.util.*;

import siakreborn.mahasiswa.MahasiswaFactory;
import siakreborn.mahasiswa.core.MahasiswaServiceDecorator;
import siakreborn.mahasiswa.core.MahasiswaServiceComponent;
import siakreborn.mahasiswa.core.Mahasiswa;
import siakreborn.mahasiswa.core.MahasiswaImpl;

import siakreborn.observer.core.ObserverService;
import siakreborn.observer.alumni.ObserverServiceImpl;
import siakreborn.observer.ObserverServiceFactory;

import vmj.routing.route.exceptions.NotFoundException;
import vmj.auth.model.core.*;
import vmj.auth.model.utils.*;

public class MahasiswaServiceImpl extends MahasiswaServiceDecorator {
  private MahasiswaFactory mahasiswaFactory = new MahasiswaFactory();
  private ObserverService observerService;

  public MahasiswaServiceImpl(MahasiswaServiceComponent record) {
    super(record);
    this.observerService = ObserverServiceFactory.createObserverService(
      "siakreborn.observer.alumni.ObserverServiceImpl",
      ObserverServiceFactory.createObserverService(
        "siakreborn.observer.core.ObserverServiceImpl"
    ));
  }

  public List<Mahasiswa> saveMahasiswa(HashMap<String, Object> body) {
    String nama = (String) body.get("nama");
    String npm = (String) body.get("npm");
    String tahunAngkatanStr = (String) body.get("tahunAngkatan");
	  int tahunAngkatan = Integer.parseInt(tahunAngkatanStr);
    String email = (String) body.get("email");
    String statusAkademik = (String) body.get("statusAkademik");

    Mahasiswa mahasiswa = mahasiswaFactory.createMahasiswa("siakreborn.mahasiswa.core.MahasiswaImpl", nama, npm, tahunAngkatan, email, statusAkademik);

    mahasiswaRepository.saveObject(mahasiswa);
    return getAllMahasiswa();
  }

  public Mahasiswa updateMahasiswa(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String nama = (String) body.get("nama");
    String npm = (String) body.get("npm");
    String tahunAngkatanStr = (String) body.get("tahunAngkatan");
	  int tahunAngkatan = Integer.parseInt(tahunAngkatanStr);
    String email = (String) body.get("email");
    String statusAkademik = (String) body.get("statusAkademik");
    String isPublicStr = (String) body.get("isPublic");
    boolean isPublic = Boolean.parseBoolean(isPublicStr);

    Mahasiswa mahasiswa = mahasiswaRepository.getObject(id);
    mahasiswa.setNama(nama);
    mahasiswa.setNpm(npm);
    mahasiswa.setEmail(email);
    mahasiswa.setTahunAngkatan(tahunAngkatan);
    mahasiswa.setStatusAkademik(statusAkademik);
    mahasiswa.setIsPublic(isPublic);

    mahasiswaRepository.updateObject(mahasiswa);
    mahasiswa = mahasiswaRepository.getObject(id);

    return mahasiswa;
  }

  public Mahasiswa getMahasiswa(UUID id) {
    Mahasiswa mahasiswa = mahasiswaRepository.getObject(id);
    return mahasiswa;
  }

  public Mahasiswa getMahasiswaByEmail(String email) {
    try {
      Mahasiswa mahasiswa = mahasiswaRepository.getListObject("mahasiswa_comp", "email", email).get(0);
      return mahasiswa;
    } catch (Exception e) {
      throw new NotFoundException("mahasiswa tidak ditemukan");
    }
  }

  public List<Mahasiswa> getAllMahasiswa() {
    List<Mahasiswa> mahasiswaList = mahasiswaRepository.getAllObject("mahasiswa_impl", MahasiswaImpl.class.getName());
    return mahasiswaList;
  }

  public List<Mahasiswa> getAllMahasiswaPublic() {
    List<Mahasiswa> mahasiswaList = mahasiswaRepository.getListObject("mahasiswa_impl", "isPublic", true);
    return mahasiswaList;
  }

  public List<Mahasiswa> getNotGraduated() {
    List<Mahasiswa> mahasiswaList = mahasiswaRepository.getListObject("mahasiswa_impl", "statusAkademik", "Aktif");
    return mahasiswaList;
  }

  public List<Mahasiswa> deleteMahasiswa(UUID id) {
    mahasiswaRepository.deleteObject(id);
    return getAllMahasiswa();
  }

  public List<HashMap<String, Object>> transformMahasiswaListToHashMap(List<Mahasiswa> mahasiswaList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < mahasiswaList.size(); i++) {
      resultList.add(mahasiswaList.get(i).toHashMap());
    }

    return resultList;
  }

  public Mahasiswa verify(HashMap<String, Object> body) {
    String nama = (String) body.get("nama");
		String npm = (String) body.get("npm");
    
    List<Mahasiswa> mahasiswaList = mahasiswaRepository.getAllObject("mahasiswa_impl", MahasiswaImpl.class.getName());
    Mahasiswa result = null;

    for (Mahasiswa mahasiswa : mahasiswaList) {
        if (mahasiswa.getNama().equals(nama) && mahasiswa.getNpm().equals(npm)) {
            result = mahasiswa;
            break;
        }
    }
    return result;
  }

  public List<HashMap<String, Object>> getAllAngkatan() {
      List<Mahasiswa> mahasiswaList = mahasiswaRepository.getAllObject("mahasiswa_impl");
      Set<Integer> uniqueTahunAngkatanSet = new HashSet<>();
      for (Mahasiswa mahasiswa : mahasiswaList) {
          uniqueTahunAngkatanSet.add(mahasiswa.getTahunAngkatan());
      }

      List<Integer> uniqueTahunAngkatanList = new ArrayList<>(uniqueTahunAngkatanSet);
      return transformTahunAngkatanListToHashMap(uniqueTahunAngkatanList);
  }

  private List<HashMap<String, Object>> transformTahunAngkatanListToHashMap(List<Integer> tahunAngkatanList) {
      List<HashMap<String, Object>> result = new ArrayList<>();
      for (Integer tahun : tahunAngkatanList) {
          HashMap<String, Object> map = new HashMap<>();
          map.put("name", tahun);
          result.add(map);
      }
      return result;
  }

  public Mahasiswa graduate(UUID id) {
    Mahasiswa mahasiswa = mahasiswaRepository.getObject(id);
    mahasiswa.setStatusAkademik("Lulus");

    mahasiswaRepository.updateObject(mahasiswa);
    mahasiswa = mahasiswaRepository.getObject(id);

    HashMap<String, Object> body = new HashMap<>();
    body.put("idMahasiswa", mahasiswa.getId().toString());
    body.put("nama", mahasiswa.getNama());
    body.put("npm", mahasiswa.getNpm());
    
    int tahunLulus = Calendar.getInstance().get(Calendar.YEAR);
    body.put("tahunLulus", Integer.toString(tahunLulus));

    ((ObserverServiceImpl) observerService).saveObserver(body);

    User user = changeRole(mahasiswa.getEmail(), "MahasiswaAlumni");

    return mahasiswa;
  }

  private User changeRole(String email, String roleName) {
    UUID roleId = getAuthRoleByName(roleName);
    UUID userId = AccountUtils.getUserByEmail(email).getId();

    mahasiswaRepository.executeQuery(session -> {
      String sql = String.format("UPDATE auth_user_role_impl SET authrole = '%s' WHERE authuser = '%s'", roleId, userId);
      session.createNativeQuery(sql).executeUpdate();
    });

    return AccountUtils.getUserById(userId);
  }
  
  private UUID getAuthRoleByName(String name) {
    final String[] idHolder = new String[1];
    mahasiswaRepository.executeQuery(session -> {
      String sql = "SELECT CAST(ari.id AS VARCHAR) FROM auth_role_impl ari WHERE ari.name = :name";
      Object result = session.createNativeQuery(sql)
                        .setParameter("name", name)
                        .getSingleResult();
      idHolder[0] = (String) result;
    });

    return UUID.fromString(idHolder[0]);
  }
}
