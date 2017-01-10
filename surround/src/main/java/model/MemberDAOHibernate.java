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


	@Override
	public List<MemberBean> select() {
		Query query = this.getSession().createQuery("from MemberBean");
		return (List<MemberBean>) query.getResultList();
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
	
	
	@Override
	public List<MemberBean> selectAll() {   //查詢MEMBER所有表格資料
        
		Query query = this.getSession().createQuery("from MemberBean");
        
        return (List<MemberBean>)query.getResultList();

	}
	
	@Override
	public List<MemberBean> selectMemberByAccuseStatus(int account_status) {   //查詢MEMBER所有表格資料
        
		Query query = this.getSession().createQuery("from MemberBean where account_status=?");
        query.setParameter(0, account_status);
		
		
        return (List<MemberBean>)query.getResultList();

	}
	
	
	@Override
	public MemberBean update(MemberBean memberbean,int account_status){
		
		MemberBean bean = this.getSession().get(MemberBean.class, memberbean.getMember_no());
		
		if(bean!=null){
			bean.setAccount_status(account_status);
			
			return bean;
		}
		
		    return null;
		
	}
	
	@Override
	public MemberBean update(MemberBean memberbean,String newpwd){
		
		MemberBean bean = this.getSession().get(MemberBean.class, memberbean.getMember_no());
		
		System.out.println("bean:"+bean);
		
		if(bean!=null){
			bean.setPwd(newpwd);
			
			return bean;
		}
		
		    return null;
		
	}

	@Override
	public MemberBean selectMember_no(int member_no) {
		Query query = this.getSession().createQuery("from MemberBean where member_no like :name");		
		query.setParameter("name",member_no);
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
