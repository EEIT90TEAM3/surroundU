package model;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component(value="accuseService")
public class AccuseService {
	@Autowired
	private AccuseDAO accuseDao;
    @Autowired
    private AccuseBean accuseBean;
    @Autowired
    private MemberBean memberBean;
    
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
//			AccuseService service = (AccuseService)context.getBean("accuseService");
//			//檢舉失敗
////			MemberBean bean = new MemberBean();
////			bean.setMember_no(1);
////						
////			service.postAccuse(bean, "內容不雅", "擺攤",
////					new java.util.Date(), 0, null, 1, 0);
//			
//			//檢舉成功
////			MemberBean bean = new MemberBean();
////		    bean.setMember_no(4);
////			service.postAccuse(bean, "內容不雅", "擺攤",
////			        new java.util.Date(), 0, new java.util.Date(), 7, 0);			
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
    
    
	
	public Boolean postAccuse(MemberBean member_no, String accuse_type, String accuse_topic, Date accuse_post_time,
			int accuse_status, Date accuse_deal_time, int sale_no, int group_no,String accuse_deal_memo){
		
		// member_no,sale_no,Group_no去查詢同一位檢舉人是否有重複檢舉同一篇文章
		List<AccuseBean>  beanlist = accuseDao.select(member_no,sale_no,group_no);  
		System.out.println("beanlist:"+beanlist);
		
		
		//如果beanlist為空值時，表示檢舉人未檢舉過此篇文章，則使用accuseDao的insert方法新增檢舉文章至table:ACCUSE
		if(beanlist.isEmpty()){
						
			accuseBean.setMember_no(member_no);          
			accuseBean.setAccuse_type(accuse_type);
			accuseBean.setAccuse_topic(accuse_topic);
			accuseBean.setAccuse_post_time(accuse_post_time);
			accuseBean.setAccuse_status(accuse_status);
			accuseBean.setAccuse_deal_time(accuse_deal_time);
			accuseBean.setSale_no(sale_no);
			accuseBean.setGroup_no(group_no);
			accuseBean.setAccuse_deal_memo(accuse_deal_memo);
			
			
			accuseDao.insert(accuseBean);
			System.out.println("檢舉成功");
			return true;
		}else{
			
			System.out.println("您已經檢舉過了");
			return false;
		}
		
		
		
		
	}//end of postAccuse
	
	
	public List<AccuseBean> selectAllAccuse(){  //查詢所有檢舉表格
		
	  List<AccuseBean> result = accuseDao.select();
		
	
	  return result;
		
	}
	
	
	public List<AccuseBean> selectNotProcess(){  //查詢已處理檢舉表格
		
		  List<AccuseBean> result = accuseDao.selectByStatus(0);
			
		  return result;
			
	}
	
	
	
	
	public List<AccuseBean> selectProcessed(){  //查詢已處理檢舉表格
		
		  List<AccuseBean> result = accuseDao.selectByStatus(1);
			
		
		  return result;
			
		}
	
}
