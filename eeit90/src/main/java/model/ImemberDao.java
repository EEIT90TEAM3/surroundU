package model;


import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

public interface ImemberDao {
	
	MemberBean insert(MemberBean bean);
	MemberBean update(MemberBean bean);
	MemberBean delete(MemberBean bean);
	MemberBean select(int member_no);
	List<MemberBean> select();

}
