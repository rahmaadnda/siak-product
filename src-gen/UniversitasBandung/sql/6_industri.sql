-- Authentication

INSERT INTO auth_role_comp (id) VALUES ('12772338-2822-420d-8c06-cff0d411d776');
INSERT INTO auth_role_comp (id) VALUES ('22772338-2822-420d-8c06-cff0d411d776');
INSERT INTO auth_role_comp (id) VALUES ('32772338-2822-420d-8c06-cff0d411d776');
INSERT INTO auth_role_comp (id) VALUES ('42772338-2822-420d-8c06-cff0d411d776');
INSERT INTO auth_role_impl (id,name,allowedPermissions) VALUES ('12772338-2822-420d-8c06-cff0d411d776','IndustriPlatinum','home,UpdateIndustri,DetailIndustri,ListIndustri,ReadIndustri,SubscriptionRequestIndustri,ReadSubscriptionPlan,ReadSubscription,VerifyMahasiswa,VerifyAlumni,ReadMahasiswaPublic,ReadDetailMahasiswa,ReadAlumniPublic,ReadDetailAlumni,SaveInformasiIndustri,UpdateInformasiIndustri,ReadInformasiIndustri,DeleteInformasiIndustri');
INSERT INTO auth_role_impl (id,name,allowedPermissions) VALUES ('22772338-2822-420d-8c06-cff0d411d776','IndustriGold','home,UpdateIndustri,DetailIndustri,ListIndustri,ReadIndustri,SubscriptionRequestIndustri,ReadSubscriptionPlan,ReadSubscription,VerifyMahasiswa,VerifyAlumni,ReadMahasiswaPublic,ReadDetailMahasiswa,ReadAlumniPublic,ReadDetailAlumni');
INSERT INTO auth_role_impl (id,name,allowedPermissions) VALUES ('32772338-2822-420d-8c06-cff0d411d776','IndustriSilver','home,UpdateIndustri,DetailIndustri,ListIndustri,ReadIndustri,SubscriptionRequestIndustri,,ReadSubscriptionPlan,ReadSubscription,VerifyMahasiswa,VerifyAlumni');
INSERT INTO auth_role_impl (id,name,allowedPermissions) VALUES ('42772338-2822-420d-8c06-cff0d411d776','Industri','home,UpdateIndustri,DetailIndustri,ListIndustri,ReadIndustri,SubscriptionRequestIndustri,ReadSubscriptionPlan,ReadSubscription');

INSERT INTO auth_user_comp (id) VALUES 
	('c693f70a-a83e-4d08-881e-e593752fb6cf'),
	('c703f70a-a83e-4d08-881e-e593752fb6cf'),
	('c713f70a-a83e-4d08-881e-e593752fb6cf'),
	('c723f70a-a83e-4d08-881e-e593752fb6cf'),
	('c733f70a-a83e-4d08-881e-e593752fb6cf'),
	('c743f70a-a83e-4d08-881e-e593752fb6cf'),
	('c753f70a-a83e-4d08-881e-e593752fb6cf'),
	('c763f70a-a83e-4d08-881e-e593752fb6cf'),
	('c773f70a-a83e-4d08-881e-e593752fb6cf'),
	('c783f70a-a83e-4d08-881e-e593752fb6cf');

INSERT INTO auth_user_impl (id, allowedPermissions, name, email) VALUES 
    ('c693f70a-a83e-4d08-881e-e593752fb6cf', '', 'Jane Loe', 'jane@industri.com'),
    ('c703f70a-a83e-4d08-881e-e593752fb6cf', '', 'Bob Smith', 'bob@industri.com'),
    ('c713f70a-a83e-4d08-881e-e593752fb6cf', '', 'Alice Brown', 'alice@industri.com'),
    ('c723f70a-a83e-4d08-881e-e593752fb6cf', '', 'Charlie Lee', 'charlie@industri.com'),
    ('c733f70a-a83e-4d08-881e-e593752fb6cf', '', 'Dave Clark', 'dave@industri.com'),
    ('c743f70a-a83e-4d08-881e-e593752fb6cf', '', 'Emily Davis', 'emily@industri.com'),
    ('c753f70a-a83e-4d08-881e-e593752fb6cf', '', 'Michael King', 'michael@industri.com'),
    ('c763f70a-a83e-4d08-881e-e593752fb6cf', '', 'Peter Johnson', 'peter@industri.com'),
    ('c773f70a-a83e-4d08-881e-e593752fb6cf', '', 'Julia Martinez', 'julia@industri.com'),
    ('c783f70a-a83e-4d08-881e-e593752fb6cf', '', 'Jason Moore', 'jason@industri.com');

