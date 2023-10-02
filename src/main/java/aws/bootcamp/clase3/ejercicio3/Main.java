package aws.bootcamp.clase3.ejercicio3;
/*
Clase III - Ejercicios:
3 - Implementar las clases Pila y Fila sin utilizar Collections
*/
public class Main {
    //TODO terminar de implementar este ejercicio
    public static void main(String[] args) {
        // Prueba de Pila de enteros
        Pila<Integer> pilaDeEnteros = new Pila<>(Integer.class);
        pilaDeEnteros.push(1);
        pilaDeEnteros.push(2);

        System.out.println("Pila de enteros:");
        while (!pilaDeEnteros.isEmpty()) {
            System.out.println("Pop: " + pilaDeEnteros.pop());
        }

        // Prueba de Fila de cadenas
        Fila<String> filaDeCadenas = new Fila<>(String.class);
        filaDeCadenas.push("Hola");
        filaDeCadenas.push("Mundo");

        System.out.println("\nFila de cadenas:");
        while (!filaDeCadenas.isEmpty()) {
            System.out.println("Pop: " + filaDeCadenas.pop());
        }
    }
}