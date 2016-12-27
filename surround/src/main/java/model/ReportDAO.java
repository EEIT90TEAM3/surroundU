package model;

import java.util.Date;
import java.util.List;

public interface ReportDAO {
	ReportBean select(int report_no);
	
	List<ReportBean> select(MemberBean member_no,int report_status);

	List<ReportBean> select();

	Boolean insert(ReportBean bean);

	ReportBean update(MemberBean member_no,String report_memo,java.util.Date report_time,int report_status,String repot_deal_memo,int report_no);

	boolean delete(int id);  //刪除是否要用隱藏?
}

