package model;

import java.io.Serializable;

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
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Entity
@Table(name="ACCUSE", catalog="EEIT90", schema="DBO")
@Component(value="accuseBean")
public class AccuseBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/*	accuse_no		int IDENTITY (1,1) not null,                    檢舉編號
	member_no			int,						  		 	            會員編號(檢舉人)
	accuse_type			varchar(100),								 檢舉內容
	accuse_topic		varchar(20),								 檢舉主題(聊天,約團)
	accuse_post_time	datetime,									 檢舉時間
	accuse_status		int,										 檢舉狀態(成功,駁回)
	accuse_deal_time	datetime,									 處理時間
	sale_no  			int,										 擺攤文章編號
	group_no     		int,										 約團文章編號
*/  
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int accuse_no;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="member_no")
   private MemberBean member_no;
  
   private String accuse_type;
   private String accuse_topic;
   private java.util.Date accuse_post_time;
   private int accuse_status;
   private java.util.Date accuse_deal_time;
   private int sale_no;
   private int group_no;
   private String accuse_deal_memo;
	
    

   
    
   
	@Override
	public String toString() {
		return "AccuseBean [accuse_no=" + accuse_no + ", member_no=" + member_no + ", accuse_type=" + accuse_type
				+ ", accuse_topic=" + accuse_topic + ", accuse_post_time=" + accuse_post_time + ", accuse_status="
				+ accuse_status + ", accuse_deal_time=" + accuse_deal_time + ", sale_no=" + sale_no + ", group_no="
				+ group_no + ", accuse_deal_memo=" + accuse_deal_memo + "]";
	}
	
	public int getAccuse_no() {
		return accuse_no;
	}
	public void setAccuse_no(int accuse_no) {
		this.accuse_no = accuse_no;
	}
    
	
	public MemberBean getMember_no() {
		return member_no;
	}
	public void setMember_no(MemberBean member_no) {
		this.member_no = member_no;
	}
	
	
	public String getAccuse_type() {
		return accuse_type;
	}
	public void setAccuse_type(String accuse_type) {
		this.accuse_type = accuse_type;
	}
	
	
	public String getAccuse_topic() {
		return accuse_topic;
	}
	public void setAccuse_topic(String accuse_topic) {
		this.accuse_topic = accuse_topic;
	}
	
	
	public java.util.Date getAccuse_post_time() {
		return accuse_post_time;
	}
	public void setAccuse_post_time(java.util.Date accuse_post_time) {
		this.accuse_post_time = accuse_post_time;
	}
	
	
	public int getAccuse_status() {
		return accuse_status;
	}
	public void setAccuse_status(int accuse_status) {
		this.accuse_status = accuse_status;
	}
	
	
	public java.util.Date getAccuse_deal_time() {
		return accuse_deal_time;
	}
	public void setAccuse_deal_time(java.util.Date accuse_deal_time) {
		this.accuse_deal_time = accuse_deal_time;
	}
	
	
	public int getSale_no() {
		return sale_no;
	}
	public void setSale_no(int sale_no) {
		this.sale_no = sale_no;
	}
	
	
	public int getGroup_no() {
		return group_no;
	}
	public void setGroup_no(int group_no) {
		this.group_no = group_no;
	}

	public String getAccuse_deal_memo() {
		return accuse_deal_memo;
	}

	public void setAccuse_deal_memo(String accuse_deal_memo) {
		this.accuse_deal_memo = accuse_deal_memo;
	}
	
	
   
    //測試程式
//	public static void main(String[] args){
//		
//		
//		
//		ApplicationContext context = 
//				new ClassPathXmlApplicationContext("beans.config.xml");    //讀取beans.config.xml取得datasource
//		
//		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
//		
//	    
//		
//		try {
//			sessionFactory.getCurrentSession().beginTransaction();
//			Session session = sessionFactory.getCurrentSession();
//			
//			//查詢 test
////			AccuseBean bean = (AccuseBean) session.get(AccuseBean.class, 2);  
////   		    System.out.println("bean:"+bean);		
//  
//			//新增 test
////			AccuseBean accuseBean = new AccuseBean();     
////			
////			
////			MemberBean memberBean = new MemberBean();
////			memberBean.setMember_no(2);               
////			
////			accuseBean.setMember_no(memberBean);
////			accuseBean.setAccuse_type("內容不雅txt");
////			accuseBean.setAccuse_topic("擺攤");
////			accuseBean.setAccuse_post_time(new java.util.Date());
////			accuseBean.setAccuse_status(0);
////			accuseBean.setAccuse_deal_time(new java.util.Date());
////			accuseBean.setSale_no(7);
////			accuseBean.setGroup_no(0);
////			session.save(accuseBean);
//			
//			//update tests
////			AccuseBean bean  = session.get(AccuseBean.class, 2);  
////			bean.setAccuse_type("內容不雅.改");
//			
//			//delete test
////			AccuseBean bean  = session.get(AccuseBean.class, 7);  
////			session.delete(bean);
//			
//			
//			
//			
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		} finally{
//			sessionFactory.close();
//			((ConfigurableApplicationContext)context).close();
//		}
//			
//	}//End of test
	
	
	

}
