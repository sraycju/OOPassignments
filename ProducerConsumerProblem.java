
import java.util.*;

class Consumer extends Thread {

    private Producer producer;

    public Consumer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                //System.out.println("Consumer consumed an: " + data);
                String data = producer.consume();
                System.out.println("Consumer consumed an: " + data);
                Thread.sleep(500);
            }
        } catch (Exception exp) {
        }
    }
}
class Producer extends Thread {

    private static final int MAX_SIZE = 3;
    private final ArrayList<String> Items = new ArrayList<>();

    @Override
    public void run() {
        try {
            while (true) {
                produce();
            }
        } catch (Exception exp) {
        }
    }

    private synchronized void produce() throws Exception {
        while (Items.size() == MAX_SIZE) {
            System.out.println("Buffer limit reached. Waiting for consumer");
            wait();
            System.out.println("Producer got notification from consumer");
        }
        String data = "Item";
        Items.add(data);
        System.out.println("Producer produced an "+data);
        notify();
    }

    public synchronized String consume() throws Exception {
        //notify();
        while (Items.isEmpty()) {
            wait();
        }
        String data = Items.get(0);
        Items.remove(data);
        notify();
        return data;
    }
}
public class ProducerConsumerProblem {

    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.setName("Producer->");
        producer.start();

        Consumer consumer = new Consumer(producer);
        consumer.setName("Consumer->");
        consumer.start();
    }
}
/*Output
Producer produced an Item
Producer produced an Item
Producer produced an Item
Buffer limit reached. Waiting for consumer
Producer got notification from consumer
Producer produced an Item
Buffer limit reached. Waiting for consumer
Consumer consumed an: Item
Consumer consumed an: Item
Producer got notification from consumer
Producer produced an Item
Buffer limit reached. Waiting for consumer
Producer got notification from consumer
Consumer consumed an: Item
Producer produced an Item
Buffer limit reached. Waiting for consumer
Consumer consumed an: Item
Producer got notification from consumer
Producer produced an Item......(infinite loop) */