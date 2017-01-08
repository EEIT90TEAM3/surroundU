package model;
import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;
@Component(value="memberBean")
@Entity
@Table(name="MEMBER",catalog="EEIT90", schema="DBO")

public class MemberBean  implements Serializable {
	
	private static final long SerialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int member_no;       //會員編號
	private String account;		//帳號
	private String pwd;			//密碼
	private String name;		//姓名
	private String nickname;	//暱稱
	private java.util.Date birth;//生日
	private String hobby;		//興趣
	private int member_status;	//上線狀態
	private int gender;			//性別
	private int account_status; //帳號狀態，0為正常，1為暫停，2為永久停用，99為管理員
	private Blob member_photo;		//會員照片
	private java.util.Date suspended; //停權結束日
	private String account_email;
	private String account_google;		//google帳號
	private String account_facebook;	//facebook帳號
	
	
	
	
	
	@Override
	public String toString() {
		return "MemberBean [member_no=" + member_no + ", account=" + account + ", pwd=" + pwd + ", name=" + name
				+ ", nickname=" + nickname + ", birth=" + birth + ", hobby=" + hobby + ", member_status="
				+ member_status + ", gender=" + gender + ", account_status=" + account_status + ", member_photo="
				+ member_photo + ", suspended=" + suspended + ", account_email=" + account_email + ", account_google="
				+ account_google + ", account_facebook=" + account_facebook + "]";
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public java.util.Date getBirth() {
		return birth;
	}
	public void setBirth(java.util.Date birth) {
		this.birth = birth;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public int getMember_status() {
		return member_status;
	}
	public void setMember_status(int member_status) {
		this.member_status = member_status;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getAccount_status() {
		return account_status;
	}
	public void setAccount_status(int account_status) {
		this.account_status = account_status;
	}
	public Blob getMember_photo() {
		return member_photo;
	}
	public void setMember_photo(Blob member_photo) {
		this.member_photo = member_photo;
	}
	public java.util.Date getSuspended() {
		return suspended;
	}
	public void setSuspended(java.util.Date suspended) {
		this.suspended = suspended;
	}
	public String getAccount_email() {
		return account_email;
	}
	public void setAccount_email(String account_email) {
		this.account_email = account_email;
	}
	public String getAccount_google() {
		return account_google;
	}
	public void setAccount_google(String account_google) {
		this.account_google = account_google;
	}
	public String getAccount_facebook() {
		return account_facebook;
	}
	public void setAccount_facebook(String account_facebook) {
		this.account_facebook = account_facebook;
	}
	
//	public MemberBean(){
//	
//}
//
//public MemberBean(int member_no, String account, String pwd, String name, String nickname, Date birth, String hobby,
//		int member_ststus, int gender, int account_status, Blob member_photo, Date suspended, String account_google,
//		String account_facebook) {
//	super();
//	this.member_no = member_no;
//	this.account = account;
//	this.pwd= pwd;
//	this.name = name;
//	this.nickname = nickname;
//	this.birth = birth;
//	this.hobby = hobby;
//	this.member_ststus = member_ststus;
//	this.gender = gender;
//	this.account_status = account_status;
//	this.member_photo = member_photo;
//	this.suspended = suspended;
//	this.account_google = account_google;
//	this.account_facebook = account_facebook;
//}
	
	
	
	

	

	
	
}
