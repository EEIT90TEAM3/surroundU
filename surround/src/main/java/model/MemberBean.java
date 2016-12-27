package model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Entity
@Table(name="MEMBER",catalog="EEIT90", schema="DBO")
@Component(value="memberBean")
public class MemberBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int	member_no;	//會員編號
	private String account;	//*帳號
	private String pwd;	//*密碼
	private String name; //*姓名
	private String nickname; //*暱稱
	private java.util.Date birth;//*生日
	private String hobby;//*興趣
	private int member_status;//*上線狀態
	private int gender; //*性別(0為female,1為male)*/ 
	private int account_status;/*帳號狀態(0為正常,1為暫時停用,2為永久停用,99為管理員)*/ 
	private Blob member_photo;//*會員照片*
	private java.util.Date suspended;//*停權結束日期
	private String account_email;//*Email帳號
	private String account_google;//*Google帳號
	private String account_facebook;//*Facebook帳號
	//private Set<SaleBean> saleBean = new HashSet<SaleBean>();
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="member_no")
	private Set<AccuseBean> accuseBean=new HashSet<AccuseBean>();
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="member_no")
	private Set<SaleBean> saleBean = new HashSet<SaleBean>();
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="member_no")
	private Set<TogetherBean> togetherBean=new HashSet<TogetherBean>();
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="member_no")
	private Set<TogetherMemBean> togetherMemBean=new HashSet<TogetherMemBean>();
	

    //測試程式
//	public static void main(String[] args) {
//		ApplicationContext context =
//				new ClassPathXmlApplicationContext("beans.config.xml");
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//		try {
//			sessionFactory.getCurrentSession().beginTransaction();
//			Session session = sessionFactory.getCurrentSession();
//			
////單筆查詢	
////			MemberBean memb = session.get(MemberBean.class,1);
////			System.out.println(memb.getMember_no());
////			System.out.println(memb.getAccount());
////			System.out.println(memb.getPwd());
////			System.out.println(memb.getHobby());
////			System.out.println(memb.getMember_status());
////			System.out.println(memb.getGender());
////查詢-getAll
////			Query query = session.createQuery("from MemberBean order by member_no");//對類查詢非對資料庫
////			List<MemberBean> list = query.getResultList();
////			for (MemberBean aDept : list) {
////				System.out.print(aDept.getMember_no() + ",");
////				System.out.print(aDept.getAccount() + ",");
////				System.out.print(aDept.getPwd());
////				System.out.print(aDept.getName());
////				System.out.print(aDept.getNickname());
////				System.out.print(aDept.getBirth());
////				System.out.print(aDept.getHobby());
////				System.out.print(aDept.getMember_status());
////				System.out.print(aDept.getGender());
////				System.out.print(aDept.getAccount_status());
////				System.out.print(aDept.getMember_photo());
////				System.out.print(aDept.getSuspended());
////				System.out.print(aDept.getAccount_google());
////				System.out.print(aDept.getAccount_facebook());
////				System.out.println();
////				}
//	
//			//getAll加上擺攤
////			Query query1 = session.createQuery("from MemberBean order by member_no");
////			List<MemberBean> list1 = query1.getResultList();
////			for (MemberBean aDept : list1) {
////				System.out.print(aDept.getMember_no() + ",");
////				System.out.print(aDept.getAccount() + ",");
////				System.out.print(aDept.getPwd());
////				System.out.print(aDept.getName());
////				System.out.print(aDept.getNickname());
////				System.out.print(aDept.getBirth());
////				System.out.print(aDept.getHobby());
////				System.out.print(aDept.getMember_status());
////				System.out.print(aDept.getMember_photo());
////				System.out.print(aDept.getSuspended());
////				System.out.print(aDept.getMember_photo());
////				System.out.print(aDept.getAccount_google());
////				System.out.print(aDept.getAccount_facebook());
////				
////				System.out.println("\n-----------------");
////				Set<SaleBean> set2 = aDept.getSaleBean();
////				for (SaleBean aEmp : set2) {
////					System.out.print(aEmp.getSale_no() + ",");
////					System.out.print(aEmp.getSale_topic() + ",");
////					System.out.print(aEmp.getSale_name() + ",");
////					System.out.print(aEmp.getSale_locate() + ",");
////					System.out.print(aEmp.getSale_time() + ",");
////					System.out.print(aEmp.getSale_memo() + ",");
////					System.out.print(aEmp.getSale_post_time() + ",");
////					System.out.print(aEmp.getSale_delete_time() + ",");
////					System.out.print(aEmp.getSale_modify_time() + ",");
////					System.out.print(aEmp.getSale_status() + ",");
////					System.out.print(aEmp.getSale_lng() + ",");	
////					System.out.print(aEmp.getMember_no().getMember_no() + ",");
////					System.out.print(aEmp.getMember_no().getAccount() + ",");
////					System.out.print(aEmp.getMember_no().getPwd());
////					System.out.println();
////				}
////				System.out.println();
////			}
////新增  無主鍵則為修改
////			MemberBean memberBean = new MemberBean(); //會員POJO
////			memberBean.setAccount("DOIJOIJ");
////			memberBean.setPwd("製造部s");
////			memberBean.setName("中國江西s");
////			memberBean.setNickname("中國江西s");
////			memberBean.setBirth(null);
////			memberBean.setHobby("中國江西s");
////			memberBean.setMember_status(1);
////			memberBean.setGender(2);
////			memberBean.setAccount_status(0);
////			memberBean.setMember_photo(null);
////			memberBean.setSuspended(null);
////			memberBean.setAccount_google("中國江西s");
////			memberBean.setAccount_facebook("製造部s");
////			session.saveOrUpdate(memberBean);
////刪除
////			MemberBean membdelete = session.get(MemberBean.class,8);
////			session.delete(membdelete);
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
	
