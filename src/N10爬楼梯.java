/*
描述
在你面前有一个n阶的楼梯，你一步只能上1阶或2阶。 请问计算出你可以采用多少种不同的方式爬完这个楼梯。

输入
一个正整数，表示这个楼梯一共有多少阶

输出
一个正整数，表示有多少种不同的方式爬完这个楼梯

输入样例
5
10


输出样例
8
89
 */
public class N10爬楼梯 {

    private static String solution(String line) {

        String[] array = line.split(" ");
        String result = "";
        int num = Integer.parseInt(array[0]);
        int f1 = 1, f2 = 2, f = 0;
        for (int i = 3; i <= num; ++i) {
            f = f2 + f1;
            f1 = f2;
            f2 = f;
        }


        result = Integer.toString(f);
        return result;
    }


    public static void main(String[] args) {


        System.out.println(solution("10"));


    }
}
