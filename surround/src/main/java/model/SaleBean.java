package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


@Entity
@Table(name="SALE",catalog="EEIT90", schema="DBO")
@Component(value="saleBean")
public class SaleBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id //主鍵	
	@GeneratedValue(strategy = GenerationType.IDENTITY)   //2.再用@GeneratedValue的generator屬性指定要用哪個generator
	private int sale_no;  /*擺攤文章編號*/
	@ManyToOne(fetch=FetchType.LAZY) //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "member_no")  //指定用來join table的column
	private MemberBean member_no; /*會員編號*/
	private String sale_topic ;/*主題*/
	private String sale_name;/*擺攤名稱*/
	private String sale_locate;/*地點*/
	private java.util.Date sale_time;/*時間*/
	private String sale_memo;/*備註*/
	private java.util.Date sale_post_time;/*發文時間*/
	private java.util.Date sale_delete_time;/*刪除時間*/
	private java.util.Date sale_modify_time;/*修改時間*/
	private int sale_status;/*文章狀態*/
	private float sale_lng;/*經度*/
	private float sale_lat;/*緯度*/
	//@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="sale_no")
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="sale_no")//避免fk無法刪掉 
	private Set<ProductBean> productBean = new HashSet<ProductBean>();

    //測試程式
//	public static void main(String[] args) {
////		//hibernate控管session
////			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
////			Session session = HibernateUtil.getSessionFactory().getCurrentSession();		
//		ApplicationContext context =
//				new ClassPathXmlApplicationContext("beans.config.xml");
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//		
//		try {
//
//		sessionFactory.getCurrentSession().beginTransaction();
//		Session session = sessionFactory.getCurrentSession();
////單筆查詢	
////		SaleBean memb = session.get(SaleBean.class,2);
////		System.out.print(memb.getSale_no()+",");
////		System.out.print(memb.getMember_no().getPwd()+",");
////		System.out.print(memb.getSale_topic()+",");
////		System.out.print(memb.getSale_name()+",");
////		System.out.print(memb.getSale_locate()+",");
////		System.out.print(memb.getSale_time()+",");
////		System.out.print(memb.getSale_memo()+",");
////		System.out.print(memb.getSale_post_time()+",");
////		System.out.print(memb.getSale_delete_time()+",");
////		System.out.print(memb.getSale_modify_time()+",");
////		System.out.print(memb.getSale_status()+",");
////		System.out.print(memb.getSale_lng()+",");
////		System.out.print(memb.getSale_lat()+",");
////多筆查詢	
////		Query query = session.createQuery("from SaleBean order by sale_no");
////		List<SaleBean> list = query.getResultList();
////		for (SaleBean aDept : list) {
////			System.out.print(aDept.getSale_no()+",");
////			System.out.print(aDept.getMember_no().getPwd()+",");
////			System.out.print(aDept.getSale_topic()+",");
////			System.out.print(aDept.getSale_name()+",");
////			System.out.print(aDept.getSale_locate()+",");
////			System.out.print(aDept.getSale_time()+",");
////			System.out.print(aDept.getSale_memo()+",");
////			System.out.print(aDept.getSale_post_time()+",");
////			System.out.print(aDept.getSale_delete_time()+",");
////			System.out.print(aDept.getSale_modify_time()+",");
////			System.out.print(aDept.getSale_status()+",");
////			System.out.print(aDept.getSale_lng()+",");
////			System.out.print(aDept.getSale_lat()+",");
////			System.out.println();}
////新增或修改			
////		    MemberBean memberBean = new model.MemberBean(); // 部門POJO
////			memberBean.setMember_no(2);
////			SaleBean saleBean = new SaleBean(); //會員POJO
////			saleBean.setSale_no(5);
////			saleBean.setMember_no(memberBean);
////			saleBean.setSale_topic("這是修改你知道的");
////			saleBean.setSale_name("中國江西s");
////			saleBean.setSale_locate("中國江西s");
////			saleBean.setSale_time(null);
////			saleBean.setSale_memo("中國江西s");
////			saleBean.setSale_post_time(null);
////			saleBean.setSale_delete_time(null);
////			saleBean.setSale_modify_time(null);
////			saleBean.setSale_status(0);
////			saleBean.setSale_lng(0);
////			saleBean.setSale_lat(0);
////			session.saveOrUpdate(saleBean);
////刪除
////		SaleBean saledelete = session.get(SaleBean.class,7);
////		session.delete(saledelete);
//
//			
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		}finally{
//			sessionFactory.close();
//			((ConfigurableApplicationContext) context).close();
//		}
//	}
	
	
	public int getSale_no() {
		return sale_no;
	}
	public void setSale_no(int sale_no) {
		this.sale_no = sale_no;
	}
	

	public MemberBean getMember_no() {
		return member_no;
	}
	public void setMember_no(MemberBean member_no) {
		this.member_no = member_no;
	}
	public String getSale_topic() {
		return sale_topic;
	}
	public void setSale_topic(String sale_topic) {
		this.sale_topic = sale_topic;
	}
	public String getSale_name() {
		return sale_name;
	}
	public void setSale_name(String sale_name) {
		this.sale_name = sale_name;
	}
	public String getSale_locate() {
		return sale_locate;
	}
	public void setSale_locate(String sale_locate) {
		this.sale_locate = sale_locate;
	}
	public java.util.Date getSale_time() {
		return sale_time;
	}
	public void setSale_time(java.util.Date sale_time) {
		this.sale_time = sale_time;
	}
	public String getSale_memo() {
		return sale_memo;
	}
	public void setSale_memo(String sale_memo) {
		this.sale_memo = sale_memo;
	}
	public java.util.Date getSale_post_time() {
		return sale_post_time;
	}
	public void setSale_post_time(java.util.Date sale_post_time) {
		this.sale_post_time = sale_post_time;
	}
	public java.util.Date getSale_delete_time() {
		return sale_delete_time;
	}
	public void setSale_delete_time(java.util.Date sale_delete_time) {
		this.sale_delete_time = sale_delete_time;
	}
	public java.util.Date getSale_modify_time() {
		return sale_modify_time;
	}
	public void setSale_modify_time(java.util.Date sale_modify_time) {
		this.sale_modify_time = sale_modify_time;
	}
	public int getSale_status() {
		return sale_status;
	}
	public void setSale_status(int sale_status) {
		this.sale_status = sale_status;
	}
	public float getSale_lng() {
		return sale_lng;
	}
	public void setSale_lng(float sale_lng) {
		this.sale_lng = sale_lng;
	}
	public float getSale_lat() {
		return sale_lat;
	}
	public void setSale_lat(float sale_lat) {
		this.sale_lat = sale_lat;
	}	

	public Set<ProductBean> getProductBean() {
		return productBean;
	}
	public void setProductBean(Set<ProductBean> productBean) {
		this.productBean = productBean;
	}
}

