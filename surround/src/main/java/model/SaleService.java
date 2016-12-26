package model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.ConfigurableApplicationContext;

@Service(value="saleService")
@Transactional
public class SaleService {
	@Autowired
	private SaleDAO saleDAO;
	

	@Transactional
	public List<SaleBean> select(SaleBean bean) {
		List<SaleBean> result = null;
		if (bean != null) {
			result = saleDAO.select(bean);
		}
		return result;
	}
	
	@Transactional
	public SaleBean insert(SaleBean bean) {
		SaleBean result = null;
		if (bean != null) {
			result = saleDAO.insert(bean);
		}
		return result;
	}
	@Transactional
	public SaleBean update(SaleBean bean) {
		SaleBean result = null;
		if (bean != null) {
			result = saleDAO.update(bean);
		}
		return result;
	}
	@Transactional
	public boolean delete(SaleBean bean) {
		boolean result = false;
		if (bean != null) {
			result = saleDAO.delete(bean.getSale_no());
		}
		return result;
	}
}
