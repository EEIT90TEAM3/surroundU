package model;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import model.MemberBean;
import model.TogetherDAO;
import model.TogetherBean;

@Repository(value="togetherDao")
public class TogetherDAOHibernate implements TogetherDAO {
	@Autowired
	private SessionFactory sessionFactory;
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
			TogetherDAO dao=(TogetherDAO)context.getBean("togetherDao");
			//單筆查詢
			TogetherBean tobn=dao.select(1);
			System.out.println(tobn.getTogether_name());
			
			//多筆查詢
//			List<TogetherBean> list=dao.select();
//			for(TogetherBean tobn : list ){
//				System.out.println(tobn.getTogether_no() + "," );
//			    System.out.println(tobn.getMember_no().getName() + ",");
//			    System.out.println(tobn.getTogether_name());
//			    System.out.println(tobn.getTogether_people());
//			    System.out.println(tobn.getMember_no().getAccount());
//			   }
			//新增
//		    MemberBean memberBean = new MemberBean(); // 部門POJO
//			memberBean.setMember_no(2);
//			TogetherBean tobn=new TogetherBean();
//			tobn.setMember_no(memberBean);
//			tobn.setTogether_no(4);
//			tobn.setTogether_topic("遊戲");
//			tobn.setTogether_name("翻花繩");
//			tobn.setTogether_locate("大安森林公園");
//			tobn.setTogether_when(java.sql.Date.valueOf("2016-12-20"));
//			tobn.setTogether_when_end(java.sql.Date.valueOf("2016-12-23"));
//			tobn.setTogether_people(20);
//			tobn.setTogether_memo("翻花繩教學");
//			tobn.setTogether_post_time(null);
//			tobn.setTogether_delete_time(null);
//			tobn.setTogether_modify_time(null);
//			tobn.setTogether_status(0);
//			tobn.setTogether_lat(0);
//			tobn.setTogether_lng(0);
//			dao.insert(tobn);
//			dao.update(4, memberBean, "遊戲", "翻花繩", "和平公園", java.sql.Date.valueOf("2016-12-20"), java.sql.Date.valueOf("2016-12-22"), 5, "翻花繩教學", null, null, null, 1, 0, 0);
			//刪除
//			dao.delete(4);
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
				
			sessionFactory.close();
			((ConfigurableApplicationContext) context).close();
		}
	}
	
	@Override
	public TogetherBean select(int together_no) {
		return this.getSession().get(TogetherBean.class,together_no);
	}

	@Override
	public List<TogetherBean> select() {
		Query query=this.getSession().createQuery("from TogetherBean");
		return (List<TogetherBean>) query.getResultList();
	}

	@Override
	public TogetherBean insert(TogetherBean bean) {
	    if(bean!=null){
		     TogetherBean insert=this.getSession().get(TogetherBean.class,bean.getTogether_no());
		     if(insert==null){
		         this.getSession().save(bean);
		         return bean;
		     }
		}
	    return null;
	}

	@Override
	public TogetherBean update(int together_no, MemberBean member_no, String together_topic, String together_name,
			String together_locate, Date together_when,Date together_when_end, int together_people, String together_memo,
			Date together_post_time, Date together_delete_time, Date together_modify_time, int together_status,
			float together_lng, float together_lat) {
		    TogetherBean update=this.getSession().get(TogetherBean.class,together_no);
		    if(update!=null){
		    	update.setMember_no(member_no);
		    	update.setTogether_topic(together_topic);
		    	update.setTogether_name(together_name);
		    	update.setTogether_locate(together_locate);
		    	update.setTogether_when(together_when);
		    	update.setTogether_when_end(together_when_end);
		    	update.setTogether_people(together_people);
		    	update.setTogether_memo(together_memo);
		    	update.setTogether_post_time(together_post_time);
		    	update.setTogether_delete_time(together_delete_time);
		    	update.setTogether_modify_time(together_modify_time);
		    	update.setTogether_status(together_status);
		    	update.setTogether_lat(together_lat);
		    	update.setTogether_lng(together_lng);    	
		    }
		
		return update;
	}

	@Override
	public boolean delete(int together_no) {
		TogetherBean delete=this.getSession().get(TogetherBean.class,together_no);
		if(delete!=null){
		this.getSession().delete(delete);
		return true;
		}
		return false;
	}
	

}
