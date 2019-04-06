package jack.dao;

import jack.domain.User;

public interface UserDao extends BaseDao<User>{


	User getUserByCodePassword(String usercode);

}