//	@Column(name = "member_no")
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getMember_no() {
		return member_no;
	}
	
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	
	//@OrderBy("together_no")
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="member_no")	
	public Set<AccuseBean> getAccuseBean() {
		return accuseBean;
	}

	public void setAcuseBean(Set<AccuseBean> accuseBean) {
		this.accuseBean = accuseBean;
	}
	
	public Set<SaleBean> getSaleBean() {
		return saleBean;
	}
	public void setSaleBean(Set<SaleBean> saleBean) {
		this.saleBean = saleBean;
	}
	
	public Set<TogetherBean> getTogetherBean() {
		return togetherBean;
	}

	public void setTogetherBean(Set<TogetherBean> togetherBean) {
		this.togetherBean = togetherBean;
	}
	
	public Set<TogetherMemBean> getTogetherMemBean() {
		return togetherMemBean;
	}

	public void setTogetherMemBean(Set<TogetherMemBean> togetherMemBean) {
		this.togetherMemBean = togetherMemBean;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public java.util.Date getBirth() {
		return birth;
	}
	public void setBirth(java.util.Date birth) {
		this.birth = birth;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public int getMember_status() {
		return member_status;
	}
	public void setMember_status(int member_status) {
		this.member_status = member_status;
	}	
//	@OrderBy("sale_no,asc")
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="member_no")
//	public Set<SaleBean> getSaleBean() {
//		return saleBean;
//	}
//	public void setSaleBean(Set<SaleBean> saleBean) {
//		this.saleBean = saleBean;
//	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getAccount_status() {
		return account_status;
	}
	public void setAccount_status(int account_status) {
		this.account_status = account_status;
	}
	public Blob getMember_photo() {
		return member_photo;
	}
	public void setMember_photo(Blob member_photo) {
		this.member_photo = member_photo;
	}
	public java.util.Date getSuspended() {
		return suspended;
	}
	public void setSuspended(java.util.Date suspended) {
		this.suspended = suspended;
	}
	public String getAccount_email() {
		return account_email;
	}

	public void setAccount_email(String account_email) {
		this.account_email = account_email;
	}
	public String getAccount_google() {
		return account_google;
	}
	public void setAccount_google(String account_google) {
		this.account_google = account_google;
	}
	public String getAccount_facebook() {
		return account_facebook;
	}
	public void setAccount_facebook(String account_facebook) {
		this.account_facebook = account_facebook;
	}

}
