package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component(value="backendService")
public class BackendService {

	@Autowired
	private AccuseDAO accuseDao;
	@Autowired
	private ReportDAO reportDao;
	@Autowired
	private MemberDAO memberDao;
	@Autowired
	private TogetherDAO togetherDao;
	@Autowired
	private SaleDAO saleDAO;
	
	
	 public List<AccuseBean> selectAllAccuse(){  //查詢所有檢舉表格
		
		  List<AccuseBean> result = accuseDao.select();
			
		
		  return result;
			
		}
		
		
		public List<AccuseBean> selectNotProcessAccuse(){  //查詢已處理檢舉表格
			
			  List<AccuseBean> result = accuseDao.selectByStatus(0);
				
			  return result;
				
		}
		
		
		
		
		public List<AccuseBean> selectProcessedAccuse(){  //查詢已處理檢舉表格
			
			  List<AccuseBean> result1 = accuseDao.selectByStatus(1);
			  List<AccuseBean> result2 = accuseDao.selectByStatus(2);
			  
			  List<AccuseBean> result = new ArrayList<AccuseBean>();
			  result.addAll(result1);
			  result.addAll(result2);
			  
			
			  return result;
				
			}

		
		@Transactional
		public List<ReportBean> selectAllReport(){  //查詢所有檢舉表格
		   		
		    List<ReportBean> beanlist = reportDao.select();
		   		   	
		   	return beanlist;
		   		
	    }//end of selectAllReport
			
	    
		public List<ReportBean> selectNotProcessReport(){  //查詢已處理檢舉表格
				
			List<ReportBean> result = reportDao.selectByStatus(0);
					
			return result;
					
	    }
			
			
		public List<ReportBean> selectProcessedReport(){  //查詢已處理檢舉表格
				
			List<ReportBean> result = reportDao.selectByStatus(1);
					
				
			return result;
					
		}
		
		public List<MemberBean> selectMember(){ //查詢所有會員
			
			List<MemberBean> result = memberDao.selectAll();
			
			return result;
			
			
		}
		
        public List<MemberBean> selectManager(){ //查詢管理員
			
			List<MemberBean> result = memberDao.selectMemberByAccuseStatus(99);
			
			return result;
			
			
		}
		
		
        public List<MemberBean> selectAccusedMember(){ //查詢停權會員
        	
			
			List<MemberBean> result1 = memberDao.selectMemberByAccuseStatus(1);
			List<MemberBean> result2 = memberDao.selectMemberByAccuseStatus(2);
			
			
			
			result1.addAll(result2);
			
			return result1;
			
			
		}
        
        
//      public Boolean changeManagerPwd(){ //查詢停權會員
//    	
//		
//	
//		
//		return null;
//		
//		
//	 }
        
      //處理檢舉文章 
      public Boolean dealAccuse(int accuse_no,int accuse_status,String accuse_deal_memo){  
    	  
    	AccuseBean bean = accuseDao.select(accuse_no); //select要處理的文章
    	
    	if (bean!=null) {
			if (bean.getSale_no() == 0) { //如果文章為約團文章
				AccuseBean updatebean = accuseDao.update(bean.getMember_no(), bean.getAccuse_type(),
						bean.getAccuse_topic(), bean.getAccuse_post_time(), accuse_status, new java.util.Date(), 0,
						bean.getGroup_no(), accuse_deal_memo, accuse_no);
				
				System.out.println("updatebean.getAccuse_status():"+updatebean.getAccuse_status());
				
				
//				if(updatebean.getAccuse_status()==2){ //如果檢舉成立,則去變更文章狀態
//					
//								
//					
//				}
				
				if(updatebean.getAccuse_status()==2){ //如果檢舉成立,則去變更文章狀態
					
			        System.out.println("更新約團文章狀態");
					
					AccuseBean rs1 = accuseDao.select(accuse_no);
					
					System.out.println("group_no:"+rs1.getGroup_no());
					
					TogetherBean rs2 = togetherDao.updateStatus(rs1.getGroup_no(),2);  //將文章狀態改為2(檢舉成立)
								
					
				}
			
				
				
				if(updatebean!=null){
					return true;
				}
				

			} else { //如果文章為擺攤文章         
				AccuseBean updatebean = accuseDao.update(bean.getMember_no(), bean.getAccuse_type(),
						bean.getAccuse_topic(), bean.getAccuse_post_time(), accuse_status, new java.util.Date(),
						bean.getSale_no(), 0, accuse_deal_memo, accuse_no);
				if(updatebean!=null){
					
					System.out.println("updatebean.getAccuse_status():"+updatebean.getAccuse_status());
					
					   if(updatebean.getAccuse_status()==2){ //如果檢舉成立,則去變更文章狀態為已檢舉(2)
						
					        System.out.println("更新約團文章狀態");
							
							AccuseBean rs1 = accuseDao.select(accuse_no);
							
							System.out.println("group_no:"+rs1.getSale_no());
							
							SaleBean rs2 = saleDAO.updateByStatus(rs1.getSale_no(), 2);  //將文章狀態改為2(檢舉成立)
										
							
					 	}
					
					return true;
				}
			} 
		}
    	
		return false;
      }
      
      
      //處理回報文章
      public Boolean dealReport(int report_no,int report_status,String report_deal_memo){
    	  
    	  ReportBean bean = reportDao.select(report_no);
    	  
    	  ReportBean rs = reportDao.update(bean.getMember_no(), bean.getReport_memo(), bean.getReport_time(), 
    			  report_status, report_deal_memo, report_no);
    	  
    	  if(rs!=null){
    		  return true; 
    	  }
    	  
    	  return false;
      }
      
      //依檢舉文章編號查詢文章編號,後以查詢擺攤文章內容
      public SaleBean lookAccuseOfSale(int accuse_no){
    	  
    	  AccuseBean bean = accuseDao.select(accuse_no);
    	  
    	  SaleBean rs = saleDAO.select(bean.getSale_no());
    	  
    	  return rs;
      }
      
      //依檢舉文章編號查詢文章編號,後以查詢約團文章內容
      public TogetherBean lookAccuseOfTogether(int accuse_no){
    	  
    	  AccuseBean bean = accuseDao.select(accuse_no);
    	  
 //   	  System.out.println("約團文章編號:"+bean.getGroup_no());
    	  TogetherBean rs = togetherDao.select(bean.getGroup_no());
    	      	  
    	  return rs;

      }
      
        
		
		
		
}
