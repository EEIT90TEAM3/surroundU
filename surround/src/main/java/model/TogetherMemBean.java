package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Query;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Entity
@Table(name="TOGETHERMEM",catalog="EEIT90", schema="DBO")
@Component(value="togetherMemBean")
public class TogetherMemBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int togethermem_no;		         /*流水號*/
	
	@ManyToOne(fetch=FetchType.LAZY,targetEntity = TogetherBean.class)
	@JoinColumn(name="together_no")
	private TogetherBean together_no;        /*約團文章編號*/
	
	@ManyToOne(fetch=FetchType.LAZY,targetEntity = MemberBean.class)
	@JoinColumn(name="member_no")
	private MemberBean member_no;					 /*會員編號*/
	private int togethermem_status;  		 /*申請狀態(申請中,已加入,拒絕....)*/
	private java.util.Date togethermem_time;
	
    //測試程式
//	public static void main(String[] args) {
//		ApplicationContext context =
//				new ClassPathXmlApplicationContext("beans.config.xml");
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//		try {
//			sessionFactory.getCurrentSession().beginTransaction();
//			Session session = sessionFactory.getCurrentSession();
//
//			TogetherMemBean tome=session.get(TogetherMemBean.class, 1);
//			//單筆查詢
////			System.out.println(tome.getMember_no().getName()+","+tome.getMember_no().getAccount()+","
////					           +tome.getMember_no().getPwd()+","+tome.getMember_no().getNickname()+","+tome.getMember_no().getBirth()+","+tome.getMember_no().getHobby());
////	
////			System.out.println(tome.getTogether_no().getMember_no().getName());
////	
//			//多筆查詢
////			List<TogetherBean> list = null;
////			Query query = session.createQuery("from TogetherBean order by together_no");
////			list = query.getResultList();
////			for(TogetherBean tobe : list){
////				System.out.println(tobe.getTogether_no()+","+tobe.getMember_no().getName());
////			}
//			
//			//新增或修改
////			model.MemberBean memberBean = new model.MemberBean(); // 部門POJO
////			memberBean.setMember_no(1);
////			
////					
////			model.TogetherBean togetherBean = new model.TogetherBean(); // 部門POJO
////			
////			togetherBean.setMember_no(memberBean);
////			togetherBean.setTogether_no(1);
////			
////			
////			
////			TogetherMemBean togetherMemBean=new TogetherMemBean();
////			togetherMemBean.setTogether_no(togetherBean);
////			togetherMemBean.setMember_no(memberBean);
////			togetherMemBean.setTogethermem_status(1);
////			togetherMemBean.setTogethermem_time(java.sql.Date.valueOf("2016-12-20"));
////			session.saveOrUpdate(togetherMemBean);
//			
//			//刪除
//		
////			Query query = session.createQuery("delete TogetherMemBean where togetherMem_no=3");
////			
////			System.out.println("刪除的筆數=" + query.executeUpdate());
//			
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		} finally {
//				//	sessionFactory.getCurrentSession().getTransaction().rollback();
//			sessionFactory.close();
//			((ConfigurableApplicationContext) context).close();
//			}	
//
//	}


	public int getTogethermem_no() {
		return togethermem_no;
	}


	public void setTogethermem_no(int togethermem_no) {
		this.togethermem_no = togethermem_no;
	}




	public TogetherBean getTogether_no() {
		return together_no;
	}


	public void setTogether_no(TogetherBean together_no) {
		this.together_no = together_no;
	}


	public MemberBean getMember_no() {
		return member_no;
	}


	public void setMember_no(MemberBean member_no) {
		this.member_no = member_no;
	}


	public int getTogethermem_status() {
		return togethermem_status;
	}


	public void setTogethermem_status(int togethermem_status) {
		this.togethermem_status = togethermem_status;
	}


	public java.util.Date getTogethermem_time() {
		return togethermem_time;
	}


	public void setTogethermem_time(java.util.Date togethermem_time) {
		this.togethermem_time = togethermem_time;
	}

	
	
}