INSERT INTO auth_user_passworded (id,password,user_id) VALUES 
	('c693f70a-a83e-4d08-881e-e593752fb6cf','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b','c693f70a-a83e-4d08-881e-e593752fb6cf'),
	('c703f70a-a83e-4d08-881e-e593752fb6cf','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b','c703f70a-a83e-4d08-881e-e593752fb6cf'),
	('c713f70a-a83e-4d08-881e-e593752fb6cf','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b','c713f70a-a83e-4d08-881e-e593752fb6cf'),
	('c723f70a-a83e-4d08-881e-e593752fb6cf','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b','c723f70a-a83e-4d08-881e-e593752fb6cf'),
	('c733f70a-a83e-4d08-881e-e593752fb6cf','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b','c733f70a-a83e-4d08-881e-e593752fb6cf'),
	('c743f70a-a83e-4d08-881e-e593752fb6cf','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b','c743f70a-a83e-4d08-881e-e593752fb6cf'),
	('c753f70a-a83e-4d08-881e-e593752fb6cf','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b','c753f70a-a83e-4d08-881e-e593752fb6cf'),
	('c763f70a-a83e-4d08-881e-e593752fb6cf','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b','c763f70a-a83e-4d08-881e-e593752fb6cf'),
	('c773f70a-a83e-4d08-881e-e593752fb6cf','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b','c773f70a-a83e-4d08-881e-e593752fb6cf'),
	('c783f70a-a83e-4d08-881e-e593752fb6cf','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b','c783f70a-a83e-4d08-881e-e593752fb6cf');

INSERT INTO auth_user_role_comp (id) VALUES 
	('148e7175-1028-4d11-8074-17ecb4536709'),
	('248e7175-1028-4d11-8074-17ecb4536709'),
	('348e7175-1028-4d11-8074-17ecb4536709'),
	('448e7175-1028-4d11-8074-17ecb4536709'),
	('548e7175-1028-4d11-8074-17ecb4536709'),
	('648e7175-1028-4d11-8074-17ecb4536709'),
	('748e7175-1028-4d11-8074-17ecb4536709'),
	('848e7175-1028-4d11-8074-17ecb4536709'),
	('948e7175-1028-4d11-8074-17ecb4536709'),
	('048e7175-1028-4d11-8074-17ecb4536709');

INSERT INTO auth_user_role_impl (id,authRole,authUser) VALUES 
	('148e7175-1028-4d11-8074-17ecb4536709','42772338-2822-420d-8c06-cff0d411d776','c693f70a-a83e-4d08-881e-e593752fb6cf'),
	('248e7175-1028-4d11-8074-17ecb4536709','42772338-2822-420d-8c06-cff0d411d776','c703f70a-a83e-4d08-881e-e593752fb6cf'),
	('348e7175-1028-4d11-8074-17ecb4536709','42772338-2822-420d-8c06-cff0d411d776','c713f70a-a83e-4d08-881e-e593752fb6cf'),
	('448e7175-1028-4d11-8074-17ecb4536709','42772338-2822-420d-8c06-cff0d411d776','c723f70a-a83e-4d08-881e-e593752fb6cf'),
	('548e7175-1028-4d11-8074-17ecb4536709','42772338-2822-420d-8c06-cff0d411d776','c733f70a-a83e-4d08-881e-e593752fb6cf'),
	('648e7175-1028-4d11-8074-17ecb4536709','42772338-2822-420d-8c06-cff0d411d776','c743f70a-a83e-4d08-881e-e593752fb6cf'),
	('748e7175-1028-4d11-8074-17ecb4536709','42772338-2822-420d-8c06-cff0d411d776','c753f70a-a83e-4d08-881e-e593752fb6cf'),
	('848e7175-1028-4d11-8074-17ecb4536709','42772338-2822-420d-8c06-cff0d411d776','c763f70a-a83e-4d08-881e-e593752fb6cf'),
	('948e7175-1028-4d11-8074-17ecb4536709','42772338-2822-420d-8c06-cff0d411d776','c773f70a-a83e-4d08-881e-e593752fb6cf'),
	('048e7175-1028-4d11-8074-17ecb4536709','42772338-2822-420d-8c06-cff0d411d776','c783f70a-a83e-4d08-881e-e593752fb6cf');


