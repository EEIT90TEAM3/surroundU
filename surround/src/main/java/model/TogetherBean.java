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
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import model.MemberBean;

@Entity
@Table(name="Together",catalog="EEIT90", schema="DBO")
@Component(value="togetherBean")
public class TogetherBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int together_no;                 /*約團文章編號*/
	
	//private int member_no;                       /*會員編號*/
	@ManyToOne(fetch=FetchType.LAZY,targetEntity = MemberBean.class)
	@JoinColumn(name="member_no")
	private MemberBean member_no;
	private String together_topic;               /*主題(唱歌,逛街,運動.....)*/
	private String together_name;                /*約團名稱*/
	private String together_locate;              /*地點*/
	private java.util.Date together_when;        /*活動時間*/
	private java.util.Date together_when_end;    /*活動時間結束*/
	private int together_people;                 /*限定人數*/
	private String together_memo;                /*備註*/
	private java.util.Date together_post_time;   /*發文時間*/
	private java.util.Date together_delete_time; /*刪除時間*/
	private java.util.Date together_modify_time; /*修改時間*/
	private int together_status;                 /*文章狀態*/
	private float together_lng;                 /*經度*/
	private float together_lat;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="together_no")
	private Set<TogetherMemBean> togetherBeanMem=new HashSet<TogetherMemBean>();
	
	
	//測試程式
//	public static void main(String[] args){
//		ApplicationContext context =
//				new ClassPathXmlApplicationContext("beans.config.xml");
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//		try {
//			sessionFactory.getCurrentSession().beginTransaction();
//			Session session = sessionFactory.getCurrentSession();
//
//			TogetherBean memb=session.get(TogetherBean.class, 1);
//			//單筆查詢
////			System.out.println(memb.getMember_no().getName()+","+memb.getMember_no().getAccount()+","
////					           +memb.getMember_no().getPwd()+","+memb.getMember_no().getNickname()+","+memb.getMember_no().getBirth()+","+memb.getMember_no().getHobby());
//	
////			System.out.println(memb.getTogether_name()+",");
//	
//			//多筆查詢
////			List<TogetherBean> list = null;
////			Query query = session.createQuery("from TogetherBean order by together_no");
////			list = query.getResultList();
////			for(TogetherBean tobe : list){
////				System.out.println(tobe.getTogether_no()+","+tobe.getMember_no().getName());
////			}
//			
//			//新增或修改
////			MemberBean memberBean = new MemberBean(); // 部門POJO
////			memberBean.setMember_no(2);
////			TogetherBean tobn=new TogetherBean();
////			tobn.setMember_no(memberBean);
////			tobn.setTogether_no(3);
////			tobn.setTogether_topic("遊戲.改");
////			tobn.setTogether_name("翻花繩");
////			tobn.setTogether_locate("大安森林公園");
////			tobn.setTogether_when(java.sql.Date.valueOf("2016-12-20"));
////			tobn.setTogether_when_end(java.sql.Date.valueOf("2016-12-21"));;
////			tobn.setTogether_people(20);
////			tobn.setTogether_memo("翻花繩教學");
////			tobn.setTogether_post_time(null);
////			tobn.setTogether_delete_time(null);
////			tobn.setTogether_modify_time(null);
////			tobn.setTogether_status(0);
////			tobn.setTogether_lat(0);
////			tobn.setTogether_lng(0);
////			session.saveOrUpdate(tobn);
//			
//			//刪除
//		
////			Query query = session.createQuery("delete TogetherBean where together_no=3");
////			
////			System.out.println("刪除的筆數=" + query.executeUpdate());
//			
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		} finally {
//				//	sessionFactory.getCurrentSession().getTransaction().rollback();
//			sessionFactory.close();
//			((ConfigurableApplicationContext) context).close();
//		}
//	
//	
//	}
	

	
	
	@Override
	public String toString() {
		return "TogetherBean [together_no=" + together_no + ", member_no=" + member_no + ", together_topic="
				+ together_topic + ", together_name=" + together_name + ", together_locate=" + together_locate
				+ ", together_when=" + together_when + ", together_when_end=" + together_when_end + ", together_people="
				+ together_people + ", together_memo=" + together_memo + ", together_post_time=" + together_post_time
				+ ", together_delete_time=" + together_delete_time + ", together_modify_time=" + together_modify_time
				+ ", together_status=" + together_status + ", together_lng=" + together_lng + ", together_lat="
				+ together_lat + ", togetherBeanMem=" + togetherBeanMem + "]";
	}




	public int getTogether_no() {
		return together_no;
	}
		public void setTogether_no(int together_no) {
		this.together_no = together_no;
	}
//		@ManyToOne(fetch=FetchType.LAZY) //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
//		@JoinColumn(name = "member_no")
		public MemberBean getMember_no() {
			return member_no;
		}
		public void setMember_no(MemberBean member_no) {
			this.member_no = member_no;
		}

		
	public String getTogether_topic() {
		return together_topic;
	}
	public void setTogether_topic(String together_topic) {
		this.together_topic = together_topic;
	}
	public String getTogether_name() {
		return together_name;
	}
	public void setTogether_name(String together_name) {
		this.together_name = together_name;
	}
	public String getTogether_locate() {
		return together_locate;
	}
	public void setTogether_locate(String together_locate) {
		this.together_locate = together_locate;
	}
	public java.util.Date getTogether_when() {
		return together_when;
	}
	public void setTogether_when(java.util.Date together_when) {
		this.together_when = together_when;
	}
	
	
	
	public java.util.Date getTogether_when_end() {
		return together_when_end;
	}
	public void setTogether_when_end(java.util.Date together_when_end) {
		this.together_when_end = together_when_end;
	}
	public int getTogether_people() {
		return together_people;
	}
	public void setTogether_people(int together_people) {
		this.together_people = together_people;
	}
	public String getTogether_memo() {
		return together_memo;
	}
	public void setTogether_memo(String together_memo) {
		this.together_memo = together_memo;
	}
	public java.util.Date getTogether_post_time() {
		return together_post_time;
	}
	public void setTogether_post_time(java.util.Date together_post_time) {
		this.together_post_time = together_post_time;
	}
	public java.util.Date getTogether_delete_time() {
		return together_delete_time;
	}
	public void setTogether_delete_time(java.util.Date together_delete_time) {
		this.together_delete_time = together_delete_time;
	}
	public java.util.Date getTogether_modify_time() {
		return together_modify_time;
	}
	public void setTogether_modify_time(java.util.Date together_modify_time) {
		this.together_modify_time = together_modify_time;
	}
	public int getTogether_status() {
		return together_status;
	}
	public void setTogether_status(int together_status) {
		this.together_status = together_status;
	}
	
public float getTogether_lng() {
		return together_lng;
	}
	public void setTogether_lng(float together_lng) {
		this.together_lng = together_lng;
	}
	public float getTogether_lat() {
		return together_lat;
	}
	public void setTogether_lat(float together_lat) {
		this.together_lat = together_lat;
	}
	//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="together_no")
	public Set<TogetherMemBean> getTogetherBeanMem() {
		return togetherBeanMem;
	}
	public void setTogetherBeanMem(Set<TogetherMemBean> togetherBeanMem) {
		this.togetherBeanMem = togetherBeanMem;
	}   
	
	
}
