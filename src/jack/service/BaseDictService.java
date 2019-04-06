package jack.service;

import java.util.List;

import jack.domain.BaseDict;

public interface BaseDictService {

	List<BaseDict> getListByTypeCode(String dict_type_code);

}
