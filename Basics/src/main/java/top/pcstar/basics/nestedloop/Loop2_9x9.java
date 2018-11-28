package top.pcstar.basics.nestedloop;

/**
 * @Author: PanChao
 * @Description: 多重循环：打印9*9乘法表
 * @Date: Created in 10:44 2018/6/23
 */
public class Loop2_9x9 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " * " + i + " = " + j * i + "\t");
            }
            System.out.println();
        }
    }
}
