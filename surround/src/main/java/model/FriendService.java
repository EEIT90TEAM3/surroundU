package model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="friendService")
@Transactional
public class FriendService {
	@Autowired
	private FriendDAO friendDAO;
	public List<FriendBean> friendList(int member_no) {
		System.out.println("FriendBean");
		List<FriendBean> result = null;
//		if (account != null) {
			result = friendDAO.friendList(member_no);
			
//		}
		
		System.out.println("result= "+result);
		return result;
	}
	@Transactional
	public List<FriendBean> inviteList(int member_no) {
		List<FriendBean> result = null;
			result = friendDAO.inviteList(member_no);	
		return result;
	}	
	@Transactional
	public FriendBean addFriend(FriendBean bean) {
		FriendBean result = null;
		if (bean != null &&friendDAO.findpram(bean)==0) {
			result = friendDAO.addFriend(bean);
		}
		return result;
	}
	@Transactional
	public FriendBean update(FriendBean bean) {
		FriendBean result = null;
//		if (bean != null) {
			result = friendDAO.update(bean);
//		}
		return result;
	}
	@Transactional
	public boolean delete(FriendBean bean) {
		boolean result = false;
			result = friendDAO.delete(bean);
		return result;
	}

}	
	

