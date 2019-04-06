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
	//Ϊ����ǿ����ĸ����ԣ����Բ���Ҫ����customer��ֱ�Ӵ���һ�����߲�ѯ���󣬿�����Ч����ǿ����ĸ�����
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//��дҵ���߼�
		//1.����dao��ʵ�ֲ�ѯ������
		Integer totalCount = cd.getTotalCount(dc);
		//2.����pageBean�������乹�췽�� 
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3.��ȡlist,ע��������ϲ������еļ��ϣ����Ƿ�ҳ���ݵļ���
		List<Customer> list = cd.getPageList(dc,pb.getStart(),pb.getPageSize()); 
		//4.����list
		pb.setList(list);
		//����������list����
		return pb;
	}
	
	public void save(Customer customer) {

		//1.ά��Custoemr�������ֵ����Ĺ�ϵ
		//�����Ѿ����������ֵ��id���Ա��������ԣ����Բ���Ҫ���ж����ά������
		//2.����Dao�����û�
		cd.save(customer);
	}
	public Customer getById(Long cust_id) {
		// TODO Auto-generated method stub
		return cd.getById(cust_id);
		
	}

	
}
