package jack.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import jack.dao.UserDao;
import jack.domain.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	

	@Override
	public void save(User t) {
		// TODO Auto-generated method stub
		super.save(t);
	}

	public User getUserByCodePassword(final String usercode) {
		//hql
		/*return getHibernateTemplate().execute(new HibernateCallback<User>() {

			public User doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				String hql = "from User where user_code = ?";
				Query query = session.createQuery(hql);
				query.setParameter(0, usercode );
				User user = (User) query.uniqueResult();
				return user;
			}
			
		});*/
		//criteria
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("user_code", usercode));
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}else {
			return null; 
		}
	}

	

}
