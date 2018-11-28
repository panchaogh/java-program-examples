package top.pcstar.basics.nestedloop;

/**
 * @Author: PanChao
 * @Description: 多重循环：
 * 百钱百鸡问题：公鸡5元一只，母鸡3元一只，小鸡3只一元，用一百元买一百只鸡，怎么卖
 * @Date: Created in 11:12 2018/6/23
 */
public class Chick100Money100 {
    public static void main(String[] args) {
        System.out.println("第一版，穷举所有解");
        for (int cock = 0; cock < 25; cock++) {
            for (int hen = 0; hen < 33; hen++) {
                for (int chick = 0; chick < 100; chick += 3) {
                    int number = cock + hen + chick;
                    int price = cock * 5 + hen * 3 + chick / 3;
                    if (price == 100 && number == 100) {
                        System.out.println("公鸡：" + cock + "---母鸡：" + hen + "---小鸡：" + chick);
                    }
                }
            }
        }
        System.out.println("第二版，利用标志变量，只找第一组解");
        boolean found = false;
        for (int cock = 0; !found && cock < 25; cock++) {
            for (int hen = 0; !found && hen < 33; hen++) {
                for (int chick = 0; !found && chick < 100; chick += 3) {
                    int number = cock + hen + chick;
                    int price = cock * 5 + hen * 3 + chick / 3;
                    if (price == 100 && number == 100) {
                        System.out.println("公鸡：" + cock + "---母鸡：" + hen + "---小鸡：" + chick);
                        found = true;
                    }
                }
            }
        }
        System.out.println("第三版，修改循环变量，只找第一组解");
        for (int cock = 0; cock < 25; cock++) {
            for (int hen = 0; hen < 33; hen++) {
                for (int chick = 0; chick < 100; chick += 3) {
                    int number = cock + hen + chick;
                    int price = cock * 5 + hen * 3 + chick / 3;
                    if (price == 100 && number == 100) {
                        System.out.println("公鸡：" + cock + "---母鸡：" + hen + "---小鸡：" + chick);
                        cock = hen = chick = 100;
                    }
                }
            }
        }
        System.out.println("第四版，直接跳转，只找第一组解");
        outOfHere:
        for (int cock = 0; cock < 25; cock++) {
            for (int hen = 0; hen < 33; hen++) {
                for (int chick = 0; chick < 100; chick += 3) {
                    int number = cock + hen + chick;
                    int price = cock * 5 + hen * 3 + chick / 3;
                    if (price == 100 && number == 100) {
                        System.out.println("公鸡：" + cock + "---母鸡：" + hen + "---小鸡：" + chick);
                        break outOfHere;
                    }
                }
            }
        }
    }
}
