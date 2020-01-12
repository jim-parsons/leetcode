package other;

public class Test1 {
    public static void main(String[] args) {
        t1.start();
        t2.start();
        t3.start();
    }

    static Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("t1 ...");
        }
    }, "t1");

    static Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 ...");
        }
    }, "t1");

    static Thread t3 = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3 ...");
        }
    }, "t1");
}
