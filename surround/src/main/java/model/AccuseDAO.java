package model;

import java.util.Date;
import java.util.List;

public interface AccuseDAO {
	
	AccuseBean select(int accuse_no);
	
	List<AccuseBean> select(MemberBean member_no,int sale_no, int group_no);
	
	List<AccuseBean> selectByStatus(int accuse_status);

	List<AccuseBean> select();

	AccuseBean insert(AccuseBean bean);

	AccuseBean update(MemberBean member_no,String accuse_type, String accuse_topic, Date accuse_post_time,
			int accuse_status, Date accuse_deal_time, int sale_no, int group_no,int accuse_no);
    
	boolean delete(int id);  //刪除是否要用隱藏?
}
