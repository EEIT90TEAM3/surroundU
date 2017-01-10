package model;

import java.util.List;

public interface PrivateTalkDAO {
	PrivateTalkBean select(int privatetalk_no);
	List<PrivateTalkBean> select();

	PrivateTalkBean insert(PrivateTalkBean bean);

	PrivateTalkBean update(PrivateTalkBean bean);

	boolean delete(int privatetalk_no);
}
