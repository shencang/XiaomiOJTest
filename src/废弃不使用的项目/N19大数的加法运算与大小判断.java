package 废弃不使用的项目;

import java.util.Arrays;
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
                return sameLongCamp(temp, 'L');
            }
        }

        if (flagM) {
            if (temp[0].length() < temp[1].length()) {
                return "Y";
            } else if (temp[0].length() > temp[1].length()) {
                return "N";
            } else {
                //同位比较
                return sameLongCamp(temp, 'M');
            }
        }
        if (flagAdd) {
            char[] num1 = maxCharArr(temp);
            char[] num2 = CampForAdd(temp, num1);
            return getAddSolution(charArrToString(num1), charArrToString(num2));
        }

        return "";
    }

    private static String getAddSolution(String numberA, String numberB) {
        int lengthA = numberA.length();
        int lengthB = numberB.length();
        int[] a = new int[lengthA];
        int[] b = new int[lengthA];
        for (int i = 0; i < lengthA; i++) {
            a[i] = Integer.parseInt(String.valueOf(numberA.charAt(i)));
            if (i < lengthB) {
                if (i < lengthA - lengthB) {
                    b[i] = 0;
                    b[i + lengthA - lengthB] = Integer.parseInt(String.valueOf(numberB.charAt(i)));
                }
            }
        }
        return getAddNumber(a, b);
    }

    private static String getAddNumber(int[] a, int[] b) {
        int[] result = new int[a.length];
        for (int i = 0; i < b.length; i++) {
            result[i] = a[i] + b[i];
        }
        StringBuffer sb;
        sb = new StringBuffer();
        for (int i = b.length - 1; i >= 1; i--) {
            if (result[i] >= 10) {
                result[i - 1] += 1;
                result[i] -= 10;
            }
            sb.append(result[i]);
        }
        if (result[0] >= 10) {
            sb.append(result[0] - 10).append("1");
        } else {
            sb.append(result[0]);
        }
        return sb.reverse().toString();
    }

    private static String sameLongCamp(String[] temp, char flag) {
        char[] num1 = temp[0].toCharArray();
        char[] num2 = temp[1].toCharArray();
        for (int i = 0; i < temp[0].length(); i++) {
            if (flag == 'L') {
                if (Integer.parseInt(String.valueOf(num1[i]))
                        >
                        Integer.parseInt(String.valueOf(num2[i]))) {
                    return "Y";

                } else if (Integer.parseInt(String.valueOf(num1[i]))
                        ==
                        Integer.parseInt(String.valueOf(num2[i]))) {
                    continue;
                } else {
                    return "N";
                }
            } else if (flag == 'M') {
                if (Integer.parseInt(String.valueOf(num1[i]))
                        <
                        Integer.parseInt(String.valueOf(num2[i]))) {
                    return "Y";

                } else if (Integer.parseInt(String.valueOf(num1[i]))
                        ==
                        Integer.parseInt(String.valueOf(num2[i]))) {
                    continue;
                } else {
                    return "N";
                }
            }
        }
        return "err";

    }

    private static char[] CampForAdd(String[] temp, char[] other) {
        if (Arrays.equals(temp[0].toCharArray(), other)) {
            return temp[1].toCharArray();
        } else {
            return temp[0].toCharArray();
        }
    }

    private static String charArrToString(char[] num1) {
        String res = "";
        for (char i : num1) {
            res += i;
        }

        return res;
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
            //System.out.println("n19");

        }

    }
}
