package dataStructure.ringBuffer;

public class App {
    public static void main(String[] args) {

        InseoRingBuffer ringBuffer = new InseoRingBuffer(5);

        ringBuffer.append("inseo");
        ringBuffer.append("taku");
        ringBuffer.append("nomura");
        ringBuffer.append("shohei");
        ringBuffer.append("oshikiri");

        System.out.println(ringBuffer.list());
        System.out.println(ringBuffer.toString());

        ringBuffer.append("lucy");

        System.out.println(ringBuffer.list());
        System.out.println(ringBuffer.toString());

        ringBuffer.append("hukuhara");

        System.out.println(ringBuffer.list());
        System.out.println(ringBuffer.toString());

        ringBuffer.remove();

        System.out.println(ringBuffer.list());
        System.out.println(ringBuffer.toString());

        ringBuffer.append("hara");

        System.out.println(ringBuffer.list());
        System.out.println(ringBuffer.toString());
    }
}
