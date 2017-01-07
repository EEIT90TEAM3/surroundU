package model;

import java.util.List;

public interface ProductDAO {
	
	
	ProductBean select(int product_no);

	List<ProductBean> select(ProductBean bean);
	
	List<ProductBean> select();

	ProductBean insert(ProductBean bean);

	ProductBean update(ProductBean bean);

	boolean delete(int product_no);

}
