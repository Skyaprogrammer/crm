package jack.service;

import jack.domain.User;

public interface UserService {
		//��½����
		User	getUserByCodePassword(User u);
		//ע���û�
		void saveUser(User u);
}
