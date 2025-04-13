package siakreborn.matakuliahprasyarat.sudahmengambil;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.auth.annotations.Restricted;

import siakreborn.matakuliahprasyarat.core.*;

public class MataKuliahPrasyaratResourceImpl extends MataKuliahPrasyaratResourceDecorator {
	private MataKuliahPrasyaratService mataKuliahPrasyaratService;

    public MataKuliahPrasyaratResourceImpl (MataKuliahPrasyaratResourceComponent recordController, MataKuliahPrasyaratServiceComponent recordService) {
        super(recordController);
		this.mataKuliahPrasyaratService = new MataKuliahPrasyaratServiceImpl(recordService);
    }

	@Route(url="call/matakuliahprasyarat/syarat")
	public List<HashMap<String,String>> listSyarat(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return mataKuliahPrasyaratService.listSyarat();
	}
}
