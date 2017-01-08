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
	private ImemberDao memberDao;

	@Transactional
	public List<MemberBean> select(MemberBean bean) {
		List<MemberBean> result = null;
		if (bean != null && bean.getAccount() != null) {
			MemberBean temp = memberDao.select(bean.getAccount());
			if (temp != null) {
				result = new ArrayList<MemberBean>();
				result.add(temp);
			}
		} else {
			result = memberDao.select();
		}
		return result;
	}

	@Transactional
	public MemberBean insert(MemberBean bean) {
		MemberBean result = null;
		if (bean != null) {

			result = memberDao.insert(bean);
		}
		return result;

	}

	@Transactional
	public MemberBean update(MemberBean bean) {
		MemberBean result = null;
		if (bean != null) {
			result = memberDao.update(bean.getNickname(),bean.getHobby(), bean.getAccount());
		}
		return result;

	}

	

	@Transactional
	public boolean delete(MemberBean bean) {
		boolean result = false;
		if (bean != null) {
			result = memberDao.delete(bean.getMember_no());

		}
		return result;

	}

	@Transactional(readOnly = true)
	public MemberBean login(String account, String pwd) {
		MemberBean bean = memberDao.select(account);
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

				return memberDao.updatePwd(account, temp);
			}
		}
		return false;
	}

}
