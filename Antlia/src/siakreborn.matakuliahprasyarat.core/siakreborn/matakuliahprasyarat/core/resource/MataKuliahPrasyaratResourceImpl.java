package siakreborn.matakuliahprasyarat.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.matakuliahprasyarat.MataKuliahPrasyaratFactory;
import vmj.auth.annotations.Restricted;
//add other required packages
import siakreborn.matakuliah.core.MataKuliah;

public class MataKuliahPrasyaratResourceImpl extends MataKuliahPrasyaratResourceComponent {
	private MataKuliahPrasyaratService mataKuliahPrasyaratService = new MataKuliahPrasyaratServiceImpl();

	@Restricted(permissionName = "SaveMataKuliahPrasyarat")
    @Route(url="call/matakuliahprasyarat/save")
    public List<HashMap<String,Object>> saveMataKuliahPrasyarat(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		List<MataKuliahPrasyarat> mataKuliahPrasyaratList = mataKuliahPrasyaratService
        	.saveMataKuliahPrasyarat((HashMap<String, Object>) vmjExchange.getPayload());
    return mataKuliahPrasyaratService.transformMataKuliahPrasyaratListToHashMap(mataKuliahPrasyaratList);
	}

	@Restricted(permissionName = "UpdateMataKuliahPrasyarat")
    @Route(url="call/matakuliahprasyarat/update")
    public HashMap<String, Object> updateMataKuliahPrasyarat(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		MataKuliahPrasyarat mataKuliahPrasyarat = mataKuliahPrasyaratService
        	.updateMataKuliahPrasyarat((HashMap<String, Object>) vmjExchange.getPayload());
		
		return mataKuliahPrasyarat.toHashMap();
		
	}

	@Restricted(permissionName = "ReadMataKuliahPrasyarat")
    @Route(url="call/matakuliahprasyarat/detail")
    public HashMap<String, Object> getMataKuliahPrasyarat(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("prasyaratId"); 
		if(idStr == null) {
			throw new IllegalArgumentException("Invalid UUID");
		  }
		  UUID id = UUID.fromString(idStr);
		MataKuliahPrasyarat mataKuliahPrasyarat = mataKuliahPrasyaratService.getMataKuliahPrasyarat(id);
		return mataKuliahPrasyarat.toHashMap();
	}

	@Restricted(permissionName = "ReadMataKuliahPrasyarat")
    @Route(url="call/matakuliahprasyarat/list")
    public List<HashMap<String,Object>> getAllMataKuliahPrasyarat(VMJExchange vmjExchange){
		List<MataKuliahPrasyarat> mataKuliahPrasyaratList = mataKuliahPrasyaratService.getAllMataKuliahPrasyarat();
		return mataKuliahPrasyaratService.transformMataKuliahPrasyaratListToHashMap(mataKuliahPrasyaratList);
	}

	@Restricted(permissionName = "ReadMataKuliahPrasyarat")
    @Route(url="call/matakuliahprasyarat/filter")
    public List<HashMap<String,Object>> getAllMataKuliahPrasyaratFromParent(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("mataKuliahId"); 
		if(idStr == null) {
			throw new IllegalArgumentException("Invalid UUID");
		}
		UUID id = UUID.fromString(idStr);
		List<MataKuliahPrasyarat> mataKuliahPrasyaratList = mataKuliahPrasyaratService.getAllMataKuliahPrasyaratFromParent(id);
		return mataKuliahPrasyaratService.transformMataKuliahPrasyaratListToHashMap(mataKuliahPrasyaratList);
	}

	@Restricted(permissionName = "DeleteMataKuliahPrasyarat")
	@Route(url="call/matakuliahprasyarat/delete")
	public List<HashMap<String,Object>> deleteMataKuliahPrasyarat(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		UUID id = UUID.fromString(idStr);
		List<MataKuliahPrasyarat> mataKuliahPrasyaratList = mataKuliahPrasyaratService.deleteMataKuliahPrasyarat(id);
		return mataKuliahPrasyaratService.transformMataKuliahPrasyaratListToHashMap(mataKuliahPrasyaratList);
	}

	@Restricted(permissionName = "ReadMataKuliahPrasyarat")
	@Route(url="call/matakuliahprasyarat/syarat")
	public List<HashMap<String,String>> listSyarat(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return mataKuliahPrasyaratService.listSyarat();
	}


}
