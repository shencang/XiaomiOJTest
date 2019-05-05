package 通过的项目; /**
 描述
 有一行由 N 个数字组成的数字字符串，字符串所表示的数是一正整数。移除字符串中的 K 个数字，使剩下的数字是所有可能中最小的。

 假设：

 字符串的长度一定大于等于 K
 字符串不会以 0 开头
 输入
 一行由 N 个数字组成的数字字符串（0 < N < 20），和一个正整数 K（K < N），两个数据由空格隔开，如：1432219 3。

 输出
 移除 K 位后可能的最小的数字字符串。 如 1432219 移除 4, 3, 2 这 3 个数字后得到 1219，为所有可能中的最小值。

 输入样例
 1432219 3
 10200 1

 输出样例
 1219
 200
 */


import java.util.ArrayList;
import java.util.List;

public class N9移除K位得到最小值 {
    private static String solution(String line) {

        String[] array = line.split(" ");
        String result = "";
        int k = Integer.parseInt(array[1]);
        String num = array[0];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num.length(); i++) {
            int number = Integer.parseInt(String.valueOf(num.charAt(i)));
            while (list.size() != 0 && k > 0 && (list.get(list.size() - 1) > number)) {
                list.remove(list.size() - 1);
                k--;
            }
            if (number != 0 || list.size() != 0) {
                list.add(number);
            }
        }
        while (list.size() != 0 && k > 0) {
            list.remove(list.size() - 1);
            k--;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0 && result.length() == 0) {


            } else {
                result = result + list.get(i);
            }
        }
        if (result.equals(""))
            result = String.valueOf(0);
        return result;
    }


    public static void main(String[] args) {


        System.out.println(solution("10200 1"));


    }
}
