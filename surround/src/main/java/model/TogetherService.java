package model;

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
    
    public static void main(String[] args) {
    	ApplicationContext context=new ClassPathXmlApplicationContext("beans.config.xml");
    	SessionFactory sessionFactory=(SessionFactory)context.getBean("sessionFactory");
    	try{
    		sessionFactory.getCurrentSession().beginTransaction();
    		TogetherService togetherService=(TogetherService) context.getBean("togetherService");
    		
    		//新增約團
//    		model.MemberBean memberBean = new model.MemberBean();
//    		memberBean.setMember_no(3);
//    		model.TogetherBean togetherBean=new TogetherBean();
//    		togetherBean.setMember_no(memberBean);
//    		togetherBean.setTogether_topic("運動");
//    		togetherBean.setTogether_name("大安森林公園慢跑團");
//    		togetherBean.setTogether_locate("大安森林公園");
//    		togetherBean.setTogether_when(java.sql.Date.valueOf("2016-12-20"));
//    		togetherBean.setTogether_when_end(java.sql.Date.valueOf("2016-12-20"));
//    		togetherBean.setTogether_people(20);
//			togetherBean.setTogether_memo("慢跑時請注意身體狀況");
//			togetherBean.setTogether_post_time(null);
//			togetherBean.setTogether_delete_time(null);
//			togetherBean.setTogether_modify_time(null);
//			togetherBean.setTogether_status(0);
//			togetherBean.setTogether_lat(0);
//			togetherBean.setTogether_lng(0);
//			togetherService.insert(togetherBean);
    		
    		//修改
//    		model.MemberBean memberBean = new model.MemberBean();
//    		memberBean.setMember_no(3);
//    		model.TogetherBean togetherBean=new TogetherBean();
//            togetherBean.setTogether_no(5);  //文章編號
//    		togetherBean.setMember_no(memberBean);
//    		togetherBean.setTogether_topic("運動");
//    		togetherBean.setTogether_name("大安森林公園慢跑團_初級");
//    		togetherBean.setTogether_locate("大安森林公園");
//    		togetherBean.setTogether_when(java.sql.Date.valueOf("2016-12-21"));
//    		togetherBean.setTogether_when_end(java.sql.Date.valueOf("2016-12-21"));
//    		togetherBean.setTogether_people(20);
//			togetherBean.setTogether_memo("慢跑時請注意身體狀況");
//			togetherBean.setTogether_post_time(null);
//			togetherBean.setTogether_delete_time(null);
//			togetherBean.setTogether_modify_time(null);
//			togetherBean.setTogether_status(0);
//			togetherBean.setTogether_lat(0);
//			togetherBean.setTogether_lng(0);
//			togetherService.update(togetherBean);
			
//			model.TogetherBean togetherBean=new TogetherBean();
//			togetherBean.setTogether_no(7);
//    		togetherService.delete(togetherBean);
			
			sessionFactory.getCurrentSession().getTransaction().commit();
    	}finally{
    		sessionFactory.close();
    		((ConfigurableApplicationContext) context).close();
    	}
    	
    }
    
    @Transactional
    public TogetherBean insert(TogetherBean bean){
    	TogetherBean result =null;
    	if(bean!=null){
    		result=togetherDao.insert(bean);
    	}
    	return result;
    }
    
    @Transactional
    public TogetherBean update(TogetherBean bean){
    	TogetherBean result =null;
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
    
}
