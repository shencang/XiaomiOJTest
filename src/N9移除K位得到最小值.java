import java.util.ArrayList;
import java.util.List;

public class N9移除K位得到最小值 {
    private static String solution(String line) {

        String[] array = line.split(" ");
        String result = "";
        int k = Integer.parseInt(array[1]);
        String num = array[0];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num.length(); i++) {
            int number = Integer.parseInt(String.valueOf(num.charAt(i)));
            while (list.size() != 0 && k > 0 && (list.get(list.size() - 1) > number)) {
                list.remove(list.size() - 1);
                k--;
            }
            if (number != 0 || list.size() != 0) {
                list.add(number);
            }
        }
        while (list.size() != 0 && k > 0) {
            list.remove(list.size() - 1);
            k--;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0 && result.length() == 0) {


            } else {
                result = result + list.get(i);
            }
        }
        if (result.equals(""))
            result = String.valueOf(0);
        return result;
    }


    public static void main(String[] args) {


        System.out.println(solution("10200 1"));


    }
}
