package dataStructure.linkedList;

public class App {

    public static InseoLinkedList linkedList;

    public static void main(String[] args) {

        linkedList = new InseoLinkedList();

        linkedList.add("inseo");
        linkedList.add("taku");
        linkedList.add("nomura");
        linkedList.add("shohei");
        linkedList.add("oshikiri");

        System.out.println("Size: " + linkedList.size());
        System.out.println("Call the third node: " + linkedList.get(3));
        System.out.println("Remove the third node: " + linkedList.remove(3));
        System.out.println("Call the third node: " + linkedList.get(3));
        System.out.println("Size: " + linkedList.size());

        System.out.println("Add element");
        linkedList.add("Lucy", 3);

        System.out.println("Call the third node: " + linkedList.get(3));
        System.out.println("Size: " + linkedList.size());
    }
}
