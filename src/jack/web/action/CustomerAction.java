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
		//1.调用service查询分页数据（PageBean）
		//要传入3个参数，1.一页有多少条，2.当前页 3.当前用户
		//封装一个离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		//将cust_name封装进离线查询对象
		if(StringUtils.isNotBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		System.out.println(currentPage);
		System.out.println(pageSize);
		PageBean pb = customerService.getPageBean(dc,currentPage,pageSize);
		//2.配好的信息放入request域中，转发到列表
		ActionContext.getContext().put("pageBean", pb);
		return "list";//重定向，不转发
	}
	
	
	
	
	public String add() throws Exception {
		
		//把文件上传到本地文件夹
		
		photo.renameTo(new File("F:/upload/"+photoFileName));
		
		
		
		//1.调用service保存用户
		customerService.save(customer);
		//2.重定向到list显示，Action跳转
		return "toList";
		
	}




	public String toEdit() throws Exception {
		// TODO Auto-generated method stub
		
		//1.根据id获取用户
		Customer c = customerService.getById(customer.getCust_id());
		//2.放到request域中回显
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
