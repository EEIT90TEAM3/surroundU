package model;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="togetherMemService")
@Transactional(transactionManager="transactionManager")
public class TogetherMemService {
	@Autowired
	private TogetherMemDAO togetherMemDao; 

	//測試程式
//	public static void main(String[] args) {
//		ApplicationContext context=new ClassPathXmlApplicationContext("beans.config.xml");
//		SessionFactory sessionFactory=(SessionFactory) context.getBean("sessionFactory");
//		try{
//			sessionFactory.getCurrentSession().beginTransaction();
//			TogetherMemService togetherMemService=(TogetherMemService) context.getBean("togetherMemService");
//			
//			//新增
////			model.MemberBean memberBean=new MemberBean();
////			memberBean.setMember_no(3);
////			model.TogetherBean togetherBean=new TogetherBean();
////			togetherBean.setTogether_no(1);
////			TogetherMemBean tome=new TogetherMemBean();
////			tome.setMember_no(memberBean);
////			tome.setTogether_no(togetherBean);
////			tome.setTogethermem_status(1);
////			tome.setTogethermem_time(null);
////			togetherMemService.instert(tome);
//			//修改
////			model.MemberBean memberBean=new MemberBean();
////			memberBean.setMember_no(3);
////			model.TogetherBean togetherBean=new TogetherBean();
////			togetherBean.setTogether_no(1);
////			TogetherMemBean togetherMemBean=new TogetherMemBean();
////			togetherMemBean.setTogethermem_no(5); //主鍵
////			togetherMemBean.setMember_no(memberBean);
////			togetherMemBean.setTogether_no(togetherBean);
////			togetherMemBean.setTogethermem_status(2);
////			togetherMemBean.setTogethermem_time(java.sql.Date.valueOf("2016-12-20"));
////			togetherMemService.update(togetherMemBean);
//			//刪除
////			TogetherMemBean togetherMemBean=new TogetherMemBean();
////			togetherMemBean.setTogethermem_no(5); //主鍵
////			togetherMemService.delete(togetherMemBean);
//			
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		}finally{
//			sessionFactory.close();
//			((ConfigurableApplicationContext) context).close();
//		}
//		
//	}

	public TogetherMemBean instert(TogetherMemBean bean){
		TogetherMemBean result=null;
		if(bean!=null){
			result=togetherMemDao.insert(bean);
		}
		return result;
	}
	
	public TogetherMemBean update(TogetherMemBean bean){
		TogetherMemBean result=null;
		if(bean!=null){
			result=togetherMemDao.update(bean.getTogethermem_no(), bean.getTogether_no(), bean.getMember_no(), bean.getTogethermem_status(), bean.getTogethermem_time());
		}
		return result;
	}
	
	public boolean delete(TogetherMemBean bean){
		boolean result=false;
		if(bean!=null){
			result=togetherMemDao.delete(bean.getTogethermem_no());
		}
		return result;
	}
}
