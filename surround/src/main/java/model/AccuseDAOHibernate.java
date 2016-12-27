
package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.swing.MenuElement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository(value="accuseDao")
public class AccuseDAOHibernate implements AccuseDAO {
	@Autowired
	private SessionFactory sessionFactory;         
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	//測試程式
//	public static void main(String[] args){
//		ApplicationContext context = 
//				new ClassPathXmlApplicationContext("beans.config.xml");    //讀取beans.config.xml取得datasource
//		
//		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
//		
//	    try {
//			sessionFactory.getCurrentSession().beginTransaction();
//				
//	
//			//查詢
////			AccuseDAO dao = (AccuseDAO) context.getBean("accuseDao");
////		    AccuseBean bean = dao.select(2);
////			System.out.println("bean:"+bean);
////			System.out.println("accuse_no:" + bean.getAccuse_no());
////			System.out.println("member_no:" + bean.getMember_no());
////			System.out.println("accuse_typ:" + bean.getAccuse_type());
////			System.out.println("accuse_topic:" + bean.getAccuse_topic());
////			System.out.println("accuse_post_time:" + bean.getAccuse_post_time());
////			System.out.println("accuse_status:" + bean.getAccuse_status());
////			System.out.println("accuse_deal_time:" + bean.getAccuse_deal_time());
////			System.out.println("Sale_no:" + bean.getSale_no());
////			System.out.println("Group_no:" + bean.getGroup_no());
//			
//			
//			//查詢是否有重複檢舉文章
////			AccuseDAO dao = (AccuseDAO) context.getBean("accuseDao");
////			MemberBean bean = new MemberBean();
////			bean.setMember_no(1);
////			List<AccuseBean> rs = dao.select(bean, 1, 0);
////			System.out.println(rs);
//			
//			
//			//查詢全部
////			AccuseDAO dao = (AccuseDAO) context.getBean("accuseDao");
////			List<AccuseBean> beanlist = dao.select();
////          System.out.println(beanlist);
//			
//
//			
//			//新增 test
////			AccuseBean bean = new AccuseBean(); 
////			MemberBean memberbean = new MemberBean();
////			memberbean.setMember_no(2);
////			
////			bean.setMember_no(memberbean);
////			bean.setAccuse_type("內容不雅yyy");
////			bean.setAccuse_topic("擺攤");
////			bean.setAccuse_post_time(new java.util.Date());
////			bean.setAccuse_status(0);
////			bean.setAccuse_deal_time(new java.util.Date());
////			bean.setSale_no(7);
////			bean.setGroup_no(0);
////			System.out.println(bean.toString());
////			AccuseDAO dao = (AccuseDAO) context.getBean("accuseDao");
////			dao.insert(bean);
//			
//			//update test
////		    AccuseDAO dao = (AccuseDAO) context.getBean("accuseDao");	
////		    MemberBean memberBean = new MemberBean();
////		    memberBean.setMember_no(4);
////		    
////			dao.update(memberBean,"內容不雅.修改","約團",new java.util.Date(),   
////					0,new java.util.Date(),0,9,8);
//			
////			//delete test
////			AccuseDAO dao = (AccuseDAO) context.getBean("accuseDao");	
////			dao.delete(8);
//			
//			
//			
//			
//			
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		} finally{
//			sessionFactory.close();
//			((ConfigurableApplicationContext)context).close();
//		}
//		
//    }

	

	@Override   
	public AccuseBean select(int accuse_no) {      //以主鍵accuse_no查詢表格              
        
		AccuseBean bean = this.getSession().get(AccuseBean.class, accuse_no);  
       
		return bean;
	}
	
	
	
	@Override
	public List<AccuseBean> select(MemberBean member_no,int sale_no,int group_no){  //查詢是否同一人是否有
		
		Query query = this.getSession().createQuery("from AccuseBean where member_no=? and sale_no =? and group_no= ?");
		query.setParameter(0, member_no);
		query.setParameter(1, sale_no);
		query.setParameter(2, group_no);
		
		List<AccuseBean> rs = query.getResultList();
				
		return rs;
	};
	
	@Override
	public List<AccuseBean> selectByStatus(int accuse_status){  //查詢是否同一人是否有
		
		Query query = this.getSession().createQuery("from AccuseBean where accuse_status=?");
		query.setParameter(0, accuse_status);
		
		List<AccuseBean> rs = query.getResultList();
				
		return rs;
	};
	
	

	@Override
	public List<AccuseBean> select() {
        Query query = this.getSession().createQuery("from AccuseBean");
        return (List<AccuseBean>)query.getResultList();
	}
	


	@Override
	public AccuseBean insert(AccuseBean bean) {
		
		if(bean!=null){
		 	
		 this.getSession().save(bean);
		 System.out.println("save bean");
		}	
		
		return null;
	}
	
	


	@Override
	public AccuseBean update(MemberBean member_no,String accuse_type, String accuse_topic, Date accuse_post_time,
			int accuse_status, Date accuse_deal_time, int sale_no, int group_no,int accuse_no) {
		
		
		AccuseBean bean = this.getSession().get(AccuseBean.class, accuse_no);
		if(bean!=null){
        bean.setMember_no(member_no);
        bean.setAccuse_type(accuse_type);
        bean.setAccuse_topic(accuse_topic);
        bean.setAccuse_post_time(accuse_post_time);
        bean.setAccuse_status(accuse_status);
        bean.setAccuse_deal_time(accuse_deal_time);
        bean.setSale_no(sale_no);
        bean.setGroup_no(group_no);
		} 
        
        
		
		return null;
	}


	@Override
	public boolean delete(int accuse_no) {
		
		AccuseBean bean  = this.getSession().get(AccuseBean.class, accuse_no);
		if(bean!=null){
		this.getSession().delete(bean); 
		}
		return false;
	}

}
