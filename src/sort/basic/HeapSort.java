package sort.basic;

public class HeapSort {

    public void sort(int[] nums){
        int heapSize = nums.length;
        buildMaxHeap(nums,heapSize);
        for (int i = nums.length-1;i>=0;i--){
            swap(nums,0,i);
            heapSize--;
            maxHeapify(nums,0,heapSize);
        }
    }

    public void buildMaxHeap(int[] nums,int heapSize){
        for (int i = nums.length/2;i>=0;i--){
            maxHeapify(nums,i,heapSize);
        }
    }

    public void maxHeapify(int[] a,int i,int heapSize){
        int l=2*i+1;
        int r = 2*i+2;
        int largest = i;
        if (l<heapSize && a[l]>a[largest]){
            largest = l;
        }
        if (r<heapSize && a[r]>a[largest]){
            largest = r;
        }
        if (largest!=i){
            swap(a,i,largest);
            maxHeapify(a,largest,heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
