package model;

import java.util.List;

public interface SaleDAO {
	SaleBean select(int sale_no);
	
	List<SaleBean> select(SaleBean bean);
	
	List<SaleBean> select();
	
	List<SaleBean> selectByStatus(int sale_status);

	SaleBean insert(SaleBean bean);

	SaleBean update(SaleBean bean);
	
	SaleBean updateByStatus(int sale_no,int sale_status);

	boolean delete(int sale_no);

}

