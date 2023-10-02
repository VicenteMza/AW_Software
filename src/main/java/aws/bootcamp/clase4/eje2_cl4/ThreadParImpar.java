package aws.bootcamp.clase4.eje2_cl4;
/*
2) Generar un Thread o una Implementacion de Runnable que imprima numeros pares (1 al 10) y calcule la suma.
  Lanzar junto a otro Thread o Runnable que imprima impares (1 al 10) y calcula la suma.
    Cada Thread muestra la suma resultante cuando finaliza.
      Utilizar las pausas necesarias para que se observe el paralelismo.


*/
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class NumbersRunnable implements Runnable {
    private List<Integer> numbers;
    private Predicate<Integer> predicate;
    private String type;

    public NumbersRunnable(List<Integer> numbers, Predicate<Integer> predicate, String type) {
        this.numbers = numbers;
        this.predicate = predicate;
        this.type= type;
    }
    private void printAndPause(int i) {
        System.out.println("Número " + type + ": " + i);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {

        int sum = numbers.stream()
                .filter(predicate)
                .peek(this::printAndPause)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("La suma de los numeros " + type +" es: " + sum);
        }
}
public class ThreadParImpar {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Thread threadPares = new Thread(new NumbersRunnable(numbers, i -> i % 2 == 0, "Par"));
        Thread threadImpares = new Thread(new NumbersRunnable(numbers, i -> i % 2 != 0, "Impar"));

        threadPares.start();
        threadImpares.start();
    }
}