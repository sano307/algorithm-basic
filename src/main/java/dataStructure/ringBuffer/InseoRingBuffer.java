package dataStructure.ringBuffer;

import java.util.Arrays;

public class InseoRingBuffer {

    private String[] buffer;
    private int counter, head, tail;
    private boolean isFull;

    public InseoRingBuffer(int counter) {
        this.buffer = new String[counter];
        this.counter = counter;
        this.head = this.tail = 0;
        this.isFull = false;
    }

    public void append(String s) {
        // 할당되어 있는 버퍼의 크기에 문자열이 다 들어있는 경우
        if (this.isFull) {
            // 현재 머리 부분의 값을 제거
            // 머리 부분 다음의 값이 머리의 값으로 변경
            this.head = (this.head + 1) % this.counter;
        }

        // 꼬리 부분에 새로운 문자열을 추가
        this.buffer[this.tail] = s;

        // 꼬리 부분을 머리 부분의 인덱스와 일치시켜준다.
        this.tail = (this.tail + 1) % this.counter;

        // 버퍼의 크기가 0인 경우
        if (this.tail == this.head) {
            // 가득차 있는 상태로 표현
            this.isFull = true;
        }
    }

    public boolean isEmpty() {
        return !this.isFull && (this.head == this.tail);
    }

    public void remove() {
        if (!this.isEmpty()) {
            this.head = (this.head + 1) % this.counter;
            this.isFull = false;
        }
    }

    public String list() {
        StringBuilder sb = new StringBuilder();

        int numElements =
                (this.isFull) ? this.counter :
                        ((this.head > this.tail) ? (this.tail + this.counter) - this.head : this.tail - this.head);

        for (int i = 0; i < numElements; i++) {
            sb.append(this.buffer[(this.head + i) % this.counter] + "\n");
        }

        return sb.toString();
    }

    public String toString() {
        return "Buffer: " + Arrays.toString(this.buffer) + '\n' +
                "Counter: " + this.counter + ", Head index: " + this.head + ", Tail index: " + this.tail + '\n' +
                ((this.isFull) ? "Buffer is full" : "Buffer is not full");
    }
}
