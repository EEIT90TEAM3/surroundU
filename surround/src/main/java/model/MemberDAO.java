package model;

import java.util.List;

public interface MemberDAO {

	MemberBean select(String custid);

	List<MemberBean> selectAll();
	
	List<MemberBean> selectMemberByAccuseStatus(int account_status);
}