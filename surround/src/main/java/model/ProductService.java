package model;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductService {
	@Autowired
	private ProductDAO productDAO;
	
	//測試程式
	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		try {
			SaleService saleService = (SaleService) context.getBean("saleService");
			
			
			
		} finally {
			sessionFactory.close();
			((ConfigurableApplicationContext) context).close();
		}

	}

}
