package model;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

public interface ImemberDao {

	MemberBean insert(MemberBean bean);

	boolean updatePwd(String pwd, String account);

	MemberBean update(String nickname,String hobby,String account);
	boolean delete(int member_no);

	MemberBean select(String account);

	List<MemberBean> select();

	

}
