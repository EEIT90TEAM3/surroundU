package model;

import java.util.Arrays;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="memberService")
@Transactional
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	//測試程式
//	public static void main(String[] args) {
//		ApplicationContext context =
//				new ClassPathXmlApplicationContext("beans.config.xml");
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//		try {
//			sessionFactory.getCurrentSession().beginTransaction();
//			MemberService memberService = (MemberService) context.getBean("memberService");
//			MemberBean mem=memberService.login("Doraemon", "2112");
//			System.out.println(mem.getAccount());
//			System.out.println(mem.getMember_no());
//			System.out.println(mem.getMember_status());
//			
//		} finally {
//			sessionFactory.close();
//			((ConfigurableApplicationContext) context).close();
//		}
//		
//	}
	
	@Transactional
	public MemberBean login(String account, String pwd) {
		MemberBean bean = memberDAO.select(account);
		if (bean != null) {
			if (pwd != null && pwd.length() != 0) {
				String pass = bean.getPwd(); 
				if (pass.equals(pwd)) {
					return bean;
				}
			}
		}
		return null;
	}

}