-- Data
INSERT INTO subscriptionplan_comp (id, deskripsi, harga, name, objectname) VALUES
    ('8227c3ca-f0af-4541-b3db-c4ba1fdbe399', 
     'Paket Gold: Akses fitur verifikasi mahasiswa dan alumni, serta tambahan akses penuh ke daftar mahasiswa dan alumni.', 
     2000000, 'Gold', 'siakreborn.subscriptionplan.core.SubscriptionPlanImpl'),
    ('9227c3ca-f0af-4541-b3db-c4ba1fdbe399', 
     'Paket Platinum: Akses semua fitur termasuk verifikasi mahasiswa dan alumni, daftar mahasiswa dan alumni, serta tambahan fitur eksklusif untuk memposting informasi.', 
     3000000, 'Platinum', 'siakreborn.subscriptionplan.core.SubscriptionPlanImpl'),
    ('7227c3ca-f0af-4541-b3db-c4ba1fdbe399', 
     'Paket Silver: Akses fitur dasar untuk verifikasi status mahasiswa dan alumni.', 
     1000000, 'Silver', 'siakreborn.subscriptionplan.core.SubscriptionPlanImpl');


INSERT INTO subscriptionplan_impl (id) VALUES
	 ('8227c3ca-f0af-4541-b3db-c4ba1fdbe399'),
	 ('9227c3ca-f0af-4541-b3db-c4ba1fdbe399'),
	 ('7227c3ca-f0af-4541-b3db-c4ba1fdbe399');

