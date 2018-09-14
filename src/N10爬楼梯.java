public class N10爬楼梯 {

    private static String solution(String line) {

        String[] array = line.split(" ");
        String result = "";
        int num = Integer.parseInt(array[0]);
        int f1 = 1, f2 = 2, f = 0;
        for (int i = 3; i <= num; ++i) {
            f = f2 + f1;
            f1 = f2;
            f2 = f;
        }


        result = Integer.toString(f);
        return result;
    }


    public static void main(String[] args) {


        System.out.println(solution("10"));


    }
}
