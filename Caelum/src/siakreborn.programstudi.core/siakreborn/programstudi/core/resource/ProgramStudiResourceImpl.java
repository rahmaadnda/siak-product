package siakreborn.programstudi.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.programstudi.ProgramStudiFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class ProgramStudiResourceImpl extends ProgramStudiResourceComponent {
  private ProgramStudiFactory programStudiFactory = new ProgramStudiFactory();
  private ProgramStudiService programStudiService = new ProgramStudiServiceImpl();

  @Restricted(permissionName = "CreateProgramStudi")
  @Route(url = "call/programstudi/save")
  public List<HashMap<String, Object>> saveProgramStudi(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    List<ProgramStudi> programStudiList = programStudiService
        .saveProgramStudi((HashMap<String, Object>) vmjExchange.getPayload());
    return programStudiService.transformProgramStudiListToHashMap(programStudiList);
  }

  @Restricted(permissionName = "UpdateProgramStudi")
  @Route(url = "call/programstudi/update")
  public HashMap<String, Object> updateProgramStudi(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    ProgramStudi programStudi = programStudiService
        .updateProgramStudi((HashMap<String, Object>) vmjExchange.getPayload());
    return programStudi.toHashMap();
  }

  @Restricted(permissionName = "ReadProgramStudi")
  @Route(url = "call/programstudi/detail")
  public HashMap<String, Object> getProgramStudi(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    ProgramStudi programStudi = programStudiService.getProgramStudi(id);
    return programStudi.toHashMap();
  }

  @Restricted(permissionName = "ReadProgramStudi")
  @Route(url = "call/programstudi/list")
  public List<HashMap<String, Object>> getAllProgramStudi(VMJExchange vmjExchange) {
    List<ProgramStudi> programStudiList = programStudiService.getAllProgramStudi();
    return programStudiService.transformProgramStudiListToHashMap(programStudiList);
  }

  @Restricted(permissionName = "DeleteProgramStudi")
  @Route(url = "call/programstudi/delete")
  public List<HashMap<String, Object>> deleteProgramStudi(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<ProgramStudi> programStudiList = programStudiService.deleteProgramStudi(id);
    return programStudiService.transformProgramStudiListToHashMap(programStudiList);
  }

}
