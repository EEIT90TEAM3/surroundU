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
	
	//測試程式
//	public static void main(String[] args) {
//		ApplicationContext context =
//				new ClassPathXmlApplicationContext("beans.config.xml");
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//	
//		try {
//			sessionFactory.getCurrentSession().beginTransaction();
//			
//			MemberDAO memberDAO = (MemberDAO) context.getBean("memberDAO");		
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

}
