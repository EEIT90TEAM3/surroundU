package model;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component(value="reportService")
@Transactional(transactionManager="transactionManager")
public class ReportService {
    
	@Autowired
	private ReportDAO reportDao;
    @Autowired
    private ReportBean reportBean;
	
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
//			ReportService service = (ReportService)context.getBean("reportService");
//			
//			//新增建議
////			MemberBean bean = new MemberBean();
////			bean.setMember_no(1);
////					
////			service.postReport(bean, "斷線,lag,修不好", new java.util.Date(), 0,null);		
//			//新增建議超逾五篇,無法新增
////			MemberBean bean = new MemberBean();
////			bean.setMember_no(1);
////					
////			service.postReport(bean, "斷線,lag,修不好", new java.util.Date(), 0,null);				
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
   
    
    
    
    @Transactional
	public Boolean postReport(MemberBean member_no,String report_memo,
			java.util.Date report_time,int report_status,String report_deal_memo){
		 System.out.println(member_no.getMember_no());
		 
        //判斷未處理建議是否超過5篇
    	List<ReportBean> beanlist = reportDao.select(member_no, 0);
    	System.out.println(beanlist);
    	System.out.println("beanlist.size:"+beanlist.size());
    	if(beanlist.size()<5){
	    		reportBean.setMember_no(member_no);
				reportBean.setReport_memo(report_memo);
				reportBean.setReport_time(report_time);
				reportBean.setReport_status(report_status);
				reportBean.setReport_deal_memo(report_deal_memo);
				Boolean rs = reportDao.insert(reportBean);
			if(rs){
				return true;
			}
    	}
    	
		return false;
	}//end of postReport
	
    
    
    @Transactional
   	public List<ReportBean> selectAllReport(){  //查詢所有檢舉表格
   		
    	List<ReportBean> beanlist = reportDao.select();
   		   	
   	  return beanlist;
   		
   	}//end of selectAllReport
	
	
}
