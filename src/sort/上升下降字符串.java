package sort;

public class 上升下降字符串 {
    public String sortString(String s) {
        char[] chars = s.toCharArray();
        int[] bucket = new int[26];
        for (char c : chars){
            bucket[c-'a']+=1;
        }
        char[] res = new char[chars.length];
        int idx = 0;
        int j = 0;
        while (idx<res.length){
            while (j<bucket.length){
                if (bucket[j]>0){
                    bucket[j]--;
                    res[idx++] = (char) (j+'a');
                }
                j++;
            }
            j--;
            while (j>=0){
                if (bucket[j]>0){
                    bucket[j]--;
                    res[idx++] = (char) (j+'a');
                }
                j--;
            }
            j++;
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println(new 上升下降字符串().sortString("aaaabbbbcccc"));
    }
}
