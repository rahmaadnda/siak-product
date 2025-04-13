package siakreborn.matakuliahprasyarat.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class MataKuliahPrasyaratResourceDecorator extends MataKuliahPrasyaratResourceComponent{
	protected MataKuliahPrasyaratResourceComponent record;

    public MataKuliahPrasyaratResourceDecorator(MataKuliahPrasyaratResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveMataKuliahPrasyarat(VMJExchange vmjExchange){
		return record.saveMataKuliahPrasyarat(vmjExchange);
	}

    public HashMap<String, Object> updateMataKuliahPrasyarat(VMJExchange vmjExchange){
		return record.updateMataKuliahPrasyarat(vmjExchange);
	}

    public HashMap<String, Object> getMataKuliahPrasyarat(VMJExchange vmjExchange){
		return record.getMataKuliahPrasyarat(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllMataKuliahPrasyarat(VMJExchange vmjExchange){
		return record.getAllMataKuliahPrasyarat(vmjExchange);
	}

	public List<HashMap<String,Object>> getAllMataKuliahPrasyaratFromParent(VMJExchange vmjExchange){
		return record.getAllMataKuliahPrasyaratFromParent(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteMataKuliahPrasyarat(VMJExchange vmjExchange){
		return record.deleteMataKuliahPrasyarat(vmjExchange);
	}

	public List<HashMap<String,String>> listSyarat(VMJExchange vmjExchange){
		return record.listSyarat(vmjExchange);
	}

}
