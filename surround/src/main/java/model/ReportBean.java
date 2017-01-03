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
@Table(name="REPORT", catalog="EEIT90", schema="DBO")
@Component(value="reportBean")
public class ReportBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/*   回報表
	 create table REPORT (
	 report_no	        int IDENTITY (1,1) not null,                     文章編號
	 member_no		    int,											   會員編號
	 report_memo		varchar(500),									   回報內容
	 report_time		datetime,									   	   回報時間
	 report_status	    int,			 		  				    	   回報狀態(處理,未處理)
	 PRIMARY KEY (report_no),
	 FOREIGN KEY (member_no) REFERENCES MEMBER(member_no)
	 );
*/	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int               report_no;
	
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="member_no")
    private MemberBean 		  member_no;
	private String  		  report_memo;
	private java.util.Date 	  report_time;
	private int               report_status;
	private String            report_deal_memo;
	
	

	
	
	@Override
	public String toString() {
		return "ReportBean [report_no=" + report_no + ", member_no=" + member_no + ", report_memo=" + report_memo
				+ ", report_time=" + report_time + ", report_status=" + report_status + ", report_deal_memo="
				+ report_deal_memo + "]";
	}
	public int getReport_no() {
		return report_no;
	}
	public void setReport_no(int report_no) {
		this.report_no = report_no;
	}
		
	public MemberBean getMember_no() {
		return member_no;
	}
	public void setMember_no(MemberBean member_no) {
		this.member_no = member_no;
	}

	
	public String getReport_memo() {
		return report_memo;
	}
	public void setReport_memo(String report_memo) {
		this.report_memo = report_memo;
	}
	public java.util.Date getReport_time() {
		return report_time;
	}
	public void setReport_time(java.util.Date report_time) {
		this.report_time = report_time;
	}
	public int getReport_status() {
		return report_status;
	}  
	public void setReport_status(int report_status) {
		this.report_status = report_status;
	}
	public String getReport_deal_memo() {
		return report_deal_memo;
	}
	public void setReport_deal_memo(String report_deal_memo) {
		this.report_deal_memo = report_deal_memo;
	}
	
	
	
    //測試程式
//	public static void main(String[] args){
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
////			ReportBean bean = (ReportBean) session.get(ReportBean.class, 1);  
////   	    System.out.println("bean:"+bean);		
//  
//			//新增 test
////			ReportBean bean = new ReportBean();
////			MemberBean memberBean = new MemberBean();
////			memberBean.setMember_no(2);
////			
////			bean.setMember_no(memberBean);
////			bean.setReport_memo("圖案可以可愛點.新增");
////			bean.setReport_time(new java.util.Date());
////			bean.setReport_status(0);
////			System.out.println(bean.toString());
////			session.save(bean);
//			
//			//update test
////			ReportBean bean  = session.get(ReportBean.class, 10);  
////			bean.setReport_memo("圖案可以可愛點6.改");
//			
//			//delete test
////			ReportBean bean  = session.get(ReportBean.class, 10);  
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
//	}
	
	
	
	
	
	
	
}
