package dataStructure.linkedList;

/**
 * - Linked list
 *   - 앞쪽에서 뒷쪽을 가리키는 방향성을 가진 끈으로 순서가 있는 데이터를 연결하는 방식
 *
 * - Linked list 의 요소
 *   - HEAD pointer: 첫번째 요소의 위치 정보를 저장
 *     - 첫번째 요소가 존재하지 않을 경우에는 종료 정보를 저장
 *
 *   - Data: 데이터를 저장
 *
 *   - Next pointer: 다음 요소의 위치 정보를 저장
 *     - 마지막 요소일 경우에는 종료 정보를 저장
 */

public class InseoLinkedList {

    private static int counter;
    private Node head;  // HEAD Pointer

    private static int getCounter() {
        return counter;
    }

    private static void incrementCounter() {
        counter++;
    }

    private static void decrementCounter() {
        counter--;
    }

    public void add(Object data) {
        if (head == null) {
            head = new Node(data);
        }

        Node temp = new Node(data);
        Node current = head;

        if (current != null) {
            while (current.getNext() != null) {
                current = current.getNext();
            }

            current.setNext(temp);
        }

        incrementCounter();
    }

    public void add(Object data, int index) {
        Node temp = new Node(data);
        Node current = head;

        if (current != null) {
            for (int i = 0; i < index && current.getNext() != null; i++) {
                current = current.getNext();
            }
        }

        temp.setNext(current.getNext());
        current.setNext(temp);

        incrementCounter();
    }

    public Object get(int index) {
        if (index < 0) {
            return null;
        }

        Node current = null;

        if (head != null) {
            current = head.getNext();

            for (int i = 0; i < index; i++) {
                if (current.getNext() == null) {
                    return null;
                }

                current = current.getNext();
            }

            return current.getData();
        }

        return current;
    }

    public Object remove(int index) {
        if (index < 1 || index > size()) {
            return false;
        }

        Node current = head;

        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null) {
                    return false;
                }

                current = current.getNext();
            }

            current.setNext(current.getNext().getNext());

            decrementCounter();
            return true;
        }

        return false;
    }

    public int size() {
        return getCounter();
    }

    private class Node {
        Object data;
        Node next;  // NEXT Pointer

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }
    }
}
