module siakreborn.observer.alumni {
  requires siakreborn.util.core;
  requires siakreborn.observer.core;
  requires siakreborn.mahasiswa.core;

  exports siakreborn.observer.alumni;

  requires vmj.routing.route;
  requires vmj.hibernate.integrator;
  requires vmj.auth;
  requires vmj.auth.model;
  requires java.logging;
  // https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
  requires java.naming;

  opens siakreborn.observer.alumni to org.hibernate.orm.core, gson;
}