INSERT INTO observer_comp (id, email, nama, objectname, modulesequence) VALUES
    ('c693f70a-a83e-4d08-881e-e593752fb6cf', 'jane@industri.com', 'Jane Loe', 'siakreborn.observer.core.ObserverImpl', 'observer_impl, observer_industri'),
    ('419ae769-230f-4ee3-bab5-b30c16254330', 'jane@industri.com', 'Jane Loe', 'siakreborn.observer.industri.ObserverImpl', NULL),
    ('c703f70a-a83e-4d08-881e-e593752fb6cf', 'bob@industri.com', 'Bob Smith', 'siakreborn.observer.core.ObserverImpl', 'observer_impl, observer_industri'),
    ('419ae769-230f-4ee3-bab5-b30c16254331', 'bob@industri.com', 'Bob Smith', 'siakreborn.observer.industri.ObserverImpl', NULL),
    ('c713f70a-a83e-4d08-881e-e593752fb6cf', 'alice@industri.com', 'Alice Brown', 'siakreborn.observer.core.ObserverImpl', 'observer_impl, observer_industri'),
    ('419ae769-230f-4ee3-bab5-b30c16254332', 'alice@industri.com', 'Alice Brown', 'siakreborn.observer.industri.ObserverImpl', NULL),
    ('c723f70a-a83e-4d08-881e-e593752fb6cf', 'charlie@industri.com', 'Charlie Lee', 'siakreborn.observer.core.ObserverImpl', 'observer_impl, observer_industri'),
    ('419ae769-230f-4ee3-bab5-b30c16254333', 'charlie@industri.com', 'Charlie Lee', 'siakreborn.observer.industri.ObserverImpl', NULL),
    ('c733f70a-a83e-4d08-881e-e593752fb6cf', 'dave@industri.com', 'Dave Clark', 'siakreborn.observer.core.ObserverImpl', 'observer_impl, observer_industri'),
    ('419ae769-230f-4ee3-bab5-b30c16254334', 'dave@industri.com', 'Dave Clark', 'siakreborn.observer.industri.ObserverImpl', NULL),
    ('c743f70a-a83e-4d08-881e-e593752fb6cf', 'emily@industri.com', 'Emily Davis', 'siakreborn.observer.core.ObserverImpl', 'observer_impl, observer_industri'),
    ('7f8e9d1c-2b3a-4c5d-8e6f-7a8b9c0d1e25', 'emily@industri.com', 'Emily Davis', 'siakreborn.observer.industri.ObserverImpl', NULL),
    ('c753f70a-a83e-4d08-881e-e593752fb6cf', 'michael@industri.com', 'Michael King', 'siakreborn.observer.core.ObserverImpl', 'observer_impl, observer_industri'),
    ('419ae769-230f-4ee3-bab5-b30c16254336', 'michael@industri.com', 'Michael King', 'siakreborn.observer.industri.ObserverImpl', NULL),
    ('c763f70a-a83e-4d08-881e-e593752fb6cf', 'peter@industri.com', 'Peter Johnson', 'siakreborn.observer.core.ObserverImpl', 'observer_impl, observer_industri'),
    ('419ae769-230f-4ee3-bab5-b30c16254337', 'peter@industri.com', 'Peter Johnson','siakreborn.observer.industri.ObserverImpl', NULL),
    ('c773f70a-a83e-4d08-881e-e593752fb6cf', 'julia@industri.com', 'Julia Martinez', 'siakreborn.observer.core.ObserverImpl', 'observer_impl, observer_industri'),
    ('419ae769-230f-4ee3-bab5-b30c16254338', 'julia@industri.com', 'Julia Martinez','siakreborn.observer.industri.ObserverImpl', NULL),
    ('c783f70a-a83e-4d08-881e-e593752fb6cf', 'jason@industri.com', 'Jason Moore', 'siakreborn.observer.core.ObserverImpl', 'observer_impl, observer_industri'),
    ('419ae769-230f-4ee3-bab5-b30c16254339', 'jason@industri.com', 'Jason Moore', 'siakreborn.observer.industri.ObserverImpl', NULL);

INSERT INTO observer_impl (id) VALUES
    ('c693f70a-a83e-4d08-881e-e593752fb6cf'),
    ('c703f70a-a83e-4d08-881e-e593752fb6cf'),
    ('c713f70a-a83e-4d08-881e-e593752fb6cf'),
    ('c723f70a-a83e-4d08-881e-e593752fb6cf'),
    ('c733f70a-a83e-4d08-881e-e593752fb6cf'),
    ('c743f70a-a83e-4d08-881e-e593752fb6cf'),
    ('c753f70a-a83e-4d08-881e-e593752fb6cf'),
    ('c763f70a-a83e-4d08-881e-e593752fb6cf'),
    ('c773f70a-a83e-4d08-881e-e593752fb6cf'),
    ('c783f70a-a83e-4d08-881e-e593752fb6cf');

