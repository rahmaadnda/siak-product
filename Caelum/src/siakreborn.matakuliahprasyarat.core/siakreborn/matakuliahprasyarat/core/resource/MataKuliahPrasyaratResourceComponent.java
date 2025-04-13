package siakreborn.matakuliahprasyarat.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class MataKuliahPrasyaratResourceComponent implements MataKuliahPrasyaratResource{
	protected RepositoryUtil<MataKuliahPrasyarat> mataKuliahPrasyaratRepository;

    public MataKuliahPrasyaratResourceComponent(){
        this.mataKuliahPrasyaratRepository = new RepositoryUtil<MataKuliahPrasyarat>(siakreborn.matakuliahprasyarat.core.MataKuliahPrasyaratComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveMataKuliahPrasyarat(VMJExchange vmjExchange);
	public abstract HashMap<String, Object> updateMataKuliahPrasyarat(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getMataKuliahPrasyarat(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllMataKuliahPrasyarat(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllMataKuliahPrasyaratFromParent(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteMataKuliahPrasyarat(VMJExchange vmjExchange);
	public abstract List<HashMap<String,String>> listSyarat(VMJExchange vmjExchange);
}
