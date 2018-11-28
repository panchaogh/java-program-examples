package top.pcstar.basics.nestedloop;

/**
 * @Author: PanChao
 * @Description: 多重循环：打印10行10列星号
 * @Date: Created in 10:44 2018/6/23
 */
public class Loop1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
