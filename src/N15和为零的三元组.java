import java.util.*;

public class N15和为零的三元组 {
    /**
     * 描述
     * 给出一个整数数组, 数组中是否存在任意 3 个数 a, b, c 满足 a + b + c = 0? 找出数组中所有满足以上条件的三元组，最后输出这些三元组的个数（包含相同元素的三元组只计算一次）。
     * <p>
     * 输入
     * 一个包含多个整数（正或负）的字符串，每个整数之间用逗号（,）分隔，如：-1,0,1,2,-1,-4。
     * <p>
     * 输出
     * 输入满足加和结果正好等于 0 的三元组的个数，如对于 -1,0,1,2,-1,-4 有 [-1, 0, 1] 和 [-1, -1, 2]，所以输出 2
     * <p>
     * 输入样例
     * -1,0,1,2,-1,-4
     * <p>
     * 输出样例
     * 2
     */

    private static String solution(String line) {
        // 在此处理单行数据
        List<Integer> numList = new ArrayList<>();
        List<Integer> zeroList = new ArrayList<>();
        List<List> resultList = new ArrayList<>();
        for (String i : line.split(",")) {
            numList.add(Integer.parseInt(i));
        }
        Collections.sort(numList);
       // System.out.println(numList);
        //-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6正确6，结果11，待修改
        int countx = 0;
        int county = 0;
        int countz = 0;
            for (int i :numList){
                countx++;
                for (int j:numList){
                    county++;
                    for (int k:numList) {
                        countz++;
                        if ((i + j + k) == 0&&countx!=county&&countx!=countz&&county!=countz) {
                            zeroList.add(i);
                            zeroList.add(j);
                            zeroList.add(k);
                           // System.out.println(countx+county+countz);
                            Collections.sort(zeroList);
                            resultList.add(zeroList);
                            zeroList = new ArrayList<>();
                            //zeroList.clear();
                        }
                    }
                    countz=0;
                }
                county=0;
            }
            countx=0;
            resultList= removeDuplicateWithOrder(resultList);
            //System.out.println(resultList);
        return Integer.toString(resultList.size());



    }

    // 删除ArrayList中重复元素，保持顺序
    private static List removeDuplicateWithOrder(List list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            Object element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        list.clear();
        list.addAll(newList);
        return list;
    }


    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            //15ti
            System.out.println(solution(line));
            System.out.println("OK");

        }

    }
}
//参考：
//        java.util.Set<java.util.List<Integer>> set = new java.util.HashSet<>();
//        int ssa=0;
//        int []a1= new int[numList.size()];
//        for (Integer i :numList){
//            a1[ssa]=i;
//            ssa++;
//        }
//        int sum = 0;
//        for (int i = 0; i < a1.length - 2; i++) {
//            int high = a1.length - 1;
//            int low = i + 1;
//
//            while (low < high) {
//
//                if (a1[i] + a1[low] + a1[high] < 0)
//                    low++;
//                else if (a1[i] + a1[low] + a1[high] > 0)
//                    high--;
//
//                if (a1[i] + a1[low] + a1[high] == 0&&low!=high) {
//                    java.util.List<Integer> t1 = new java.util.ArrayList<>();
//                    t1.add(a1[i]);
//                    t1.add(a1[low]);
//                    t1.add(a1[high]);
//                    set.add(t1);
//                    low++;
//
//                }
//
//            }
//        }
//        return String.valueOf(set.size());

