package model;

import java.util.List;

public interface TogetherMemDAO {
	TogetherMemBean select(int togethermem_no);
	List<TogetherMemBean> select();
	TogetherMemBean insert(TogetherMemBean bean);

	TogetherMemBean update(int togethermem_no,TogetherBean together_no,MemberBean member_no,int togethermem_status,java.util.Date togethermem_time,java.util.Date togethermem_time_okay);
	boolean delete(int togethermem_no);

	
	List<TogetherMemBean> selectTogetherNo(TogetherBean together_no);
	boolean selectMemberNo(TogetherBean together_no,MemberBean member_no);
	List<TogetherMemBean> selectTogetherMemStatus(TogetherBean together_no,MemberBean member_no);	
	List<TogetherMemBean> selectTogetherMemDetails(TogetherBean together_no);	
	List<TogetherMemBean> selectMyTogetherMemDetails(MemberBean member_no);
	
}

