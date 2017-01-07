package model;

import java.util.List;

public interface SaleDAO {
	SaleBean select(int sale_no);
	List<SaleBean> select(SaleBean bean);
	List<SaleBean> select();

	SaleBean insert(SaleBean bean);

	SaleBean update(SaleBean bean);

	boolean delete(int sale_no);

}

