package aws.bootcamp.clase3.ejercicio2;
/*
Clase III - Ejercicios:
2 - Implementar la clase Fila (Utilizando una Collection que no implemente la interfaz Queue / Deque)

3 - Implementar las clases Pila y Fila sin utilizar Collections

4 - Implementar la clase Arbol Binario con los 3 recorridos básicos (inOrden, preOrden y postOrden)

5 - Recursion: Método factorial recursivo

6 - Recursion: Calcular el producto de dos enteros sin utilizar multiplicación

8 - NO OBLIGATORIO (Es para pensar): Metodo que devuelva un boolean indicando si esta formado por la suma de numeros consecutivos menores.
    Ej:
       firma --> boolean esSumatoriaDeConsecutivos(int value);

       esSumatoriaDeConsecutivos(3) = TRUE pq 3 = 2 + 1
       esSumatoriaDeConsecutivos(9) = TRUE pq 9 = 4 + 3 + 2

    Se puede implementar recursivo e iterativo.  Deseable contar con metodo que devuelva la lista de numeros que representan la suma.  Comparar performance de ambas implementaciones y sacar conclusiones.
 */
//TODO Sin terminar estoy haciendo pruebas: : Seguir investigando, todavia no lo entiendo
public class Main implements Runnable{
    String mensaje;
    Main(String mensaje) {
        this.mensaje = mensaje;
    }
    public void run() {
        try {
            for(int i=0; i<100; i++) {
            System.out.println(i +" "+ mensaje);
            Thread.sleep(1000);
            }
        }catch (InterruptedException ignorar) {

        }
    }
}
class TareaTontaMain {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Main("Soy A"));
        Thread t2 = new Thread(new Main("Soy B"));
        Thread t3 = new Thread(new Main("Soy C"));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Fin");
    }
}