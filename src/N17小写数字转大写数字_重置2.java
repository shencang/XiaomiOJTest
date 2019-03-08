import java.util.Scanner;

public class N17小写数字转大写数字_重置2 {



    public static void main(String []args) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            System.out.println(solution(line));

            System.out.println("测试：");
            // System.out.println("answer");
        }
    }
        private static String[] cstr = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
        private static String[] wstr = { "", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰","千" };

        private static String solution(String line) {

            char a[] = new char[line.length()];
            a = line.toCharArray();
            String str = "";
            for (int i = 0; i <a.length; i++)
            {
                str+=cstr[(int)(a[i]-'0')];
                str+=wstr[a.length-i-1];

            }
            str+="元整";

            //System.out.println(str);
            str=str.replaceAll("拾零","拾");
            str=str.replaceAll("零拾","零");
            str=str.replaceAll("零佰","零");
            str=str.replaceAll("零仟","零");
            str=str.replaceAll("零万","万");
            for(int i = 0;i<6;i++)

                str = str.replaceAll("零零", "零");
            str = str.replaceAll("零万", "万");
            str=str.replaceAll("零亿","亿");
            str=str.replaceAll("零零","零");
            str=str.replaceAll("零元","元");


            return str;
        }

    }

