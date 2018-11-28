package top.pcstar.basics.comparer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 测试内比较器和外比较器
 * 
 * @author PANCHAO
 *
 */
public class Test {
	/**
	 * 通过内比较器排序
	 * @param list
	 * @return
	 */
	public static List<Person> sortByComparable(List<Person> list) {
		Collections.sort(list);
		return list;
	}
	/**
	 * 通过外比较器排序
	 * @param list
	 * @return
	 */
	public static List<Person> sortByComparator(List<Person> list) {
		list.sort(new PersonComparator());
		return list;
	}
	/**
	 * 随机生成PersonID
	 * @return
	 */
	public static String createId() {
		Random random = new Random();
		return String.valueOf(random.nextInt(50));
	}
	/**
	 * 创建一个大小为num的Person集合
	 * @param num
	 * @return
	 */
	public static List<Person> createPersonList(int num) {
		// 随机生成num个Person对象
		List<Person> list = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			Person p = new Person(createId(), createId(), createId());
			list.add(p);
		}
		return list;
	}

	public static void main(String[] args) {
		List<Person> comparableList = createPersonList(10);
		System.out.println("内比较器排序前:"+comparableList);
		Collections.sort(comparableList);
		System.out.println("内比较器排序后:"+comparableList);
		System.out.println("-----------------------------------");
		List<Person> comparatorList = createPersonList(10);
		System.out.println("外比较器排序前:"+comparatorList);
		comparatorList.sort(new PersonComparator());
		System.out.println("外比较器排序后:"+comparatorList);
	}
}
