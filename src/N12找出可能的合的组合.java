/*描述
        给出一组不重复的正整数，从这组数中找出所有可能的组合使其加合等于一个目标正整数 M，如：

        一组数为 1, 2, 3，目标数为 4，那么可能的加合组合为： 1, 1, 1, 1 1, 1, 2 1, 2, 1 1, 3 2, 1, 1 2, 2 3, 1 注意相同的组合数字顺序不同也算一种，所以这个例子的结果是 7 种。

        输入
        一组连续不重复的 N 个正整数（, 隔开，0<N<100）以及目标正整数（与数组之间用空格隔开）

        输出
        所有可能的加合等于目标正整数 M 的组合种数

        输入样例
        1,2,3 4


        输出样例
        7
*/
public class N12找出可能的合的组合 {

    private static String solution(String line) {

        String[] array = line.split(" ");
        String result = "";
        String s1 = array[0];
        String s2 = array[1];
        int n = Integer.parseInt(s2);
        String[] sa = s1.split(",");

        return Integer.toString(get_num(sa, n));


        //return "";
    }

    static int get_num(String[] na, int n) {
        int sum = 0;
        for (int i = 0; i < na.length; i++) {
            if (n - Integer.parseInt(na[i]) == 0) {
                sum++;
                break;
            }
            if (n - Integer.parseInt(na[i]) > 0)
                sum += get_num(na, n - Integer.parseInt(na[i]));
            if (n - Integer.parseInt(na[i]) < 0)
                break;
        }
        return sum;
    }


    public static void main(String[] args) {

        System.out.println(solution("1,2,3 4"));


    }

}
