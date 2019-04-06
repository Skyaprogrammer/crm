package jack.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import jack.dao.CustomerDao;
import jack.domain.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{

	
	
	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		return super.getTotalCount(dc);
	}

	public List<Customer> getPageList(DetachedCriteria dc, int start, Integer pageSize) {
		// TODO Auto-generated method stub
		return super.getPageList(dc, start, pageSize);
	}

	


	

}
