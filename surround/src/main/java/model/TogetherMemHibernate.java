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
import model.TogetherBean;
import model.TogetherMemBean;
import model.TogetherMemDAO;

@Repository(value="togetherMemDao")
public class TogetherMemHibernate implements TogetherMemDAO {
    @Autowired
	private SessionFactory sessionFactory;
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	//測試程式
//	public static void main(String[] args) {
//		ApplicationContext context=new ClassPathXmlApplicationContext("beans.config.xml");
//		SessionFactory sessionFactory=(SessionFactory)context.getBean("sessionFactory");
//		try{
//			sessionFactory.getCurrentSession().beginTransaction();
//			TogetherMemDAO dao=(TogetherMemDAO)context.getBean("togetherMemDao");
//			//單筆查詢
////			TogetherMemBean tome=dao.select(1);
////			System.out.println(tome.getTogethermem_no());
////			System.out.println(tome.getTogether_no().getTogether_memo());
////			System.out.println(tome.getTogether_no().getMember_no().getName());
////			System.out.println(tome.getTogethermem_status());
//			//多筆查詢
////			List<TogetherMemBean> list=dao.select();
////			for(TogetherMemBean tome : list){
////				System.out.println(tome.getTogethermem_no());
////				System.out.println(tome.getTogether_no().getTogether_memo());
////				System.out.println(tome.getMember_no().getName());
////				System.out.println(tome.getTogethermem_status());
////			}
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
////			dao.insert(tome);
//			//修改
////			model.MemberBean memberBean=new MemberBean();
////			memberBean.setMember_no(4);
////			model.TogetherBean togetherBean=new TogetherBean();
////			togetherBean.setTogether_no(1);
////			dao.update(3, togetherBean, memberBean, 1, null);
////			
//			//刪除
////		    dao.delete(4);
//			
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		}finally{
//			sessionFactory.close();
//			((ConfigurableApplicationContext)context).close();
//			
//		}
//
//	}

	@Override
	public TogetherMemBean select(int togethermem_no) {
		return this.getSession().get(TogetherMemBean.class, togethermem_no);
	}

	@Override
	public List<TogetherMemBean> select() {
		Query query=this.getSession().createQuery("from TogetherMemBean");
		return (List<TogetherMemBean>) query.getResultList();
	}

	@Override
	public TogetherMemBean insert(TogetherMemBean bean) {
		if(bean!=null){
		      TogetherMemBean insert=this.getSession().get(TogetherMemBean.class,bean.getTogethermem_no());
		   if(insert==null){
		         this.getSession().save(bean);
		         return bean;
		   }
		}
		return null;
	}

	@Override
	public TogetherMemBean update(int togethermem_no, TogetherBean together_no, MemberBean member_no, int togethermem_status,
			Date togethermem_time) {
		TogetherMemBean update=this.getSession().get(TogetherMemBean.class, togethermem_no);
		if(update!=null){
			update.setMember_no(member_no);
			update.setTogether_no(together_no);
			update.setTogethermem_status(togethermem_status);
			update.setTogethermem_time(togethermem_time);
			
		}
		return update;
	}

	@Override
	public boolean delete(int togethermem_no) {
		TogetherMemBean delete=this.getSession().get(TogetherMemBean.class, togethermem_no);
		if(delete!=null){
			this.getSession().delete(delete);
			return true;
		}
		return false;
	}

	
	
	
	
}
