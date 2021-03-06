package 通过的项目;

import java.util.Scanner;
import java.util.Stack;
public class N16四则运算 {
    //新设备测试
    /**
     * 实现一个算法，可以进行任意非负整数的加减乘除组合四则运算。
     * 请注意运算符的优先级。
     * 输入
     *
     * 请输入一行算式，使用空格分隔数字与运算符。
     * 数字为任意非负整数，运算符为+ - * /，不考虑括号。
     *
     * 输出
     *
     * 输出算式的运算结果。如果是小数，请向下取整（包含中间步骤结果）。 如果出现“除0异常”，输出err。
     *
     * 输入样例
     * 3 + 5
     * 12 + 45 / 9
     * 1 / 2
     * 1 / 0
     * 12 + 34 * 56 - 78
     * V
     * 输出样例
     * 8
     * 17
     * 0
     * err
     * 1838
     *  复制样例
     * 小提示
     * 可以使用栈来解决此类问题。
     */
        private static String solution(String line,String S) {
            // 在此处理单行数据
            String[] array = line.split(" ");
            System.out.println(array.length);


            return "1";
        }


    public static String  solution(String line)
    {
        Stack<String> stack = new Stack<String>();
        String []array = line.split(" ");
        for(int i = 0;i<array.length;i++)
        {
            if(array[i].equals("/"))
            {
                if(array[i+1].equals("0"))
                    return "err";
                stack.add(String.valueOf(Integer.parseInt(stack.pop())/Integer.parseInt(array[++i])));
            }
            else if(array[i].equals("*"))
                stack.add(String.valueOf(Integer.parseInt(stack.pop())*Integer.parseInt(array[++i])));

            else
                stack.add(array[i]);
        }
        int[] a1 = new int[(stack.size()+1)/2];
        int flag =0;
        int temp=0;
        int sum=0;
        int m =stack.size();
        for(int i = 0;i<m;i++)
        {
            if(flag==0)
            {a1[temp++] = Integer.parseInt(stack.pop());
                flag =1;}
            else
            {
                if(stack.pop().equals("+"))
                {sum+=a1[temp-1];
                    flag =0;}
                else
                {sum-=a1[temp-1];
                    flag =0;
                }

            }
        }
        sum+=a1[a1.length-1];


        return String.valueOf(sum);
    }



    public static void main(String args[]) {
            Scanner scan = new Scanner(System.in);
            String line;
            while (scan.hasNextLine()) {
                line = scan.nextLine().trim();
                // please write your code here
                System.out.println(solution(line));
                System.out.println("No16");
                // System.out.println("answer");
            }

        }
    }


