/**
 * 描述
 * 给出三个队列 s1，s2，s3 ，判断 s3 是否是由 s1 和 s2 交叉得来。 如：s1 为 aabcc ， s2 为 dbbca。 当 s3 为 aadbbcbcac 时，返回 true（即将 s1 拆成三部分： aa，bc，c 分别插入 s2 对应位置） 否则返回 false。
 * <p>
 * 输入
 * aabcc,dbbca,aadbbcbcac
 * <p>
 * 输出
 * true
 * <p>
 * 输入样例
 * aabcc,dbbca,aadbbcbcac
 * aabcc,dbbca,aadbbbaccc
 * a,b,ab
 * a,b,ba
 * a,b,ac
 * abc,bca,bcaabc
 * abc,bca,aabbcc
 * <p>
 * 输出样例
 * true
 * false
 * true
 * true
 * false
 * true
 * false
 */
public class N6交叉队列 {
    private static boolean solution(String line) {
        // 在此处理单行数据
        String[] array = line.split(",");
        int lengthA = array[0].length();
        int lengthB = array[1].length();
        int lengthC = array[2].length();
        if ((lengthA + lengthB) != lengthC) {
            return false;
        }
        boolean[][] reslut = new boolean[lengthA + 1][lengthB + 1];
        // reslut[i][j]表示s3[1,lengthA+lengthB]是否由s1[1,lengthA]和s2[1,lengthB]交错组成
        reslut[0][0] = true;
        for (int i = 0; i < lengthA + 1; i++) {
            for (int j = 0; j < lengthB + 1; j++) {
                if ((i - 1) >= 0 && reslut[i - 1][j] && array[0].charAt(i - 1) == array[2].charAt(i - 1 + j)) { // reslut[i-1][j]=true表示s3[1, i-1+j]由s1[1,i-1]和s2[1,j]交错组成,如果s1.charAt(i-1)与s3.charAt(i-1+j)相等，那么很显然reslut[i][j]也为true
                    reslut[i][j] = true;
                }
                if ((j - 1) >= 0 && reslut[i][j - 1] && array[1].charAt(j - 1) == array[2].charAt(i + j - 1)) { // reslut[i][j-1]=true表示s3[1, i+j-1]由s1[1,i]和s2[1,j-1]交错组成,如果s2.charAt(j-1)与s3.charAt(i+j-1)相等，那么很显然reslut[i][j]也为true
                    reslut[i][j] = true;
                } // 除以上两种情况外，result[i][j]为false
            }
        }
        return reslut[lengthA][lengthB];

    }


    public static void main(String[] args) {


        System.out.println(solution("aabcc,dbbca,aadbbcbcac"));
        //

    }
}
