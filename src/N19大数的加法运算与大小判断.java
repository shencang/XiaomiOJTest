import java.util.Scanner;

/**
 * 描述
 * 对于给定的算术表达式，按规则输出计算结果，仅包含加法和大小判断。
 * 输入
 * <p>
 * 一行字符串，为加号、大于、小于( + < > ) 连接的两个不限大小的非负整数。
 * <p>
 * 输出
 * <p>
 * 当符号为 + 时, 计算两个数相加的和, 并以字符串格式返回； 当符号为 < 时, 如果左数小于右数, 返回大写字母字符 Y, 否则返回大写字母字符 N； 当符号为 > 时, 如果左数大于右数, 返回大写字母字符 Y, 否则返回大写字母字符 N。
 * !!!请同学们尽量使用算法来解决这个问题
 * <p>
 * 输入样例
 * 972919822976663297>74058
 * 875098336507333719633571722631534917759993913379786689>53558270653237768027942884431075534537929401567824882097903948774409200
 * 7625022925148127196027859399571498914361+790786706794530
 * 复制样例
 * 输出样例
 * Y
 * N
 * 7625022925148127196027860190358205708891
 */

public class N19大数的加法运算与大小判断 {

    private static String solution(String line) {
        // 在此处理单行数据
        String[] arrAdd = line.split("\\+");
        String[] arrL = line.split(">");
        String[] arrM = line.split("<");
        String[] temp;
        boolean flagAdd = false, flagL = false, flagM = false;
        if (arrAdd.length == 2) {
            temp = arrAdd;
            flagAdd = true;
        } else if (arrL.length == 2) {
            temp = arrL;
            flagL = true;
        } else {
            temp = arrM;
            flagM = true;
        }

        if (flagL) {
            if (temp[0].length() > temp[1].length()) {
                return "Y";
            } else if (temp[0].length() < temp[1].length()) {
                return "N";
            } else {
                //同位比较
                char[] num1 = temp[0].toCharArray();
                char[] num2 = temp[1].toCharArray();
                for (int i = 0; i < temp[0].length(); i++) {
                    if (Integer.parseInt(String.valueOf(num1[0]))
                            >
                            Integer.parseInt(String.valueOf(num1[1]))) {
                        return "Y";

                    } else if (Integer.parseInt(String.valueOf(num1[0]))
                            ==
                            Integer.parseInt(String.valueOf(num1[1]))) {
                        continue;
                    } else {
                        return "Y";
                    }
                }
            }
        }

        if (flagM) {
            if (temp[0].length() < temp[1].length()) {
                return "Y";
            } else if (temp[0].length() > temp[1].length()) {
                return "N";
            } else {
                //同位比较
                char[] num1 = temp[0].toCharArray();
                char[] num2 = temp[1].toCharArray();
                for (int i = 0; i < temp[0].length(); i++) {
                    if (Integer.parseInt(String.valueOf(num1[0]))
                            <
                            Integer.parseInt(String.valueOf(num1[1]))) {
                        return "Y";

                    } else if (Integer.parseInt(String.valueOf(num1[0]))
                            ==
                            Integer.parseInt(String.valueOf(num1[1]))) {
                        continue;
                    } else {
                        return "Y";
                    }
                }
            }
        }
        if (flagAdd) {
            char[] num1 = maxCharArr(temp);
            char[] num2 = minCharArr(temp);
            int longth = num1.length;
            int number = 0;
            for (int i = longth - 1; i > 0; i++) {

                if (i != num2.length - 1) {
                    if ((Integer.parseInt(String.valueOf(num1[i]))
                            + Integer.parseInt(String.valueOf(num2[i])) > 10)) {
                        num1[i] = (char) ((Integer.parseInt(String.valueOf(num1[i]))
                                + Integer.parseInt(String.valueOf(num2[i]))) % 10 + '0');
                        num1[i - 1] = num1[i - 1]++;
                        //还有点问题，等待修改
                        //进位处理


                    }
                } else {
                    return charArrToString(num1);
                }

            }
        }


        return "1";
    }

    private static String charArrToString(char[] num1) {
        String res = "";
        for (char i : num1) {
            res += i;
        }
        return res;
    }

    private static char[] minCharArr(String[] temp) {
        if (temp[0].length() < temp[1].length()) {
            return temp[0].toCharArray();
        } else {
            return temp[1].toCharArray();
        }
    }

    private static char[] maxCharArr(String[] temp) {
        if (temp[0].length() > temp[1].length()) {
            return temp[0].toCharArray();
        } else {
            return temp[1].toCharArray();
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            System.out.println(solution(line));
            System.out.println("n19");

        }

    }
}
