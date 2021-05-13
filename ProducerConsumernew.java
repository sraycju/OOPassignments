class Store{
    int item=1;
    boolean empty=true;
    synchronized int get() throws InterruptedException{
        int k;
        while(empty){
                wait();
        }
        k=item;
        empty=true;
        notifyAll();
        return k;
    }
    synchronized void set(int x) throws InterruptedException{
        while(!empty){
                wait();
        }
        item=x;
        empty=false;
        notifyAll();
    }
}

class ProducerD implements Runnable{
    Store s;
    ProducerD(Store st){
        s=st;
    }
    public void run(){
        try{
        int i=1;
        while(true){
            s.set(i);
            i++;
        }
    }
    catch(InterruptedException e){
        System.err.print(e.getMessage());
    }
    }
}

class ConsumerD implements Runnable{
    Store s;
    ConsumerD(Store st){s=st;}
    public void run(){
        while(true){
            try{
                System.out.println(s.get());
            }
            catch(InterruptedException e){
                System.err.print(e.getMessage());
            }
        }
    }
}

public class ProducerConsumernew {
 public static void main(String[] args) {
     Store s=new Store();
     ProducerD p=new ProducerD(s);
     ConsumerD c=new ConsumerD(s);
     Thread pt=new Thread(p);
     Thread ct=new Thread(c);
     pt.start();
     ct.start();
     
 }   
}
