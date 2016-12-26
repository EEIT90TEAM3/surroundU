package eeit90;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.MemberBean;
import model.dao.MemberDao;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			
			MemberDao memberDAO = (MemberDao) context.getBean("memberDao");		
			MemberBean memb = memberDAO.select("Nobi");
			System.out.println(memb.getAccount());
			System.out.println(memb.getMember_status());
			System.out.println(memb.getPwd());
			
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		
		} finally {
			sessionFactory.close();
			((ConfigurableApplicationContext) context).close();
		}
	}

}
