package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");

		try {

			sessionFactory.getCurrentSession().beginTransaction();
			Session session = sessionFactory.getCurrentSession();
						
			System.out.println("hell");
			MemberBean b = session.get(MemberBean.class,4);
			System.out.println(b.getMember_no());
			sessionFactory.getCurrentSession().getTransaction().commit();
//			((ConfigurableApplicationContext) context).close();
		} finally{
			sessionFactory.close();
			sessionFactory.getCurrentSession().getTransaction().rollback();
			((ConfigurableApplicationContext) context).close();
		}
		

	}

}
