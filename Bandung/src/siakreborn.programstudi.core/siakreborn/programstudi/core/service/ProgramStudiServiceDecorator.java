package siakreborn.programstudi.core;

import java.util.*;

public abstract class ProgramStudiServiceDecorator extends ProgramStudiServiceComponent {
  protected ProgramStudiServiceComponent record;

  public ProgramStudiServiceDecorator(ProgramStudiServiceComponent record) {
    this.record = record;
  }

  public List<ProgramStudi> saveProgramStudi(HashMap<String, Object> body) {
    return record.saveProgramStudi(body);
  }

  public ProgramStudi updateProgramStudi(HashMap<String, Object> body) {
    return record.updateProgramStudi(body);
  }

  public ProgramStudi getProgramStudi(UUID id) {
    return record.getProgramStudi(id);
  }

  public List<ProgramStudi> getAllProgramStudi() {
    return record.getAllProgramStudi();
  }

  public List<ProgramStudi> deleteProgramStudi(UUID id) {
    return record.deleteProgramStudi(id);
  }

  public List<HashMap<String, Object>> transformProgramStudiListToHashMap(List<ProgramStudi> programStudiList) {
    return record.transformProgramStudiListToHashMap(programStudiList);
  }
}
