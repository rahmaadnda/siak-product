package siakreborn.programstudi.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class ProgramStudiResourceDecorator extends ProgramStudiResourceComponent {
  protected ProgramStudiResourceComponent record;

  public ProgramStudiResourceDecorator(ProgramStudiResourceComponent record) {
    this.record = record;
  }

  public List<HashMap<String, Object>> saveProgramStudi(VMJExchange vmjExchange) {
    return record.saveProgramStudi(vmjExchange);
  }

  public HashMap<String, Object> updateProgramStudi(VMJExchange vmjExchange) {
    return record.updateProgramStudi(vmjExchange);
  }

  public HashMap<String, Object> getProgramStudi(VMJExchange vmjExchange) {
    return record.getProgramStudi(vmjExchange);
  }

  public List<HashMap<String, Object>> getAllProgramStudi(VMJExchange vmjExchange) {
    return record.getAllProgramStudi(vmjExchange);
  }

  public List<HashMap<String, Object>> deleteProgramStudi(VMJExchange vmjExchange) {
    return record.deleteProgramStudi(vmjExchange);
  }

}
