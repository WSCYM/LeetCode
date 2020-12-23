import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ba");
        list.add("ab");
        list.add("b");
        list.add("a");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()!=o2.length()){
                    return o1.length()-o2.length();
                } else {
                    return o2.compareTo(o1);
                }
            }
        });
        for (String s : list){
            System.out.println(s);
        }
    }
}
