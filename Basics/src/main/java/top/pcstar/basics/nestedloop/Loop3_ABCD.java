package top.pcstar.basics.nestedloop;

/**
 * @Author: PanChao
 * @Description: 多重循环：穷举ABCD的不重复组合
 * @Date: Created in 10:53 2018/6/23
 */
public class Loop3_ABCD {
    public static void main(String[] args) {
        int count = 0;
        for (char i = 'A'; i < 'E'; i++) {
            for (char j = 'A'; j < 'E'; j++) {
                if (j == i) {
                    continue;
                }
                for (char k = 'A'; k < 'E'; k++) {
                    if (k == j || k == i) {
                        continue;
                    }
                    for (char l = 'A'; l < 'E'; l++) {
                        if (l == k || l == j || l == i) {
                            continue;
                        }
                        System.out.println("" + i + j + k + l);
                        count++;
                    }
                }
            }
        }
        System.out.println("4个字母的全组合有"+count+"种");
    }
}
