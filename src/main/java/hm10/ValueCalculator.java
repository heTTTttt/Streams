package hm10;

import java.util.Arrays;

public class ValueCalculator {

    float[] arr = new float[1_000_000];
    int arrSize = arr.length;
    int halfArr = arrSize / 2;
    int num;

    public void run() throws InterruptedException {

        Arrays.fill(arr, 3);

        float[] a = Arrays.copyOfRange(arr, 0, halfArr);
        float[] b = Arrays.copyOfRange(arr, halfArr, arrSize);  // Arrays.copyOfRange допомогає розбити масив arr навпіл.

//        System.out.println(Arrays.toString(arr));  ці рядки для ночності
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));

        System.out.println("----------------------------------------");


        Runnable task1 = () -> {
            for (int i = 0; i < a.length; i++) {
                float c = calculateNewNumber(a[i], i);
                a[i] = c;
                System.out.println("First thread " + a[i]);
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < b.length; i++) {
                float c = calculateNewNumber(b[i], i);
                b[i] = c;
                System.out.println("Second thread " + b[i]); // task1 і task2 містить умови за якими потоки має робити
                // свою задачу
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2); // створення 2х потоків.


        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join(); // рядки 47-50 відовідають за запуск потоків

        int aLen = a.length;
        int bLen = b.length;
        float[] result = new float[a.length + b.length];

        System.arraycopy(a, 0, result, 0, aLen);
        System.arraycopy(b, 0, result, aLen, bLen);

        //System.out.println(Arrays.toString(result));  цей рядок для нагочності того, що з'єднання масисвів було вдале.
    }

    public float calculateNewNumber(float num, int i) {

        return (float) (num * Math.sin(0.2f + i / 5) *
                Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }
}

