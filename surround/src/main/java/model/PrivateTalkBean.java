package model;

import java.io.Serializable;
import java.util.List;

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
@Table(name="PRIVATETALK",catalog="EEIT90", schema="DBO")
@Component(value="privateTalkBean")
public class PrivateTalkBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id //主鍵
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int privatetalk_no;/*流水號*/
//	private SaleBean member_no;/*擺攤文章編號*/
	private String privatetalk_txt;/*聊天內容*/
	private java.util.Date privatetalk_time;/*聊天時間*/
	private int privatetalk_status;
	
	@ManyToOne(fetch=FetchType.LAZY,targetEntity = MemberBean.class) //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "member_no")  //指定用來join table的column
	private MemberBean member_no;/*會員編號(發話會員編號)*/

	@ManyToOne(fetch=FetchType.LAZY,targetEntity = MemberBean.class) //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "catch_id")  //指定用來join table的column
	private MemberBean catch_id;/*會員編號(發話會員編號)*/
	

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Session session = sessionFactory.getCurrentSession();

			//單筆查詢	
			PrivateTalkBean memb = session.get(PrivateTalkBean.class, 1);
			System.out.print(memb.getPrivatetalk_no()+",");
			System.out.print(memb.getPrivatetalk_txt()+",");
			System.out.print(memb.getPrivatetalk_time()+",");
			System.out.print(memb.getMember_no()+",");
			System.out.print(memb.getCatch_id()+",");			
			
//			Query query = session.createQuery("from PrivateTalkBean");
//			List<PrivateTalkBean> list = query.getResultList();
//			for (PrivateTalkBean aDept : list) {
//				System.out.print(aDept.getPrivatetalk_no()+",");
//				System.out.print(aDept.getPrivatetalk_txt()+",");
//				System.out.print(aDept.getPrivatetalk_time()+",");
//				System.out.print(aDept.getMember_no()+",");
//				System.out.print(aDept.getCatch_id()+",");
//				System.out.println();}
			//新增或修改			
//			model.SaleBean saleBean = new model.SaleBean();
//			saleBean.setSale_no(2);
//				ProductBean productBean = new ProductBean(); //會員POJO
//			//	productBean.setProduct_no(5);
//				productBean.setSale_no(saleBean);
//				productBean.setProduct_name("這是修改你知道的");
//				productBean.setProduct_memo("這是修改你知道的");
//				productBean.setProduct_price(20000);
//				productBean.setProduct_pic(null);
//				productBean.setProduct_status(0);
//				session.save(productBean);//新增
//				session.merge(productBean);//修改
			
//刪除
//			ProductBean saledelete = session.get(ProductBean.class,3);
//			session.delete(saledelete);	
			
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			sessionFactory.close();
			((ConfigurableApplicationContext) context).close();
		}
	}
			

	public int getPrivatetalk_status() {
		return privatetalk_status;
	}


	public void setPrivatetalk_status(int privatetalk_status) {
		this.privatetalk_status = privatetalk_status;
	}


	public int getPrivatetalk_no() {
		return privatetalk_no;
	}
	public void setPrivatetalk_no(int privatetalk_no) {
		this.privatetalk_no = privatetalk_no;
	}
	public String getPrivatetalk_txt() {
		return privatetalk_txt;
	}
	public void setPrivatetalk_txt(String privatetalk_txt) {
		this.privatetalk_txt = privatetalk_txt;
	}
	public java.util.Date getPrivatetalk_time() {
		return privatetalk_time;
	}
	public void setPrivatetalk_time(java.util.Date privatetalk_time) {
		this.privatetalk_time = privatetalk_time;
	}
	public MemberBean getMember_no() {
		return member_no;
	}
	public void setMember_no(MemberBean member_no) {
		this.member_no = member_no;
	}
	public MemberBean getCatch_id() {
		return catch_id;
	}
	public void setCatch_id(MemberBean catch_id) {
		this.catch_id = catch_id;
	}
}
