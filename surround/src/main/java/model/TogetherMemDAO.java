package model;

import java.util.List;

public interface TogetherMemDAO {
	TogetherMemBean select(int togethermem_no);
	List<TogetherMemBean> select();
	TogetherMemBean insert(TogetherMemBean bean);
	TogetherMemBean update(int togethermem_no,TogetherBean together_no,MemberBean member_no,int togethermem_status,java.util.Date togethermem_time);
	boolean delete(int togethermem_no);

}
