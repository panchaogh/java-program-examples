package top.pcstar.basics.nestedloop;

/**
 * @Author: PanChao
 * @Description: 打印几何图形
 * @Date: Created in 11:30 2018/6/23
 */
public class PrintStar2 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - 1 - i; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
