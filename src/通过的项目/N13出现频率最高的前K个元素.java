package 通过的项目;

import java.util.*;

/**描述
 有一个不为空且仅包含正整数的数组，找出其中出现频率最高的前 K 个数，时间复杂度必须在 O(n log n) 以内。

 输入
 一行数据包括两部分，一个正整数数组（数字间 ',' 分隔）和一个正整数 K （1 ≤ K ≤ 数组长度），数组和 K 之间有一个空格。

 输出
 输出包含前 K 个出现频率最高的数（出现频率相同时，较小的数在前），用 ', ' 分隔，保证升序排列。

 输入样例
 1,1,1,2,2,3 2


 输出样例
 1,2
*/
public class N13出现频率最高的前K个元素 {

    private static String solution(String line) {
        List<Integer> res = new LinkedList<Integer>();
        String[] array = line.split(" ");
        String result = "";
        String numArray = array[0];
        String nums = array[1];
        int n = Integer.parseInt(nums);
        int down = -1;
        String[] sa = numArray.split(",");
        int[] intArray = new int[sa.length];
        int[][] intArrays = new int[sa.length][sa.length];
        for (int i = 0; i < sa.length; i++) {
            intArray[i] = Integer.parseInt(sa[i]);
        }
        res = topKFrequent2(intArray, n);

        for (int i = 0; i < res.size(); i++) {
            result = result + res.get(i);
            if (i != res.size() - 1) {
                result = result + ",";
            }
        }
        // System.out.println(res.get(0)+res.get(1));
        return result;
    }

    public static List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> res = new LinkedList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.get(num) == null)
                map.put(num, 1);
            else
                map.put(num, (int) (map.get(num)) + 1);
        }
        int len = nums.length;
        ArrayList<Integer>[] times = new ArrayList[len + 1];
        Set<Integer> set = map.keySet();
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int num = it.next();
            int time = map.get(num);
            if (times[time] == null)
                times[time] = new ArrayList<>();
            times[map.get(num)].add(num);
        }
        for (int i = len; i >= 0; i--)
            if (times[i] != null) {
                it = times[i].iterator();
                while (k > 0 && it.hasNext()) {
                    res.add(it.next());
                    k--;
                }
            }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(solution("1,1,1,2,2,3 2"));


    }

}
