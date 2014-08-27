package entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.jpa.GenericModel;
import service.LoginService;

@Entity
@Table(name = "userSecure")
public class UserSecure extends GenericModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	public Integer id;
	
	@Column(name = "uid")
	public Integer uid;
	
	@Column(name = "mobile")
	public String mobile;
	
	@Column(name = "email")
	public String email;
	
	@Column(name = "uname")
	public String uname;
	
	@Column(name = "studentId")
	public String studentId;
	
	@Column(name = "passwdMd5")
	public String password;
	
	private static Map<Integer, String> typeKeyMap= new HashMap<Integer, String>();
	static{
		typeKeyMap.put(LoginService.LoginType.TYPE_MAIL, "email");
		typeKeyMap.put(LoginService.LoginType.TYPE_MOBILE, "mobile");
		typeKeyMap.put(LoginService.LoginType.TYPE_STUDENT_ID, "studentId");
		typeKeyMap.put(LoginService.LoginType.TYPE_UNAME, "uname");
	}
	
	public static UserSecure findByLoginType(String value, Integer loginType){
		if(!typeKeyMap.containsKey(loginType)){
			return null;
		}
		List<UserSecure> secure =  UserSecure.find(typeKeyMap.get(loginType)+" = ?", value).fetch();
		return secure.get(0);
	}
}
