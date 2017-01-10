package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import chat.GetHttpSessionConfigurator;
import model.FriendBean;
import model.FriendService;
import model.MemberBean;
import model.MemberDAO;
import model.MemberDAOHibernate;
import model.MemberService;
import model.PrivateTalkBean;
import model.PrivateTalkDAO;
import model.PrivateTalkService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;




@ServerEndpoint(value="/websocket/{loginName}", configurator = GetHttpSessionConfigurator.class)
public class ChatController{
	private PrivateTalkService privateTalkService;
	private MemberService memberService;
	private FriendService friendService;
	private HttpSession httpSession;
	private PrivateTalkDAO pdao;
		
	private Session session;
	private String nickname;
	private static final Map<String,ChatController > connections = new ConcurrentHashMap<String,ChatController>();
	private static int nums = 0;

	@OnOpen
	public void open(Session session, @PathParam("loginName") String loginName , EndpointConfig config){
		this.httpSession = (HttpSession) config.getUserProperties()
                .get(HttpSession.class.getName());
		WebApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(this.httpSession.getServletContext());
		this.privateTalkService = (PrivateTalkService) context.getBean("privateTalkService");
		this.memberService = (MemberService) context.getBean("memberService");
		this.friendService = (FriendService) context.getBean("friendService");
		this.pdao = (PrivateTalkDAO) context.getBean("privateTalkDAO");
		System.out.println("loginName------------------------"+loginName);
		this.session = session;
		System.out.println("session:"+session);
		this.nickname=loginName;
		connections.put(loginName, this);

		addOnlineCount();
		System.out.println("在線人數:" + String.valueOf(getOnlineCount()));
		String nowOnline = "{'num':'"+String.valueOf(getOnlineCount())+"','type':'nums'}";
		try {
			sendAll(nowOnline);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
    @OnClose
    public void onClose(){
    	System.out.println("this--------------"+nickname);
    	connections.remove(nickname);  //從set中删除
    	subOnlineCount();
    	System.out.println("有一連線關閉！目前在線人數為:" + getOnlineCount());
		String nowOnline = "{'num':'"+String.valueOf(getOnlineCount())+"','type':'nums'}";
		try {
			sendAll(nowOnline);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @OnError
    public void onError(Session session, Throwable thr) {}
    
	@OnMessage
	public void getMessage(String message, Session session) {
		System.out.println("Received:------------------------------");
		System.out.println("Received: " + message);

		JSONObject jsonObject = JSONObject.fromObject(message);
//		this.nickname = (String) jsonObject.get("nickname");

//		System.out.println(privateTalkService.select(1));		
		String type = (String) jsonObject.get("type");
		String nickname = (String) jsonObject.get("nickname");
		String to = (String) jsonObject.get("to");
		FriendBean bean;
		switch (type) {
		case "searchID":

			MemberBean memberBean=memberService.selectName(nickname);
			if(memberBean!=null){
				jsonObject.put("himg", memberBean.getMember_photo_chat());
				try {
					jsonObject.put("name", memberBean.getAccount());
					this.session.getBasicRemote().sendText(jsonObject.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}			
			break;
		case "private":
			try {
				sendPrivate(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "all":
			System.out.println("全頻");
			try {
				sendAll(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "addfriend":

			bean=new FriendBean();
			bean.setBuddy_no(memberService.select(to));
			bean.setFriend_status(0);
			bean.setMember_no(memberService.select(nickname));
			friendService.addFriend(bean);
			try {
				connections.get(to).session.getBasicRemote().sendText(jsonObject.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "delfriend":
			bean = new FriendBean();
			bean.setMember_no(memberService.select(nickname));
			bean.setBuddy_no(memberService.select(to));
			bean.setFriend_status(0);
			friendService.delete(bean);
			bean.setMember_no(memberService.select(to));
			bean.setBuddy_no(memberService.select(nickname));
			bean.setFriend_status(0);
			friendService.delete(bean);
			break;
		case "delinvite":
			bean = new FriendBean();
			bean.setMember_no(memberService.select(to));
			bean.setBuddy_no(memberService.select(nickname));
			bean.setFriend_status(0);
			friendService.delete(bean);
			break;
		case "accpetinvite":
			bean = new FriendBean();
			bean.setMember_no(memberService.select(nickname));
			bean.setBuddy_no(memberService.select(to));
			bean.setFriend_status(1);
			friendService.addFriend(bean);
			bean.setMember_no(memberService.select(to));
			bean.setBuddy_no(memberService.select(nickname));
			friendService.update(bean);
			break;
//		case "friendlist":
//			MemberBean friendbean=memberService.select(nickname);
//			List<FriendBean> listFriend= friendService.friendList(friendbean.getMember_no()); //取得好友資料
//			System.out.println("listFriend:"+listFriend.size());
//			System.out.println("listFriend:"+listFriend);
//			if(listFriend.size()>0){
////				JSONObject object = new JSONObject(listFriend);
//				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa");
//				jsonObject2.put("listFriend", listFriend);
//				System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbb");
//				JSONArray object = jsonObject2.getJSONArray(listFriend.toString());
//
//				System.out.println("ccccccccccccccccccccccccccc");
//
//				System.out.println("==========object="+jsonObject);
//				}
//			System.out.println("fffffffffffffffffffffffffffffffffff");
//			List<FriendBean> listInvite= friendService.inviteList(friendbean.getMember_no()); //取得好友資料			
//			if(listInvite.size()>0){
////				session.setAttribute("selectinvite", listInvite);
//			}		
//			try {
//			this.session.getBasicRemote().sendText(message);
//
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			break;
		default:
			break;
		}

		//	       for(chatb item: webSocketSet){
//		try {
//			broadcast(message);
//			session.getBasicRemote().sendText(message);
//			item.sendMessage(message);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	       }

	
//		// 把客户端的消息解析为JSON对象
//		JSONObject jsonObject = JSONObject.fromObject(message);
//		// 获得昵称
//		String nikename = (String) jsonObject.get("nickname");
//
//		connections.put(this, nikename);
//		broadcast(message);
	}
    public void sendPrivate(String message) throws IOException{

    	JSONObject jsonObject = JSONObject.fromObject(message);
		String to = (String)jsonObject.get("to"); 
		String content = (String)jsonObject.get("content");
		
		int online = 0;
		if(to!=null && to!="" && to.length()!=0){
//			System.out.println(connections.get(to));
			to = memberService.selectName(to).getAccount();
			if(connections.get(to)!=null ){
				online = 1;
				connections.get(to).session.getBasicRemote().sendText(jsonObject.toString());
				System.out.println("私訊");
			}
			System.out.println("---------------0");

			PrivateTalkBean tobn=new PrivateTalkBean();
			tobn.setMember_no(memberService.select(nickname));
			tobn.setCatch_id(memberService.select(to));
			tobn.setPrivatetalk_status(online);
			tobn.setPrivatetalk_txt(content);
			tobn.setPrivatetalk_time(new java.util.Date());

		try {
			System.out.println("---------------4"+Integer.toString(1));
			System.out.println(privateTalkService.insert(tobn));////////////////
		} catch (Exception e) {
			e.printStackTrace();
		}
//		tobn.setPrivatetalk_txt("遊戲");
//		tobn.setPrivatetalk_time(java.sql.Date.valueOf("2016-12-20"));
//		tobn.setCatch_id(memberDAOHibernate.selectId(1));
// 		tobn.setPrivatetalk_status(online);
// 		System.out.println("---------------2");
// 		privateTalkService.insert(tobn);
// 		System.out.println("---------------3");
//--------------------------------------------------------			
//			ApplicationContext context =
//					new ClassPathXmlApplicationContext("beans.config.xml");
//			SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//			try {
//				sessionFactory.getCurrentSession().beginTransaction();
//				PrivateTalkDAO dao=(PrivateTalkDAO)context.getBean("privateTalkDAO");
//
//			MemberDAO memberDAO = (MemberDAO) context.getBean("memberDAO");
//			MemberBean memberBean = new MemberBean();
//			memberBean.setMember_no(2);
//			PrivateTalkBean tobn=new PrivateTalkBean();
//		tobn.setMember_no(memberBean);
//		tobn.setMember_no(memberDAO.selectId(3));
//		tobn.setPrivatetalk_txt("遊戲");
//		tobn.setPrivatetalk_time(java.sql.Date.valueOf("2016-12-20"));
//		tobn.setCatch_id(memberDAO.selectId(1));
// 		tobn.setPrivatetalk_status(online);
//		dao.insert(tobn);
//		
//			sessionFactory.getCurrentSession().getTransaction().commit();
//		} finally {
//				
//			sessionFactory.close();
//			((ConfigurableApplicationContext) context).close();
//		}
	}			
    }
    public void sendAll(String message) throws IOException{
 //       this.session.getBasicRemote().sendText(message);
    	
    	JSONObject jsonObject = JSONObject.fromObject(message);
    	Iterator<String> iterator = connections.keySet().iterator();
		while (iterator.hasNext()) {
			String client = iterator.next();
			synchronized (client) {

				// 把客户端的消息解析为JSON对象
				// 在消息中添加发送日期
//				jsonObject.put("date", DATE_FORMAT.format(new Date()));
//				System.out.println("client="+client);
				// 添加本条消息是否为当前会话本身发的标志
//				jsonObject.put("isSelf", client.session.equals(session));
//				String nickname = (String)jsonObject.get("nickname");
				// 发送JSON格式的消息
//					connections.get(client).session.getAsyncRemote().sendText(jsonObject.toString());

				if(connections.get(client)!=null){
					System.out.println("訊息發送成功");
					connections.get(client).session.getBasicRemote().sendText(jsonObject.toString());	
					
				}
			}
			System.out.println("訊息發送完畢");
		}
		
    }
    public static synchronized int getOnlineCount() {
        return nums;
    }

    public static synchronized void addOnlineCount() {
        ChatController.nums++;
    }
     
    public static synchronized void subOnlineCount() {
    	ChatController.nums--;
    }
}
