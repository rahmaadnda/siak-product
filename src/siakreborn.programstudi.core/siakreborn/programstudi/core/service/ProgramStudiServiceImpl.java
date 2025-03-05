package siakreborn.programstudi.core;

import java.util.*;

import siakreborn.programstudi.ProgramStudiFactory;

public class ProgramStudiServiceImpl extends ProgramStudiServiceComponent {
  private ProgramStudiFactory programStudiFactory = new ProgramStudiFactory();

  public List<ProgramStudi> saveProgramStudi(HashMap<String, Object> body) {
    String kode = (String) body.get("kode");
    String noSK = (String) body.get("noSK");
    String nama = (String) body.get("nama");
    String kaprodi = (String) body.get("kaprodi");
    String jenjang = (String) body.get("jenjang");

    ProgramStudi programStudi = programStudiFactory.createProgramStudi("siakreborn.programstudi.core.ProgramStudiImpl",
        kode, noSK, nama, kaprodi, jenjang);
    programStudiRepository.saveObject(programStudi);

    return getAllProgramStudi();
  }

  public ProgramStudi updateProgramStudi(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String kode = (String) body.get("kode");
    String noSK = (String) body.get("noSK");
    String nama = (String) body.get("nama");
    String kaprodi = (String) body.get("kaprodi");
    String jenjang = (String) body.get("jenjang");

    ProgramStudi programStudi = programStudiRepository.getObject(id);
    programStudi.setKode(kode);
    programStudi.setNoSK(noSK);
    programStudi.setNama(nama);
    programStudi.setKaprodi(kaprodi);
    programStudi.setJenjang(jenjang);

    programStudiRepository.updateObject(programStudi);
    programStudi = programStudiRepository.getObject(id);

    return programStudi;
  }

  public ProgramStudi getProgramStudi(UUID id) {
    ProgramStudi programStudi = programStudiRepository.getObject(id);
    return programStudi;
  }

  public List<ProgramStudi> getAllProgramStudi() {
    List<ProgramStudi> programStudiList = programStudiRepository.getAllObject("program_studi_impl",
        ProgramStudiImpl.class.getName());
    return programStudiList;
  }

  public List<ProgramStudi> deleteProgramStudi(UUID id) {
    programStudiRepository.deleteObject(id);
    return getAllProgramStudi();
  }

  public List<HashMap<String, Object>> transformProgramStudiListToHashMap(List<ProgramStudi> programStudiList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < programStudiList.size(); i++) {
      resultList.add(programStudiList.get(i).toHashMap());
    }

    return resultList;
  }
}
