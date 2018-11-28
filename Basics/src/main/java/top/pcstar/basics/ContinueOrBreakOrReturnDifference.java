package top.pcstar.basics;

/**
 * @Author: PanChao
 * @Description: continue，break，return区别
 * @Date: Created in 19:19 2018/5/19
 */
public class ContinueOrBreakOrReturnDifference {
    /**
     * continue
     */
    public static void testContinue() {
        for (int i = 0; i < 3; i++) {
            System.out.println("i的值是" + i);
            if (i == 1) {
                continue;
            }
            System.out.println("testContinue第"+i+"次结束");
        }
    }
    /**
     * break
     */
    public static void testBreak() {
        for (int i = 0; i < 3; i++) {
            System.out.println("i的值是" + i);
            if (i == 1) {
                break;
            }
            System.out.println("testBreak第"+i+"次结束");
        }
    }
    /**
     * breakTag
     */
    public static void testBreakTag() {
        tag:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("i的值为:" + i + " j的值为:" + j);
                if (j == 1) {
                    break tag;
                }
            }
        }
    }

    /**
     * return
     */
    public static void testReturn() {
        for (int i = 0; i < 3; i++) {
            System.out.println("i的值是" + i);
            if (i == 1) {
                return;
            }
            System.out.println("testReturn第"+i+"次结束");
        }
    }

    public static void main(String[] args) {
        System.out.println("-------------------testContinue测试开始--------------------");
        ContinueOrBreakOrReturnDifference.testContinue();
        System.out.println("-------------------testContinue测试结束--------------------");
        System.out.println("-------------------testBreak测试开始--------------------");
        ContinueOrBreakOrReturnDifference.testBreak();
        System.out.println("-------------------testBreak测试结束--------------------");
        System.out.println("-------------------testBreakTag测试开始--------------------");
        ContinueOrBreakOrReturnDifference.testBreakTag();
        System.out.println("-------------------testBreakTag测试结束--------------------");
        System.out.println("-------------------testReturn测试开始--------------------");
        ContinueOrBreakOrReturnDifference.testReturn();
        System.out.println("-------------------testReturn测试结束--------------------");
    }
}
