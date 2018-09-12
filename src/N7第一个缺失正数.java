public class N7第一个缺失正数 {

    private static String solution(String line) {

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
            if (((a[i] + 1) == a[i + 1]) && (a[a.length - 1] - 1 == a[a.length - 2]) && a[a.length - 1] >= 0) {
                result = Integer.toString(a[a.length - 1] + 1);

                break;

            } else if (a[a.length - 1] <= 0) {
                result = Integer.toString(1);

                break;

            } else if (a[i] + 1 != 0) {
                result = Integer.toString(a[i] + 1);

                break;


            }

        }


        //result = Integer.toString(count + 1);
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


        System.out.println(solution("-1,-10,0"));


    }
}
