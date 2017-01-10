package model;

import java.util.List;

public interface FriendDAO {
	List<FriendBean> friendList(int member_no);
	List<FriendBean> inviteList(int member_no);
	FriendBean addFriend(FriendBean bean);
	List<FriendBean> select();


	FriendBean acceptFriend(FriendBean bean);
	int findpram(FriendBean bean);
	FriendBean update(FriendBean bean);
	boolean delete(FriendBean bean);
}
