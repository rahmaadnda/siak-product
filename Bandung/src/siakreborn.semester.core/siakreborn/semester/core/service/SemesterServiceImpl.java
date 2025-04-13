package siakreborn.semester.core;

import java.util.*;

import siakreborn.semester.SemesterFactory;

public class SemesterServiceImpl extends SemesterServiceComponent {
  private SemesterFactory semesterFactory = new SemesterFactory();

  public List<Semester> saveSemester(HashMap<String, Object> body) {
    String kode = (String) body.get("kode");
    String status = (String) body.get("status");
    String tanggalMulai = (String) body.get("tanggalMulai");
    String tanggalSelesai = (String) body.get("tanggalSelesai");
    String deskripsi = (String) body.get("deskripsi");
    String idStr = (String) body.get("id");

    Semester semester;
    if (idStr != null) {
      UUID id = UUID.fromString(idStr);
      semester = semesterFactory.createSemester("siakreborn.semester.core.SemesterImpl", id, kode, status,
          tanggalMulai, tanggalSelesai, deskripsi);
    } else {
      semester = semesterFactory.createSemester("siakreborn.semester.core.SemesterImpl", kode, status,
          tanggalMulai, tanggalSelesai, deskripsi);
    }

    semesterRepository.saveObject(semester);
    return getAllSemester();
  }

  public Semester updateSemester(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String kode = (String) body.get("kode");
    String status = (String) body.get("status");
    String tanggalMulai = (String) body.get("tanggalMulai");
    String tanggalSelesai = (String) body.get("tanggalSelesai");
    String deskripsi = (String) body.get("deskripsi");

    Semester semester = semesterRepository.getObject(id);
    semester.setKode(kode);
    semester.setStatus(status);
    semester.setTanggalMulai(tanggalMulai);
    semester.setTanggalSelesai(tanggalSelesai);
    semester.setDeskripsi(deskripsi);

    semesterRepository.updateObject(semester);
    semester = semesterRepository.getObject(id);

    return semester;
  }

  public Semester getSemester(UUID id) {
    Semester semester = semesterRepository.getObject(id);
    return semester;
  }

  public Semester getActiveSemester() {
    List<Semester> semesterList = semesterRepository.getListObject("semester_comp", "status", "Aktif");

    if (semesterList.size() == 0)
      return null;

    return semesterList.get(0);
  }

  public List<Semester> getAllSemester() {
    List<Semester> semesterList = semesterRepository.getAllObject("semester_impl", SemesterImpl.class.getName());
    return semesterList;
  }

  public List<Semester> deleteSemester(UUID id) {
    semesterRepository.deleteObject(id);
    return getAllSemester();
  }

  public List<HashMap<String, Object>> transformSemesterListToHashMap(List<Semester> semesterList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < semesterList.size(); i++) {
      resultList.add(semesterList.get(i).toHashMap());
    }

    return resultList;
  }
}
