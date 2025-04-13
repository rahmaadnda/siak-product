package siakreborn.informasi.akademik;

import siakreborn.informasi.core.*;
import siakreborn.adminakademik.core.*;

import siakreborn.util.core.Util;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.OneToOne;

import java.util.*;

@Entity(name = "informasi_akademik")
@Table(name = "informasi_akademik")
public class InformasiImpl extends InformasiDecorator {

    @OneToOne(targetEntity = siakreborn.adminakademik.core.AdminAkademikComponent.class)
    public AdminAkademik adminAkademik;

    public InformasiImpl() {
        super();
        this.objectName = InformasiImpl.class.getName();
    }

    public InformasiImpl(AdminAkademik adminAkademik) {
        super();
        this.adminAkademik = adminAkademik;
        this.objectName = InformasiImpl.class.getName();
    }

    public InformasiImpl(InformasiComponent record, AdminAkademik adminAkademik) {
        super(record);
        this.adminAkademik = adminAkademik;
        this.objectName = InformasiImpl.class.getName();
    }

    public InformasiImpl(UUID id, InformasiComponent record, AdminAkademik adminAkademik) {
        super(id, record);
        this.adminAkademik = adminAkademik;
        this.objectName = InformasiImpl.class.getName();
    }

    public AdminAkademik getAdminAkademik() {
        return adminAkademik;
    }

    public void setAdminAkademik(AdminAkademik adminAkademik) {
        this.adminAkademik = adminAkademik;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", record='" + getRecord() + "'" +
            ", adminAkademik='" + getAdminAkademik() + "'" +
            "}";
    }

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> informasiMap = record.toHashMap();
        informasiMap.put("id", this.getId());
        informasiMap = Util.combine(informasiMap, ((AdminAkademikComponent) this.getAdminAkademik()).toHashMap(), "adminAkademik");
        return informasiMap;
    }
}