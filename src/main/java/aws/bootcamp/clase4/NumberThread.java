package aws.bootcamp.clase4;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/*
Clase IV - Ejercicios:

        Threads:

        1) Mostrar los numeros del 1 al 20 con un retardo de 3 segundos entre cada numero
*/
public class NumberThread implements Runnable{
    private final int maxNumber;

    public NumberThread(int maxNumber) {
        this.maxNumber = maxNumber;
    }
    @Override
    public void run() {
        int start = (maxNumber > 0)? 1 : -1;
        int end = (maxNumber > 0)? maxNumber + 1: maxNumber - 1;
        int step = (maxNumber > 0)? 1 :-1;

        for (int i = start; i != end; i += step) {
            System.out.println(i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
    public static void main(String[] args) {
        int maxNumber = -5;
        Runnable numberPrinter = new NumberThread(maxNumber);

        Thread thread = new Thread(numberPrinter);
        thread.start();
    }
    /*
    public static void main(String[] args) {
        int startNumber = -5;
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        IntStream.rangeClosed(startNumber < 0 ? startNumber : 1, startNumber > 0 ? startNumber : -1).forEach(i -> {
            executor.schedule(() -> System.out.println(i), 3 * Math.abs(i), TimeUnit.SECONDS);
        });
        executor.shutdown();
    }*/
}
