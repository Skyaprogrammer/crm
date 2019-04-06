package jack.dao;

import java.util.List;

import jack.domain.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict>{

	List<BaseDict> getListByTypeCode(String dict_type_code);

}
