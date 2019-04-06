package jack.service;

import org.hibernate.criterion.DetachedCriteria;

import jack.domain.Customer;
import jack.utils.PageBean;

public interface CustomerService {

	//��ҳ
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	//�����û�
	void save(Customer customer);

	Customer getById(Long cust_id);

}
