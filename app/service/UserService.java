package service;

import model.Person;
import model.Student;
import model.Teacher;
import entity.StudentInfo;
import entity.User;

public class UserService {

	private UserService() {}

	public static UserService newInstance() {
		return new UserService();
	}

	/**
	 * 根据uid获取用户
	 * 
	 * @param uid
	 * @return
	 */
	public Person getUser(int uid) {
		// 首先去用户表查询用户基本信息
		User u = User.findByUid(uid);
		Person p = null;
		if (u != null) {
			switch (u.type) {
			case User.USER_TYPE_STUDENT:
				p = new Student();
				StudentInfo student = StudentInfo.findByUid(u.id);
				((Student)p).init(student, u);
				break;
			case User.USER_TYPE_TEACHER:
				p = new Teacher();
				break;
			case User.USER_TYPE_STAFF:
				p = new Person();
				p.init(u);
				break;
			case User.USER_TYPE_COMMON:
				p = new Person();
				p.init(u);
				break;
			}
		}
		return p;
	}
}
