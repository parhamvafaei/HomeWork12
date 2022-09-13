package printNumbers;

public class NumberFunction {
    int count = 0;
     int number;

    public NumberFunction(int num) {
    this.number=num;
    }

    public synchronized void OddNumber() {
        while (count < number) {
            while (count % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(count+"is odd number");
            count++;
            notify();
        }
    }


    public synchronized void EvenNumber() {
        while (count < number) {
            while (count % 2 == 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(count +"is even number");
            count++;
            notify();
        }
    }
}

