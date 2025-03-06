SET datestyle = 'ISO, DMY';

INSERT INTO program_studi_comp (id, jenjang, kaprodi, kode, nama, nosk, modulesequence, objectname) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397','S1','Alfan Farizki Wicaksono, S.T., M.Sc., Ph.D.','IK','Sarjana Ilmu Komputer','SK/2024/01/01','program_studi_impl','siakreborn.programstudi.core.ProgramStudiImpl'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397','S1','Prof. Dr. Putu Wuri Handayani, S.Kom., M.Sc.','SI','Sarjana Sistem Informasi','SK/2024/01/01','program_studi_impl','siakreborn.programstudi.core.ProgramStudiImpl')
ON CONFLICT DO NOTHING;

INSERT INTO program_studi_impl (id) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397')
ON CONFLICT DO NOTHING;

INSERT INTO kurikulum_comp (id, kode, nosk, profillulusan, status, programstudi_id, modulesequence, objectname) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397','IK2020','SK/2020/IK','Profil Lulusan IK','Aktif','1bcc6aaa-38a0-4185-bccc-585c8acb6397','kurikulum_impl','siakreborn.kurikulum.core.KurikulumImpl'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397','SI2020','SK/2020/SI','Profil Lulusan SI','Aktif','2bcc6aaa-38a0-4185-bccc-585c8acb6397','kurikulum_impl','siakreborn.kurikulum.core.KurikulumImpl'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397','IK2024','SK/2024/IK','Profil Lulusan IK','Aktif','1bcc6aaa-38a0-4185-bccc-585c8acb6397','kurikulum_impl','siakreborn.kurikulum.core.KurikulumImpl'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397','SI2024','SK/2024/SI','Profil Lulusan SI','Aktif','2bcc6aaa-38a0-4185-bccc-585c8acb6397','kurikulum_impl','siakreborn.kurikulum.core.KurikulumImpl')
ON CONFLICT DO NOTHING;

INSERT INTO kurikulum_impl (id) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397')
ON CONFLICT DO NOTHING;

INSERT INTO mata_kuliah_comp (id, kode, nama, sks, term, kurikulum_id, modulesequence, objectname) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397','DDP-1','Dasar-Dasar Pemrograman 1',4,1,'3bcc6aaa-38a0-4185-bccc-585c8acb6397','mata_kuliah_impl','siakreborn.matakuliah.core.MataKuliahImpl'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397','DDP-2','Dasar-Dasar Pemrograman 2',4,2,'3bcc6aaa-38a0-4185-bccc-585c8acb6397','mata_kuliah_impl','siakreborn.matakuliah.core.MataKuliahImpl'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397','Kalkulus-1','Kalkulus 1',3,1,'3bcc6aaa-38a0-4185-bccc-585c8acb6397','mata_kuliah_impl','siakreborn.matakuliah.core.MataKuliahImpl'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397','Kalkulus-2','Kalkulus 2',3,2,'3bcc6aaa-38a0-4185-bccc-585c8acb6397','mata_kuliah_impl','siakreborn.matakuliah.core.MataKuliahImpl'),
('5bcc6aaa-38a0-4185-bccc-585c8acb6397','RPL','Rekayasa Perangkat Lunak',3,5,'3bcc6aaa-38a0-4185-bccc-585c8acb6397','mata_kuliah_impl','siakreborn.matakuliah.core.MataKuliahImpl'),
('6bcc6aaa-38a0-4185-bccc-585c8acb6397','PPL','Proyek Perangkat Lunak',6,6,'3bcc6aaa-38a0-4185-bccc-585c8acb6397','mata_kuliah_impl','siakreborn.matakuliah.core.MataKuliahImpl'),
('7bcc6aaa-38a0-4185-bccc-585c8acb6397','PBP','Pemrograman Berbasis Platform',3,3,'3bcc6aaa-38a0-4185-bccc-585c8acb6397','mata_kuliah_impl','siakreborn.matakuliah.core.MataKuliahImpl'),
('8bcc6aaa-38a0-4185-bccc-585c8acb6397','Adpro','Pemrograman Lanjut',4,4,'3bcc6aaa-38a0-4185-bccc-585c8acb6397','mata_kuliah_impl','siakreborn.matakuliah.core.MataKuliahImpl')
ON CONFLICT DO NOTHING;

