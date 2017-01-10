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

@Repository(value="memberDao")
public class MemberDao implements ImemberDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public MemberBean select(String account) {
		Query query = this.getSession().createQuery("from MemberBean where account=?");
		query.setParameter(0, account);

		MemberBean bean = (MemberBean) query.getSingleResult();
		if (bean != null) {

			return bean;
		}

		return null;
	}

	@Override
	public List<MemberBean> select() {
		Query query = this.getSession().createQuery("from MemberBean");
		return (List<MemberBean>) query.getResultList();
	}

	// 註冊
	@Override
	public MemberBean insert(MemberBean bean) {
		if (bean != null) {

			Query query = this.getSession().createQuery("from MemberBean where account=?");
			query.setParameter(0, bean.getAccount());

			List<MemberBean> insert = query.getResultList();

			if (insert.isEmpty()) {

				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	// 修改密碼
	@Override
	public boolean updatePwd(String account, String pwd) {
		// 查資料庫內帳號(HQL查詢)
		Query query = this.getSession().createQuery("from MemberBean where account=?");
		query.setParameter(0, account);
		// 儲存查詢結果
		MemberBean bean = (MemberBean) query.getSingleResult();
		if (bean != null) {
			// session查詢
			MemberBean bean2 = this.getSession().get(MemberBean.class, bean.getMember_no());
			bean2.setPwd(pwd);// 儲存新密碼

			return true;

		}
		return false;

	}

	// 修改興趣與暱稱
	@Override
	public MemberBean update(String nickname, String hobby, String account) {
		// 查資料庫內暱稱(HQL查詢)
		Query query = this.getSession().createQuery("from MemberBean where account=?");
		query.setParameter(0, account);
		// 儲存查詢結果
		MemberBean bean = (MemberBean) query.getSingleResult();
		if (bean != null) {
			// session查詢
			MemberBean bean2 = this.getSession().get(MemberBean.class, bean.getMember_no());
			bean2.setNickname(nickname);// 儲存新暱稱
			bean2.setHobby(hobby);//儲存興趣
			return bean2;

		}
		return bean;
	}

	// 刪除會員資料
	@Override
	public boolean delete(int member_no) {
		MemberBean delete = this.getSession().get(MemberBean.class, member_no);
		if (delete != null) {
			this.getSession().delete(delete);
			return true;
		}
		return false;
	}

}
