package 通过的项目;

/**
 * 描述
 * 两个长度超出常规整形变量上限的大数相减，请避免使用各语言内置大数处理库，如 Java.math.BigInteger 等。
 * <p>
 * 输入
 * 有 N 行测试数据，每一行有两个代表整数的字符串 a 和 b，长度超过百位。规定 a>=b，a, b > 0。 测试结果可以用 linux 小工具 bc进行测试是否正确。
 * <p>
 * 输出
 * 返回表示结果整数的字符串。
 * <p>
 * 输入样例
 * 1231231237812739878951331231231237812739878951331231231237812739878951331231231237812739878951331231231237812739878951331231231237812739870-89513312312312378127398789513312312312378127398789513312312312378127398789513
 * 1231231237812739878951331231231237812739878951331231231237812739878951331230000000000000000000000001-331231231237812739878951331231231
 * <p>
 * 输出样例
 * 1231231237812739878951331231231237812739878951331231231237812650365639018918853110413950365639018918853110413950365639018918853110413950357
 * 1231231237812739878951331231231237812739878951331231231237812739878620099998762187260121048668768770
 */
public class N3大数相减版本1提交版 {
    public static void main(String[] args) {
        System.out.println(solution("111118888888111 - 3333888888888333"));


    }

    private static String solution(String line) {
        // 在此处理单行数据
        String[] array = line.split(" - ");
        int a = 0;
        int count = 0;
        char[] as = new StringBuffer(array[0]).reverse().toString().toCharArray();
        char[] b = new StringBuffer(array[1]).reverse().toString().toCharArray();
        int lenA = as.length;
        int lenB = b.length;
        // 找到最大长度
        int len = lenA > lenB ? lenA : lenB;
        int[] result = new int[len];
        // 表示结果的正负
        char sign = '+';
        // 判断最终结果的正负
        if (lenA < lenB) {
            sign = '-';
        } else if (lenA == lenB) {
            int i = lenA - 1;
            while (i > 0 && as[i] == b[i]) {
                i--;
            }
            if (as[i] < b[i]) {
                sign = '-';
            }
        }
        // 计算结果集，如果最终结果为正，那么就a-b否则的话就b-a
        for (int i = 0; i < len; i++) {
            int aint = i < lenA ? (as[i] - '0') : 0;
            int bint = i < lenB ? (b[i] - '0') : 0;
            if (sign == '+') {
                result[i] = aint - bint;
            } else {
                result[i] = bint - aint;
            }
        }
        // 如果结果集合中的某一位小于零，那么就向前一位借一，然后将本位加上10。其实就相当于借位做减法
        for (int i = 0; i < result.length - 1; i++) {
            if (result[i] < 0) {
                result[i + 1] -= 1;
                result[i] += 10;
            }
        }

        StringBuffer sb = new StringBuffer();
        // 如果最终结果为负值，就将负号放在最前面，正号则不需要
        if (sign == '-') {
            sb.append('-');
        }
        // 判断是否有前置0
        boolean flag = true;
        for (int i = len - 1; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            sb.append(result[i]);
        }
        // 如果最终结果集合中没有值，就说明是两值相等，最终返回0
        if (sb.toString().equals("")) {
            sb.append("0");
        }
        // 返回值

        return sb.toString();


    }


}
