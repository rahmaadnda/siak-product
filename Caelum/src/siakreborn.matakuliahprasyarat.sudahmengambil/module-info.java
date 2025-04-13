module siakreborn.matakuliahprasyarat.sudahmengambil {
	requires siakreborn.matakuliahprasyarat.core;

    exports siakreborn.matakuliahprasyarat.sudahmengambil;

	requires vmj.routing.route;
	requires vmj.hibernate.integrator;
	requires java.logging;
	// https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
	requires java.naming;

	opens siakreborn.matakuliahprasyarat.sudahmengambil to org.hibernate.orm.core, gson, vmj.hibernate.integrator;
}
