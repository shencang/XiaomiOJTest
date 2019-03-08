import java.util.*;

public class N17小写数字转大写数字 {
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
    public static void main(String []args) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            System.out.println(solution(line));

            System.out.println("测试：");
            // System.out.println("answer");
        }
    }

    private static String solution(String line) {
        // 在此处理单行数据
        boolean flagBY = true,flagSY = true,flagY = true,flagKW = true,
                flagBW = true,flagSW = true,flagW = true, flagK = true,
                flagB = true,flagS = true,flagQSA = true;
        List<String> listCh = new ArrayList<String>();
        char[] count = line.toCharArray();
        for (int i = 0; i < count.length; i++) {

            switch (count[i]) {
                case '1':
                    listCh.add("壹");
                    break;
                case '2':
                    listCh.add("贰");
                    break;
                case '3':
                    listCh.add("叁");
                    break;
                case '4':
                    listCh.add("肆");
                    break;
                case '5':
                    listCh.add("伍");
                    break;
                case '6':
                    listCh.add("陆");
                    break;
                case '7':
                    listCh.add("柒");
                    break;
                case '8':
                    listCh.add("捌");
                    break;
                case '9':
                    listCh.add("玖");
                    break;
                case '0':
                    if (i < count.length - 1 && count[i + 1] == '0') {
                        flagQSA = false;
                        break;

                    }
                    if (i == count.length - 1 && count[i] == '0') {
                        flagQSA = false;
                        break;

                    }
                    if (i<count.length-2&&count[i]!='0'&&count[i+1]=='0'&&count[i+2]!='0'){
                        flagQSA=false;
                        break;

                    }
                    listCh.add("零");
                    break;

            }
            if (count.length == 1 && count[0] == '0') {
                listCh.add("零");
            }

            if (count.length > 10 && flagBY && flagQSA ) {
                listCh.add("佰");
                flagBY = false;
                continue;
            }
            if (count.length > 9 && flagSY && flagQSA) {
                listCh.add("拾");
                flagSY = false;
                continue;
            }
            if (count.length > 8 && flagY && flagQSA) {
                listCh.add("亿");
                flagY = false;
                continue;
            }
            if (count.length > 7 && flagKW && flagQSA) {
                listCh.add("仟");
                flagKW = false;
                continue;
            }
            if (count.length > 6 && flagBW && flagQSA) {
                listCh.add("佰");
                flagBW = false;
                continue;
            }
            if (count.length > 5 && flagSW && flagQSA) {
                listCh.add("拾");
                flagSW = false;
                continue;
            }
            if (count.length > 4 && flagW && flagQSA) {
                listCh.add("万");
                flagW = false;
                continue;
            }
            if (count.length > 3 && flagK && flagQSA ) {
                listCh.add("仟");
                flagK = false;
                continue;
            }
            if (count.length > 2 && flagB && flagQSA) {
                listCh.add("佰");
                flagB = false;
                continue;
            }
            if (count.length > 1 && flagS && flagQSA) {
                listCh.add("拾");
                flagS = false;
                continue;
            }

        }
        return result(listCh);
    }

    public static String result(List<String> S) {
        String s = "";
        for (String c : S) {
            s = s + c;
        }
        return s + "元整";
    }

}
