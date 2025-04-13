package siakreborn.adminakademik.core;

import java.util.*;

public interface AdminAkademikService {
  List<AdminAkademik> saveAdminAkademik(HashMap<String, Object> body);

  AdminAkademik updateAdminAkademik(HashMap<String, Object> body);

  AdminAkademik getAdminAkademik(UUID id);

  AdminAkademik getAdminAkademikByEmail(String email);

  List<AdminAkademik> getAllAdminAkademik();

  List<AdminAkademik> deleteAdminAkademik(UUID id);

  List<HashMap<String, Object>> transformAdminAkademikListToHashMap(List<AdminAkademik> adminAkademikList);
}
