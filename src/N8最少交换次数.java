/**
描述
给出一个无序数列，每次只能交换相邻两个元素，求将原数列变成递增数列的最少交换次数。 如：数列：2,3,1，交换3和1后变成：2,1,3；交换1和2之后变成：1,2,3。总共交换2次。

输入
逗号隔开的正整数数列

输出
正整数

输入样例
2,3,1

输出样例
2
 */

public class N8最少交换次数 {

    private static String solution(String line) {

        String[] array = line.split(",");
        String result = "";
        int a[] = new int[array.length];
        int sum = 0, temp = 0;
        for (int y = 0; y < array.length; y++) {
            a[y] = Integer.parseInt(array[y]);
        }


        for (int j = 0; j < 1000; j++) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    //   System.out.println(a[i]+ " "+a[i+1]+ " "+sum);
                    sum++;

                }
            }
        }


        result = Integer.toString(sum);
        return result;
    }


    public static void main(String[] args) {


        System.out.println(solution("4,2,3,1"));


    }
}
