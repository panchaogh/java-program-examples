package top.pcstar.basics.nestedloop;

/**
 * @Author: PanChao
 * @Description: 打印几何图形
 * @Date: Created in 11:30 2018/6/23
 */
public class PrintStar4 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - 1 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i || i==4) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
