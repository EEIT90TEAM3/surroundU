package model;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
@Repository(value="productDAO")
public class ProductDAOHibernate implements ProductDAO{
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
//		
//		try {
//			sessionFactory.getCurrentSession().beginTransaction();
//			ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
////單筆查詢		
////			ProductBean memb = productDAO.select(3);
////			System.out.print(memb.getProduct_no()+",");
////			System.out.print(memb.getSale_no().getSale_no()+",");
////			System.out.print(memb.getProduct_name()+",");
////			System.out.print(memb.getProduct_memo()+",");
////			System.out.print(memb.getProduct_price()+",");
////			System.out.print(memb.getProduct_pic()+",");
////			System.out.print(memb.getProduct_status()+",");
//			//多筆查詢	
////			List<ProductBean> listSale = productDAO.select();
////			for (ProductBean aDept : listSale) {
////				System.out.print(aDept.getProduct_no()+",");
////				System.out.print(aDept.getSale_no().getSale_no()+",");
////				System.out.print(aDept.getProduct_name()+",");
////				System.out.print(aDept.getProduct_memo()+",");
////				System.out.print(aDept.getProduct_price()+",");
////				System.out.print(aDept.getProduct_pic()+",");
////				System.out.print(aDept.getProduct_status()+",");
////				System.out.println();
////				}
////搜尋物品
////			ProductBean productBeanBeanpro = new ProductBean();
////			productBeanBeanpro.setProduct_name("衣服");
////			List<ProductBean> ppp=productDAO.select(productBeanBeanpro);	
////			for(ProductBean prb :ppp){
////			System.out.print(prb.getProduct_no() + ",");
////			System.out.print(prb.getProduct_name() + ",");
////			}
//
//			
////新增	
////修改
////			model.SaleBean saleBean = new model.SaleBean(); // 部門POJO
////			saleBean.setSale_no(4);
////			ProductBean productBeanBean = new ProductBean(); //會員POJO
////			productBeanBean.setProduct_no(1);
////			productBeanBean.setSale_no(saleBean);
////			productBeanBean.setProduct_name("製造部test");
////			productBeanBean.setProduct_memo("中國江西s");
////			productBeanBean.setProduct_price(123);
////			productBeanBean.setProduct_pic(null);
////			productBeanBean.setProduct_status(0);
//////			productDAO.insert(productBeanBean);	
////			productDAO.update(productBeanBean);	
//			
////		刪除
////			productDAO.delete(8);
////
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		} finally {
//			sessionFactory.close();
//			((ConfigurableApplicationContext) context).close();
//		}
//	
//	}
	
	
	
	@Override
	public ProductBean select(int product_no) {
		return this.getSession().get(ProductBean.class, product_no);
	}

	/* (non-Javadoc)
	 * @see model.ProductDAO#select(model.ProductBean)
	 */
	@Override
	public List<ProductBean> select(ProductBean bean) {
		Query query = this.getSession().createQuery("from ProductBean where product_name like :name");		
		query.setParameter("name","%"+bean.getProduct_name()+"%");
		return (List<ProductBean>) query.getResultList();
	}

	@Override
	public List<ProductBean> select() {
		Query query = this.getSession().createQuery("from ProductBean");
		return (List<ProductBean>) query.getResultList();
	}

	@Override
	public ProductBean insert(ProductBean bean) {
		if(bean!=null) {
			ProductBean insert = this.getSession().get(ProductBean.class, bean.getProduct_no());
			if(insert==null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public ProductBean update(ProductBean bean) {
		ProductBean update = this.getSession().get(ProductBean.class, bean.getProduct_no());
		if(update!=null) {
			this.getSession().merge(bean);

		}
		return update;
	}

	@Override
	public boolean delete(int product_no) {
		ProductBean bean=this.getSession().get(ProductBean.class, product_no);
		if(bean!=null){
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}


}
