 import  java.util.*;

public class N17小写数字转大写数字 {
    /**
     * 序号：#17
     * 难度：有挑战
     * 时间限制：1000ms
     * 内存限制：10M
     * 描述
     * 实现一个算法，可以将小写数字转换成大写数字。
     * 输入
     *
     * 输入一个整数。范围在0～450亿之间。
     *
     * 输出
     *
     * 输出对应的大写数字，以“元整”结尾。 大写数字要符合汉语读写习惯。
     *
     * 输入样例
     * 0
     * 5
     * 233
     * 1001
     * 40607
     * 8900000000
     *
     * 输出样例
     * 零元整
     * 伍元整
     * 贰佰叁拾叁元整
     * 壹仟零壹元整
     * 肆万零陆佰零柒元整
     * 捌拾玖亿元整
     */
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            System.out.println(solution(line));

            // System.out.println("answer");
        }
    }

    private static String solution(String line) {
        // 在此处理单行数据
        boolean flagBY=true;
        boolean flagSY=true;
        boolean flagY=true;
        boolean flagKW=true;
        boolean flagBW=true;
        boolean flagSW=true;
        boolean flagW=true;
        boolean flagK=true;
        boolean flagB=true;
        boolean flagS=true;
        List<String>listCh= new ArrayList<String>();
        char []count = line.toCharArray();
        for (int i =0;i<count.length;i++){

            switch (count[i]){
                case '1':listCh.add("壹");break;
                case '2':listCh.add("贰");break;
                case '3':listCh.add("叁");break;
                case '4':listCh.add("肆");break;
                case '5':listCh.add("伍");break;
                case '6':listCh.add("陆");break;
                case '7':listCh.add("柒");break;
                case '8':listCh.add("捌");break;
                case '9':listCh.add("玖");break;
                case '0':
                    if (i<count.length-1&&count[i+1]=='0'){
                        break;
                    }
                    if (i==count.length-1&&count[i]=='0'){
                        break;
                    }
                    listCh.add("零");break;

            }
            if (count.length>10&&flagBY==true){
                listCh.add("百");
                flagBY=false;
                continue;
            }
            if (count.length>9&&flagSY==true){
                listCh.add("拾");
                flagSY=false;
                continue;
            }
            if (count.length>8&&flagY==true){
                listCh.add("亿");
                flagY=false;
                continue;
            }
            if (count.length>7&&flagKW==true){
                listCh.add("仟");
                flagKW=false;
                continue;
            }
            if (count.length>6&&flagBW==true){
                listCh.add("百");
                flagBW=false;
                continue;
            }
            if (count.length>5&&flagSW==true){
                listCh.add("拾");
                flagSW=false;
                continue;
            }
            if (count.length>4&&flagW==true){
                listCh.add("万");
                flagW=false;
                continue;
            }
            if (count.length>3&&flagK==true){
                listCh.add("仟");
                flagK=false;
                continue;
            }
            if (count.length>2&&flagB==true){
                listCh.add("百");
                flagB=false;
                continue;
            }
            if (count.length>1&&flagS==true){
                listCh.add("拾");
                flagS=false;
                continue;
            }

        }
        return result(listCh);
    }
    public static  String result(List<String> S){
        String s="";
        for (String c:S){
            s=s+c;
        }
        return s+"元整";
    }

}
