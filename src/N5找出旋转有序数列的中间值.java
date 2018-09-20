/**
 * 描述
 * 给出一个有序数列随机旋转之后的数列，如原有序数列为：[0,1,2,4,5,6,7] ，旋转之后为[4,5,6,7,0,1,2]。 假定数列中无重复元素，且数列长度为奇数。 求出旋转数列的中间值。如数列[4,5,6,7,0,1,2]的中间值为4。
 * <p>
 * 输入
 * 4,5,6,7,0,1,2
 * <p>
 * 输出
 * 4
 * <p>
 * 输入样例
 * 1
 * 1,2,3
 * 4,5,6,7,0,1,2
 * 12,13,14,5,6,7,8,9,10
 * <p>
 * 输出样例
 * 1
 * 2
 * 4
 * 9
 */
public class N5找出旋转有序数列的中间值 {
    //运行时间打败了 100% 的 Java 玩家！堆排序666
    private static String solution(String line) {
        // 在此处理单行数据
        String[] array = line.split(",");
        int count = 0;
        int a[] = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            a[i] = Integer.parseInt(array[i]);

        }
        a = HeapSort(a, a.length);

        count = a[a.length / 2];
        String result = Integer.toString(count);
        // 返回处理后的结果
        return result;
        // 返回处理后的结果
        // return ans;
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


        System.out.println(solution("12,13,14,5,6,7,8,9,10"));
        //

    }
}
