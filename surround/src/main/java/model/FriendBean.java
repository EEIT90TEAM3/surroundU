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
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="FRIEND",catalog="EEIT90", schema="DBO")
@Component(value="FriendBean")
public class FriendBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Expose private int friend_no;/*流水號*/
	@Expose private MemberBean member_no;/*會員編號(發話會員編號)*/
	@Expose private MemberBean buddy_no;/*會員編號(發話會員編號)*/	
	@Expose private int friend_status;/*聊天內容*/

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Session session = sessionFactory.getCurrentSession();

			//單筆查詢	
			
//			FriendBean memb = session.get(FriendBean.class, 1);
//			System.out.print(memb.getFriend_no()+",");
//			System.out.print(memb.getBuddy_no()+",");
//			System.out.print(memb.getFriend_status()+",");
//			System.out.print(memb.getMember_no());			
			
			Query query = session.createQuery("from FriendBean");
			List<FriendBean> list = query.getResultList();
			for (FriendBean memb : list) {
			System.out.print(memb.getFriend_no()+",");
			System.out.print(memb.getBuddy_no()+",");
			System.out.print(memb.getFriend_status()+",");
			System.out.print(memb.getMember_no());}
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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getFriend_no() {
		return friend_no;
	}
	public void setFriend_no(int friend_no) {
		this.friend_no = friend_no;
	}
	@ManyToOne(fetch=FetchType.EAGER,targetEntity = MemberBean.class) //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "member_no")  //指定用來join table的column
	public MemberBean getMember_no() {
		return member_no;
	}
	public void setMember_no(MemberBean member_no) {
		this.member_no = member_no;
	}
	@ManyToOne(fetch=FetchType.EAGER,targetEntity = MemberBean.class) //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "buddy_no")  //指定用來join table的column
	public MemberBean getBuddy_no() {
		return buddy_no;
	}
	public void setBuddy_no(MemberBean buddy_no) {
		this.buddy_no = buddy_no;
	}
	public int getFriend_status() {
		return friend_status;
	}
	public void setFriend_status(int friend_status) {
		this.friend_status = friend_status;
	}	
	
}