INSERT INTO observer_industri (alamat, domain, jumlahkaryawan, tahunberdiri, websiteurl, id, record_id, subscription_id, recordname, base_component_id) VALUES
    ('Jl. Jalin', 'Kesehatan', 200, 2020, 'jane.com', '419ae769-230f-4ee3-bab5-b30c16254330', 'c693f70a-a83e-4d08-881e-e593752fb6cf', NULL,'siakreborn.observer.core.ObserverImpl', 'c693f70a-a83e-4d08-881e-e593752fb6cf'),
    ('Jl. Anggrek', 'Teknologi', 150, 2019, 'bobtech.com', '419ae769-230f-4ee3-bab5-b30c16254331', 'c703f70a-a83e-4d08-881e-e593752fb6cf', NULL,'siakreborn.observer.core.ObserverImpl', 'c703f70a-a83e-4d08-881e-e593752fb6cf'),
    ('Jl. Melati', 'Pendidikan', 300, 2018, 'aliceedu.com', '419ae769-230f-4ee3-bab5-b30c16254332', 'c713f70a-a83e-4d08-881e-e593752fb6cf', NULL,'siakreborn.observer.core.ObserverImpl', 'c713f70a-a83e-4d08-881e-e593752fb6cf'),
    ('Jl. Mawar', 'Transportasi', 500, 2017, 'charlietran.com', '419ae769-230f-4ee3-bab5-b30c16254333', 'c723f70a-a83e-4d08-881e-e593752fb6cf', NULL,'siakreborn.observer.core.ObserverImpl', 'c723f70a-a83e-4d08-881e-e593752fb6cf'),
    ('Jl. Sakura', 'Keuangan', 250, 2021, 'davefinance.com', '419ae769-230f-4ee3-bab5-b30c16254334', 'c733f70a-a83e-4d08-881e-e593752fb6cf', NULL,'siakreborn.observer.core.ObserverImpl', 'c733f70a-a83e-4d08-881e-e593752fb6cf'),
    ('Jl. Cemara', 'Agrikultur', 180, 2022, 'emilyagri.com', '7f8e9d1c-2b3a-4c5d-8e6f-7a8b9c0d1e25', 'c743f70a-a83e-4d08-881e-e593752fb6cf', NULL,'siakreborn.observer.core.ObserverImpl', 'c743f70a-a83e-4d08-881e-e593752fb6cf'),
    ('Jl. Kenanga', 'E-commerce', 400, 2016, 'michaelstore.com', '419ae769-230f-4ee3-bab5-b30c16254336', 'c753f70a-a83e-4d08-881e-e593752fb6cf', NULL,'siakreborn.observer.core.ObserverImpl', 'c753f70a-a83e-4d08-881e-e593752fb6cf'),
    ('Jl. Dahlia', 'Manufaktur', 600, 2015, 'peterfact.com', '419ae769-230f-4ee3-bab5-b30c16254337', 'c763f70a-a83e-4d08-881e-e593752fb6cf', NULL,'siakreborn.observer.core.ObserverImpl', 'c763f70a-a83e-4d08-881e-e593752fb6cf'),
    ('Jl. Pucuk', 'Properti', 220, 2023, 'juliaprop.com', '419ae769-230f-4ee3-bab5-b30c16254338', 'c773f70a-a83e-4d08-881e-e593752fb6cf', NULL,'siakreborn.observer.core.ObserverImpl', 'c773f70a-a83e-4d08-881e-e593752fb6cf'),
    ('Jl. Akasia', 'Pariwisata', 500, 2021, 'jasontour.com', '419ae769-230f-4ee3-bab5-b30c16254339', 'c783f70a-a83e-4d08-881e-e593752fb6cf', NULL,'siakreborn.observer.core.ObserverImpl', 'c783f70a-a83e-4d08-881e-e593752fb6cf');

INSERT INTO informasi_comp (id,deskripsi,judul,objectname,tanggalpublikasi,modulesequence) VALUES
	 ('4e7679c1-cdf1-414f-a3d8-68d951859851','PT Maju Bersama sedang mencari mitra kerja sama dalam bidang teknologi informasi untuk pengembangan aplikasi berbasis cloud. Alumni atau perusahaan terkait dapat menghubungi email: kerjasama@example.com sebelum 15 Januari 2025.','Kerja Sama Teknologi Informasi dengan PT Maju Bersama','siakreborn.informasi.industri.InformasiImpl','2024-12-23 11:56:39.099',NULL),
	 ('21720f0c-9d0a-40ad-8a65-439226b152d1','PT Maju Bersama sedang mencari mitra kerja sama dalam bidang teknologi informasi untuk pengembangan aplikasi berbasis cloud. Alumni atau perusahaan terkait dapat menghubungi email: kerjasama@example.com sebelum 15 Januari 2025.','Kerja Sama Teknologi Informasi dengan PT Maju Bersama','siakreborn.informasi.core.InformasiImpl','2024-12-23 11:56:39.099','informasi_impl, informasi_industri');

