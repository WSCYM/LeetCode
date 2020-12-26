package sort;

import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] arr,int l,int r){
        if (l+1>r){
            return;
        }
        int first = l;int last = r;int key = arr[first];
        while (first<last){
            while (first<last && arr[last]>=key){
                last--;
            }
            arr[first] = arr[last];
            while (first<last && arr[first]<=key){
                first++;
            }
            arr[last] = arr[first];
        }
        arr[first] = key;
        quickSort(arr,l,first-1);
        quickSort(arr,first+1,r);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,0};
        new QuickSort().quickSort(arr,0,1);
        for (int i : arr){
            System.out.println(i);
        }
    }
}
