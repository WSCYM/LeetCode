package writtenTest.lanhu;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int ret = 0;
        HashMap<Integer, List<Integer>> hashMap= new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        for (int i = 0;i<n;i++){
            Integer ai =sc.nextInt();
            List<Integer> list = hashMap.getOrDefault(ai, new ArrayList<>());
            list.add(i);
            hashMap.put(ai,list);
        }
        Set<Integer> set = hashMap.keySet();
        for (int num : set){
            if (hashMap.containsKey(sum-num)){
                ret+=hashMap.get(num).size()*hashMap.get(sum-num).size();
            }
        }
        System.out.println(ret/2);
    }
}
