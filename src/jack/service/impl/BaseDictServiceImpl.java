package jack.service.impl;

import java.util.List;

import jack.dao.BaseDictDao;
import jack.domain.BaseDict;
import jack.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {

	private BaseDictDao bdd;
	
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		// TODO Auto-generated method stub
		return bdd.getListByTypeCode(dict_type_code);
	}

	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}

	
}
