package org.codesquad.heap;

public class HeapSort {

    private final Heap heap;

    public HeapSort() {
        this.heap = new MinHeap();
        //this.heap = new MaxHeap();
    }

    public void insertHeap(int number) {
        this.heap.insert(number);
    }

    public void printHeap() {
        System.out.println(this.heap.show());
    }

    public int getHeapSize() {
        return this.heap.size();
    }

    public int deleteHeap() {
        return this.heap.delete();
    }
}
