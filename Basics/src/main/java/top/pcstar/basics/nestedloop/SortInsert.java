package top.pcstar.basics.nestedloop;

import java.util.Arrays;

/**
 * @Author: PanChao
 * @Description: 插入排序法
 * @Date: Created in 17:34 2018/6/23
 */
public class SortInsert {
    public static void main(String[] args) {
        int[] array = {34, 65, 16, 32, 11, 22, 23};
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        int[] array1 = {34, 65, 16, 32, 11, 22, 23};
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));
    }
}
