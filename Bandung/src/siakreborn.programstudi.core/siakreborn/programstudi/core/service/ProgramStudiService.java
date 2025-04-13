package siakreborn.programstudi.core;

import java.util.*;

public interface ProgramStudiService {
  List<ProgramStudi> saveProgramStudi(HashMap<String, Object> body);

  ProgramStudi updateProgramStudi(HashMap<String, Object> body);

  ProgramStudi getProgramStudi(UUID id);

  List<ProgramStudi> getAllProgramStudi();

  List<ProgramStudi> deleteProgramStudi(UUID id);

  List<HashMap<String, Object>> transformProgramStudiListToHashMap(List<ProgramStudi> programStudiList);
}
