package top.pcstar.basics.clone;

import java.io.Serializable;

/**
 * 学生类
 * @author PANCHAO
 *
 */
public class Student implements Serializable,Cloneable{
	private static final long serialVersionUID = 5643701912783985256L;
	private int stuId;
	private String stuName;
	private StudentGroup stuGroup;
	public Student(int stuId, String stuName, StudentGroup stuGroup) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuGroup = stuGroup;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public StudentGroup getStuGroup() {
		return stuGroup;
	}
	public void setStuGroup(StudentGroup stuGroup) {
		this.stuGroup = stuGroup;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Student student = (Student) super.clone();
		student.setStuGroup((StudentGroup)stuGroup.clone());
		return student;
	}
	@Override
	public String toString() {
		return "stuId:"+stuId+"---stuName:"+stuName+"---stuGroup:"+"[groupId:"+getStuGroup().getGroupId()+",groupName:"+getStuGroup().getGroupName()+"]";
	}
}
