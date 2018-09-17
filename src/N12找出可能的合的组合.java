public class N12找出可能的合的组合 {

    private static String solution(String line) {

        String[] array = line.split(" ");
        String result = "";
        String s1 = array[0];
        String s2 = array[1];
        int n = Integer.parseInt(s2);
        String[] sa = s1.split(",");

        return Integer.toString(get_num(sa, n));


        //return "";
    }

    static int get_num(String[] na, int n) {
        int sum = 0;
        for (int i = 0; i < na.length; i++) {
            if (n - Integer.parseInt(na[i]) == 0) {
                sum++;
                break;
            }
            if (n - Integer.parseInt(na[i]) > 0)
                sum += get_num(na, n - Integer.parseInt(na[i]));
            if (n - Integer.parseInt(na[i]) < 0)
                break;
        }
        return sum;
    }


    public static void main(String[] args) {

        System.out.println(solution("1,2,3 4"));


    }

}
