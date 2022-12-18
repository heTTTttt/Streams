import hm10.ValueCalculator;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis(); // час запуску програми.

        ValueCalculator valueCalculator = new ValueCalculator();

        valueCalculator.run();
        long end = System.currentTimeMillis(); // час завершення програми.
        System.out.println(end - start); // скільки взагалі часу було витрачено на виконання програми.

    }
}
