module siakreborn.capaian.cpl {
  requires siakreborn.kurikulum.core;
  requires siakreborn.capaian.core;
  requires siakreborn.util.core;

  exports siakreborn.capaian.cpl;

  requires vmj.routing.route;
  requires vmj.hibernate.integrator;
  requires vmj.auth;
  requires java.logging;
  // https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
  requires java.naming;

  opens siakreborn.capaian.cpl to org.hibernate.orm.core, gson;
}
