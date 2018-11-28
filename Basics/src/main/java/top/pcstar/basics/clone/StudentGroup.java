package top.pcstar.basics.clone;

import java.io.Serializable;

/**
 * 小组
 * @author PANCHAO
 *
 */
public class StudentGroup implements Serializable,Cloneable{
	private static final long serialVersionUID = -445392204151287876L;
	private int groupId;
	private String groupName;
	public StudentGroup(int groupId, String groupName) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
