import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N18帮小学生排队 {
    /**
     * 描述
     * 用一个数组表示一群正在排队的小学生，每个小学生用一对整数 H, K 来表示：H 表示这个小学生的身高，K 表示这个小学生前面应该有 K 个人的身高 >= 他。
     * 写一个算法，对给出的一组小学生计算出符合描述的正确排序。
     * 输入
     *
     * 输入为一组整数，以空格分隔：
     * 第 1 个数字表示小学生的数量 n；
     * 从第 2 个数字起，后续的数字两两一组，分别代表每个小学生的 H 和 K 的值：
     * H1 K1 H2 K2⋯Hn KnH_1\text{ }K_1\text{ }H_2\text{ }K_2 \cdots H_n\text{ }K_n
     * H
     * 1
     * ​
     *
     *  K
     * 1
     * ​
     *
     *  H
     * 2
     * ​
     *
     *  K
     * 2
     * ​
     *
     * ⋯H
     * n
     * ​
     *
     *  K
     * n
     * ​
     *
     * .
     *
     * 输出
     *
     * 根据输入，按照题目要求对小学生进行排序，每个小学生对应的 H 和 K 值为一组，按组输出，数字间使用空格分隔。比如
     * H1′ K1′ H2′ K2′⋯Hn′ Kn′H_1&#x27;\text{ }K_1&#x27;\text{ }H_2&#x27;\text{ }K_2&#x27; \cdots H_n&#x27; \text{ }K_n&#x27;
     * H
     * 1
     * ′
     * ​
     *
     *  K
     * 1
     * ′
     * ​
     *
     *  H
     * 2
     * ′
     * ​
     *
     *  K
     * 2
     * ′
     * ​
     *
     * ⋯H
     * n
     * ′
     * ​
     *
     *  K
     * n
     * ′
     * ​
     *
     *
     * 输入样例
     * 6 7 0 4 4 7 1 5 0 6 1 5 2
     *  复制样例
     * 输出样例
     * 5 0 7 0 5 2 6 1 4 4 7 1
     */

    private static String solution(String line) {
        // 在此处理单行数据
        String[] arr = line.split(" ");
        System.out.println(arr[0]);
        int num = Integer.parseInt(arr[0]);
        int[] temp = new int[num];
        int count = 0;
        List<Integer> number = new ArrayList<>();


        for (int i = 1; i < num * 2; i += 2) {
            //   System.out.println(arr[i]+" "+arr[i+1]);
            temp[count] = Integer.parseInt(arr[i] + arr[i + 1]);
            count++;
        }
//        for (int i :temp){
//            System.out.println(i);
//        }

        for (int i : temp) {
            number.add(i);
        }
        int tempa = 0;

        for (int i = 0; i < number.size(); i++) {
            for (int j = 0; j < number.size(); j++) {
                if (number.get(j) % 10 >= i) {
                    tempa = number.get(j);
                    number.remove(j);
                    number.add(tempa);
//                    if (temp[i+1]%10==0&&temp[i]<temp[i+1]){
//
                }
            }
        }
//        Collections.sort(number);
        System.out.println(number);

        return arr[1];

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(solution(line));
            System.out.println("n18");

        }

    }
}
