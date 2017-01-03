package model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="togetherService")
@Transactional(transactionManager="transactionManager")
public class TogetherService {
    @Autowired
	private TogetherDAO togetherDao;
    
//    public static void main(String[] args) {
//    	ApplicationContext context=new ClassPathXmlApplicationContext("beans.config.xml");
//    	SessionFactory sessionFactory=(SessionFactory)context.getBean("sessionFactory");
//    	try{
//    		sessionFactory.getCurrentSession().beginTransaction();
//    		TogetherService togetherService=(TogetherService) context.getBean("togetherService");
//    		
//    		//新增約團
////    		model.MemberBean memberBean = new model.MemberBean();
////    		memberBean.setMember_no(3);
////    		model.TogetherBean togetherBean=new TogetherBean();
////    		togetherBean.setMember_no(memberBean);
////    		togetherBean.setTogether_topic("運動");
////    		togetherBean.setTogether_name("大安森林公園慢跑團");
////    		togetherBean.setTogether_locate("大安森林公園");
////    		togetherBean.setTogether_when(java.sql.Date.valueOf("2016-12-20"));
////    		togetherBean.setTogether_when_end(java.sql.Date.valueOf("2016-12-20"));
////    		togetherBean.setTogether_people(20);
////			togetherBean.setTogether_memo("慢跑時請注意身體狀況");
////			togetherBean.setTogether_post_time(null);
////			togetherBean.setTogether_delete_time(null);
////			togetherBean.setTogether_modify_time(null);
////			togetherBean.setTogether_status(0);
////			togetherBean.setTogether_lat(0);
////			togetherBean.setTogether_lng(0);
////			togetherService.insert(togetherBean);
//    		
//    		//修改
////    		model.MemberBean memberBean = new model.MemberBean();
////    		memberBean.setMember_no(3);
////    		model.TogetherBean togetherBean=new TogetherBean();
////            togetherBean.setTogether_no(5);  //文章編號
////    		togetherBean.setMember_no(memberBean);
////    		togetherBean.setTogether_topic("運動");
////    		togetherBean.setTogether_name("大安森林公園慢跑團_初級");
////    		togetherBean.setTogether_locate("大安森林公園");
////    		togetherBean.setTogether_when(java.sql.Date.valueOf("2016-12-21"));
////    		togetherBean.setTogether_when_end(java.sql.Date.valueOf("2016-12-21"));
////    		togetherBean.setTogether_people(20);
////			togetherBean.setTogether_memo("慢跑時請注意身體狀況");
////			togetherBean.setTogether_post_time(null);
////			togetherBean.setTogether_delete_time(null);
////			togetherBean.setTogether_modify_time(null);
////			togetherBean.setTogether_status(0);
////			togetherBean.setTogether_lat(0);
////			togetherBean.setTogether_lng(0);
////			togetherService.update(togetherBean);
//			
////			model.TogetherBean togetherBean=new TogetherBean();
////			togetherBean.setTogether_no(7);
////    		togetherService.delete(togetherBean);
//			
//			sessionFactory.getCurrentSession().getTransaction().commit();
//    	}finally{
//    		sessionFactory.close();
//    		((ConfigurableApplicationContext) context).close();
//    	}
//    	
//    }
    
    @Transactional
    public TogetherBean insert(TogetherBean bean){
    	TogetherBean result =null;
    	bean.setTogether_post_time(new java.util.Date());
    	if(bean!=null){
    		result=togetherDao.insert(bean);
    	}
    	return result;
    }
    
    @Transactional
    public TogetherBean update(TogetherBean bean){
    	TogetherBean result =null;
    	bean.setTogether_modify_time(new java.util.Date());
    	System.out.println("=================service Bean===============");
    	System.out.println(bean.getTogether_no()+",Together_no");
    	System.out.println(bean.getMember_no()+",Member_no");
    	System.out.println(bean.getTogether_topic()+",Together_topic");
    	System.out.println(bean.getTogether_lat()+",Together_lat");
    	System.out.println(bean.getTogether_lng()+",Together_lng");
    	System.out.println(bean.getTogether_locate()+",Together_locate");
    	System.out.println(bean.getTogether_memo()+",Together_memo");
    	System.out.println(bean.getTogether_name()+",Together_name");
    	System.out.println(bean.getTogether_people()+",Together_people");
    	System.out.println(bean.getTogether_status()+",Together_status");
    	System.out.println(bean.getTogether_delete_time()+",Together_delete_time");
    	System.out.println(bean.getTogether_modify_time()+",Together_modify_time");
    	System.out.println(bean.getTogether_post_time()+",Together_post_time");
    	System.out.println(bean.getTogether_when()+",Together_when");
    	System.out.println(bean.getTogether_when_end()+",Together_when_end");
    	System.out.println("=================end========================");
    	if(bean!=null){
    		result=togetherDao.update(bean.getTogether_no(), bean.getMember_no(), bean.getTogether_topic(), bean.getTogether_name(), bean.getTogether_locate(), bean.getTogether_when(),bean.getTogether_when_end(), bean.getTogether_people(), bean.getTogether_memo(), bean.getTogether_post_time(), bean.getTogether_delete_time(), bean.getTogether_modify_time(), bean.getTogether_status(), bean.getTogether_lat(), bean.getTogether_lng());
    	}
    	return result;
    }

    
   public boolean delete(TogetherBean bean){
	   boolean result=false;
	   if(bean!=null){
		   result=togetherDao.delete(bean.getTogether_no());
	   }
	   return result;
	   
   }
   
   public List<TogetherBean> selectMap(){
	    
	   return togetherDao.select();
   }
   
   
   public List<TogetherBean>  togetherStatusChange(MemberBean memberBean){
	   List<TogetherBean> result=null;
	   if(memberBean!=null){
	   Set<TogetherBean> togetherBean=memberBean.getTogetherBean();
		Calendar date = Calendar.getInstance();
		Date today = date.getTime();
		   for(TogetherBean i : togetherBean){
			   if(i.getTogether_status()==0){
			       if(i.getTogether_when_end().before(today)){
				       i.setTogether_status(1);
			       }
			   }
		   }
		   result=togetherDao.selectStatus(memberBean,0);
	   }
	   return result;
   }   
    
   public TogetherBean togetherStatusDelete(TogetherBean bean){
	   TogetherBean result=null;
	   if(bean!=null){
		   bean.setTogether_status(1);
		   bean.setTogether_delete_time(new java.util.Date());
		   result=togetherDao.update(bean.getTogether_no(), bean.getMember_no(), bean.getTogether_topic(), bean.getTogether_name(), bean.getTogether_locate(), bean.getTogether_when(),bean.getTogether_when_end(), bean.getTogether_people(), bean.getTogether_memo(), bean.getTogether_post_time(), bean.getTogether_delete_time(), bean.getTogether_modify_time(), bean.getTogether_status(), bean.getTogether_lat(), bean.getTogether_lng());
	   }
	   System.out.println("============================");
	   
	   return result;
   }
    
   public List<TogetherBean> togetherSelectStatus(){
	   List<TogetherBean> result=null;
	   result=togetherDao.selectStatus(0);
	   return result;
   }
}
