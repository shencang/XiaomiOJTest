package 通过的项目;

/**
 * 描述
 * 输入一个乱序的连续数列，输出其中最长连续数列长度，要求算法复杂度为 O(n) 。
 * <p>
 * 输入
 * 54,55,300,12,56
 * <p>
 * 输出
 * 3
 * <p>
 * 输入样例
 * 100,4,200,1,3,2
 * 54,55,300,12
 * 1
 * 5,4,3,2,1
 * 1,2,3,4,5,6
 * <p>
 * 输出样例
 * 4
 * 2
 * 1
 * 5
 * 6
 */
public class N4最长连续数列 {
    public static void main(String[] args) {
        //    System.out.println("rw");

        System.out.println(solution("100,4,200,1,3,2"));
        //

    }

    private static String solution(String line) {
        // 在此处理单行数据

        String[] array = line.split(",");
        String result = "";
        int count = 0;
        int a[] = new int[array.length];
        String RETURN;
        for (int i = 0; i < array.length; i++) {

            a[i] = Integer.parseInt(array[i]);


            //int a = Integer.parseInt(array[i]);
            //count = count + a;
        }
        a = HeapSort(a, a.length);

        for (int i = 0; i < array.length - 1; i++) {
            if ((a[i] + 1) == a[i + 1]) {
                count++;
            }

        }


        result = Integer.toString(count + 1);
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

}
