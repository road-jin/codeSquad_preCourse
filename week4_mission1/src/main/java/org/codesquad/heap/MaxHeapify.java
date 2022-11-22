package org.codesquad.heap;

public class MaxHeapify implements Heapify {

    @Override
    public void upHeapify(int size, int[] heap) {
        int childIndex = size - 1;
        int parentIndex = childIndex / 2;

        while (parentIndex != 0 && heap[parentIndex] < heap[childIndex]) {
            changeValue(parentIndex, childIndex, heap);
            childIndex /= 2;
            parentIndex /= 2;
        }
    }

    @Override
    public void downHeapify(int size, int[] heap) {
        int parentIndex = 1;
        int childIndex = parentIndex * 2;

        while (childIndex < size) {
            if (childIndex + 1 < size && heap[childIndex] < heap[childIndex + 1]) {
                childIndex = parentIndex * 2 + 1;
            }

            if (heap[parentIndex] > heap[childIndex]) {
                break;
            }

            changeValue(parentIndex, childIndex, heap);
            parentIndex = childIndex;
            childIndex = parentIndex * 2;
        }
    }
}
