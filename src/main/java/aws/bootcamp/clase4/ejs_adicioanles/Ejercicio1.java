package aws.bootcamp.clase4.ejs_adicioanles;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/*
1 - Construir un Stream de numeros naturales que contenga todos los números pares mayores o iguales a 10 y menores o iguales a 20.  Presentar en una lista de Integer en forma ordenada.
Existen varias formas de realizar esto y me gustaría ver todas las opciones que se les ocurren.
*/
public class Ejercicio1 {
    public static void main(String[] args) {
        Ejercicio1 ma = new Ejercicio1();
        Random rand = new Random();

        // Lista de números enteros aleatorios entre 10 y 20 usando Stream
        List<Integer> numbers = rand.ints(10, 21)
                .limit(11)
                .peek(ma::printNumber)
                .boxed()
                .collect(Collectors.toList());

        // Imprimir números impares usando Stream
        System.out.println("\nLista de nuemeros pares: ");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .distinct()
                .sorted()
                .forEach(ma::printNumber);
    }
    private void printNumber(int n){
        System.out.print("[" + n + "]");
    }
 }

