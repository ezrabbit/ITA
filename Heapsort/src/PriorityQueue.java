import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
    List<Integer> heap = new ArrayList<>();
    public void insert(Integer key){
        heap.add(Integer.MIN_VALUE);
        heapIncreaseKey(heap.size()-1, key);
    }

    public Integer maximum(){
        return heap.get(0);
    }

    public Integer extractMax(){
        if(heap.size() < 1) throw new RuntimeException("heap underflow");
        Integer max = heap.get(0);
        heap.set(0, heap.remove(heap.size()-1));
        maxHeapify(heap, 0);
        return max;
    }

    private void maxHeapify(List<Integer> heap, int i) {
        int left = (i+1)*2-1, right = (i+1)*2+1-1;
        int greatest = i;
        if(left<heap.size())
            greatest = heap.get(left) > heap.get(greatest) ? left : greatest;
        if(right<heap.size())
            greatest = heap.get(right) > heap.get(greatest) ? right : greatest;
        if(greatest!=i){
            swap(i, greatest);
            maxHeapify(heap, greatest);
        }
    }

    public void heapIncreaseKey(int index, Integer key){
        if(index >= heap.size())    throw new RuntimeException("index overflow");
        if(key < heap.get(index))   throw new RuntimeException("new key is smaller than current key");
        heap.set(index, key);
        while(index>0 && heap.get((index+1)/2-1)<heap.get(index)){
            swap(index, (index+1)/2-1);
            index = (index+1)/2-1;
        }
    }

    private void swap(int i, int j) {
        int tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

}
