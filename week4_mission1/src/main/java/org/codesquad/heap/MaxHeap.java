package org.codesquad.heap;

import java.util.Arrays;

public class MaxHeap implements Heap{

    private int[] heap = new int[1];
    private int size = 1;

    @Override
    public void insert(int number) {
        heapReSize(this.heap.length + 1, this.size + 1);

        this.heap[this.size] = number;
        this.size++;

        upHeapify();
    }

    @Override
    public int delete() {
        int lastNumber = this.heap[1];

        this.heap[1] = this.heap[this.size - 1];
        this.heap[this.size - 1] = 0;
        this.size--;

        downHeapify();
        heapReSize(this.heap.length, this.size);
        return lastNumber;
    }

    @Override
    public int size() {
        return this.size - 1;
    }

    @Override
    public String show() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Max Heap : ");

        for (int i = 1; i <= this.size - 1; i++) {
            stringBuilder.append("[")
                    .append(this.heap[i])
                    .append("] ");
        }

        return stringBuilder.toString();
    }

    private void heapReSize(int heapSize, int newHeapSize) {
        if (this.size < heapSize) {
            this.heap = Arrays.copyOf(this.heap, newHeapSize);
        }
    }

    private void upHeapify() {
        int childIndex = this.size - 1;
        int parentIndex = childIndex / 2;

        while (parentIndex != 0) {
            if (this.heap[parentIndex] < this.heap[childIndex]) {
                changeValue(parentIndex, childIndex);
                childIndex /= 2;
                parentIndex /= 2;
                continue;
            }

            break;
        }
    }

    private void downHeapify() {
        int parentIndex = 1;
        int childIndex = parentIndex * 2;

        while (childIndex <= this.size - 1) {
            if (childIndex + 1 < this.size &&
                    this.heap[childIndex] < this.heap[childIndex + 1]) {
                childIndex = parentIndex * 2 + 1;
            }

            if (this.heap[parentIndex] > this.heap[childIndex]) {
                break;
            }

            changeValue(parentIndex, childIndex);
            parentIndex = childIndex;
            childIndex = parentIndex * 2;
        }
    }

    private void changeValue(int parentIndex, int childIndex) {
        int temp = this.heap[parentIndex];
        this.heap[parentIndex] = this.heap[childIndex];
        this.heap[childIndex] = temp;
    }
}
