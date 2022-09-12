import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static LinkedList<Integer> result = new LinkedList<>();


    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        Thread t2 = new Thread(new EvenThread(number));
        Thread t1 = new Thread(new OddThread(number));

        t1.start();
        t2.start();




        System.out.println(result.size());

    }
}
