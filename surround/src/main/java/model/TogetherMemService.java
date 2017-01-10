package model;


import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="togetherMemService")
@Transactional(transactionManager="transactionManager")
public class TogetherMemService {
	@Autowired
	private TogetherMemDAO togetherMemDao; 
//	@Autowired
//	private TogetherDAO togetherDao;
	//測試程式
//	public static void main(String[] args) {
//		ApplicationContext context=new ClassPathXmlApplicationContext("beans.config.xml");
//		SessionFactory sessionFactory=(SessionFactory) context.getBean("sessionFactory");
//		try{
//			sessionFactory.getCurrentSession().beginTransaction();
//			TogetherMemService togetherMemService=(TogetherMemService) context.getBean("togetherMemService");
//			
//			//新增
////			model.MemberBean memberBean=new MemberBean();
////			memberBean.setMember_no(3);
////			model.TogetherBean togetherBean=new TogetherBean();
////			togetherBean.setTogether_no(1);
////			TogetherMemBean tome=new TogetherMemBean();
////			tome.setMember_no(memberBean);
////			tome.setTogether_no(togetherBean);
////			tome.setTogethermem_status(1);
////			tome.setTogethermem_time(null);
////			togetherMemService.instert(tome);
//			//修改
////			model.MemberBean memberBean=new MemberBean();
////			memberBean.setMember_no(3);
////			model.TogetherBean togetherBean=new TogetherBean();
////			togetherBean.setTogether_no(1);
////			TogetherMemBean togetherMemBean=new TogetherMemBean();
////			togetherMemBean.setTogethermem_no(5); //主鍵
////			togetherMemBean.setMember_no(memberBean);
////			togetherMemBean.setTogether_no(togetherBean);
////			togetherMemBean.setTogethermem_status(2);
////			togetherMemBean.setTogethermem_time(java.sql.Date.valueOf("2016-12-20"));
////			togetherMemService.update(togetherMemBean);
//			//刪除
////			TogetherMemBean togetherMemBean=new TogetherMemBean();
////			togetherMemBean.setTogethermem_no(5); //主鍵
////			togetherMemService.delete(togetherMemBean);
//			
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		}finally{
//			sessionFactory.close();
//			((ConfigurableApplicationContext) context).close();
//		}
//		
//	}

	public TogetherMemBean instert(TogetherMemBean bean){
		TogetherMemBean result=null;
		
		System.out.println("=====service=====");
		System.out.println(bean);
		System.out.println(bean.getTogethermem_no());
		System.out.println(bean.getTogethermem_status());
		System.out.println(bean.getMember_no().getMember_no());
		System.out.println(bean.getTogether_no().getTogether_no());
        System.out.println(bean.getTogethermem_time());
        System.out.println(bean.getTogethermem_time_okay());
		System.out.println();
		if(bean!=null){
			bean.setTogethermem_no(0);
			bean.setTogethermem_time(new java.util.Date());
			result=togetherMemDao.insert(bean);
			System.out.println(result);
			System.out.println("=====service=====");
		}
		return result;
	}
	
	public TogetherMemBean update(TogetherMemBean bean){
		TogetherMemBean result=null;
		System.out.println("=====service=====");
		System.out.println(bean);
		if(bean!=null){
			System.out.println("IIIIIII");
			bean.setTogethermem_time_okay(new java.util.Date());
			result=togetherMemDao.update(bean.getTogethermem_no(), bean.getTogether_no(), bean.getMember_no(), bean.getTogethermem_status(), bean.getTogethermem_time(),bean.getTogethermem_time_okay());
		    System.out.println(result);
		}System.out.println("=====service=====");
		return result;
	}
	
	public boolean delete(TogetherMemBean bean){
		
		boolean result=false;
		if(bean!=null){
			result=togetherMemDao.delete(bean.getTogethermem_no());
		}
		return result;
	}
	// 0=正常加入  1=人數超過  2=已加入過  3=其他
	public int togetherMemPeopleVerify(TogetherMemBean bean,int together_people){
		List<TogetherMemBean> result = null;
		boolean result1=false;
		if(bean!=null){
			//System.out.println("============joinPeoOkay=============");
			TogetherBean together_no=bean.getTogether_no();
			//System.out.println(together_no);
			MemberBean member_no=bean.getMember_no();
			//System.out.println(member_no);
			result=togetherMemDao.selectTogetherNo(together_no);//判斷有幾個人加入
			result1=togetherMemDao.selectMemberNo(together_no, member_no);//判斷有沒有加入過
//			System.out.println(result1+"result");
//			System.out.println("============res=====================");
//			System.out.println(result1);
			if(result1){
				if(together_people>0){
					int quantity=result.size();
					if(quantity>=0 && quantity+1<together_people){
						return 0;
					}else{
						return 1;
					}
				}
			}else{
				return 2;
			}
		}
		return 3;
	}
	
	public int selectTogetherMemStatus(TogetherBean together_no, MemberBean member_no) {
		List<TogetherMemBean> result = null;
		if(together_no!=null && member_no!=null){	
			result=togetherMemDao.selectTogetherMemStatus(together_no,member_no);
			System.out.println("result="+result.size());
			if(result.size()!=0){
				System.out.println("約團加入狀態="+result.get(0).getTogethermem_status());
			return result.get(0).getTogethermem_status();
			}return 99;//資料庫沒資料
		}
		return -1;//together_no, member_no 有錯誤
	}
	
	public List<TogetherMemBean> selectTogetherMemDetails(TogetherBean together_no) {
		List<TogetherMemBean> result = null;
		if(together_no!=null){
			result=togetherMemDao.selectTogetherMemDetails(together_no);
		return result;
		}return null;
	}

	public List<TogetherMemBean> selectMyTogetherMemDetails(MemberBean member_no){
		List<TogetherMemBean> result = null;
		if(member_no!=null){
			result=togetherMemDao.selectMyTogetherMemDetails(member_no);
			return result;
		}
		return null;
	}
	public TogetherMemBean select(TogetherMemBean bean){
		System.out.println("===================service TogetherMemBean select===================");
		System.out.println(bean);
		System.out.println("togetherBean="+bean.getMember_no());
		System.out.println("memberBean"+bean.getMember_no().getMember_no());
		System.out.println("togetherBean="+bean.getTogether_no());
		System.out.println("memberBeam="+bean.getTogether_no().getTogether_no());
		System.out.println("togetherMemNo="+bean.getTogethermem_no());
		TogetherMemBean result=null;
		if(bean.getTogethermem_no()!=0){
			int member_no=bean.getMember_no().getMember_no();
			int together_no=bean.getTogether_no().getTogether_no();
			if(member_no!=0 && together_no!=0){
				result=togetherMemDao.select(bean.getTogethermem_no());
				if(result.getMember_no().getMember_no()==member_no && result.getTogether_no().getTogether_no()==together_no){
					System.out.println("===================service TogetherMemBean select===================");
					return result;
				}
			}
		}
		return null;
	}
	

}
