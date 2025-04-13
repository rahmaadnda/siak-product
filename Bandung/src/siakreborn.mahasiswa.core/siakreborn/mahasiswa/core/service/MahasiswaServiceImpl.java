package siakreborn.mahasiswa.core;

import java.util.*;

import siakreborn.mahasiswa.MahasiswaFactory;
import siakreborn.programstudi.core.ProgramStudi;

import vmj.routing.route.exceptions.NotFoundException;

public class MahasiswaServiceImpl extends MahasiswaServiceComponent {
  private MahasiswaFactory mahasiswaFactory = new MahasiswaFactory();

  public List<Mahasiswa> saveMahasiswa(HashMap<String, Object> body) {
    String nama = (String) body.get("nama");
    String npm = (String) body.get("npm");
    String tahunAngkatanStr = (String) body.get("tahunAngkatan");
	  int tahunAngkatan = Integer.parseInt(tahunAngkatanStr);
    String email = (String) body.get("email");
    String statusAkademik = (String) body.get("statusAkademik");
    String programStudiIdStr = (String) body.get("programStudiId");

    ProgramStudi programStudi = null;
    if (programStudiIdStr != null) {
      UUID programStudiId = UUID.fromString(programStudiIdStr);
      programStudi = mahasiswaRepository.getProxyObject(siakreborn.programstudi.core.ProgramStudiComponent.class,
          programStudiId);
    }

    Mahasiswa mahasiswa = mahasiswaFactory.createMahasiswa("siakreborn.mahasiswa.core.MahasiswaImpl", nama, npm, tahunAngkatan, email, programStudi, statusAkademik);

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
    String programStudiIdStr = (String) body.get("programStudiId");
    String statusAkademik = (String) body.get("statusAkademik");
    String isPublicStr = (String) body.get("isPublic");
    boolean isPublic = Boolean.parseBoolean(isPublicStr);

    Mahasiswa mahasiswa = mahasiswaRepository.getObject(id);

    ProgramStudi programStudi = mahasiswa.getProgramStudi();
    if (programStudiIdStr != null) {
      UUID programStudiId = UUID.fromString(programStudiIdStr);
      programStudi = mahasiswaRepository.getProxyObject(siakreborn.programstudi.core.ProgramStudiComponent.class,
          programStudiId);
    }

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
    return mahasiswa;
  }
}
