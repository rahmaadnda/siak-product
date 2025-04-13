package siakreborn.programstudi.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;

public abstract class ProgramStudiServiceComponent implements ProgramStudiService {
  protected RepositoryUtil<ProgramStudi> programStudiRepository;

  public ProgramStudiServiceComponent() {
    this.programStudiRepository = new RepositoryUtil<ProgramStudi>(
        siakreborn.programstudi.core.ProgramStudiComponent.class);
  }

  public abstract List<ProgramStudi> saveProgramStudi(HashMap<String, Object> body);

  public abstract ProgramStudi updateProgramStudi(HashMap<String, Object> body);

  public abstract ProgramStudi getProgramStudi(UUID id);

  public abstract List<ProgramStudi> getAllProgramStudi();

  public abstract List<ProgramStudi> deleteProgramStudi(UUID id);

  public abstract List<HashMap<String, Object>> transformProgramStudiListToHashMap(List<ProgramStudi> programStudiList);
}
