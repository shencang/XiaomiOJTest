import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 描述
 * 假设一个有序的数组，经过未知次数的旋转（例如0 1 2 4 5 6 7 被旋转成 4 5 6 7 0 1 2），从中查找一个目标值，如果存在，返回其下标，不存在，返回-1。注：假设数组无重复数字
 * <p>
 * 输入
 * 输入一个有序经过旋转的数组和要查找的目标数字，数组中各数字用“逗号”分隔，数组和目标数字用“空格”分隔
 * <p>
 * 输出
 * 一个整数，表示该目标数字的下标（不存在返回-1）
 * <p>
 * 输入样例
 * 4,5,6,7,0,1,2 6
 * <p>
 * 输出样例
 * 2
 */
public class N14在一个有序的经过旋转的数组里查找一个数 {


    private static Integer solution(String line) {
        // 在此处理单行数据
        String[] array = line.split(" ");

        List<Integer> num = new ArrayList<>();
        for (String i : array[0].split(",")) {
            num.add(Integer.parseInt(i));
        }
        int count = 0;
        for (Integer i : num) {

            if (i.equals(Integer.parseInt(array[1]))) {
                return count;
            }
            count++;

        }
        return -1;


    }


    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            System.out.println(solution(line));
            // System.out.println("answer");
        }

    }
}
