package top.pcstar.basics.comparer;
/**
 * 包含内比较器的类
 * @author PANCHAO
 *
 */
public class Person implements Comparable<Person>{
	private String id;
	private String name;
	private String sex;
	public Person(String id, String name, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return id;
	}
	@Override
	public int compareTo(Person arg0) {
		if (Integer.parseInt(this.getId()) > Integer.parseInt(arg0.getId())) {
			return 1;
		}else if(Integer.parseInt(this.getId()) < Integer.parseInt(arg0.getId())) {
			return -1;
		}else {
			return 0;
		}
	}
}
