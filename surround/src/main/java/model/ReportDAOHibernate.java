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

@Repository(value="reportDao")
public class ReportDAOHibernate implements ReportDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
    //測試程式
//	public static void main(String[] args){
//	ApplicationContext context = 
//			new ClassPathXmlApplicationContext("beans.config.xml");    //讀取beans.config.xml取得datasource
//	
//	SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
//	
//    try {
//		sessionFactory.getCurrentSession().beginTransaction();
//			
//
//		//查詢
////		ReportDAO dao = (ReportDAO) context.getBean("reportDao");
////	    ReportBean bean = dao.select(2);
////		System.out.println("bean:"+bean);
//		
//		//查詢全部
////		ReportDAO dao = (ReportDAO) context.getBean("reportDao");
////		List<ReportBean> beanlist = dao.select();
////        System.out.println(beanlist);
//		
//		
//		//新增 test
////		ReportBean bean = new ReportBean();    
////	    MemberBean memberbean = new MemberBean();
////	    memberbean.setMember_no(2);
////		
////		bean.setMember_no(memberbean);
////		bean.setReport_memo("圖案可以可愛點.新增");
////		bean.setReport_time(new java.util.Date());
////		bean.setReport_status(0);
////
////		System.out.println(bean.toString());
////		ReportDAO dao = (ReportDAO) context.getBean("reportDao");
////		dao.insert(bean);
//		
//		//update test
////		ReportDAO dao = (ReportDAO) context.getBean("reportDao");	
////		MemberBean memberBean = new MemberBean();
////		memberBean.setMember_no(11);
////		
////		dao.update(memberBean, "圖案可以可愛點.修改", new java.util.Date(), 0,null, 1002);
//		
//		//delete test
////		ReportDAO dao = (ReportDAO) context.getBean("reportDao");	
////		Boolean rs = dao.delete(12);
////		System.out.println("return:"+rs);
//		
//		
//		
//		sessionFactory.getCurrentSession().getTransaction().commit();
//	} finally{
//		sessionFactory.close();
//		((ConfigurableApplicationContext)context).close();
//	}
//	
//}
	
	@Override
	public ReportBean select(int report_no) {  //由主鍵查詢表格
		ReportBean bean = this.getSession().get(ReportBean.class, report_no);
		return bean;
	}

	
	@Override
	public List<ReportBean> select(MemberBean member_no,int report_status) {  //由會員編號及回報文章狀態查詢表格
		 Query query = this.getSession().createQuery("from ReportBean where member_no=? and report_status=?");
		 query.setParameter(0, member_no);
		 query.setParameter(1, report_status);
		 
		 List<ReportBean> rs =  query.getResultList();
		 
		 
		 return rs;
	}
	
	@Override
	public List<ReportBean> select() {   //查詢REPORT所有表格資料
        Query query = this.getSession().createQuery("from ReportBean");
        
        return (List<ReportBean>)query.getResultList();

	}

	@Override 
	public Boolean insert(ReportBean bean) {  
		if(bean!=null){
			this.getSession().save(bean);
			return true;
			}	
		
		return false;
	}

	@Override
	public ReportBean update(MemberBean member_no, String report_memo, Date report_time, int report_status,String report_deal_memo,
			int report_no) {
		ReportBean bean = this.getSession().get(ReportBean.class, report_no);
		if(bean!=null){
        bean.setMember_no(member_no);
        bean.setReport_memo(report_memo);
        bean.setReport_time(report_time);
        bean.setReport_status(report_status);
        bean.setReport_memo(report_deal_memo);

		} 
		return null;
	}

	@Override
	public boolean delete(int report_no) {
		
		ReportBean bean  = this.getSession().get(ReportBean.class, report_no);
		if(bean!=null){
		this.getSession().delete(bean); 
		}
		
		return false;
	}

}
