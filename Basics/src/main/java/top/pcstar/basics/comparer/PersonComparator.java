package top.pcstar.basics.comparer;

import java.util.Comparator;

/**
 * 外比较器
 * @author PANCHAO
 *
 */
public class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person arg0, Person arg1) {
		if (Integer.parseInt(arg0.getId()) > Integer.parseInt(arg1.getId())) {
			return 1;
		}else if(Integer.parseInt(arg0.getId()) < Integer.parseInt(arg1.getId())) {
			return -1;
		}else {
			return 0;
		}
	}

}
