import java.util.LinkedList;

public class OddThread implements Runnable{
    private int n;

    private LinkedList<Integer> list;

    public OddThread(int n) {
        this.n = n;
    }

    @Override
    public synchronized void run() {
        try {
            Thread.sleep(1000);
            while (Main.result.size() % 2 == 0) {
                System.out.println("odd wait");
                wait();
            }
        } catch (InterruptedException e) {
          e.getMessage();
        }
        for (int i = 1; i <= n; i+=2) {
            System.out.println("odd add");
        Main.result.add(i);
        notify();
        }
        System.out.println(Main.result);
    }
}
