package model;

import java.util.List;

public interface MemberDAO {
	MemberBean fbselect(MemberBean bean);
	MemberBean select(String custid);
	MemberBean insert(MemberBean bean);

}