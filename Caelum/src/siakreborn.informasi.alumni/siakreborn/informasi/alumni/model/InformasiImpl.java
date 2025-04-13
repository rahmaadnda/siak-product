package siakreborn.informasi.alumni;

import siakreborn.informasi.core.*;
import siakreborn.observer.core.Observer;
import siakreborn.observer.alumni.*;

import siakreborn.util.core.Util;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.OneToOne;

import java.util.*;

@Entity(name = "informasi_alumni")
@Table(name = "informasi_alumni")
public class InformasiImpl extends InformasiDecorator {

    @OneToOne(targetEntity = siakreborn.observer.alumni.ObserverImpl.class)
    public Observer alumni;

    public InformasiImpl() {
        super();
        this.objectName = InformasiImpl.class.getName();
    }

    public InformasiImpl(Observer alumni) {
        super();
        this.alumni = alumni;
        this.objectName = InformasiImpl.class.getName();
    }

    public InformasiImpl(InformasiComponent record, Observer alumni) {
        super(record);
        this.alumni = alumni;
        this.objectName = InformasiImpl.class.getName();
    }

    public InformasiImpl(UUID id, InformasiComponent record, Observer alumni) {
        super(id, record);
        this.alumni = alumni;
        this.objectName = InformasiImpl.class.getName();
    }

    public Observer getAlumni() {
        return alumni;
    }

    public void setAlumni(Observer alumni) {
        this.alumni = alumni;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", record='" + getRecord() + "'" +
            ", alumni='" + getAlumni() + "'" +
            "}";
    }

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> informasiMap = record.toHashMap();
        informasiMap.put("id", this.getId());
        informasiMap = Util.combine(informasiMap, ((ObserverImpl) this.getAlumni()).toHashMap(), "alumni");
        return informasiMap;
    }
}