package model;

import java.util.List;

public interface TogetherDAO {
	TogetherBean select(int together_no);
	List<TogetherBean> select();
	List<TogetherBean> selectByStatus(int together_status);
	TogetherBean insert(TogetherBean bean);
	TogetherBean update(int together_no,MemberBean member_no,String together_topic,String together_name,
			String together_locate,java.util.Date together_when,java.util.Date together_when_end,int together_people,String together_memo,
			java.util.Date together_post_time,java.util.Date together_delete_time,java.util.Date together_modify_time,
			int together_status,String together_lng,String together_lat);

	boolean delete(int together_no);
	TogetherBean updateStatus(int together_no,int together_status);
	List<TogetherBean> selectStatus(MemberBean member_no,int together_status);
	TogetherBean selectStatus(int together_no,int together_status);
	List<TogetherBean> selectStatus(int together_status);
	


}



