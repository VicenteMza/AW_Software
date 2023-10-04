package aws.bootcamp.clase3.ejercicio1;

/*
Clase III - Ejercicios:
1 - Implementar la clase Pila (Utilizando una Collection que no implemente la interfaz Queue / Deque )
 */
//TODO revisar, casi terminado: Seguir investigando, todavia no lo entiendo
public class Main {
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();

        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);

        System.out.println("Pila: " + pila);

        System.out.println("Cima de la pila: " + pila.cima());

        int elementoDesapilado = pila.desapilar();
        System.out.println("Elemento desapilado: " + elementoDesapilado);
        System.out.println("Pila después de desapilar: " + pila);
    }
}
