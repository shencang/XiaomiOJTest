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
