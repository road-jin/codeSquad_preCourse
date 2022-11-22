package org.codesquad.heap;

import java.util.Arrays;

public class Heap {

    private final Heapify heapify;
    private int[] heap = new int[1];
    private int size = 1;

    public Heap(Heapify heapify) {
        this.heapify = heapify;
    }

    public void insert(int number) {
        heapReSize(this.heap.length + 1, this.size + 1);
        insertLastArray(number);
        heapify.upHeapify(this.size, this.heap);
    }

    public int delete() {
        int lastNumber = deleteLastArray();
        heapify.downHeapify(this.size, this.heap);
        heapReSize(this.heap.length, this.size);
        return lastNumber;
    }

    public int size() {
        return this.size - 1;
    }

    public String show() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Min Heap : ");

        for (int i = 1; i < this.size; i++) {
            stringBuilder.append("[")
                    .append(this.heap[i])
                    .append("] ");
        }

        return stringBuilder.toString();
    }

    private void insertLastArray(int number) {
        this.heap[size] = number;
        this.size++;
    }

    private int deleteLastArray() {
        int lastNumber = this.heap[1];
        this.heap[1] = this.heap[this.size - 1];
        this.heap[this.size - 1] = 0;
        this.size--;
        return lastNumber;
    }

    private void heapReSize(int heapSize, int newHeapSize) {
        if (this.size < heapSize) {
            this.heap = Arrays.copyOf(this.heap, newHeapSize);
        }
    }
}