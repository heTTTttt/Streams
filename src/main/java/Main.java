import hm10.ValueCalculator;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        ValueCalculator valueCalculator = new ValueCalculator();
        Thread thread = new Thread(valueCalculator);

        valueCalculator.run();
    }
}
