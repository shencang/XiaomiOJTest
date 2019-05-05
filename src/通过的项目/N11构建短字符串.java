package 通过的项目;

/**
描述
给定任意一个较短的子串，和另一个较长的字符串，判断短的字符串是否能够由长字符串中的字符组合出来，且长串中的每个字符只能用一次。

 输入
一行数据包括一个较短的字符串和一个较长的字符串，用一个空格分隔，如： ab aab bb abc aa cccc uak areuok

 输出
如果短的字符串可以由长字符串中的字符组合出来，返回字符串 “true”，否则返回字符串 "false"，注意返回字符串类型而不是布尔型。

 输入样例
a b
aa ab
aa aab
uak areuok


 输出样例
false
false
true
true
 */
public class N11构建短字符串 {

    private static String solution(String line) {

        String[] array = line.split(" ");
        String result = "";
        String s1 = array[0];
        String s2 = array[1];
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        if (find(ch1, ch2)) {
            return "true";
        } else {
            return "false";
        }
    }

    public static boolean find(char[] a, char[] b) {

        for (int i = 0; i < a.length; i++) {
            int c = 0;
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    b[j] = '!';
                    c = 1;
                    break;
                }
            }
            if (c == 0) {
                return false;
            }

        }
        return true;
    }


    public static void main(String[] args) {


        System.out.println(solution("uak areuok"));


    }
}
