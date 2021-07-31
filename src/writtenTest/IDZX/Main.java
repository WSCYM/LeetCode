package writtenTest.IDZX;

public class Main {
    public int[] max_version (String[][] version_list) {
        int[] ret = new int[version_list.length];
        int idx =0;
        for (String[] strings : version_list){
            if (strings[0].compareTo(strings[1])>=0){
                ret[idx++] = 1;
            } else {
                ret[idx++] = 2;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] rets = new Main().max_version(
                new String[][]{{"0.1.0", "1.0"}, {"2.1.13", "1.20.0"}, {"2.1.0", "2.1.0"}}
        );
        for (int i:rets){
            System.out.println(i);
        }
    }
}
