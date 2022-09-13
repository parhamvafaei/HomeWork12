package printNumbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int inputNumber= scanner.nextInt();

        NumberFunction numberFunction=new NumberFunction(inputNumber);
        Thread t1= new Thread(numberFunction::EvenNumber);
        Thread t2= new Thread(numberFunction::OddNumber);

        t1.start();
        t2.start();
    }
    }

