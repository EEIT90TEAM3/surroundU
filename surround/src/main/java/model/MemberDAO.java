package model;

import java.util.List;

public interface MemberDAO {

	

	boolean updatePwd(String pwd, String account);

	MemberBean update(String nickname,String hobby,String account);
	boolean delete(int member_no);

	

	List<MemberBean> select();

	MemberBean fbselect(MemberBean bean);
	
	MemberBean select(String account);
	
	MemberBean insert(MemberBean bean);

	List<MemberBean> selectAll();
	
	List<MemberBean> selectMemberByAccuseStatus(int account_status);
	
	MemberBean update(MemberBean memberbean,int account_status);

	MemberBean update(MemberBean memberbean,String newpwd);

	//together要用
	MemberBean selectMember_no(int member_no);


}