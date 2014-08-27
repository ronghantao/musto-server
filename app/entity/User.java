package entity;

import javax.persistence.*;

import play.db.jpa.GenericModel;

@Entity
@Table(name = "user")
public class User extends GenericModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	public Integer id;
	
	/** 用户名  */
	@Column(name = "uname")
	public String uname;
	
	/** 手机号 */
	@Column(name = "mobile")
	public String mobile;
	
	/** 邮箱 */
	@Column(name = "email")
	public String email;
	
	/** 姓名  */
	@Column(name = "name")
	public String name;
	
	/** 性别  */
	@Column(name = "sex")
	public Integer gender;
	
	/** 身份证 */
	@Column(name = "IDNumber")
	public String idNumber;
	
	/** 头像资源地址 */
	@Column(name = "portrait")
	public String portraitUri;
	
	/** 出生年月 */
	@Column(name = "birthday")
	public String birthday;
	
	/** 省份 */
	@Column(name = "originProvince")
	public String originProvince;
	
	/** 市 */
	@Column(name = "originCity")
	public String originCity;
	
	/** 用户类型 */
	@Column(name = "type")
	public Integer type;
	
	@Column(name = "isDeleted")
	public Integer isDeleted;
	
	public static User findByUid(int uid){
		return User.find("id=? and isDeleted=?", uid, 0).first();
	}
	
	public static final int USER_TYPE_STUDENT = 0;
	public static final int USER_TYPE_TEACHER = 1;
	public static final int USER_TYPE_STAFF = 2;
	public static final int USER_TYPE_COMMON = 3;
}
