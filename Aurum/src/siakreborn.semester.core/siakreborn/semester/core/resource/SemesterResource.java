package siakreborn.semester.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface SemesterResource {
    List<HashMap<String,Object>> saveSemester(VMJExchange vmjExchange);
    HashMap<String, Object> updateSemester(VMJExchange vmjExchange);
    HashMap<String, Object> getSemester(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllSemester(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteSemester(VMJExchange vmjExchange);
}
