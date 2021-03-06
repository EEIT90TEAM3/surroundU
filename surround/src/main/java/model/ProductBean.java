package model;

import java.io.Serializable;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Query;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.annotations.Expose;
@Entity
@Table(name="PRODUCT",catalog="EEIT90", schema="DBO")
public class ProductBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Expose private int product_no;/*擺攤物品編號*/
	private SaleBean sale_no;/*擺攤文章編號*/
	@Expose private String product_name;/*商品*/
	@Expose private String product_memo;/*描述*/
	@Expose private int product_price;/*價格*/
	@Expose private String product_pic;/*圖片*/
	@Expose private int product_status;/*物品狀態(0存在,1隱藏2刪除)*/
	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Session session = sessionFactory.getCurrentSession();

			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			sessionFactory.close();
			((ConfigurableApplicationContext) context).close();
		}
	}
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	@ManyToOne(fetch=FetchType.LAZY) //(雙向多對一/一對多)的多對一    //【原預設為 @ManyToOne(fetch=FetchType.LAZY)】--> 【是指原為lazy="true"之意】
	@JoinColumn(name = "sale_no")  //指定用來join table的column

	public SaleBean getSale_no() {
		return sale_no;
	}
	
	public void setSale_no(SaleBean sale_no) {
		this.sale_no = sale_no;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_memo() {
		return product_memo;
	}
	public void setProduct_memo(String product_memo) {
		this.product_memo = product_memo;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_pic() {
		return product_pic;
	}
	public void setProduct_pic(String product_pic) {
		this.product_pic = product_pic;
	}
	public int getProduct_status() {
		return product_status;
	}
	public void setProduct_status(int product_status) {
		this.product_status = product_status;
	}



}

