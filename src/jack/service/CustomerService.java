package jack.service;

import org.hibernate.criterion.DetachedCriteria;

import jack.domain.Customer;
import jack.utils.PageBean;

public interface CustomerService {

	//分页
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	//保存用户
	void save(Customer customer);

	Customer getById(Long cust_id);

}