INSERT INTO informasi_comp (id,deskripsi,judul,objectname,tanggalpublikasi,modulesequence) VALUES
	 ('4e7679c1-cdf1-414f-a3d8-68d951859852','Industri kreatif Indonesia mengalami peningkatan 20% pada tahun 2024. Mahasiswa dan alumni diundang untuk bergabung dalam seminar "Inovasi di Era Digital" yang diselenggarakan oleh Kemenparekraf pada 10 Maret 2025. Informasi pendaftaran tersedia di seminar.digital.id.','Seminar Inovasi di Era Digital','siakreborn.informasi.industri.InformasiImpl','2024-12-23 11:56:39.099',NULL),
	 ('21720f0c-9d0a-40ad-8a65-439226b152d2','Industri kreatif Indonesia mengalami peningkatan 20% pada tahun 2024. Mahasiswa dan alumni diundang untuk bergabung dalam seminar "Inovasi di Era Digital" yang diselenggarakan oleh Kemenparekraf pada 10 Maret 2025. Informasi pendaftaran tersedia di seminar.digital.id.','Seminar Inovasi di Era Digital','siakreborn.informasi.core.InformasiImpl','2024-12-23 11:56:39.099','informasi_impl, informasi_industri');

INSERT INTO informasi_comp (id,deskripsi,judul,objectname,tanggalpublikasi,modulesequence) VALUES
	 ('4e7679c1-cdf1-414f-a3d8-68d951859853','PT Global Sukses mengundang mahasiswa dan alumni untuk bergabung dalam webinar "Tren Teknologi Masa Depan". Webinar ini akan dilaksanakan secara daring pada 20 Februari 2025. Daftar segera melalui website globalsukses.com/webinar.','Webinar Tren Teknologi Masa Depan','siakreborn.informasi.industri.InformasiImpl','2024-12-23 11:56:39.099',NULL),
	 ('21720f0c-9d0a-40ad-8a65-439226b152d3','PT Global Sukses mengundang mahasiswa dan alumni untuk bergabung dalam webinar "Tren Teknologi Masa Depan". Webinar ini akan dilaksanakan secara daring pada 20 Februari 2025. Daftar segera melalui website globalsukses.com/webinar.','Webinar Tren Teknologi Masa Depan','siakreborn.informasi.core.InformasiImpl','2024-12-23 11:56:39.099','informasi_impl, informasi_industri');

INSERT INTO informasi_impl (id) VALUES
     ('21720f0c-9d0a-40ad-8a65-439226b152d1'),
     ('21720f0c-9d0a-40ad-8a65-439226b152d2'),
     ('21720f0c-9d0a-40ad-8a65-439226b152d3');

INSERT INTO informasi_industri (id,record_id,industri_id,recordname,base_component_id) VALUES
	 ('4e7679c1-cdf1-414f-a3d8-68d951859851','21720f0c-9d0a-40ad-8a65-439226b152d1','419ae769-230f-4ee3-bab5-b30c16254330','siakreborn.informasi.core.InformasiImpl','21720f0c-9d0a-40ad-8a65-439226b152d1');

INSERT INTO informasi_industri (id,record_id,industri_id,recordname,base_component_id) VALUES
	 ('4e7679c1-cdf1-414f-a3d8-68d951859852','21720f0c-9d0a-40ad-8a65-439226b152d2','419ae769-230f-4ee3-bab5-b30c16254330','siakreborn.informasi.core.InformasiImpl','21720f0c-9d0a-40ad-8a65-439226b152d2');

INSERT INTO informasi_industri (id,record_id,industri_id,recordname,base_component_id) VALUES
	 ('4e7679c1-cdf1-414f-a3d8-68d951859853','21720f0c-9d0a-40ad-8a65-439226b152d3','419ae769-230f-4ee3-bab5-b30c16254330','siakreborn.informasi.core.InformasiImpl','21720f0c-9d0a-40ad-8a65-439226b152d3');
