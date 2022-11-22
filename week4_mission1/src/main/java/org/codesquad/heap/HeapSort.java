package org.codesquad.heap;

public class HeapSort {

    private final Heap heap;

    public HeapSort() {
        this.heap = new Heap(new MinHeapify());
        //this.heap = new Heap(new MaxHeapify());
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
