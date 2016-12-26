package model.dao;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import model.ImemberDao;
import model.MemberBean;


@Repository("memberDao")
public class MemberDao implements ImemberDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public MemberBean select(int member_no) {
		MemberBean bean=this.getSession().get(MemberBean.class,member_no);
		return bean;
	}

	@Override
	public List<MemberBean> select() {
		Query query = this.getSession().createQuery("from MemberBean");
		return (List<MemberBean>) query.getResultList();
	}
	@Override
	public MemberBean insert(MemberBean bean) {
		if(bean!=null) {
			MemberBean insert = this.getSession().get(MemberBean.class, bean.getMember_no());
			if(insert==null) {
				this.getSession().save(bean);
				
			 }
		}
		return bean;
			}

	@Override
	public MemberBean update(MemberBean bean) {
		
		return null;
	}

	@Override
	public MemberBean delete(MemberBean bean) {

		return null;
	}

	public MemberBean select(String account) {
		Query query = this.getSession().createQuery("from MemberBean where account=?");		
		query.setParameter(0,account);
		
			MemberBean bean = (MemberBean) query.getSingleResult();
			if (bean != null) {
				return bean;
			} 
		
		//		return (MemberBean) query.getSingleResult();
		return null;
	}
	


}
