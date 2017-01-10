package model;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
@Repository(value="privateTalkDAO")
public class PrivateTalkDAOHibernate implements PrivateTalkDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public PrivateTalkDAOHibernate() {
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
//測試程式
	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			PrivateTalkDAO dao=(PrivateTalkDAO)context.getBean("privateTalkDAO");
//單筆查詢
			PrivateTalkBean memb=dao.select(1);
			System.out.print(memb.getPrivatetalk_no()+",");
			System.out.print(memb.getPrivatetalk_txt()+",");
			System.out.print(memb.getPrivatetalk_time()+",");
			System.out.print(memb.getMember_no()+",");
			System.out.print(memb.getCatch_id()+",");
//多筆查詢
//			List<PrivateTalkBean> list=dao.select();
//			for(PrivateTalkBean memb : list ){
//				System.out.print(memb.getPrivatetalk_no()+",");
//				System.out.print(memb.getPrivatetalk_txt()+",");
//				System.out.print(memb.getPrivatetalk_time()+",");
//				System.out.print(memb.getMember_no()+",");
//				System.out.print(memb.getCatch_id()+",");
//			   }
//新增

//			MemberBean memberBean = new MemberBean(); // 部門POJO
//			MemberDAO memberDAO = (MemberDAO) context.getBean("memberDAO");
////			memberBean.setMember_no(2);
//			PrivateTalkBean tobn=new PrivateTalkBean();
////			tobn.setMember_no(memberBean);
//			tobn.setMember_no(memberDAO.selectId(3));
//			tobn.setPrivatetalk_txt("遊戲");
//			tobn.setPrivatetalk_time(java.sql.Date.valueOf("2016-12-20"));
//			tobn.setCatch_id(memberDAO.selectId(1));
//			dao.insert(tobn);
//刪除
//			dao.delete(7);
			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
				
			sessionFactory.close();
			((ConfigurableApplicationContext) context).close();
		}
	}
	
	@Override
	public PrivateTalkBean select(int privatetalk_no) {
		return this.getSession().get(PrivateTalkBean.class,privatetalk_no);
	}

	@Override
	public List<PrivateTalkBean> select() {
		Query query = this.getSession().createQuery("from PrivateTalkBean");
		return (List<PrivateTalkBean>) query.getResultList();
	}

	@Override
	public PrivateTalkBean insert(PrivateTalkBean bean) {
	    if(bean!=null){
	    	PrivateTalkBean insert=this.getSession().get(PrivateTalkBean.class,bean.getPrivatetalk_no());
		     if(insert==null){
		         this.getSession().save(bean);
		         return bean;
		     }
		}
	    return null;
	}

	@Override
	public PrivateTalkBean update(PrivateTalkBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int privatetalk_no) {
		PrivateTalkBean delete=this.getSession().get(PrivateTalkBean.class,privatetalk_no);
		if(delete!=null){
		this.getSession().delete(delete);
		return true;
		}
		return false;
	}

}
