package jack.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import jack.dao.CustomerDao;
import jack.domain.Customer;
import jack.service.CustomerService;
import jack.utils.PageBean;

public class CustomerServiceImpl implements CustomerService{

	private CustomerDao cd;
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}
	//为了增强代码的复用性，所以不需要传入customer，直接传入一个离线查询对象，可以有效的增强代码的复用性
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//书写业务逻辑
		//1.利用dao层实现查询总条数
		Integer totalCount = cd.getTotalCount(dc);
		//2.创建pageBean对象，有其构造方法 
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3.获取list,注意这个集合不是所有的集合，而是分页数据的集合
		List<Customer> list = cd.getPageList(dc,pb.getStart(),pb.getPageSize()); 
		//4.放入list
		pb.setList(list);
		//返回所给的list数据
		return pb;
	}
	
	public void save(Customer customer) {

		//1.维护Custoemr与数据字典对象的关系
		//我们已经利用数据字典的id属性保存了属性，所以不需要进行多余的维护关秀
		//2.调用Dao保存用户
		cd.save(customer);
	}
	public Customer getById(Long cust_id) {
		// TODO Auto-generated method stub
		return cd.getById(cust_id);
		
	}

	
}
