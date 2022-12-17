package hm10;

import java.util.Arrays;

public class ValueCalculator implements Runnable {

    float[] arr = new float[8];
    int arrSize = arr.length;
    int halfArr = arrSize / 2;
    int num;

    @Override
    public void run() {

        Arrays.fill(arr, 3);

        float[] a = Arrays.copyOfRange(arr, 0, halfArr);
        float[] b = Arrays.copyOfRange(arr, halfArr, arrSize);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        System.out.println("----------------------------------------");

        Runnable task1 = () ->
        {
            try {
                for (int i = 0; i < a.length; i++) {
                    float c = (float) (arr[i] * Math.sin(0.2f + i / 5) *
                            Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    Arrays.fill(a, c);
                    Thread.sleep(1);
                    System.out.println("First thread " + Arrays.toString(a));
                }
            } catch (InterruptedException e) {
            }
        };

        Runnable task2 = () ->
        {
            try {
                for (int i = 0; i < b.length; i++) {
                    float c = (float) (arr[i] * Math.sin(0.2f + i / 5) *
                            Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    Arrays.fill(b,c);
                    Thread.sleep(1);
                    System.out.println("Second thread " + Arrays.toString(b));
                }
            } catch (InterruptedException e) {
            }
        };

        new Thread(task1).start();
        new Thread(task2).start();

        int aLen = a.length;
        int bLen = b.length;
        float[] result = new float[a.length + b.length];

        System.arraycopy(a, 0, result, 0, aLen);
        System.arraycopy(b, 0, result, aLen, bLen);

        System.out.println(Arrays.toString(result));
    }
}

