module siakreborn.capaian.cpmk {
  requires siakreborn.util.core;
  requires siakreborn.matakuliah.core;
  requires siakreborn.capaian.core;

  exports siakreborn.capaian.cpmk;

  requires vmj.routing.route;
  requires vmj.hibernate.integrator;
  requires vmj.auth;
  requires java.logging;
  // https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
  requires java.naming;

  opens siakreborn.capaian.cpmk to org.hibernate.orm.core, gson, vmj.hibernate.integrator;
}
