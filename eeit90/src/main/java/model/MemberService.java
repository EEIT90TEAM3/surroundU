package model;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.dao.MemberDao;
@Component(value="memberService")
//@Service(value = "memberService")
@Transactional(transactionManager = "transactionManager")
public class MemberService {
	@Autowired
	private MemberDao memberDAO;
	@Autowired
	private MemberBean memberBean;

	@Transactional(readOnly = true)
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

	public MemberBean register(MemberBean bean) {
		
		
		
		MemberBean result = null;
		if (bean != null) {
			result = memberDAO.insert(bean);
		}
		return result;

	}

}
