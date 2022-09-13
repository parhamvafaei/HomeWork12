package deadlock;

public class DeadLockTest {
    public static void main(String[] args) {
        String string1="string1";
        String string2="string2";
        String string3="string3";
        Thread t1= new Thread(() -> {
            synchronized (string1){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread1 on string1");

                synchronized (string2){
                    System.out.println("Thread1 on string2");
                }
            }
        });

        Thread t2= new Thread(() -> {
            synchronized (string2){
                System.out.println("Thread2 on string2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (string3){
                    System.out.println("Thread2 on string3");
                }
            }
        });

        Thread t3= new Thread(() -> {
            synchronized (string3){
                System.out.println("Thread3 on string3");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (string1){
                    System.out.println("Thread3 on string1");
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
