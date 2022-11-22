package org.codesquad.heap;

public interface Heapify {

    void upHeapify(int size, int[] heap);

    void downHeapify(int size, int[] heap);

    default void changeValue(int parentIndex, int childIndex, int[] heap) {
        int temp = heap[parentIndex];
        heap[parentIndex] = heap[childIndex];
        heap[childIndex] = temp;
    }
}
