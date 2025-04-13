-- Authentication
INSERT INTO auth_role_comp (id) VALUES ('12572338-2822-420d-8c06-cff0d411d776') ON CONFLICT DO NOTHING;
INSERT INTO auth_role_impl (id,name,allowedPermissions) VALUES ('12572338-2822-420d-8c06-cff0d411d776','Alumni','home,UpdateAlumni,ReadDetailAlumni,SaveInformasiAlumni,UpdateInformasiAlumni,ReadInformasiAlumni,DeleteInformasiAlumni,VerifyMahasiswa,VerifyAlumni,ReadMahasiswaPublic,ReadAlumniPublic,ReadDetailMahasiswa') ON CONFLICT DO NOTHING;

INSERT INTO auth_user_comp (id) VALUES ('20a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp (id) VALUES ('21a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp (id) VALUES ('22a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp (id) VALUES ('23a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp (id) VALUES ('24a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp (id) VALUES ('25a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp (id) VALUES ('26a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp (id) VALUES ('27a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp (id) VALUES ('28a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_comp (id) VALUES ('29a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;

INSERT INTO auth_user_impl (id,allowedPermissions,name,email) VALUES ('20a9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Lukmanul Hakim','lukmanul.hakim@alumni.com') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_impl (id,allowedPermissions,name,email) VALUES ('21a9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Laila Syifa Muthmainah','laila.syifa@alumni.com') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_impl (id,allowedPermissions,name,email) VALUES ('22a9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Hafidz Furqon','hafidz.furqon@alumni.com') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_impl (id,allowedPermissions,name,email) VALUES ('23a9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Ahmad','ahmad@alumni.com') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_impl (id,allowedPermissions,name,email) VALUES ('24a9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Bambang','bambang@alumni.com') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_impl (id,allowedPermissions,name,email) VALUES ('25a9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Cantika','cantika@alumni.com') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_impl (id,allowedPermissions,name,email) VALUES ('26a9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Dimas','dimas@alumni.com') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_impl (id,allowedPermissions,name,email) VALUES ('27a9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Eka','eka@alumni.com') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_impl (id,allowedPermissions,name,email) VALUES ('28a9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Gatot','gatot@alumni.com') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_impl (id,allowedPermissions,name,email) VALUES ('29a9ff33-6dd2-4c0a-b113-a90ee32a01ca','','Hikam','hikam@alumni.com') ON CONFLICT DO NOTHING;

INSERT INTO auth_user_passworded (id,password,user_id) VALUES ('20a9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b','20a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_passworded (id,password,user_id) VALUES ('21a9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b','21a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_passworded (id,password,user_id) VALUES ('22a9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b','22a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_passworded (id,password,user_id) VALUES ('23a9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b','23a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_passworded (id,password,user_id) VALUES ('24a9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b','24a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_passworded (id,password,user_id) VALUES ('25a9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b','25a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_passworded (id,password,user_id) VALUES ('26a9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b','26a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_passworded (id,password,user_id) VALUES ('27a9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b','27a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_passworded (id,password,user_id) VALUES ('28a9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b','28a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_passworded (id,password,user_id) VALUES ('29a9ff33-6dd2-4c0a-b113-a90ee32a01ca','349cbccafc082902f6d88098da92b998129d98c079996b96f305705ffddc67baa935e07353a00b6068e6b0f8e1245ee8d499c80ece5232ad938825cb292bce3b','29a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;

INSERT INTO auth_user_role_comp (id) VALUES ('308d7175-1028-4d11-8074-17ecb4536709') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_comp (id) VALUES ('318d7175-1028-4d11-8074-17ecb4536709') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_comp (id) VALUES ('328d7175-1028-4d11-8074-17ecb4536709') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_comp (id) VALUES ('338d7175-1028-4d11-8074-17ecb4536709') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_comp (id) VALUES ('348d7175-1028-4d11-8074-17ecb4536709') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_comp (id) VALUES ('358d7175-1028-4d11-8074-17ecb4536709') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_comp (id) VALUES ('368d7175-1028-4d11-8074-17ecb4536709') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_comp (id) VALUES ('378d7175-1028-4d11-8074-17ecb4536709') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_comp (id) VALUES ('388d7175-1028-4d11-8074-17ecb4536709') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_comp (id) VALUES ('398d7175-1028-4d11-8074-17ecb4536709') ON CONFLICT DO NOTHING;

INSERT INTO auth_user_role_impl (id,authRole,authUser) VALUES ('308d7175-1028-4d11-8074-17ecb4536709','12572338-2822-420d-8c06-cff0d411d776','20a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_impl (id,authRole,authUser) VALUES ('318d7175-1028-4d11-8074-17ecb4536709','12572338-2822-420d-8c06-cff0d411d776','21a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_impl (id,authRole,authUser) VALUES ('328d7175-1028-4d11-8074-17ecb4536709','12572338-2822-420d-8c06-cff0d411d776','22a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_impl (id,authRole,authUser) VALUES ('338d7175-1028-4d11-8074-17ecb4536709','12572338-2822-420d-8c06-cff0d411d776','23a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_impl (id,authRole,authUser) VALUES ('348d7175-1028-4d11-8074-17ecb4536709','12572338-2822-420d-8c06-cff0d411d776','24a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_impl (id,authRole,authUser) VALUES ('358d7175-1028-4d11-8074-17ecb4536709','12572338-2822-420d-8c06-cff0d411d776','25a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_impl (id,authRole,authUser) VALUES ('368d7175-1028-4d11-8074-17ecb4536709','12572338-2822-420d-8c06-cff0d411d776','26a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_impl (id,authRole,authUser) VALUES ('378d7175-1028-4d11-8074-17ecb4536709','12572338-2822-420d-8c06-cff0d411d776','27a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_impl (id,authRole,authUser) VALUES ('388d7175-1028-4d11-8074-17ecb4536709','12572338-2822-420d-8c06-cff0d411d776','28a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;
INSERT INTO auth_user_role_impl (id,authRole,authUser) VALUES ('398d7175-1028-4d11-8074-17ecb4536709','12572338-2822-420d-8c06-cff0d411d776','29a9ff33-6dd2-4c0a-b113-a90ee32a01ca') ON CONFLICT DO NOTHING;


-- Data

INSERT INTO mahasiswa_comp (id, email, nama, npm, objectname, statusakademik, tahunangkatan, ispublic, programstudi_id, modulesequence) VALUES
('1acc6aae-38a0-4185-bccc-585c8acb6397', 'lukmanul.hakim@mahasiswa.com', 'Lukmanul Hakim', '2106751114', 'siakreborn.mahasiswa.core.MahasiswaImpl', 'Lulus', 2021, true, '2bcc6aaa-38a0-4185-bccc-585c8acb6397', 'mahasiswa_impl'),
('2acc6aae-38a0-4185-bccc-585c8acb6397', 'laila.syifa@mahasiswa.com', 'Laila Syifa Muthmainah', '2106702296', 'siakreborn.mahasiswa.core.MahasiswaImpl', 'Lulus', 2021, true, '2bcc6aaa-38a0-4185-bccc-585c8acb6397', 'mahasiswa_impl'),
('3acc6aae-38a0-4185-bccc-585c8acb6397', 'hafidz.furqon@mahasiswa.com', 'Hafidz Furqon', '2106751115', 'siakreborn.mahasiswa.core.MahasiswaImpl', 'Lulus', 2021, true, '2bcc6aaa-38a0-4185-bccc-585c8acb6397', 'mahasiswa_impl'),
('4acc6aae-38a0-4185-bccc-585c8acb6397', 'ahmad@mahasiswa.com', 'Ahmad', '2006751116', 'siakreborn.mahasiswa.core.MahasiswaImpl', 'Lulus', 2020, true, '2bcc6aaa-38a0-4185-bccc-585c8acb6397', 'mahasiswa_impl'),
('5acc6aae-38a0-4185-bccc-585c8acb6397', 'bambang@mahasiswa.com', 'Bambang', '2006751117', 'siakreborn.mahasiswa.core.MahasiswaImpl', 'Lulus', 2020, true, '2bcc6aaa-38a0-4185-bccc-585c8acb6397', 'mahasiswa_impl'),
('6acc6aae-38a0-4185-bccc-585c8acb6397', 'cantika@mahasiswa.com', 'Cantika', '1906751118', 'siakreborn.mahasiswa.core.MahasiswaImpl', 'Lulus', 2019, true, '2bcc6aaa-38a0-4185-bccc-585c8acb6397', 'mahasiswa_impl'),
('7acc6aae-38a0-4185-bccc-585c8acb6397', 'dimas@mahasiswa.com', 'Dimas', '1906751119', 'siakreborn.mahasiswa.core.MahasiswaImpl', 'Lulus', 2019, true, '2bcc6aaa-38a0-4185-bccc-585c8acb6397', 'mahasiswa_impl'),
('8acc6aae-38a0-4185-bccc-585c8acb6397', 'eka@mahasiswa.com', 'Eka', '1806751120', 'siakreborn.mahasiswa.core.MahasiswaImpl', 'Lulus', 2018, true, '2bcc6aaa-38a0-4185-bccc-585c8acb6397', 'mahasiswa_impl'),
('9acc6aae-38a0-4185-bccc-585c8acb6397', 'gatot@mahasiswa.com', 'Gatot', '1806751121', 'siakreborn.mahasiswa.core.MahasiswaImpl', 'Lulus', 2018, true, '2bcc6aaa-38a0-4185-bccc-585c8acb6397', 'mahasiswa_impl'),
('10ac6aae-38a0-4185-bccc-585c8acb6397', 'hikam@mahasiswa.com', 'Hikam', '1806751122', 'siakreborn.mahasiswa.core.MahasiswaImpl', 'Lulus', 2018, true, '2bcc6aaa-38a0-4185-bccc-585c8acb6397', 'mahasiswa_impl');

INSERT INTO mahasiswa_impl (id) VALUES 
('1acc6aae-38a0-4185-bccc-585c8acb6397'), 
('2acc6aae-38a0-4185-bccc-585c8acb6397'), 
('3acc6aae-38a0-4185-bccc-585c8acb6397'), 
('4acc6aae-38a0-4185-bccc-585c8acb6397'), 
('5acc6aae-38a0-4185-bccc-585c8acb6397'), 
('6acc6aae-38a0-4185-bccc-585c8acb6397'), 
('7acc6aae-38a0-4185-bccc-585c8acb6397'), 
('8acc6aae-38a0-4185-bccc-585c8acb6397'), 
('9acc6aae-38a0-4185-bccc-585c8acb6397'), 
('10ac6aae-38a0-4185-bccc-585c8acb6397'); 

INSERT INTO observer_comp (id, email, nama, objectname, modulesequence) VALUES
    ('d0bbd073-f9a6-4150-a23a-0b3ec2e021ad', 'lukmanul.hakim@alumni.com', 'Lukmanul Hakim', 'siakreborn.observer.core.ObserverImpl', 'observer_impl, observer_alumni'),
    ('0f843ca6-8989-4fae-b799-0e715486c0eb', 'lukmanul.hakim@alumni.com', 'Lukmanul Hakim', 'siakreborn.observer.alumni.ObserverImpl', NULL),
    ('d1bbd073-f9a6-4150-a23a-0b3ec2e021ad', 'laila.syifa@alumni.com', 'Laila Syifa Muthmainah', 'siakreborn.observer.core.ObserverImpl', 'observer_impl, observer_alumni'),
    ('1f843ca6-8989-4fae-b799-0e715486c0eb', 'laila.syifa@alumni.com', 'Laila Syifa Muthmainah','siakreborn.observer.alumni.ObserverImpl', NULL),
    ('d2bbd073-f9a6-4150-a23a-0b3ec2e021ad', 'hafidz.furqon@alumni.com', 'Hafidz Furqon', 'siakreborn.observer.core.ObserverImpl', 'observer_impl, observer_alumni'),
    ('2f843ca6-8989-4fae-b799-0e715486c0eb', 'hafidz.furqon@alumni.com', 'Hafidz Furqon', 'siakreborn.observer.alumni.ObserverImpl', NULL),
    ('d3bbd073-f9a6-4150-a23a-0b3ec2e021ad', 'ahmad@alumni.com', 'Ahmad', 'siakreborn.observer.core.ObserverImpl', 'observer_impl, observer_alumni'),
    ('3f843ca6-8989-4fae-b799-0e715486c0eb', 'ahmad@alumni.com', 'Ahmad', 'siakreborn.observer.alumni.ObserverImpl', NULL),
    ('d4bbd073-f9a6-4150-a23a-0b3ec2e021ad', 'bambang@alumni.com', 'Bambang', 'siakreborn.observer.core.ObserverImpl', 'observer_impl, observer_alumni'),
    ('4f843ca6-8989-4fae-b799-0e715486c0eb', 'bambang@alumni.com', 'Bambang', 'siakreborn.observer.alumni.ObserverImpl', NULL),
    ('d5bbd073-f9a6-4150-a23a-0b3ec2e021ad', 'cantika@alumni.com', 'Cantika', 'siakreborn.observer.core.ObserverImpl', 'observer_impl, observer_alumni'),
    ('5f843ca6-8989-4fae-b799-0e715486c0eb', 'cantika@alumni.com', 'Cantika', 'siakreborn.observer.alumni.ObserverImpl', NULL),
    ('d6bbd073-f9a6-4150-a23a-0b3ec2e021ad', 'dimas@alumni.com', 'Dimas', 'siakreborn.observer.core.ObserverImpl', 'observer_impl, observer_alumni'),
    ('6f843ca6-8989-4fae-b799-0e715486c0eb', 'dimas@alumni.com', 'Dimas', 'siakreborn.observer.alumni.ObserverImpl', NULL),
    ('d7bbd073-f9a6-4150-a23a-0b3ec2e021ad', 'eka@alumni.com', 'Eka', 'siakreborn.observer.core.ObserverImpl', 'observer_impl, observer_alumni'),
    ('7f843ca6-8989-4fae-b799-0e715486c0eb', 'eka@alumni.com', 'Eka', 'siakreborn.observer.alumni.ObserverImpl', NULL),
    ('d8bbd073-f9a6-4150-a23a-0b3ec2e021ad', 'gatot@alumni.com', 'Gatot', 'siakreborn.observer.core.ObserverImpl', 'observer_impl, observer_alumni'),
    ('8f843ca6-8989-4fae-b799-0e715486c0eb', 'gatot@alumni.com', 'Gatot', 'siakreborn.observer.alumni.ObserverImpl', NULL),
    ('d9bbd073-f9a6-4150-a23a-0b3ec2e021ad', 'hikam@alumni.com', 'Hikam', 'siakreborn.observer.core.ObserverImpl', 'observer_impl, observer_alumni'),
    ('9f843ca6-8989-4fae-b799-0e715486c0eb', 'hikam@alumni.com', 'Hikam', 'siakreborn.observer.alumni.ObserverImpl', NULL);

INSERT INTO observer_impl (id) VALUES
    ('d0bbd073-f9a6-4150-a23a-0b3ec2e021ad'),
    ('d1bbd073-f9a6-4150-a23a-0b3ec2e021ad'),
    ('d2bbd073-f9a6-4150-a23a-0b3ec2e021ad'),
    ('d3bbd073-f9a6-4150-a23a-0b3ec2e021ad'),
    ('d4bbd073-f9a6-4150-a23a-0b3ec2e021ad'),
    ('d5bbd073-f9a6-4150-a23a-0b3ec2e021ad'),
    ('d6bbd073-f9a6-4150-a23a-0b3ec2e021ad'),
    ('d7bbd073-f9a6-4150-a23a-0b3ec2e021ad'),
    ('d8bbd073-f9a6-4150-a23a-0b3ec2e021ad'),
    ('d9bbd073-f9a6-4150-a23a-0b3ec2e021ad');

INSERT INTO observer_alumni (ispublic,linkedinurl,npm,pekerjaan,portofoliourl,tahunlulus,tempatkerja,id,record_id,mahasiswa_id,recordname,base_component_id) VALUES
	 (true,'','2106751114','','',2025,'','0f843ca6-8989-4fae-b799-0e715486c0eb','d0bbd073-f9a6-4150-a23a-0b3ec2e021ad','1acc6aae-38a0-4185-bccc-585c8acb6397','siakreborn.observer.core.ObserverImpl', 'd0bbd073-f9a6-4150-a23a-0b3ec2e021ad'),
	 (true,'','2106700000','','',2025,'','1f843ca6-8989-4fae-b799-0e715486c0eb','d1bbd073-f9a6-4150-a23a-0b3ec2e021ad','2acc6aae-38a0-4185-bccc-585c8acb6397','siakreborn.observer.core.ObserverImpl', 'd0bbd073-f9a6-4150-a23a-0b3ec2e021ad'),
	 (true,'','2106751115','','',2025,'','2f843ca6-8989-4fae-b799-0e715486c0eb','d2bbd073-f9a6-4150-a23a-0b3ec2e021ad','3acc6aae-38a0-4185-bccc-585c8acb6397','siakreborn.observer.core.ObserverImpl', 'd1bbd073-f9a6-4150-a23a-0b3ec2e021ad'),
	 (true,'','2006751116','','',2024,'','3f843ca6-8989-4fae-b799-0e715486c0eb','d3bbd073-f9a6-4150-a23a-0b3ec2e021ad','4acc6aae-38a0-4185-bccc-585c8acb6397','siakreborn.observer.core.ObserverImpl', 'd2bbd073-f9a6-4150-a23a-0b3ec2e021ad'),
	 (true,'','2006751117','','',2024,'','4f843ca6-8989-4fae-b799-0e715486c0eb','d4bbd073-f9a6-4150-a23a-0b3ec2e021ad','5acc6aae-38a0-4185-bccc-585c8acb6397','siakreborn.observer.core.ObserverImpl', 'd3bbd073-f9a6-4150-a23a-0b3ec2e021ad'),
	 (true,'','1906751118','','',2023,'','5f843ca6-8989-4fae-b799-0e715486c0eb','d5bbd073-f9a6-4150-a23a-0b3ec2e021ad','6acc6aae-38a0-4185-bccc-585c8acb6397','siakreborn.observer.core.ObserverImpl', 'd4bbd073-f9a6-4150-a23a-0b3ec2e021ad'),
	 (true,'','1906751119','','',2023,'','6f843ca6-8989-4fae-b799-0e715486c0eb','d6bbd073-f9a6-4150-a23a-0b3ec2e021ad','7acc6aae-38a0-4185-bccc-585c8acb6397','siakreborn.observer.core.ObserverImpl', 'd5bbd073-f9a6-4150-a23a-0b3ec2e021ad'),
	 (true,'','1806751120','','',2022,'','7f843ca6-8989-4fae-b799-0e715486c0eb','d7bbd073-f9a6-4150-a23a-0b3ec2e021ad','8acc6aae-38a0-4185-bccc-585c8acb6397','siakreborn.observer.core.ObserverImpl', 'd6bbd073-f9a6-4150-a23a-0b3ec2e021ad'),
	 (true,'','1806751121','','',2022,'','8f843ca6-8989-4fae-b799-0e715486c0eb','d8bbd073-f9a6-4150-a23a-0b3ec2e021ad','9acc6aae-38a0-4185-bccc-585c8acb6397','siakreborn.observer.core.ObserverImpl', 'd7bbd073-f9a6-4150-a23a-0b3ec2e021ad'),
	 (true,'','1806751122','','',2022,'','9f843ca6-8989-4fae-b799-0e715486c0eb','d9bbd073-f9a6-4150-a23a-0b3ec2e021ad','10ac6aae-38a0-4185-bccc-585c8acb6397','siakreborn.observer.core.ObserverImpl', 'd8bbd073-f9a6-4150-a23a-0b3ec2e021ad');

INSERT INTO informasi_comp (id,deskripsi,judul,objectname,tanggalpublikasi,modulesequence) VALUES
	 ('d97e78fb-b8ed-4f54-beba-fb3f2f8cd6f1','PT Teknologi Nusantara membuka lowongan untuk posisi Software Engineer. Alumni diharapkan mengirimkan CV dan portofolio ke email@example.com paling lambat 10 Juli 2024. Informasi lebih lanjut dapat dilihat di portal alumni.','Lowongan Kerja di PT Teknologi Nusantara','siakreborn.informasi.alumni.InformasiImpl','2024-12-23 11:56:39.099',NULL),
	 ('4b069f7f-3f4e-40ae-bb50-f63c2efe2c61','PT Teknologi Nusantara membuka lowongan untuk posisi Software Engineer. Alumni diharapkan mengirimkan CV dan portofolio ke email@example.com paling lambat 10 Juli 2024. Informasi lebih lanjut dapat dilihat di portal alumni.','Lowongan Kerja di PT Teknologi Nusantara','siakreborn.informasi.core.InformasiImpl','2024-12-23 11:56:39.099','informasi_impl, informasi_alumni');

INSERT INTO informasi_comp (id,deskripsi,judul,objectname,tanggalpublikasi,modulesequence) VALUES
	 ('d97e78fb-b8ed-4f54-beba-fb3f2f8cd6f2','Reuni Akbar Alumni Universitas Indonesia akan dilaksanakan pada 20 Agustus 2024 di Balai Sidang Universitas Indonesia. Alumni dari seluruh angkatan diundang untuk menghadiri acara ini. Segera daftar melalui link berikut: ui.ac.id/reuni2024.','Reuni Akbar Alumni 2024','siakreborn.informasi.alumni.InformasiImpl','2024-12-23 11:56:39.099',NULL),
	 ('4b069f7f-3f4e-40ae-bb50-f63c2efe2c62','Reuni Akbar Alumni Universitas Indonesia akan dilaksanakan pada 20 Agustus 2024 di Balai Sidang Universitas Indonesia. Alumni dari seluruh angkatan diundang untuk menghadiri acara ini. Segera daftar melalui link berikut: ui.ac.id/reuni2024.','Reuni Akbar Alumni 2024','siakreborn.informasi.core.InformasiImpl','2024-12-23 11:56:39.099','informasi_impl, informasi_alumni');

INSERT INTO informasi_comp (id,deskripsi,judul,objectname,tanggalpublikasi,modulesequence) VALUES
	 ('d97e78fb-b8ed-4f54-beba-fb3f2f8cd6f3','Kami mengundang alumni untuk mengisi data tracer study guna membantu universitas meningkatkan kualitas pendidikan. Formulir dapat diisi melalui portal alumni hingga 30 Juni 2024. Partisipasi Anda sangat berarti!','Pengisian Data Tracer Study','siakreborn.informasi.alumni.InformasiImpl','2024-12-23 11:56:39.099',NULL),
	 ('4b069f7f-3f4e-40ae-bb50-f63c2efe2c63','Kami mengundang alumni untuk mengisi data tracer study guna membantu universitas meningkatkan kualitas pendidikan. Formulir dapat diisi melalui portal alumni hingga 30 Juni 2024. Partisipasi Anda sangat berarti!','Pengisian Data Tracer Study','siakreborn.informasi.core.InformasiImpl','2024-12-23 11:56:39.099','informasi_impl, informasi_alumni');

INSERT INTO informasi_impl (id) VALUES
     ('4b069f7f-3f4e-40ae-bb50-f63c2efe2c61'),
     ('4b069f7f-3f4e-40ae-bb50-f63c2efe2c62'),
     ('4b069f7f-3f4e-40ae-bb50-f63c2efe2c63');

INSERT INTO informasi_alumni (id,record_id,alumni_id,recordname,base_component_id) VALUES
	 ('d97e78fb-b8ed-4f54-beba-fb3f2f8cd6f1','4b069f7f-3f4e-40ae-bb50-f63c2efe2c61','0f843ca6-8989-4fae-b799-0e715486c0eb','siakreborn.informasi.core.InformasiImpl','4b069f7f-3f4e-40ae-bb50-f63c2efe2c61');

INSERT INTO informasi_alumni (id,record_id,alumni_id,recordname,base_component_id) VALUES
	 ('d97e78fb-b8ed-4f54-beba-fb3f2f8cd6f2','4b069f7f-3f4e-40ae-bb50-f63c2efe2c62','0f843ca6-8989-4fae-b799-0e715486c0eb','siakreborn.informasi.core.InformasiImpl','4b069f7f-3f4e-40ae-bb50-f63c2efe2c62');

INSERT INTO informasi_alumni (id,record_id,alumni_id,recordname,base_component_id) VALUES
	 ('d97e78fb-b8ed-4f54-beba-fb3f2f8cd6f3','4b069f7f-3f4e-40ae-bb50-f63c2efe2c63','0f843ca6-8989-4fae-b799-0e715486c0eb','siakreborn.informasi.core.InformasiImpl','4b069f7f-3f4e-40ae-bb50-f63c2efe2c63');
