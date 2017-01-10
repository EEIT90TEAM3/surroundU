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

	@Transactional
	public MemberBean fblogin(MemberBean bean) {
		MemberBean bean1=null;
		try {
			bean1 = memberDAO.fbselect(bean);
		} catch (Exception e) {
			System.out.println("aa");
			memberDAO.insert(bean);
			bean1 = memberDAO.fbselect(bean);
		}
		
		return bean1;
	}
	@Transactional
	public MemberBean login(String account, String pwd) {
		System.out.println("aa");
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
	@Transactional
	public MemberBean register(MemberBean bean) {	
		MemberBean result = null;
		if (bean != null) {
		 result = memberDAO.insert(bean);
		}
		return result;
	}
	@Transactional
	public MemberBean backendlogin(String account, String pwd) {  //後台登錄
		MemberBean bean = memberDAO.select(account);
		if (bean != null) {
			if (pwd != null && pwd.length() != 0) {
				String pass = bean.getPwd();  //取得密碼
				
				 int  status = bean.getAccount_status(); //取得權限
				
				 if (pass.equals(pwd) && status==99) {
					return bean;
				}
			}
		}
		return null;
	}
	@Transactional
	public MemberBean update(MemberBean bean) {
		MemberBean result = null;
		if (bean != null) {
			result = memberDAO.update(bean);
		}
		return result;
	}

}
