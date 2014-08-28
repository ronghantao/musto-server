package service;

import model.Person;
import entity.UserSecure;

public class LoginService {
	private String loginId;
	private String pwd;
	private int type;
	
	private LoginService(String loginId, String pwd, int type){
		this.loginId = loginId;
		this.pwd = pwd.trim();
		this.type = type;
	}
	
	public static LoginService newInstance(String loginId, String pwd, int type){
		return new LoginService(loginId, pwd, type);
	}
	
	/**
	 * 获取用户id
	 * 如果用户名和密码正确，将返回正确的uid，否则返回null
	 * @return
	 */
	public Integer getUid(){
		UserSecure us = UserSecure.findByLoginType(this.loginId, this.type);
		if(us != null && us.password.trim().equals(this.pwd)){
			return us.uid;
		}
		return null;
	}
	
	public Person checkUserGet(){
		Integer uid = this.getUid();
		if(uid != null){
			return UserService.newInstance().getUser(uid);
		}
		return null;
	}
	
	public static class LoginType{
		//0=学号登录；1=用户名登录；2=手机号登录；3=邮箱登录
		public static final int TYPE_STUDENT_ID = 0;
		public static final int TYPE_UNAME = 1;
		public static final int TYPE_MOBILE = 2;
		public static final int TYPE_MAIL = 3;
	}
}
