package model;

import java.util.ArrayList;
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

//import model.dao.MemberDao;

@Component(value = "memberService")

@Transactional(transactionManager = "transactionManager")
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
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
	public List<MemberBean> select(MemberBean bean) {
		List<MemberBean> result = null;
		if (bean != null && bean.getAccount() != null) {
			MemberBean temp = memberDAO.select(bean.getAccount());
			if (temp != null) {
				result = new ArrayList<MemberBean>();
				result.add(temp);
			}
		} else {
			result = memberDAO.select();
		}
		return result;
	}

	@Transactional
	public MemberBean insert(MemberBean bean) {
		MemberBean result = null;
		if (bean != null) {

			result = memberDAO.insert(bean);
		}
		return result;

	}

	@Transactional
	public MemberBean update(MemberBean bean) {
		MemberBean result = null;
		if (bean != null) {
			result = memberDAO.update(bean.getNickname(), bean.getHobby(), bean.getAccount());
		}
		return result;

	}

	@Transactional
	public boolean delete(MemberBean bean) {
		boolean result = false;
		if (bean != null) {
			result = memberDAO.delete(bean.getMember_no());

		}
		return result;

	}

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

	@Transactional
	public boolean changePassword(String account, String oldPwd, String newPwd) {
		MemberBean bean = this.login(account, oldPwd);

		if (bean != null) {
			System.out.println(bean.getPwd());
			if (newPwd != null && newPwd.length() != 0) {
				String temp = newPwd;

				return memberDAO.updatePwd(account, temp);
			}
		}
		return false;

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
	public MemberBean select(String account) {
		System.out.println("memberService--------------------");
		MemberBean result = null;
		System.out.println("account--"+account);
		result = memberDAO.select(account);
	
		System.out.println("result= "+result);
		return result;
	}	
	@Transactional
	public MemberBean selectName(String name) {
		MemberBean result = null;
		result = memberDAO.selectName(name);
	
		System.out.println("result= "+result);
		return result;
	}
}
