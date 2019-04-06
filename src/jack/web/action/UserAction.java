package jack.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import jack.domain.User;
import jack.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String login() throws Exception{
		 
		//1.����service�߼�
		User u = userService.getUserByCodePassword(user);
		//2.�ŵ�session��
		ActionContext.getContext().getSession().put("user", u);
		//3.�ض�����ҳ
		return "toHome";
	}

	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
