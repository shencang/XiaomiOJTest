public class N8最少交换次数 {

    private static String solution(String line) {

        String[] array = line.split(",");
        String result = "";
        int a[] = new int[array.length];
        int sum = 0, temp = 0;
        for (int y = 0; y < array.length; y++) {
            a[y] = Integer.parseInt(array[y]);
        }


        for (int j = 0; j < 1000; j++) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    //   System.out.println(a[i]+ " "+a[i+1]+ " "+sum);
                    sum++;

                }
            }
        }


        result = Integer.toString(sum);
        return result;
    }


    public static void main(String[] args) {


        System.out.println(solution("4,2,3,1"));


    }
}
