package model;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "friendDAO")
public class FriendDAOHibernate implements FriendDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<FriendBean> friendList(int member_no) {
		Query query = this.getSession().createQuery("from FriendBean where member_no.member_no=:member_no");
		query.setParameter("member_no", member_no);
		return (List<FriendBean>) query.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<FriendBean> inviteList(int member_no) {
		Query query = this.getSession().createQuery("from FriendBean where buddy_no.member_no=:member_no and friend_status=0");
		query.setParameter("member_no", member_no);
		return (List<FriendBean>) query.getResultList();
	}
	@Override
	public FriendBean addFriend(FriendBean bean) {
		if (bean != null) {
			FriendBean insert = this.getSession().get(FriendBean.class, bean.getFriend_no());
			if (insert == null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public FriendBean acceptFriend(FriendBean bean) {
		if (bean != null) {
			FriendBean insert = this.getSession().get(FriendBean.class, bean.getFriend_no());
			if (insert == null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}
	@Override
	public FriendBean update(FriendBean bean) {

		Query query = this.getSession().createNativeQuery
				("select friend_no from friend where member_no= '"+bean.getMember_no().getMember_no()+"' and buddy_no= '"+bean.getBuddy_no().getMember_no()+"'");
		
//				("update friend set friend_status=1 where member_no="+id+" and buddy_no="+fid);

//		 FriendBean update = this.getSession().get(FriendBean.class,
//		 bean.getFriend_no());
//		 if(update!=null) {
//		 this.getSession().merge(bean);
//		 }
		System.out.println((Integer)query.getSingleResult());
		bean.setFriend_no((Integer)query.getSingleResult());
		this.getSession().merge(bean);
//		friendBean.setFriend_no(friend_no);
//		friendBean.setBuddy_no(fid);
//		friendBean.setFriend_status(status);
//		friendBean.setMember_no(id);

		
		
//		FriendBean friendBean=(FriendBean) query.getMaxResults()
//		return friendBean;
		return null;
	}

	@Override
	public boolean delete(FriendBean bean) {
		Query query = this.getSession().createNativeQuery
				("select friend_no from friend where member_no= '"+bean.getMember_no().getMember_no()+"' and buddy_no= '"+bean.getBuddy_no().getMember_no()+"'");
		System.out.println("(Integer)query.getSingleResult()="+(Integer)query.getSingleResult());
		FriendBean delete = this.getSession().get(FriendBean.class, (Integer)query.getSingleResult());
		if (delete != null) {
			this.getSession().delete(delete);
			return true;
		}
		return false;
	}

	@Override
	public List<FriendBean> select() {
		Query query = this.getSession().createQuery("from FriendBean");
		return (List<FriendBean>) query.getResultList();
	}

	@Override
public int findpram(FriendBean bean) {
	Query query = this.getSession().createNativeQuery
			("select friend_no from friend where member_no= '"+bean.getMember_no().getMember_no()+"' and buddy_no= '"+bean.getBuddy_no().getMember_no()+"'");

	if(query.getResultList().isEmpty()){
		return 0;
	}
	return 1;
}

}
