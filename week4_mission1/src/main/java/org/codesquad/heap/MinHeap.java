package org.codesquad.heap;

public class MinHeap implements Heap {

    private final int[] heap = new int[100];
    private int size = 1;

    @Override
    public void insert(int number) {
        int parentIndex = this.size / 2;
        int childIndex = this.size;
        this.heap[size] = number;

        while (parentIndex != 0) {
            if (this.heap[parentIndex] > this.heap[childIndex]) {
                int temp = this.heap[parentIndex];
                this.heap[parentIndex] = this.heap[childIndex];
                this.heap[childIndex] = temp;
                childIndex /= 2;
                parentIndex /= 2;
                continue;
            }

            break;
        }

        this.size++;
    }

    @Override
    public int delete() {
        int index = 1;
        int childIndex = 1 * 2;
        int lastNumber = this.heap[1];

        this.heap[index] = this.heap[this.size - 1];
        this.heap[this.size - 1] = 0;
        this.size--;

        while (childIndex <= this.size - 1) {
            if (this.heap[childIndex + 1] == 0) {
                break;
            }

            if (this.heap[childIndex] < this.heap[childIndex + 1]) {
                int temp = this.heap[index];
                this.heap[index] = this.heap[childIndex];
                this.heap[childIndex] = temp;
                index = childIndex;
                childIndex = index * 2;
                continue;
            }

            int temp = this.heap[index];
            this.heap[index] = this.heap[childIndex + 1];
            this.heap[childIndex + 1] = temp;
            index = childIndex + 1;
            childIndex = index * 2;
        }

        return lastNumber;
    }

    @Override
    public int size() {
        return this.size -1;
    }

    @Override
    public String show() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Min Heap : ");

        for (int i = 1; i <= this.size -1 ; i++) {
            stringBuilder.append("[")
                    .append(this.heap[i])
                    .append("] ");
        }

        return stringBuilder.toString();
    }
}
