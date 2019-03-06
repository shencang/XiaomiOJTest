import java.util.*;
public class N16四则运算 {
    //新设备测试
    /**
     * 实现一个算法，可以进行任意非负整数的加减乘除组合四则运算。
     * 请注意运算符的优先级。
     * 输入
     *
     * 请输入一行算式，使用空格分隔数字与运算符。
     * 数字为任意非负整数，运算符为+ - * /，不考虑括号。
     *
     * 输出
     *
     * 输出算式的运算结果。如果是小数，请向下取整（包含中间步骤结果）。 如果出现“除0异常”，输出err。
     *
     * 输入样例
     * 3 + 5
     * 12 + 45 / 9
     * 1 / 2
     * 1 / 0
     * 12 + 34 * 56 - 78
     * V
     * 输出样例
     * 8
     * 17
     * 0
     * err
     * 1838
     *  复制样例
     * 小提示
     * 可以使用栈来解决此类问题。
     */
        private static String solution(String line) {
            // 在此处理单行数据
            String[] array = line.split(" ");
            System.out.println(array.length);


            return "1";
        }


        public static void main(String args[]) {
            Scanner scan = new Scanner(System.in);
            String line;
            while (scan.hasNextLine()) {
                line = scan.nextLine().trim();
                // please write your code here
                System.out.println(solution(line));
                System.out.println("No16");
                // System.out.println("answer");
            }

        }
    }


