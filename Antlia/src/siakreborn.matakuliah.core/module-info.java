module siakreborn.matakuliah.core {
  requires siakreborn.util.core;
  requires siakreborn.kurikulum.core;

  exports siakreborn.matakuliah;
  exports siakreborn.matakuliah.core;

  requires vmj.routing.route;
  requires vmj.hibernate.integrator;
  requires vmj.auth;
  requires java.logging;
  // https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
  requires java.naming;

  opens siakreborn.matakuliah.core to org.hibernate.orm.core, gson, vmj.hibernate.integrator;
}
