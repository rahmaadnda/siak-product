module siakreborn.product.universitascaelum {
    requires vmj.auth.model;
    requires vmj.routing.route;
    requires vmj.hibernate.integrator;
    
    requires net.bytebuddy;
    requires java.xml.bind;
    requires com.sun.xml.bind;
    requires com.fasterxml.classmate;
    requires jdk.unsupported;

    requires paymentgateway.config.core;
    requires paymentgateway.config.midtrans;
    requires paymentgateway.config.oy;
    requires paymentgateway.payment.core;
    requires paymentgateway.payment.paymentlink;
    requires siakreborn.util.core;
    requires siakreborn.programstudi.core;
    requires siakreborn.mahasiswa.core;
    requires siakreborn.adminakademik.core;
    requires siakreborn.observer.core;
    requires siakreborn.observer.alumni;
    requires siakreborn.mahasiswa.mappingalumni;
    requires siakreborn.subscriptionplan.core;
    requires siakreborn.subscription.core;
    requires siakreborn.observer.industri;
    requires siakreborn.informasi.core;
    requires siakreborn.informasi.akademik;
    requires siakreborn.informasi.alumni;
    requires siakreborn.informasi.industri;
    requires siakreborn.dosen.core;
    requires siakreborn.kurikulum.core;
    requires siakreborn.semester.core;
    requires siakreborn.kurikulumsemester.core;
    requires siakreborn.matakuliah.core;
    requires siakreborn.kelas.core;
    requires siakreborn.kelasdosen.core;
    requires siakreborn.komponenpenilaian.core;
    requires siakreborn.penilaian.core;
    requires siakreborn.pembayaran.core;
    requires siakreborn.penilaian.penilaianobe;
    requires siakreborn.capaian.core;
    requires siakreborn.bobotkomponenpenilaian.core;
    requires siakreborn.capaian.cpl;
    requires siakreborn.capaian.cpmk;
    requires siakreborn.capaian.subcpmk;
    requires siakreborn.rencanastudi.core;
    requires siakreborn.rencanastudi.precheckpembayaran;
    requires siakreborn.matakuliahprasyarat.core;
    requires siakreborn.matakuliahprasyarat.sudahmengambil;

}