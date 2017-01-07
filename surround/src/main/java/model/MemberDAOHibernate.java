package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;



@Repository(value="memberDAO")
public class MemberDAOHibernate implements MemberDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
//	public static void main(String[] args) {
//		ApplicationContext context =
//				new ClassPathXmlApplicationContext("beans.config.xml");
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//	
//		try {
//			sessionFactory.getCurrentSession().beginTransaction();
//			
//			MemberDAO memberDAO = (MemberDAO) context.getBean("MemberDAO");		
//			MemberBean memb = memberDAO.select("Nobi");
//			System.out.println(memb.getAccount());
//			System.out.println(memb.getMember_status());
//			System.out.println(memb.getPwd());
//			
//			
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		
//		} finally {
//			sessionFactory.close();
//			((ConfigurableApplicationContext) context).close();
//		}
//	}
//	
//	
//	
	

	@Override
	public MemberBean select(String account) {
		Query query = this.getSession().createQuery("from MemberBean where account like :name");		
		query.setParameter("name",account);
		try {
			MemberBean bean = (MemberBean) query.getSingleResult();
			if (bean != null) {
				return bean;
			} 
		} catch (Exception e) {
			return null;
		}
		//		return (MemberBean) query.getSingleResult();
		return null;
	}
	public MemberBean insert(MemberBean bean) {
		if(bean!=null) {
			MemberBean insert = this.getSession().get(MemberBean.class, bean.getMember_no());
			if(insert==null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}
	@Override
	public MemberBean fbselect(MemberBean bean) {
		Query query = this.getSession().createQuery("from MemberBean where account_facebook like :name");		
		query.setParameter("name",bean.getAccount_facebook());
		return (MemberBean) query.getSingleResult();
	}

}
