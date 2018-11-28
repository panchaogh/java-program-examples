package top.pcstar.basics;

/**
 * @Author: PanChao
 * @Description: 位运算
 * @Date: Created in 9:51 2018/6/22
 */
public class BitOperation {
    /**
     * 位运算-与&
     */
    public static void testAnd(){
        System.out.println("0&0 = "+ (0&0));
        System.out.println("0&1 = "+ (0&1));
        System.out.println("1&0 = "+ (1&0));
        System.out.println("1&1 = "+ (1&1));
    }
    /**
     * 位运算-或|
     */
    public static void testOr(){
        System.out.println("0|0 = "+ (0|0));
        System.out.println("0|1 = "+ (0|1));
        System.out.println("1|0 = "+ (1|0));
        System.out.println("1|1 = "+ (1|1));
    }
    /**
     * 位运算-非~
     */
    public static void testNot(){
        System.out.println("~0 = "+ (~0));// 00000000 00000000 00000000 00000000 非 11111111_11111111_11111111_11111111
        System.out.println("~1 = "+ (~1));// 00000000 00000000 00000000 00000001 非 11111111_11111111_11111111_11111110
        System.out.println(0b11111111_11111111_11111111_11111111);
        System.out.println(0b11111111_11111111_11111111_11111110);
    }
    /**
     * 位运算-异或^
     */
    public static void testXor(){
        System.out.println("0^0 = "+ (0^0));
        System.out.println("0^1 = "+ (0^1));
        System.out.println("1^0 = "+ (1^0));
        System.out.println("1^1 = "+ (1^1));
    }
    /**
     * 位运算-左移运算符<<
     */
    public static void testMoveLeft(){
        System.out.println("1<<2 = "+ (1<<2));
        System.out.println("-1<<2 = "+ (-1<<2));
    }
    /**
     * 位运算-右移运算符>>
     */
    public static void testMoveRight(){
        System.out.println("4>>2 = "+ (4>>2));
        System.out.println("-4>>2 = "+ (-4>>2));
    }
    /**
     * 位运算-无符号右移>>>
     */
    public static void testUnsignedMoveLeft(){
        System.out.println("4>>>2 = "+ (4>>>2));
        System.out.println("-4>>>2 = "+ (-4>>>2));
    }
    public static void main(String[] args) {
        testAnd();
        testOr();
        testNot();
        testXor();
        testMoveLeft();
        testMoveRight();
        testUnsignedMoveLeft();
    }
}
