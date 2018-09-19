/*描述
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

        String[] array = line.split(" ");
        String result = "";
        String numArray = array[0];
        String nums = array[1];
        int n = Integer.parseInt(nums);
        int down = -1;
        String[] sa = numArray.split(",");
        int[] intArray = new int[sa.length];
        int[] intArrays = new int[sa.length];
        for (int i = 0; i < sa.length; i++) {
            intArray[i] = Integer.parseInt(sa[i]);
        }
        intArray = HeapSort(intArray, intArray.length);


        for (int i = 0; i < intArray.length; i++) {

            if (intArray[i] != down) {
                // intArray[i];
            }
            // result=result+intArray[i]+" ";
        }
        return result;
    }


    /*返回父节点*/
    static int parent(int i) {
        return (int) java.lang.Math.floor((i - 1) / 2);
    }

    /*返回左孩子节点*/
    static int left(int i) {
        return (2 * i + 1);
    }

    /*返回右孩子节点*/
    static int right(int i) {
        return (2 * i + 2);
    }

    /*对以某一节点为根的子树做堆调整(保证最大堆性质)*/
    static void HeapAdjust(int A[], int i, int heap_size) {
        int l = left(i);
        int r = right(i);
        int largest;
        int temp;
        if (l < heap_size && A[l] > A[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < heap_size && A[r] > A[largest]) {
            largest = r;
        }
        if (largest != i) {
            temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            HeapAdjust(A, largest, heap_size);
        }
    }

    /*建立最大堆*/
    static void BuildHeap(int A[], int heap_size) {
        for (int i = (heap_size - 2) / 2; i >= 0; i--) {
            HeapAdjust(A, i, heap_size);
        }
    }


    /*堆排序*/
    static int[] HeapSort(int A[], int heap_size) {
        BuildHeap(A, heap_size);
        int temp;
        for (int i = heap_size - 1; i >= 0; i--) {
            temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            HeapAdjust(A, 0, i);
        }
        // print(A, heap_size);
        return A;
    }


    public static void main(String[] args) {

        System.out.println(solution("1,1,1,2,2,3 2"));


    }

}
