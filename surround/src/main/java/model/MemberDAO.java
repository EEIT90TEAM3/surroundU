package model;

import java.util.List;

public interface MemberDAO {

	MemberBean select(String account);

	List<MemberBean> selectAll();
	
	List<MemberBean> selectMemberByAccuseStatus(int account_status);
	
	MemberBean update(MemberBean memberbean,int account_status);
	
	MemberBean update(MemberBean memberbean,String newpwd);
}