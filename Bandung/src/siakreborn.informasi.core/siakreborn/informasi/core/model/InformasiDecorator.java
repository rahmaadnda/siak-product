package siakreborn.informasi.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
// add other required packages

@MappedSuperclass
public abstract class InformasiDecorator extends InformasiComponent {
    @OneToOne(cascade = CascadeType.ALL)
    protected InformasiComponent record;

    public InformasiDecorator(InformasiComponent record) {
        this.id = UUID.randomUUID();
        this.record = record;
    }

    public InformasiDecorator(UUID id, InformasiComponent record) {
        this.id = id;
        this.record = record;
    }

    public InformasiDecorator() {
        super();
        this.id = UUID.randomUUID();
        this.record = new InformasiImpl();
    }

    public InformasiComponent getRecord() {
        return this.record;
    }

    public void setRecord(InformasiComponent record) {
        this.record = record;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getJudul() {
        return record.getJudul();
    }

    public void setJudul(String judul) {
        record.setJudul(judul);
    }

    public String getDeskripsi() {
        return record.getDeskripsi();
    }

    public void setDeskripsi(String deskripsi) {
        record.setDeskripsi(deskripsi);
    }

    public Date getTanggalPublikasi() {
        return record.getTanggalPublikasi();
    }

    public void setTanggalPublikasi(Date tanggalPublikasi) {
        record.setTanggalPublikasi(tanggalPublikasi);
    }

    public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }
}
