package jack.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import jack.dao.BaseDictDao;
import jack.domain.BaseDict;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {

	
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		//采用离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		
		dc.add(Restrictions.eq("dict_type_code", dict_type_code));
		
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);
		
		return list;
	}

}
