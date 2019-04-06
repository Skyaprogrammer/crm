package jack.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import jack.domain.Customer;

public interface CustomerDao extends BaseDao<Customer>{

	Integer getTotalCount(DetachedCriteria dc);

	List<Customer> getPageList(DetachedCriteria dc, int start, Integer pageSize);

}
