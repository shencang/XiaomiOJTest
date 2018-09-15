import java.util.Arrays;

public class N11构建短字符串 {

    private static String solution(String line) {

        String[] array = line.split(" ");
        String result = "";
        String s1 = array[0];
        String s2 = array[1];
        int num = 0;
        s1 = sort(s1);
        s2 = sort(s2);
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        //  System.out.println(s1+" "+s2);
        for (int i = 0; i < ch2.length; i++) {
            for (int j = 0; j < ch1.length; j++) {
                if (ch2[i] == ch1[j]) {
                    num++;
                    //   System.out.println(num);
                }
            }
        }
        if (num == ch1.length) {
            return "true";
        } else {
            return "false";
        }
    }


    private static String sort(String str) {
        //把字符串转化成字符数组
        char[] chs = stringToCharArray(str);

        //对字符数组进行排序
        charSort(chs);

        //把字符数组转化成字符串
        String s = new String(chs);

        return s;
    }

    private static void charSort(char[] chs) {

        Arrays.sort(chs);

    }

    private static char[] stringToCharArray(String str) {


        return str.toCharArray();
    }


    public static void main(String[] args) {


        System.out.println(solution("aa ab"));


    }
}
