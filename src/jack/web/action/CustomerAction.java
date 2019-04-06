package jack.web.action;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import jack.domain.Customer;
import jack.service.CustomerService;
import jack.utils.PageBean;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private Customer customer = new Customer();
	private CustomerService customerService;
	private File photo;
	private String photoFileName;
	private String photoContentType;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	private Integer currentPage;
	private Integer pageSize;
	public String list() throws Exception{
		//1.����service��ѯ��ҳ���ݣ�PageBean��
		//Ҫ����3��������1.һҳ�ж�������2.��ǰҳ 3.��ǰ�û�
		//��װһ�����߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		//��cust_name��װ�����߲�ѯ����
		if(StringUtils.isNotBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		System.out.println(currentPage);
		System.out.println(pageSize);
		PageBean pb = customerService.getPageBean(dc,currentPage,pageSize);
		//2.��õ���Ϣ����request���У�ת�����б�
		ActionContext.getContext().put("pageBean", pb);
		return "list";//�ض��򣬲�ת��
	}
	
	
	
	
	public String add() throws Exception {
		
		//���ļ��ϴ��������ļ���
		
		photo.renameTo(new File("F:/upload/"+photoFileName));
		
		
		
		//1.����service�����û�
		customerService.save(customer);
		//2.�ض���list��ʾ��Action��ת
		return "toList";
		
	}




	public String toEdit() throws Exception {
		// TODO Auto-generated method stub
		
		//1.����id��ȡ�û�
		Customer c = customerService.getById(customer.getCust_id());
		//2.�ŵ�request���л���
		ActionContext.getContext().put("Customer", c);
		
		return "edit";
	}




	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	

	
}
