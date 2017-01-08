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
	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");

			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			sessionFactory.close();
			((ConfigurableApplicationContext) context).close();
		}
	
	}
	
	
	
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

	
	@Override
	public List<ProductBean> selectBySale(SaleBean sale_no) {
		Query query = this.getSession().createQuery("from ProductBean where sale_no=?");
		query.setParameter(0, sale_no);
		
		return (List<ProductBean>) query.getResultList();
	}
	



}
