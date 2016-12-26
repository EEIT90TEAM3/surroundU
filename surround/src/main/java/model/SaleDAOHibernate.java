package model;

import java.io.File;
import java.sql.Blob;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import org.springframework.context.ConfigurableApplicationContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository(value="saleDAO")
public class SaleDAOHibernate implements SaleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	//測試程式
//	public static void main(String[] args) {
//		ApplicationContext context =
//				new ClassPathXmlApplicationContext("beans.config.xml");
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//		try {
//			sessionFactory.getCurrentSession().beginTransaction();
//			SaleDAO saleDao = (SaleDAO) context.getBean("saleDAO");
////單筆查詢			
////			SaleBean memb = saleDao.select(1);
////			System.out.print(memb.getSale_no()+",");
////			System.out.print(memb.getMember_no().getPwd()+",");
////			System.out.print(memb.getSale_topic()+",");
////			System.out.print(memb.getSale_name()+",");
////			System.out.print(memb.getSale_locate()+",");
////			System.out.print(memb.getSale_time()+",");
////			System.out.print(memb.getSale_memo()+",");
////			System.out.print(memb.getSale_post_time()+",");
////			System.out.print(memb.getSale_delete_time()+",");
////			System.out.print(memb.getSale_modify_time()+",");
////			System.out.print(memb.getSale_status()+",");
////			System.out.print(memb.getSale_lng()+",");
////			System.out.print(memb.getSale_lat()+",");
////			Set<ProductBean> productBean=memb.getProductBean();
////			for(ProductBean prb :productBean){//子查詢ProductBean
////				System.out.print(prb.getProduct_no() + ",");
////				System.out.print(prb.getProduct_name() + ",");
////			}
////多筆查詢	
////			List<SaleBean> listSale = saleDao.select();
////			for (SaleBean aDept : listSale) {
////				System.out.print(aDept.getSale_no()+",");
////				System.out.print(aDept.getMember_no().getMember_no()+",");
////				System.out.print(aDept.getSale_topic()+",");
////				System.out.print(aDept.getSale_name()+",");
////				System.out.print(aDept.getSale_locate()+",");
////				System.out.print(aDept.getSale_time()+",");
////				System.out.print(aDept.getSale_memo()+",");
////				System.out.print(aDept.getSale_post_time()+",");
////				System.out.print(aDept.getSale_delete_time()+",");
////				System.out.print(aDept.getSale_modify_time()+",");
////				System.out.print(aDept.getSale_status()+",");
////				System.out.print(aDept.getSale_lng()+",");
////				System.out.print(aDept.getSale_lat()+",");
////				System.out.println();
////				System.out.print(aDept.getMember_no().getMember_no()+",");
////				System.out.print(aDept.getMember_no().getAccount()+",");
////				System.out.print(aDept.getMember_no().getPwd()+",");
////				System.out.print(aDept.getMember_no().getName()+",");
////				System.out.print(aDept.getMember_no().getNickname()+",");
////				System.out.print(aDept.getMember_no().getBirth()+",");
////				System.out.print(aDept.getMember_no().getHobby()+",");
////				System.out.print(aDept.getMember_no().getMember_status()+",");
////				System.out.print(aDept.getMember_no().getGender()+",");
////				System.out.print(aDept.getMember_no().getAccount_status()+",");
////				System.out.print(aDept.getMember_no().getMember_photo()+",");
////				System.out.print(aDept.getMember_no().getSuspended()+",");
////				System.out.print(aDept.getMember_no().getAccount_email()+",");
////				System.out.print(aDept.getMember_no().getAccount_google()+",");
////				System.out.print(aDept.getMember_no().getAccount_facebook()+",");
////				System.out.println();}
////新增	
////			model.MemberBean memberBean = new model.MemberBean(); // 部門POJO
////			memberBean.setMember_no(2);
////			SaleBean saleBean = new SaleBean(); //會員POJO
////			saleBean.setSale_no(9);
////			saleBean.setMember_no(memberBean);
////			saleBean.setSale_topic("製造部test");
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
////			saleDao.insert(saleBean);
////修改
//	//圖片		
//		//	File file = new File("C:\\Users\\Wiston\\Pictures\\21.jpg");
//			
////			model.MemberBean memberBean = new model.MemberBean(); // 部門POJO
////			memberBean.setMember_no(2);
////			SaleBean saleBean = new SaleBean(); //會員POJO
////			saleBean.setSale_no(2);
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
////			Set<ProductBean> productBean=new HashSet<ProductBean>();
////			ProductBean productup = new ProductBean();
////			productup.setProduct_no(1);
////			productup.setProduct_name("111111");
////			productup.setProduct_memo("1");
////			productup.setProduct_price(1);
////			productup.setProduct_pic(null);
////			productup.setProduct_status(1);
////			ProductBean productup1 = new ProductBean();
////			productup1.setProduct_no(2);
////			productup1.setProduct_name("22222");
////			productup1.setProduct_memo("2");
////			productup1.setProduct_price(1);
////			productup1.setProduct_pic(null);
////			productup1.setProduct_status(1);
////			productBean.add(productup);
////			productBean.add(productup1);
////			saleBean.setProductBean(productBean);
////			saleDao.update(saleBean);
////刪除
////			saleDao.delete(2);
//			
//			sessionFactory.getCurrentSession().getTransaction().commit();
//			} finally {
//				sessionFactory.close();
//				((ConfigurableApplicationContext) context).close();
//			}
//		}
	@Override
	public List<SaleBean> select(SaleBean bean) {
		System.out.println(bean.getMember_no().getMember_no());
		Query query = this.getSession().createQuery("from SaleBean where member_no.member_no=:site and sale_status=:status");		
		query.setParameter("site",bean.getMember_no().getMember_no());
		query.setParameter("status",1);
		return (List<SaleBean>) query.getResultList();
	}
	
	public SaleBean select(int sale_no) {
		return this.getSession().get(SaleBean.class, sale_no);
	}
	public List<SaleBean> select() {
		Query query = this.getSession().createQuery("from SaleBean");
		return (List<SaleBean>) query.getResultList();
	}
	public SaleBean insert(SaleBean bean) {
		if(bean!=null) {
			SaleBean insert = this.getSession().get(SaleBean.class, bean.getSale_no());
			if(insert==null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}
		public SaleBean update(SaleBean bean) {
			SaleBean update = this.getSession().get(SaleBean.class, bean.getSale_no());
			if(update!=null) {
				this.getSession().merge(bean);

			}
			return update;
		}
	public boolean delete(int sale_no) {
		SaleBean bean=this.getSession().get(SaleBean.class, sale_no);
		if(bean!=null){
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

	

}
