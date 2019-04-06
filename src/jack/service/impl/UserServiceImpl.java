package jack.service.impl;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jack.dao.UserDao;
import jack.domain.User;
import jack.service.UserService;

//���񷽷�
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class UserServiceImpl implements UserService{

	private UserDao ud;
	public User getUserByCodePassword(User u) {
		// TODO Auto-generated method stub
		User existU = ud.getUserByCodePassword(u.getUser_code());
		if(existU==null) {
			throw new RuntimeException("�û�������");
		}
		if(!existU.getUser_password().equals(u.getUser_password())) {
			throw new RuntimeException("�������");
		}
		return existU;
	}

	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveUser(User u) {
		ud.save(u);
		
	}
	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	

}
