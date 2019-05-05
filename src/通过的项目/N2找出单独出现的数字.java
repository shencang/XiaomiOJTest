package 通过的项目;

/**
 * 描述
 * 给出N个数字。其中仅有一个数字出现过一次，其他数字均出现过两次，找出这个出现且只出现过一次的数字。要求时间和空间复杂度最小。
 * <p>
 * 输入
 * 输入多个数字，每个数字以空格分开，回车结束
 * <p>
 * 输出
 * 输出内容为只出现过唯一一次的数字
 * <p>
 * 输入样例
 * 10 10 11 12 12 11 16
 * <p>
 * 输出样例
 * 16
 */
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
