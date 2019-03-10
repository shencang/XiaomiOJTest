import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N17小写数字转大写数字_重置最终 {
    /**
     * 序号：#17
     * 难度：有挑战
     * 时间限制：1000ms
     * 内存限制：10M
     * 描述
     * 实现一个算法，可以将小写数字转换成大写数字。
     * 输入
     * <p>
     * 输入一个整数。范围在0～450亿之间。
     * <p>
     * 输出
     * <p>
     * 输出对应的大写数字，以“元整”结尾。 大写数字要符合汉语读写习惯。
     * <p>
     * 输入样例
     * 0
     * 5
     * 233
     * 1001
     * 40607
     * 8900000000
     * <p>
     * 输出样例
     * 零元整
     * 伍元整
     * 贰佰叁拾叁元整
     * 壹仟零壹元整
     * 肆万零陆佰零柒元整
     * 捌拾玖亿元整
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            System.out.println("--------");
            System.out.println(solution(line));

            // System.out.println("answer");
        }
    }

    private static String solution(String line) {
        // 在此处理单行数据
        List<String> listCh = new ArrayList<String>();
        List<Character> listCc = new ArrayList<Character>();
        char[] count = line.toCharArray();
//        long number =Long.valueOf(line);
//        System.out.println(number);


        char num0 = '零', num10k = '万', num10m = '亿';
        String[] num = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        if (count.length == 1 && count[0] == '0') {
            listCh.add("0");
        } else {
            for (int i = count.length - 1; i >= 0; i--) {
                int j = count.length - 1 - i;

                if (count[i] == '0')
                    listCh.add("零");

                if (j % 4 == 3 && count[i] != '0')
                    listCh.add("仟" + num[count[i] - '0']);

                if (j % 4 == 2 && count[i] != '0')
                    listCh.add("佰" + num[count[i] - '0']);

                if (j % 4 == 1 && count[i] != '0')
                    listCh.add("拾" + num[count[i] - '0']);

                if (j % 4 == 0 && count[i] != '0')
                    listCh.add(num[count[i] - '0']);

                if (j % 8 == 3 && j != count.length - 1)
                    listCh.add("万");

                if (j % 8 == 7 && j != count.length - 1)
                    listCh.add("亿");
            }
        }
        System.out.println(listCh);
        String str = result(listCh);
        for (char c : str.toCharArray()) {
            listCc.add(c);
        }

        System.out.println(listCc);
        for (int i = 0; i < listCc.size() - 2; i++) {
            if (listCc.get(i).equals('零') && listCc.get(i + 1).equals('零')) {
                listCc.remove(i);
                listCc.remove(i + 1);
            }
        }
        System.out.println(listCc);
        //return result(listCh);38646
        return "";
    }

    public static String result(List<String> list) {
        StringBuilder s = new StringBuilder();
        char[] c;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).length() == 1) {
                s.append(list.get(i));
            } else {
                s.append(switchs(list.get(i).toCharArray()));
            }
        }
        return s + "元整";
    }


    private static String switchs(char[] c) {
        char[] temp = {c[1], c[0]};
        //  System.out.println(c);
        return String.valueOf(temp);

    }


}