INSERT INTO mata_kuliah_impl (id) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('5bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('6bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('7bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('8bcc6aaa-38a0-4185-bccc-585c8acb6397')
ON CONFLICT DO NOTHING;

INSERT INTO dosen_comp (id, nama, nip, email, modulesequence, objectname) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397','Dr. Ade Azurat, S.Kom.','512140372','ade@user.com','dosen_impl','siakreborn.dosen.core.DosenImpl'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397','Iis Solichah, S.Kom., M.Kom, M.C.S.','512182718','iis@user.com','dosen_impl','siakreborn.dosen.core.DosenImpl'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397','Dr. Maya Retno Ayu Setyautami, S.Kom., M.Kom.','512183927','maya@user.com','dosen_impl','siakreborn.dosen.core.DosenImpl'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397','Ichlasul Affan, S.Kom., M.Kom.','512198379','affan@user.com','dosen_impl','siakreborn.dosen.core.DosenImpl'),
('5bcc6aaa-38a0-4185-bccc-585c8acb6397','Daya Adianto, S.Kom., M.Kom.','512197583','daya@user.com','dosen_impl','siakreborn.dosen.core.DosenImpl'),
('6bcc6aaa-38a0-4185-bccc-585c8acb6397','Andi Pujo Rahadi, S.T., M.Sc.','512177122','andi@user.com','dosen_impl','siakreborn.dosen.core.DosenImpl'),
('7bcc6aaa-38a0-4185-bccc-585c8acb6397','Prof. Heru Suhartanto, M.Sc., Ph.D.','512118271','heru@user.com','dosen_impl','siakreborn.dosen.core.DosenImpl'),
('8bcc6aaa-38a0-4185-bccc-585c8acb6397','Dosen','182717212','dosen@user.com','dosen_impl','siakreborn.dosen.core.DosenImpl')
ON CONFLICT DO NOTHING;

INSERT INTO dosen_impl (id) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('5bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('6bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('7bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('8bcc6aaa-38a0-4185-bccc-585c8acb6397')
ON CONFLICT DO NOTHING;

INSERT INTO mahasiswa_comp (id, nama, npm, email, programstudi_id, modulesequence, objectname) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397','Bonaventura Galang K. A. H.','2106172819','bona@user.com','1bcc6aaa-38a0-4185-bccc-585c8acb6397','mahasiswa_impl','siakreborn.mahasiswa.core.MahasiswaImpl'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397','Aidah Novallia Putri','2106171927','aidah@user.com','1bcc6aaa-38a0-4185-bccc-585c8acb6397','mahasiswa_impl','siakreborn.mahasiswa.core.MahasiswaImpl'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397','Farel Muhammad Daffa','2106179172','farel@user.com','1bcc6aaa-38a0-4185-bccc-585c8acb6397','mahasiswa_impl','siakreborn.mahasiswa.core.MahasiswaImpl'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397','Ramadhan Azka Dhamawan','2106171782','azka@user.com','1bcc6aaa-38a0-4185-bccc-585c8acb6397','mahasiswa_impl','siakreborn.mahasiswa.core.MahasiswaImpl'),
('5bcc6aaa-38a0-4185-bccc-585c8acb6397','Pramudya Wibisono','2106170109','pram@user.com','1bcc6aaa-38a0-4185-bccc-585c8acb6397','mahasiswa_impl','siakreborn.mahasiswa.core.MahasiswaImpl'),
('6bcc6aaa-38a0-4185-bccc-585c8acb6397','Nur Fajar Sayyidul Ayyam','2106171129','fajar@user.com','2bcc6aaa-38a0-4185-bccc-585c8acb6397','mahasiswa_impl','siakreborn.mahasiswa.core.MahasiswaImpl'),
('7bcc6aaa-38a0-4185-bccc-585c8acb6397','Zacky Muchlas Dharmawan','2106170092','zacky@user.com','2bcc6aaa-38a0-4185-bccc-585c8acb6397','mahasiswa_impl','siakreborn.mahasiswa.core.MahasiswaImpl')
ON CONFLICT DO NOTHING;

INSERT INTO mahasiswa_impl (id) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('5bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('6bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('7bcc6aaa-38a0-4185-bccc-585c8acb6397')
ON CONFLICT DO NOTHING;

INSERT INTO semester_comp (id, kode, deskripsi, status, tanggalmulai, tanggalselesai, modulesequence, objectname) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397','2022/2023 - 1','Gasal 2022/2023','Tidak Aktif','01/07/2022','31/12/2022','semester_impl','siakreborn.semester.core.SemesterImpl'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397','2022/2023 - 2','Genap 2022/2023','Tidak Aktif','01/01/2023','30/06/2023','semester_impl','siakreborn.semester.core.SemesterImpl'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397','2023/2024 - 1','Gasal 2023/2024','Tidak Aktif','01/07/2023','31/12/2023','semester_impl','siakreborn.semester.core.SemesterImpl'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397','2023/2024 - 2','Genap 2023/2024','Tidak Aktif','01/01/2024','30/06/2024','semester_impl','siakreborn.semester.core.SemesterImpl'),
('5bcc6aaa-38a0-4185-bccc-585c8acb6397','2024/2025 - 1','Gasal 2024/2025','Aktif','01/07/2024','31/12/2024','semester_impl','siakreborn.semester.core.SemesterImpl'),
('6bcc6aaa-38a0-4185-bccc-585c8acb6397','2024/2025 - 2','Genap 2024/2025','Pending','01/01/2025','30/06/2025','semester_impl','siakreborn.semester.core.SemesterImpl'),
('7bcc6aaa-38a0-4185-bccc-585c8acb6397','2025/2026 - 1','Gasal 2025/2026','Pending','01/07/2025','31/12/2025','semester_impl','siakreborn.semester.core.SemesterImpl'),
('8bcc6aaa-38a0-4185-bccc-585c8acb6397','2025/2026 - 2','Genap 2025/2026','Pending','01/01/2026','30/06/2026','semester_impl','siakreborn.semester.core.SemesterImpl')
ON CONFLICT DO NOTHING;

INSERT INTO semester_impl (id) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('5bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('6bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('7bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('8bcc6aaa-38a0-4185-bccc-585c8acb6397')
ON CONFLICT DO NOTHING;

INSERT INTO kurikulum_semester_comp (id, kurikulum_id, semester_id, modulesequence, objectname) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397','1bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','kurikulum_semester_impl','siakreborn.kurikulumsemester.core.KurikulumSemesterImpl'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397','2bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','kurikulum_semester_impl','siakreborn.kurikulumsemester.core.KurikulumSemesterImpl'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397','3bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','kurikulum_semester_impl','siakreborn.kurikulumsemester.core.KurikulumSemesterImpl'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','kurikulum_semester_impl','siakreborn.kurikulumsemester.core.KurikulumSemesterImpl')
ON CONFLICT DO NOTHING;

INSERT INTO kurikulum_semester_impl (id) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397')
ON CONFLICT DO NOTHING;

INSERT INTO kelas_comp (id, nama, kapasitas, jadwal, ruangan, matakuliah_id, semester_id, modulesequence, objectname) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397','DDP-1 A',65,'Senin 08.00-09.40
Rabu 10.00-11.40','Gedung A','1bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_impl','siakreborn.kelas.core.KelasImpl'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397','DDP-1 B',65,'Senin 08.00-09.40
Rabu 10.00-11.40','Gedung B','1bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_impl','siakreborn.kelas.core.KelasImpl'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397','DDP-1 C',65,'Senin 08.00-09.40
Rabu 10.00-11.40','Gedung C','1bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_impl','siakreborn.kelas.core.KelasImpl'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397','DDP-2 A',65,'Senin 08.00-09.40
Rabu 10.00-11.40','Gedung A','2bcc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_impl','siakreborn.kelas.core.KelasImpl'),
('5bcc6aaa-38a0-4185-bccc-585c8acb6397','DDP-2 B',65,'Senin 08.00-09.40
Rabu 10.00-11.40','Gedung B','2bcc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_impl','siakreborn.kelas.core.KelasImpl'),
('6bcc6aaa-38a0-4185-bccc-585c8acb6397','DDP-2 C',65,'Senin 08.00-09.40
Rabu 10.00-11.40','Gedung C','2bcc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_impl','siakreborn.kelas.core.KelasImpl'),
('7bcc6aaa-38a0-4185-bccc-585c8acb6397','Kalkulus-1 A',65,'Senin 10.00-11.40
Rabu 08.00-08.50','Gedung A','3bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_impl','siakreborn.kelas.core.KelasImpl'),
('8bcc6aaa-38a0-4185-bccc-585c8acb6397','Kalkulus-1 B',65,'Senin 10.00-11.40
Rabu 08.00-08.50','Gedung B','3bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_impl','siakreborn.kelas.core.KelasImpl'),
('9bcc6aaa-38a0-4185-bccc-585c8acb6397','Kalkulus-1 C',65,'Senin 10.00-11.40
Rabu 08.00-08.50','Gedung C','3bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_impl','siakreborn.kelas.core.KelasImpl'),
('10cc6aaa-38a0-4185-bccc-585c8acb6397','Kalkulus-2 A',65,'Senin 10.00-11.40
Rabu 08.00-08.50','Gedung A','4bcc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_impl','siakreborn.kelas.core.KelasImpl'),
('11cc6aaa-38a0-4185-bccc-585c8acb6397','Kalkulus-2 B',65,'Senin 10.00-11.40
Rabu 08.00-08.50','Gedung B','4bcc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_impl','siakreborn.kelas.core.KelasImpl'),
('12cc6aaa-38a0-4185-bccc-585c8acb6397','Kalkulus-2 C',65,'Senin 10.00-11.40
Rabu 08.00-08.50','Gedung C','4bcc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_impl','siakreborn.kelas.core.KelasImpl'),
('13cc6aaa-38a0-4185-bccc-585c8acb6397','RPL A',40,'Selasa 08.00-09.40
Kamis 10.00-10.50','Gedung A','5bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_impl','siakreborn.kelas.core.KelasImpl'),
('14cc6aaa-38a0-4185-bccc-585c8acb6397','RPL B',40,'Selasa 08.00-09.40
Kamis 10.00-10.50','Gedung B','5bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_impl','siakreborn.kelas.core.KelasImpl'),
('15cc6aaa-38a0-4185-bccc-585c8acb6397','PPL A',40,'Senin 13.00-14.40
Kamis 13.00-14.40','Gedung A','6bcc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_impl','siakreborn.kelas.core.KelasImpl'),
('16cc6aaa-38a0-4185-bccc-585c8acb6397','PPL B',40,'Senin 13.00-14.40
Kamis 13.00-14.40','Gedung B','6bcc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_impl','siakreborn.kelas.core.KelasImpl'),
('17cc6aaa-38a0-4185-bccc-585c8acb6397','PBP A',65,'Selasa 10.00-11.40
Kamis 08.00-09.50','Gedung A','7bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_impl','siakreborn.kelas.core.KelasImpl'),
('18cc6aaa-38a0-4185-bccc-585c8acb6397','PBP B',65,'Selasa 10.00-11.40
Kamis 08.00-09.50','Gedung B','7bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_impl','siakreborn.kelas.core.KelasImpl'),
('19cc6aaa-38a0-4185-bccc-585c8acb6397','PBP C',65,'Selasa 10.00-11.40
Kamis 08.00-09.50','Gedung C','7bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_impl','siakreborn.kelas.core.KelasImpl'),
('20cc6aaa-38a0-4185-bccc-585c8acb6397','Adpro A',40,'Selasa 13.00-14.40
Kamis 13.00-14.40','Gedung A','8bcc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_impl','siakreborn.kelas.core.KelasImpl'),
('21cc6aaa-38a0-4185-bccc-585c8acb6397','Adpro B',40,'Selasa 13.00-14.40
Kamis 13.00-14.40','Gedung B','8bcc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_impl','siakreborn.kelas.core.KelasImpl')
ON CONFLICT DO NOTHING;

INSERT INTO kelas_impl (id) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('5bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('6bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('7bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('8bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('9bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('10cc6aaa-38a0-4185-bccc-585c8acb6397'),
('11cc6aaa-38a0-4185-bccc-585c8acb6397'),
('12cc6aaa-38a0-4185-bccc-585c8acb6397'),
('13cc6aaa-38a0-4185-bccc-585c8acb6397'),
('14cc6aaa-38a0-4185-bccc-585c8acb6397'),
('15cc6aaa-38a0-4185-bccc-585c8acb6397'),
('16cc6aaa-38a0-4185-bccc-585c8acb6397'),
('17cc6aaa-38a0-4185-bccc-585c8acb6397'),
('18cc6aaa-38a0-4185-bccc-585c8acb6397'),
('19cc6aaa-38a0-4185-bccc-585c8acb6397'),
('20cc6aaa-38a0-4185-bccc-585c8acb6397'),
('21cc6aaa-38a0-4185-bccc-585c8acb6397')
ON CONFLICT DO NOTHING;

INSERT INTO kelas_dosen_comp (id, kelas_id, dosen_id, modulesequence, objectname) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397','1bcc6aaa-38a0-4185-bccc-585c8acb6397','1bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397','1bcc6aaa-38a0-4185-bccc-585c8acb6397','2bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397','2bcc6aaa-38a0-4185-bccc-585c8acb6397','1bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397','3bcc6aaa-38a0-4185-bccc-585c8acb6397','2bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('5bcc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','1bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('6bcc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','2bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('7bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','2bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('8bcc6aaa-38a0-4185-bccc-585c8acb6397','6bcc6aaa-38a0-4185-bccc-585c8acb6397','1bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('9bcc6aaa-38a0-4185-bccc-585c8acb6397','7bcc6aaa-38a0-4185-bccc-585c8acb6397','6bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('10cc6aaa-38a0-4185-bccc-585c8acb6397','8bcc6aaa-38a0-4185-bccc-585c8acb6397','6bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('11cc6aaa-38a0-4185-bccc-585c8acb6397','9bcc6aaa-38a0-4185-bccc-585c8acb6397','6bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('12cc6aaa-38a0-4185-bccc-585c8acb6397','10cc6aaa-38a0-4185-bccc-585c8acb6397','7bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('13cc6aaa-38a0-4185-bccc-585c8acb6397','11cc6aaa-38a0-4185-bccc-585c8acb6397','7bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('14cc6aaa-38a0-4185-bccc-585c8acb6397','12cc6aaa-38a0-4185-bccc-585c8acb6397','7bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('15cc6aaa-38a0-4185-bccc-585c8acb6397','13cc6aaa-38a0-4185-bccc-585c8acb6397','3bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('16cc6aaa-38a0-4185-bccc-585c8acb6397','14cc6aaa-38a0-4185-bccc-585c8acb6397','3bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('17cc6aaa-38a0-4185-bccc-585c8acb6397','15cc6aaa-38a0-4185-bccc-585c8acb6397','1bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('18cc6aaa-38a0-4185-bccc-585c8acb6397','16cc6aaa-38a0-4185-bccc-585c8acb6397','1bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('19cc6aaa-38a0-4185-bccc-585c8acb6397','17cc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('20cc6aaa-38a0-4185-bccc-585c8acb6397','18cc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('21cc6aaa-38a0-4185-bccc-585c8acb6397','19cc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('22cc6aaa-38a0-4185-bccc-585c8acb6397','20cc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('23cc6aaa-38a0-4185-bccc-585c8acb6397','21cc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('24cc6aaa-38a0-4185-bccc-585c8acb6397','15cc6aaa-38a0-4185-bccc-585c8acb6397','8bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl'),
('25cc6aaa-38a0-4185-bccc-585c8acb6397','13cc6aaa-38a0-4185-bccc-585c8acb6397','8bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_dosen_impl','siakreborn.kelasdosen.core.KelasDosenImpl')
ON CONFLICT DO NOTHING;

INSERT INTO kelas_dosen_impl (id) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('5bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('6bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('7bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('8bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('9bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('10cc6aaa-38a0-4185-bccc-585c8acb6397'),
('11cc6aaa-38a0-4185-bccc-585c8acb6397'),
('12cc6aaa-38a0-4185-bccc-585c8acb6397'),
('13cc6aaa-38a0-4185-bccc-585c8acb6397'),
('14cc6aaa-38a0-4185-bccc-585c8acb6397'),
('15cc6aaa-38a0-4185-bccc-585c8acb6397'),
('16cc6aaa-38a0-4185-bccc-585c8acb6397'),
('17cc6aaa-38a0-4185-bccc-585c8acb6397'),
('18cc6aaa-38a0-4185-bccc-585c8acb6397'),
('19cc6aaa-38a0-4185-bccc-585c8acb6397'),
('20cc6aaa-38a0-4185-bccc-585c8acb6397'),
('21cc6aaa-38a0-4185-bccc-585c8acb6397'),
('22cc6aaa-38a0-4185-bccc-585c8acb6397'),
('23cc6aaa-38a0-4185-bccc-585c8acb6397'),
('24cc6aaa-38a0-4185-bccc-585c8acb6397'),
('25cc6aaa-38a0-4185-bccc-585c8acb6397')
ON CONFLICT DO NOTHING;

INSERT INTO rencana_studi_comp (id, totalsks, status, mahasiswa_id, semester_id, modulesequence, objectname) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397',8,'Disetujui','1bcc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','rencana_studi_impl','siakreborn.rencanastudi.core.RencanaStudiImpl'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397',8,'Disetujui','2bcc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','rencana_studi_impl','siakreborn.rencanastudi.core.RencanaStudiImpl'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397',10,'Disetujui','3bcc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','rencana_studi_impl','siakreborn.rencanastudi.core.RencanaStudiImpl'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397',10,'Disetujui','4bcc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','rencana_studi_impl','siakreborn.rencanastudi.core.RencanaStudiImpl'),
('5bcc6aaa-38a0-4185-bccc-585c8acb6397',6,'Disetujui','5bcc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','rencana_studi_impl','siakreborn.rencanastudi.core.RencanaStudiImpl'),
('6bcc6aaa-38a0-4185-bccc-585c8acb6397',7,'Disetujui','6bcc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','rencana_studi_impl','siakreborn.rencanastudi.core.RencanaStudiImpl'),
('7bcc6aaa-38a0-4185-bccc-585c8acb6397',7,'Disetujui','7bcc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','rencana_studi_impl','siakreborn.rencanastudi.core.RencanaStudiImpl'),
('8bcc6aaa-38a0-4185-bccc-585c8acb6397',6,'Menunggu persetujuan PA','1bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','rencana_studi_impl','siakreborn.rencanastudi.core.RencanaStudiImpl'),
('9bcc6aaa-38a0-4185-bccc-585c8acb6397',7,'Menunggu persetujuan PA','3bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','rencana_studi_impl','siakreborn.rencanastudi.core.RencanaStudiImpl'),
('10cc6aaa-38a0-4185-bccc-585c8acb6397',7,'Disetujui','6bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','rencana_studi_impl','siakreborn.rencanastudi.core.RencanaStudiImpl'),
('11cc6aaa-38a0-4185-bccc-585c8acb6397',7,'Disetujui','7bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','rencana_studi_impl','siakreborn.rencanastudi.core.RencanaStudiImpl')
ON CONFLICT DO NOTHING;

INSERT INTO rencana_studi_impl (id) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('5bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('6bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('7bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('8bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('9bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('10cc6aaa-38a0-4185-bccc-585c8acb6397'),
('11cc6aaa-38a0-4185-bccc-585c8acb6397')
ON CONFLICT DO NOTHING;

INSERT INTO kelas_mahasiswa_comp (id, tanggalpengisian, kelas_id, rencanastudi_id, modulesequence, objectname) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397','15/01/2024','15cc6aaa-38a0-4185-bccc-585c8acb6397','3bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_mahasiswa_impl','siakreborn.rencanastudi.core.KelasMahasiswaImpl'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397','15/01/2024','15cc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_mahasiswa_impl','siakreborn.rencanastudi.core.KelasMahasiswaImpl'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397','16/01/2024','15cc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_mahasiswa_impl','siakreborn.rencanastudi.core.KelasMahasiswaImpl'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397','15/01/2024','20cc6aaa-38a0-4185-bccc-585c8acb6397','1bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_mahasiswa_impl','siakreborn.rencanastudi.core.KelasMahasiswaImpl'),
('5bcc6aaa-38a0-4185-bccc-585c8acb6397','15/01/2024','20cc6aaa-38a0-4185-bccc-585c8acb6397','2bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_mahasiswa_impl','siakreborn.rencanastudi.core.KelasMahasiswaImpl'),
('6bcc6aaa-38a0-4185-bccc-585c8acb6397','16/01/2024','11cc6aaa-38a0-4185-bccc-585c8acb6397','6bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_mahasiswa_impl','siakreborn.rencanastudi.core.KelasMahasiswaImpl'),
('7bcc6aaa-38a0-4185-bccc-585c8acb6397','16/01/2024','11cc6aaa-38a0-4185-bccc-585c8acb6397','7bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_mahasiswa_impl','siakreborn.rencanastudi.core.KelasMahasiswaImpl'),
('8bcc6aaa-38a0-4185-bccc-585c8acb6397','15/01/2024','4bcc6aaa-38a0-4185-bccc-585c8acb6397','3bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_mahasiswa_impl','siakreborn.rencanastudi.core.KelasMahasiswaImpl'),
('9bcc6aaa-38a0-4185-bccc-585c8acb6397','15/01/2024','4bcc6aaa-38a0-4185-bccc-585c8acb6397','1bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_mahasiswa_impl','siakreborn.rencanastudi.core.KelasMahasiswaImpl'),
('10cc6aaa-38a0-4185-bccc-585c8acb6397','15/01/2024','5bcc6aaa-38a0-4185-bccc-585c8acb6397','2bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_mahasiswa_impl','siakreborn.rencanastudi.core.KelasMahasiswaImpl'),
('11cc6aaa-38a0-4185-bccc-585c8acb6397','15/01/2024','5bcc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_mahasiswa_impl','siakreborn.rencanastudi.core.KelasMahasiswaImpl'),
('12cc6aaa-38a0-4185-bccc-585c8acb6397','16/01/2024','6bcc6aaa-38a0-4185-bccc-585c8acb6397','6bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_mahasiswa_impl','siakreborn.rencanastudi.core.KelasMahasiswaImpl'),
('13cc6aaa-38a0-4185-bccc-585c8acb6397','16/01/2024','6bcc6aaa-38a0-4185-bccc-585c8acb6397','7bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_mahasiswa_impl','siakreborn.rencanastudi.core.KelasMahasiswaImpl'),
('14cc6aaa-38a0-4185-bccc-585c8acb6397','13/08/2024','13cc6aaa-38a0-4185-bccc-585c8acb6397','8bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_mahasiswa_impl','siakreborn.rencanastudi.core.KelasMahasiswaImpl'),
('15cc6aaa-38a0-4185-bccc-585c8acb6397','14/08/2024','2bcc6aaa-38a0-4185-bccc-585c8acb6397','9bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_mahasiswa_impl','siakreborn.rencanastudi.core.KelasMahasiswaImpl'),
('16cc6aaa-38a0-4185-bccc-585c8acb6397','13/08/2024','1bcc6aaa-38a0-4185-bccc-585c8acb6397','10cc6aaa-38a0-4185-bccc-585c8acb6397','kelas_mahasiswa_impl','siakreborn.rencanastudi.core.KelasMahasiswaImpl'),
('17cc6aaa-38a0-4185-bccc-585c8acb6397','13/08/2024','3bcc6aaa-38a0-4185-bccc-585c8acb6397','11cc6aaa-38a0-4185-bccc-585c8acb6397','kelas_mahasiswa_impl','siakreborn.rencanastudi.core.KelasMahasiswaImpl'),
('18cc6aaa-38a0-4185-bccc-585c8acb6397','13/08/2024','17cc6aaa-38a0-4185-bccc-585c8acb6397','8bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_mahasiswa_impl','siakreborn.rencanastudi.core.KelasMahasiswaImpl'),
('19cc6aaa-38a0-4185-bccc-585c8acb6397','13/08/2024','14cc6aaa-38a0-4185-bccc-585c8acb6397','9bcc6aaa-38a0-4185-bccc-585c8acb6397','kelas_mahasiswa_impl','siakreborn.rencanastudi.core.KelasMahasiswaImpl'),
('20cc6aaa-38a0-4185-bccc-585c8acb6397','13/08/2024','18cc6aaa-38a0-4185-bccc-585c8acb6397','10cc6aaa-38a0-4185-bccc-585c8acb6397','kelas_mahasiswa_impl','siakreborn.rencanastudi.core.KelasMahasiswaImpl'),
('21cc6aaa-38a0-4185-bccc-585c8acb6397','14/08/2024','19cc6aaa-38a0-4185-bccc-585c8acb6397','11cc6aaa-38a0-4185-bccc-585c8acb6397','kelas_mahasiswa_impl','siakreborn.rencanastudi.core.KelasMahasiswaImpl')
ON CONFLICT DO NOTHING;

INSERT INTO kelas_mahasiswa_impl (id) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('5bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('6bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('7bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('8bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('9bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('10cc6aaa-38a0-4185-bccc-585c8acb6397'),
('11cc6aaa-38a0-4185-bccc-585c8acb6397'),
('12cc6aaa-38a0-4185-bccc-585c8acb6397'),
('13cc6aaa-38a0-4185-bccc-585c8acb6397'),
('14cc6aaa-38a0-4185-bccc-585c8acb6397'),
('15cc6aaa-38a0-4185-bccc-585c8acb6397'),
('16cc6aaa-38a0-4185-bccc-585c8acb6397'),
('17cc6aaa-38a0-4185-bccc-585c8acb6397'),
('18cc6aaa-38a0-4185-bccc-585c8acb6397'),
('19cc6aaa-38a0-4185-bccc-585c8acb6397'),
('20cc6aaa-38a0-4185-bccc-585c8acb6397'),
('21cc6aaa-38a0-4185-bccc-585c8acb6397')
ON CONFLICT DO NOTHING;

INSERT INTO komponen_penilaian_comp (id, nama, bobot, kelas_id, modulesequence, objectname) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397','Tugas Pemrograman 1',15,'1bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397','Tugas Pemrograman 2',15,'1bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397','UTS',30,'1bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397','UAS',30,'1bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('5bcc6aaa-38a0-4185-bccc-585c8acb6397','Partisipasi',10,'1bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('6bcc6aaa-38a0-4185-bccc-585c8acb6397','Tugas Pemrograman 1',15,'2bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('7bcc6aaa-38a0-4185-bccc-585c8acb6397','Tugas Pemrograman 2',15,'2bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('8bcc6aaa-38a0-4185-bccc-585c8acb6397','UTS',30,'2bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('9bcc6aaa-38a0-4185-bccc-585c8acb6397','UAS',30,'2bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('10cc6aaa-38a0-4185-bccc-585c8acb6397','Partisipasi',10,'2bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('11cc6aaa-38a0-4185-bccc-585c8acb6397','Tugas Pemrograman 1',15,'3bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('12cc6aaa-38a0-4185-bccc-585c8acb6397','Tugas Pemrograman 2',15,'3bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('13cc6aaa-38a0-4185-bccc-585c8acb6397','UTS',30,'3bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('14cc6aaa-38a0-4185-bccc-585c8acb6397','UAS',30,'3bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('15cc6aaa-38a0-4185-bccc-585c8acb6397','Partisipasi',10,'3bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('16cc6aaa-38a0-4185-bccc-585c8acb6397','Tugas Pemrograman 1',10,'4bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('17cc6aaa-38a0-4185-bccc-585c8acb6397','Tugas Pemrograman 2',10,'4bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('18cc6aaa-38a0-4185-bccc-585c8acb6397','Tugas Pemrograman 3',10,'4bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('19cc6aaa-38a0-4185-bccc-585c8acb6397','UTS',35,'4bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('20cc6aaa-38a0-4185-bccc-585c8acb6397','UAS',35,'4bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('21cc6aaa-38a0-4185-bccc-585c8acb6397','Tugas Pemrograman 1',10,'5bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('22cc6aaa-38a0-4185-bccc-585c8acb6397','Tugas Pemrograman 2',10,'5bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('23cc6aaa-38a0-4185-bccc-585c8acb6397','Tugas Pemrograman 3',10,'5bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('24cc6aaa-38a0-4185-bccc-585c8acb6397','UTS',35,'5bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('25cc6aaa-38a0-4185-bccc-585c8acb6397','UAS',35,'5bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('26cc6aaa-38a0-4185-bccc-585c8acb6397','Tugas Pemrograman 1',10,'6bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('27cc6aaa-38a0-4185-bccc-585c8acb6397','Tugas Pemrograman 2',10,'6bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('28cc6aaa-38a0-4185-bccc-585c8acb6397','Tugas Pemrograman 3',10,'6bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('29cc6aaa-38a0-4185-bccc-585c8acb6397','UTS',35,'6bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('30cc6aaa-38a0-4185-bccc-585c8acb6397','UAS',35,'6bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('31cc6aaa-38a0-4185-bccc-585c8acb6397','Quiz 1',10,'7bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('32cc6aaa-38a0-4185-bccc-585c8acb6397','Quiz 2',10,'7bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('33cc6aaa-38a0-4185-bccc-585c8acb6397','PR 1',15,'7bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('34cc6aaa-38a0-4185-bccc-585c8acb6397','PR 2',15,'7bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('35cc6aaa-38a0-4185-bccc-585c8acb6397','UAS',50,'7bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('36cc6aaa-38a0-4185-bccc-585c8acb6397','Quiz 1',10,'8bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('37cc6aaa-38a0-4185-bccc-585c8acb6397','Quiz 2',10,'8bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('38cc6aaa-38a0-4185-bccc-585c8acb6397','PR 1',15,'8bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('39cc6aaa-38a0-4185-bccc-585c8acb6397','PR 2',15,'8bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('40cc6aaa-38a0-4185-bccc-585c8acb6397','UAS',50,'8bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('41cc6aaa-38a0-4185-bccc-585c8acb6397','PR 1',15,'10cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('42cc6aaa-38a0-4185-bccc-585c8acb6397','PR 2',15,'10cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('43cc6aaa-38a0-4185-bccc-585c8acb6397','PR 3',15,'10cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('44cc6aaa-38a0-4185-bccc-585c8acb6397','PR 4',15,'10cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('45cc6aaa-38a0-4185-bccc-585c8acb6397','UAS',40,'10cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('46cc6aaa-38a0-4185-bccc-585c8acb6397','PR 1',15,'11cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('47cc6aaa-38a0-4185-bccc-585c8acb6397','PR 2',15,'11cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('48cc6aaa-38a0-4185-bccc-585c8acb6397','PR 3',15,'11cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('49cc6aaa-38a0-4185-bccc-585c8acb6397','UTS',25,'11cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('50cc6aaa-38a0-4185-bccc-585c8acb6397','UAS',30,'11cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('51cc6aaa-38a0-4185-bccc-585c8acb6397','TK 1',15,'13cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('52cc6aaa-38a0-4185-bccc-585c8acb6397','TK 2',15,'13cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('53cc6aaa-38a0-4185-bccc-585c8acb6397','TK 3',15,'13cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('54cc6aaa-38a0-4185-bccc-585c8acb6397','TK 4',15,'13cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('55cc6aaa-38a0-4185-bccc-585c8acb6397','UAS',40,'13cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('56cc6aaa-38a0-4185-bccc-585c8acb6397','TK 1',15,'14cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('57cc6aaa-38a0-4185-bccc-585c8acb6397','TK 2',15,'14cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('58cc6aaa-38a0-4185-bccc-585c8acb6397','TK 3',15,'14cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('59cc6aaa-38a0-4185-bccc-585c8acb6397','TK 4',15,'14cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('60cc6aaa-38a0-4185-bccc-585c8acb6397','UAS',40,'14cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('61cc6aaa-38a0-4185-bccc-585c8acb6397','Sprint 1',20,'15cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('62cc6aaa-38a0-4185-bccc-585c8acb6397','Sprint 2',20,'15cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('63cc6aaa-38a0-4185-bccc-585c8acb6397','Sprint 3',20,'15cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('64cc6aaa-38a0-4185-bccc-585c8acb6397','Sprint 4',20,'15cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('65cc6aaa-38a0-4185-bccc-585c8acb6397','Quiz 1',10,'15cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('66cc6aaa-38a0-4185-bccc-585c8acb6397','Sprint 1',20,'16cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('67cc6aaa-38a0-4185-bccc-585c8acb6397','Sprint 2',20,'16cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('68cc6aaa-38a0-4185-bccc-585c8acb6397','Sprint 3',20,'16cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('69cc6aaa-38a0-4185-bccc-585c8acb6397','Sprint 4',20,'16cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('70cc6aaa-38a0-4185-bccc-585c8acb6397','Quiz 1 ',10,'16cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('71cc6aaa-38a0-4185-bccc-585c8acb6397','Lab',10,'17cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('72cc6aaa-38a0-4185-bccc-585c8acb6397','TK',40,'17cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('73cc6aaa-38a0-4185-bccc-585c8acb6397','UTS',25,'17cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('74cc6aaa-38a0-4185-bccc-585c8acb6397','UAS',25,'17cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('75cc6aaa-38a0-4185-bccc-585c8acb6397','Partisipasi',5,'17cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('76cc6aaa-38a0-4185-bccc-585c8acb6397','Lab',10,'18cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('77cc6aaa-38a0-4185-bccc-585c8acb6397','TK',40,'18cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('78cc6aaa-38a0-4185-bccc-585c8acb6397','UTS',25,'18cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('79cc6aaa-38a0-4185-bccc-585c8acb6397','UAS',25,'18cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('80cc6aaa-38a0-4185-bccc-585c8acb6397','Quiz',5,'18cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('81cc6aaa-38a0-4185-bccc-585c8acb6397','Lab',10,'19cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('82cc6aaa-38a0-4185-bccc-585c8acb6397','TK',40,'19cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('83cc6aaa-38a0-4185-bccc-585c8acb6397','UTS',25,'19cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('84cc6aaa-38a0-4185-bccc-585c8acb6397','UAS',25,'19cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('85cc6aaa-38a0-4185-bccc-585c8acb6397','Artikel',5,'19cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('86cc6aaa-38a0-4185-bccc-585c8acb6397','Lab',15,'20cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('87cc6aaa-38a0-4185-bccc-585c8acb6397','TK 1',20,'20cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('88cc6aaa-38a0-4185-bccc-585c8acb6397','TK 2',20,'20cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('89cc6aaa-38a0-4185-bccc-585c8acb6397','UAS',35,'20cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('90cc6aaa-38a0-4185-bccc-585c8acb6397','Partisipasi',10,'20cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('91cc6aaa-38a0-4185-bccc-585c8acb6397','Lab',15,'21cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('92cc6aaa-38a0-4185-bccc-585c8acb6397','TK 1',20,'21cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('93cc6aaa-38a0-4185-bccc-585c8acb6397','TK 2',20,'21cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('94cc6aaa-38a0-4185-bccc-585c8acb6397','UAS',35,'21cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('95cc6aaa-38a0-4185-bccc-585c8acb6397','Partisipasi',10,'21cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('96cc6aaa-38a0-4185-bccc-585c8acb6397','Quiz 1',10,'8bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('97cc6aaa-38a0-4185-bccc-585c8acb6397','Quiz 2',10,'8bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('98cc6aaa-38a0-4185-bccc-585c8acb6397','PR 1',15,'8bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('99cc6aaa-38a0-4185-bccc-585c8acb6397','PR 2',15,'8bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('100c6aaa-38a0-4185-bccc-585c8acb6397','UAS',50,'8bcc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('101c6aaa-38a0-4185-bccc-585c8acb6397','PR 1',15,'11cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('102c6aaa-38a0-4185-bccc-585c8acb6397','PR 2',15,'11cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('103c6aaa-38a0-4185-bccc-585c8acb6397','PR 3',15,'11cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('104c6aaa-38a0-4185-bccc-585c8acb6397','UTS',25,'11cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl'),
('105c6aaa-38a0-4185-bccc-585c8acb6397','UAS',30,'11cc6aaa-38a0-4185-bccc-585c8acb6397','komponen_penilaian_impl','siakreborn.komponenpenilaian.core.KomponenPenilaianImpl')
ON CONFLICT DO NOTHING;

INSERT INTO komponen_penilaian_impl (id) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('5bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('6bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('7bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('8bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('9bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('10cc6aaa-38a0-4185-bccc-585c8acb6397'),
('11cc6aaa-38a0-4185-bccc-585c8acb6397'),
('12cc6aaa-38a0-4185-bccc-585c8acb6397'),
('13cc6aaa-38a0-4185-bccc-585c8acb6397'),
('14cc6aaa-38a0-4185-bccc-585c8acb6397'),
('15cc6aaa-38a0-4185-bccc-585c8acb6397'),
('16cc6aaa-38a0-4185-bccc-585c8acb6397'),
('17cc6aaa-38a0-4185-bccc-585c8acb6397'),
('18cc6aaa-38a0-4185-bccc-585c8acb6397'),
('19cc6aaa-38a0-4185-bccc-585c8acb6397'),
('20cc6aaa-38a0-4185-bccc-585c8acb6397'),
('21cc6aaa-38a0-4185-bccc-585c8acb6397'),
('22cc6aaa-38a0-4185-bccc-585c8acb6397'),
('23cc6aaa-38a0-4185-bccc-585c8acb6397'),
('24cc6aaa-38a0-4185-bccc-585c8acb6397'),
('25cc6aaa-38a0-4185-bccc-585c8acb6397'),
('26cc6aaa-38a0-4185-bccc-585c8acb6397'),
('27cc6aaa-38a0-4185-bccc-585c8acb6397'),
('28cc6aaa-38a0-4185-bccc-585c8acb6397'),
('29cc6aaa-38a0-4185-bccc-585c8acb6397'),
('30cc6aaa-38a0-4185-bccc-585c8acb6397'),
('31cc6aaa-38a0-4185-bccc-585c8acb6397'),
('32cc6aaa-38a0-4185-bccc-585c8acb6397'),
('33cc6aaa-38a0-4185-bccc-585c8acb6397'),
('34cc6aaa-38a0-4185-bccc-585c8acb6397'),
('35cc6aaa-38a0-4185-bccc-585c8acb6397'),
('36cc6aaa-38a0-4185-bccc-585c8acb6397'),
('37cc6aaa-38a0-4185-bccc-585c8acb6397'),
('38cc6aaa-38a0-4185-bccc-585c8acb6397'),
('39cc6aaa-38a0-4185-bccc-585c8acb6397'),
('40cc6aaa-38a0-4185-bccc-585c8acb6397'),
('41cc6aaa-38a0-4185-bccc-585c8acb6397'),
('42cc6aaa-38a0-4185-bccc-585c8acb6397'),
('43cc6aaa-38a0-4185-bccc-585c8acb6397'),
('44cc6aaa-38a0-4185-bccc-585c8acb6397'),
('45cc6aaa-38a0-4185-bccc-585c8acb6397'),
('46cc6aaa-38a0-4185-bccc-585c8acb6397'),
('47cc6aaa-38a0-4185-bccc-585c8acb6397'),
('48cc6aaa-38a0-4185-bccc-585c8acb6397'),
('49cc6aaa-38a0-4185-bccc-585c8acb6397'),
('50cc6aaa-38a0-4185-bccc-585c8acb6397'),
('51cc6aaa-38a0-4185-bccc-585c8acb6397'),
('52cc6aaa-38a0-4185-bccc-585c8acb6397'),
('53cc6aaa-38a0-4185-bccc-585c8acb6397'),
('54cc6aaa-38a0-4185-bccc-585c8acb6397'),
('55cc6aaa-38a0-4185-bccc-585c8acb6397'),
('56cc6aaa-38a0-4185-bccc-585c8acb6397'),
('57cc6aaa-38a0-4185-bccc-585c8acb6397'),
('58cc6aaa-38a0-4185-bccc-585c8acb6397'),
('59cc6aaa-38a0-4185-bccc-585c8acb6397'),
('60cc6aaa-38a0-4185-bccc-585c8acb6397'),
('61cc6aaa-38a0-4185-bccc-585c8acb6397'),
('62cc6aaa-38a0-4185-bccc-585c8acb6397'),
('63cc6aaa-38a0-4185-bccc-585c8acb6397'),
('64cc6aaa-38a0-4185-bccc-585c8acb6397'),
('65cc6aaa-38a0-4185-bccc-585c8acb6397'),
('66cc6aaa-38a0-4185-bccc-585c8acb6397'),
('67cc6aaa-38a0-4185-bccc-585c8acb6397'),
('68cc6aaa-38a0-4185-bccc-585c8acb6397'),
('69cc6aaa-38a0-4185-bccc-585c8acb6397'),
('70cc6aaa-38a0-4185-bccc-585c8acb6397'),
('71cc6aaa-38a0-4185-bccc-585c8acb6397'),
('72cc6aaa-38a0-4185-bccc-585c8acb6397'),
('73cc6aaa-38a0-4185-bccc-585c8acb6397'),
('74cc6aaa-38a0-4185-bccc-585c8acb6397'),
('75cc6aaa-38a0-4185-bccc-585c8acb6397'),
('76cc6aaa-38a0-4185-bccc-585c8acb6397'),
('77cc6aaa-38a0-4185-bccc-585c8acb6397'),
('78cc6aaa-38a0-4185-bccc-585c8acb6397'),
('79cc6aaa-38a0-4185-bccc-585c8acb6397'),
('80cc6aaa-38a0-4185-bccc-585c8acb6397'),
('81cc6aaa-38a0-4185-bccc-585c8acb6397'),
('82cc6aaa-38a0-4185-bccc-585c8acb6397'),
('83cc6aaa-38a0-4185-bccc-585c8acb6397'),
('84cc6aaa-38a0-4185-bccc-585c8acb6397'),
('85cc6aaa-38a0-4185-bccc-585c8acb6397'),
('86cc6aaa-38a0-4185-bccc-585c8acb6397'),
('87cc6aaa-38a0-4185-bccc-585c8acb6397'),
('88cc6aaa-38a0-4185-bccc-585c8acb6397'),
('89cc6aaa-38a0-4185-bccc-585c8acb6397'),
('90cc6aaa-38a0-4185-bccc-585c8acb6397'),
('91cc6aaa-38a0-4185-bccc-585c8acb6397'),
('92cc6aaa-38a0-4185-bccc-585c8acb6397'),
('93cc6aaa-38a0-4185-bccc-585c8acb6397'),
('94cc6aaa-38a0-4185-bccc-585c8acb6397'),
('95cc6aaa-38a0-4185-bccc-585c8acb6397'),
('96cc6aaa-38a0-4185-bccc-585c8acb6397'),
('97cc6aaa-38a0-4185-bccc-585c8acb6397'),
('98cc6aaa-38a0-4185-bccc-585c8acb6397'),
('99cc6aaa-38a0-4185-bccc-585c8acb6397'),
('100c6aaa-38a0-4185-bccc-585c8acb6397'),
('101c6aaa-38a0-4185-bccc-585c8acb6397'),
('102c6aaa-38a0-4185-bccc-585c8acb6397'),
('103c6aaa-38a0-4185-bccc-585c8acb6397'),
('104c6aaa-38a0-4185-bccc-585c8acb6397'),
('105c6aaa-38a0-4185-bccc-585c8acb6397')
ON CONFLICT DO NOTHING;

INSERT INTO penilaian_comp (id, nilai, komponenpenilaian_id, mahasiswa_id, modulesequence, objectname) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397',90,'61cc6aaa-38a0-4185-bccc-585c8acb6397','3bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397',75,'62cc6aaa-38a0-4185-bccc-585c8acb6397','3bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397',100,'63cc6aaa-38a0-4185-bccc-585c8acb6397','3bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397',60,'64cc6aaa-38a0-4185-bccc-585c8acb6397','3bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('5bcc6aaa-38a0-4185-bccc-585c8acb6397',50,'65cc6aaa-38a0-4185-bccc-585c8acb6397','3bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('6bcc6aaa-38a0-4185-bccc-585c8acb6397',72,'61cc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('7bcc6aaa-38a0-4185-bccc-585c8acb6397',63,'62cc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('8bcc6aaa-38a0-4185-bccc-585c8acb6397',90,'63cc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('9bcc6aaa-38a0-4185-bccc-585c8acb6397',57,'64cc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('10cc6aaa-38a0-4185-bccc-585c8acb6397',96,'65cc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('11cc6aaa-38a0-4185-bccc-585c8acb6397',91,'61cc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('12cc6aaa-38a0-4185-bccc-585c8acb6397',79,'62cc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('13cc6aaa-38a0-4185-bccc-585c8acb6397',82,'63cc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('14cc6aaa-38a0-4185-bccc-585c8acb6397',89,'64cc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('15cc6aaa-38a0-4185-bccc-585c8acb6397',75,'65cc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('16cc6aaa-38a0-4185-bccc-585c8acb6397',100,'86cc6aaa-38a0-4185-bccc-585c8acb6397','2bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('17cc6aaa-38a0-4185-bccc-585c8acb6397',68,'87cc6aaa-38a0-4185-bccc-585c8acb6397','2bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('18cc6aaa-38a0-4185-bccc-585c8acb6397',68,'88cc6aaa-38a0-4185-bccc-585c8acb6397','2bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('19cc6aaa-38a0-4185-bccc-585c8acb6397',76,'89cc6aaa-38a0-4185-bccc-585c8acb6397','2bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('20cc6aaa-38a0-4185-bccc-585c8acb6397',81,'90cc6aaa-38a0-4185-bccc-585c8acb6397','2bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('21cc6aaa-38a0-4185-bccc-585c8acb6397',71,'86cc6aaa-38a0-4185-bccc-585c8acb6397','1bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('22cc6aaa-38a0-4185-bccc-585c8acb6397',78,'87cc6aaa-38a0-4185-bccc-585c8acb6397','1bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('23cc6aaa-38a0-4185-bccc-585c8acb6397',78,'88cc6aaa-38a0-4185-bccc-585c8acb6397','1bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('24cc6aaa-38a0-4185-bccc-585c8acb6397',60,'89cc6aaa-38a0-4185-bccc-585c8acb6397','1bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('25cc6aaa-38a0-4185-bccc-585c8acb6397',71,'90cc6aaa-38a0-4185-bccc-585c8acb6397','1bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('26cc6aaa-38a0-4185-bccc-585c8acb6397',91,'46cc6aaa-38a0-4185-bccc-585c8acb6397','6bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('27cc6aaa-38a0-4185-bccc-585c8acb6397',65,'47cc6aaa-38a0-4185-bccc-585c8acb6397','6bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('28cc6aaa-38a0-4185-bccc-585c8acb6397',59,'48cc6aaa-38a0-4185-bccc-585c8acb6397','6bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('29cc6aaa-38a0-4185-bccc-585c8acb6397',81,'49cc6aaa-38a0-4185-bccc-585c8acb6397','6bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('30cc6aaa-38a0-4185-bccc-585c8acb6397',70,'50cc6aaa-38a0-4185-bccc-585c8acb6397','6bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('31cc6aaa-38a0-4185-bccc-585c8acb6397',69,'46cc6aaa-38a0-4185-bccc-585c8acb6397','7bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('32cc6aaa-38a0-4185-bccc-585c8acb6397',57,'47cc6aaa-38a0-4185-bccc-585c8acb6397','7bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('33cc6aaa-38a0-4185-bccc-585c8acb6397',77,'48cc6aaa-38a0-4185-bccc-585c8acb6397','7bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('34cc6aaa-38a0-4185-bccc-585c8acb6397',85,'49cc6aaa-38a0-4185-bccc-585c8acb6397','7bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('35cc6aaa-38a0-4185-bccc-585c8acb6397',60,'50cc6aaa-38a0-4185-bccc-585c8acb6397','7bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('36cc6aaa-38a0-4185-bccc-585c8acb6397',71,'16cc6aaa-38a0-4185-bccc-585c8acb6397','3bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('37cc6aaa-38a0-4185-bccc-585c8acb6397',64,'17cc6aaa-38a0-4185-bccc-585c8acb6397','3bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('38cc6aaa-38a0-4185-bccc-585c8acb6397',56,'18cc6aaa-38a0-4185-bccc-585c8acb6397','3bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('39cc6aaa-38a0-4185-bccc-585c8acb6397',55,'19cc6aaa-38a0-4185-bccc-585c8acb6397','3bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('40cc6aaa-38a0-4185-bccc-585c8acb6397',59,'20cc6aaa-38a0-4185-bccc-585c8acb6397','3bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('41cc6aaa-38a0-4185-bccc-585c8acb6397',57,'16cc6aaa-38a0-4185-bccc-585c8acb6397','1bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('42cc6aaa-38a0-4185-bccc-585c8acb6397',85,'17cc6aaa-38a0-4185-bccc-585c8acb6397','1bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('43cc6aaa-38a0-4185-bccc-585c8acb6397',79,'18cc6aaa-38a0-4185-bccc-585c8acb6397','1bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('44cc6aaa-38a0-4185-bccc-585c8acb6397',79,'19cc6aaa-38a0-4185-bccc-585c8acb6397','1bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('45cc6aaa-38a0-4185-bccc-585c8acb6397',89,'20cc6aaa-38a0-4185-bccc-585c8acb6397','1bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('46cc6aaa-38a0-4185-bccc-585c8acb6397',82,'21cc6aaa-38a0-4185-bccc-585c8acb6397','2bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('47cc6aaa-38a0-4185-bccc-585c8acb6397',77,'22cc6aaa-38a0-4185-bccc-585c8acb6397','2bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('48cc6aaa-38a0-4185-bccc-585c8acb6397',62,'23cc6aaa-38a0-4185-bccc-585c8acb6397','2bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('49cc6aaa-38a0-4185-bccc-585c8acb6397',57,'24cc6aaa-38a0-4185-bccc-585c8acb6397','2bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('50cc6aaa-38a0-4185-bccc-585c8acb6397',93,'25cc6aaa-38a0-4185-bccc-585c8acb6397','2bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('51cc6aaa-38a0-4185-bccc-585c8acb6397',95,'21cc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('52cc6aaa-38a0-4185-bccc-585c8acb6397',66,'22cc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('53cc6aaa-38a0-4185-bccc-585c8acb6397',64,'23cc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('54cc6aaa-38a0-4185-bccc-585c8acb6397',91,'24cc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('55cc6aaa-38a0-4185-bccc-585c8acb6397',89,'25cc6aaa-38a0-4185-bccc-585c8acb6397','4bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('56cc6aaa-38a0-4185-bccc-585c8acb6397',83,'26cc6aaa-38a0-4185-bccc-585c8acb6397','6bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('57cc6aaa-38a0-4185-bccc-585c8acb6397',66,'27cc6aaa-38a0-4185-bccc-585c8acb6397','6bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('58cc6aaa-38a0-4185-bccc-585c8acb6397',68,'28cc6aaa-38a0-4185-bccc-585c8acb6397','6bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('59cc6aaa-38a0-4185-bccc-585c8acb6397',58,'29cc6aaa-38a0-4185-bccc-585c8acb6397','6bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('60cc6aaa-38a0-4185-bccc-585c8acb6397',89,'30cc6aaa-38a0-4185-bccc-585c8acb6397','6bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('61cc6aaa-38a0-4185-bccc-585c8acb6397',72,'26cc6aaa-38a0-4185-bccc-585c8acb6397','7bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('62cc6aaa-38a0-4185-bccc-585c8acb6397',90,'27cc6aaa-38a0-4185-bccc-585c8acb6397','7bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('63cc6aaa-38a0-4185-bccc-585c8acb6397',82,'28cc6aaa-38a0-4185-bccc-585c8acb6397','7bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('64cc6aaa-38a0-4185-bccc-585c8acb6397',77,'29cc6aaa-38a0-4185-bccc-585c8acb6397','7bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl'),
('65cc6aaa-38a0-4185-bccc-585c8acb6397',57,'30cc6aaa-38a0-4185-bccc-585c8acb6397','7bcc6aaa-38a0-4185-bccc-585c8acb6397','penilaian_impl','siakreborn.penilaian.core.PenilaianImpl')
ON CONFLICT DO NOTHING;

INSERT INTO penilaian_impl (id) VALUES
('1bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('2bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('3bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('4bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('5bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('6bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('7bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('8bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('9bcc6aaa-38a0-4185-bccc-585c8acb6397'),
('10cc6aaa-38a0-4185-bccc-585c8acb6397'),
('11cc6aaa-38a0-4185-bccc-585c8acb6397'),
('12cc6aaa-38a0-4185-bccc-585c8acb6397'),
('13cc6aaa-38a0-4185-bccc-585c8acb6397'),
('14cc6aaa-38a0-4185-bccc-585c8acb6397'),
('15cc6aaa-38a0-4185-bccc-585c8acb6397'),
('16cc6aaa-38a0-4185-bccc-585c8acb6397'),
('17cc6aaa-38a0-4185-bccc-585c8acb6397'),
('18cc6aaa-38a0-4185-bccc-585c8acb6397'),
('19cc6aaa-38a0-4185-bccc-585c8acb6397'),
('20cc6aaa-38a0-4185-bccc-585c8acb6397'),
('21cc6aaa-38a0-4185-bccc-585c8acb6397'),
('22cc6aaa-38a0-4185-bccc-585c8acb6397'),
('23cc6aaa-38a0-4185-bccc-585c8acb6397'),
('24cc6aaa-38a0-4185-bccc-585c8acb6397'),
('25cc6aaa-38a0-4185-bccc-585c8acb6397'),
('26cc6aaa-38a0-4185-bccc-585c8acb6397'),
('27cc6aaa-38a0-4185-bccc-585c8acb6397'),
('28cc6aaa-38a0-4185-bccc-585c8acb6397'),
('29cc6aaa-38a0-4185-bccc-585c8acb6397'),
('30cc6aaa-38a0-4185-bccc-585c8acb6397'),
('31cc6aaa-38a0-4185-bccc-585c8acb6397'),
('32cc6aaa-38a0-4185-bccc-585c8acb6397'),
('33cc6aaa-38a0-4185-bccc-585c8acb6397'),
('34cc6aaa-38a0-4185-bccc-585c8acb6397'),
('35cc6aaa-38a0-4185-bccc-585c8acb6397'),
('36cc6aaa-38a0-4185-bccc-585c8acb6397'),
('37cc6aaa-38a0-4185-bccc-585c8acb6397'),
('38cc6aaa-38a0-4185-bccc-585c8acb6397'),
('39cc6aaa-38a0-4185-bccc-585c8acb6397'),
('40cc6aaa-38a0-4185-bccc-585c8acb6397'),
('41cc6aaa-38a0-4185-bccc-585c8acb6397'),
('42cc6aaa-38a0-4185-bccc-585c8acb6397'),
('43cc6aaa-38a0-4185-bccc-585c8acb6397'),
('44cc6aaa-38a0-4185-bccc-585c8acb6397'),
('45cc6aaa-38a0-4185-bccc-585c8acb6397'),
('46cc6aaa-38a0-4185-bccc-585c8acb6397'),
('47cc6aaa-38a0-4185-bccc-585c8acb6397'),
('48cc6aaa-38a0-4185-bccc-585c8acb6397'),
('49cc6aaa-38a0-4185-bccc-585c8acb6397'),
('50cc6aaa-38a0-4185-bccc-585c8acb6397'),
('51cc6aaa-38a0-4185-bccc-585c8acb6397'),
('52cc6aaa-38a0-4185-bccc-585c8acb6397'),
('53cc6aaa-38a0-4185-bccc-585c8acb6397'),
('54cc6aaa-38a0-4185-bccc-585c8acb6397'),
('55cc6aaa-38a0-4185-bccc-585c8acb6397'),
('56cc6aaa-38a0-4185-bccc-585c8acb6397'),
('57cc6aaa-38a0-4185-bccc-585c8acb6397'),
('58cc6aaa-38a0-4185-bccc-585c8acb6397'),
('59cc6aaa-38a0-4185-bccc-585c8acb6397'),
('60cc6aaa-38a0-4185-bccc-585c8acb6397'),
('61cc6aaa-38a0-4185-bccc-585c8acb6397'),
('62cc6aaa-38a0-4185-bccc-585c8acb6397'),
('63cc6aaa-38a0-4185-bccc-585c8acb6397'),
('64cc6aaa-38a0-4185-bccc-585c8acb6397'),
('65cc6aaa-38a0-4185-bccc-585c8acb6397')
ON CONFLICT DO NOTHING;

INSERT INTO payment_comp (idtransaction, amount, vendorname, modulesequence) VALUES
(18740,5000000,'Oy',null),
(79964,5000000,'Oy','payment_impl, paymentlink_impl'),
(12430,5000000,'Oy',null),
(16365,5000000,'Oy','payment_impl, paymentlink_impl'),
(32768,5000000,'Oy',null),
(31324,5000000,'Oy','payment_impl, paymentlink_impl'),
(67520,5000000,'Oy',null),
(23422,5000000,'Oy','payment_impl, paymentlink_impl')
ON CONFLICT DO NOTHING;

INSERT INTO payment_impl (idtransaction) VALUES
(79964),
(16365),
(31324),
(23422)
ON CONFLICT DO NOTHING;

INSERT INTO paymentlink_impl (id, paymentlink, idtransaction, record_idtransaction, recordname, base_component_id) VALUES
(79964,'https://pay-stg.oyindonesia.com/197b90a0-91dd-4b0d-9e7f-58a7326474f6',18740,79964,'paymentgateway.payment.core.PaymentImpl',79964),
(16365,'https://pay-stg.oyindonesia.com/9d77ea16-cf83-4e83-b126-b9db3bab7ed2',12430,16365,'paymentgateway.payment.core.PaymentImpl',16365),
(31324,'https://pay-stg.oyindonesia.com/87309035-7293-4730-bc75-a0d21d8b4aa9',32768,31324,'paymentgateway.payment.core.PaymentImpl',31324),
(23422,'https://pay-stg.oyindonesia.com/7dcdcef8-f30f-4a8f-9265-69772c17822f',67520,23422,'paymentgateway.payment.core.PaymentImpl',23422)
ON CONFLICT DO NOTHING;

INSERT INTO pembayaran_comp (id, objectname, paymentid, paymentlink, status, vendor, mahasiswa_id, semester_id, modulesequence) VALUES
('3f0f852b-b473-4071-89a8-ba8db5baebf3','siakreborn.pembayaran.core.PembayaranComponent','79964','https://pay-stg.oyindonesia.com/197b90a0-91dd-4b0d-9e7f-58a7326474f6','SUCCESSFUL','Oy','1bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','pembayaran_impl'),
('e15961b6-3236-4d3a-943c-fa0b65b9df51','siakreborn.pembayaran.core.PembayaranComponent','16365','https://pay-stg.oyindonesia.com/9d77ea16-cf83-4e83-b126-b9db3bab7ed2','SUCCESSFUL','Oy','3bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','pembayaran_impl'),
('0d4e3545-62d1-4e0e-83b2-3d729fa7fd1a','siakreborn.pembayaran.core.PembayaranComponent','31324','https://pay-stg.oyindonesia.com/87309035-7293-4730-bc75-a0d21d8b4aa9','SUCCESSFUL','Oy','6bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','pembayaran_impl'),
('22cb5272-db97-4b69-bb11-96fbec9d8cbf','siakreborn.pembayaran.core.PembayaranComponent','23422','https://pay-stg.oyindonesia.com/7dcdcef8-f30f-4a8f-9265-69772c17822f','SUCCESSFUL','Oy','7bcc6aaa-38a0-4185-bccc-585c8acb6397','5bcc6aaa-38a0-4185-bccc-585c8acb6397','pembayaran_impl')
ON CONFLICT DO NOTHING;

INSERT INTO pembayaran_impl (id) VALUES
('3f0f852b-b473-4071-89a8-ba8db5baebf3'),
('e15961b6-3236-4d3a-943c-fa0b65b9df51'),
('0d4e3545-62d1-4e0e-83b2-3d729fa7fd1a'),
('22cb5272-db97-4b69-bb11-96fbec9d8cbf')
ON CONFLICT DO NOTHING;