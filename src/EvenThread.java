import java.util.LinkedList;

public class EvenThread implements Runnable {
    private int n;

     private LinkedList<Integer> list;

    public EvenThread(int n) {
        this.n = n;
    }

    @Override
    public synchronized void run() {

        try {
      Thread.sleep(1000);
            while (Main.result.size() % 2 == 1) {
                System.out.println("wait even");
                wait();
            }
        } catch (InterruptedException e) {
           e.getMessage();
        }

        for (int i = 0; i <= n; i += 2) {

            Main.result.add(i);
            System.out.println("even add");
            notify();
        }  System.out.println(Main.result);
    }
}
