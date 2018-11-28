package top.pcstar.basics.clone;

import java.io.*;

/**
 * Java深复制和浅复制练习
 * 
 * @author PANCHAO
 *
 */
public class CloneTest {
	/**
	 * 浅复制(引用复制):修改原对象,复制的新对象也跟随变化
	 */
	public void shallowClone() {
		Student student = new Student(1, "张三", new StudentGroup(1, "一组"));
		Student copyStudent = student;
		System.out.println("修改前：" + copyStudent);
		student.setStuId(2);
		student.setStuName("李四");
		student.getStuGroup().setGroupId(2);
		student.getStuGroup().setGroupName("二组");
		System.out.println("修改后：" + copyStudent);
	}

	/**
	 * 序列化深复制：修改原对象,复制的对象不变化,不受影响
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void serializableClone() throws IOException, ClassNotFoundException {
		Student student = new Student(1, "张三", new StudentGroup(1, "一组"));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(student);
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		Student copyStudent = (Student) ois.readObject();
		System.out.println("修改前：" + copyStudent);
		student.setStuId(2);
		student.setStuName("李四");
		student.getStuGroup().setGroupId(2);
		student.getStuGroup().setGroupName("二组");
		System.out.println("修改后：" + copyStudent);
	}

	/**
	 * Cloneable深复制：修改原对象,复制的对象不变化,不受影响
	 * 
	 * @throws CloneNotSupportedException
	 */
	public void deepClone() throws CloneNotSupportedException {
		Student student = new Student(1, "张三", new StudentGroup(1, "一组"));
		Student copyStudent = (Student) student.clone();
		System.out.println("修改前：" + copyStudent);
		student.setStuId(2);
		student.setStuName("李四");
		student.getStuGroup().setGroupId(2);
		student.getStuGroup().setGroupName("二组");
		System.out.println("修改后：" + copyStudent);
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException, CloneNotSupportedException {
		CloneTest cloneTest = new CloneTest();
		cloneTest.shallowClone();
		cloneTest.serializableClone();
		cloneTest.deepClone();
	}
}
