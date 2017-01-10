package model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service(value="privateTalkService")
@Transactional
public class PrivateTalkService {
	@Autowired
	private PrivateTalkDAO privateTalkDAO;
	

	
	public PrivateTalkBean select(int privatetalk_no) {
		System.out.println("PrivateTalkService");
		PrivateTalkBean result = null;
//		this.privateTalkDAO = pdao;//
//		System.out.println("from service"+pdao);
		if (privatetalk_no != 0) {
			result = privateTalkDAO.select(privatetalk_no);
			
		}
		
		System.out.println("result= "+result);
		return result;
	}
	
	public PrivateTalkBean insert(PrivateTalkBean bean) {
		PrivateTalkBean result = null;
		if (bean != null) {
			result = privateTalkDAO.insert(bean);
		}
		return result;
	}
	public PrivateTalkBean update(PrivateTalkBean bean) {
		PrivateTalkBean result = null;
		if (bean != null) {
			result = privateTalkDAO.update(bean);
		}
		return result;
	}
	public boolean delete(PrivateTalkBean bean) {
		boolean result = false;
		if (bean != null) {
			result = privateTalkDAO.delete(bean.getPrivatetalk_no());
		}
		return result;
	}
}
