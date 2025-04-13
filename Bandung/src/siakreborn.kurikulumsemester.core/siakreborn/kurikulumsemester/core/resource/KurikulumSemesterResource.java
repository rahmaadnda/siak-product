package siakreborn.kurikulumsemester.core;

import java.util.*;

import vmj.routing.route.VMJExchange;

public interface KurikulumSemesterResource {
  List<HashMap<String, Object>> saveKurikulumSemester(VMJExchange vmjExchange);

  List<HashMap<String, Object>> saveSemester(VMJExchange vmjExchange);

  HashMap<String, Object> updateKurikulumSemester(VMJExchange vmjExchange);

  HashMap<String, Object> getKurikulumSemester(VMJExchange vmjExchange);

  List<HashMap<String, Object>> getAllKurikulumSemester(VMJExchange vmjExchange);

  List<HashMap<String, Object>> deleteKurikulumSemester(VMJExchange vmjExchange);
}
