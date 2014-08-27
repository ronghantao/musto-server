package entity;

import javax.persistence.*;

import play.db.jpa.GenericModel;

@Entity
@Table(name = "studentInfo")
public class StudentInfo extends GenericModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	public Integer id;
	
	/** 关联user表中的id */
	@Column(name = "uid")
	public Integer uid;
	
	/** 学号 */
	@Column(name = "studentId")
	public String studentId;
	
	/** 准考证号 */
	@Column(name = "examId")
	public String examId;
	
	/** 学院 */
	@Column(name = "college")
	public String college;
	
	/** 专业 */
	@Column(name = "major")
	public String major;
	
	/** 年级 */
	@Column(name = "grade")
	public String grade;
	
	/** 班级 */
	@Column(name = "class")
	public String classTeam;
	
	/** 公寓 */
	@Column(name = "apartment")
	public String apartment;
	
	/** 宿舍 */
	@Column(name = "dorm")
	public String dorm;
	
	/** 档案 */
	@Column(name = "archiveId")
	public String archiveId;
	
	@Column(name = "isDeleted")
	public Integer isDeleted;
	
	public static StudentInfo findByUid(int uid){
		return StudentInfo.find("uid=? and isDeleted=?", uid, 0).first();
	}
}
