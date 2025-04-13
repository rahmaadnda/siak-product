package siakreborn.programstudi.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ProgramStudiResource {
    List<HashMap<String,Object>> saveProgramStudi(VMJExchange vmjExchange);
    HashMap<String, Object> updateProgramStudi(VMJExchange vmjExchange);
    HashMap<String, Object> getProgramStudi(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllProgramStudi(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteProgramStudi(VMJExchange vmjExchange);
}
