public class N2找出单独出现的数字 {
    private static String solution(String line) {
        // 在此处理单行数据
        String[] array = line.split(" ");
        int a = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length; j++) {
                if (Integer.parseInt(array[i]) == Integer.parseInt(array[j])) {
                    a = Integer.parseInt(array[i]);
                }
            }
            //int a = Integer.parseInt(array[i]);
            //count = count + a;
        }
        //String result = Integer.toString(count);
        String result = Integer.toString(a);
        // 返回处理后的结果
        return result;

        // 返回处理后的结果
        // return result;
    }
}
