package aws.bootcamp.clase3.ejercicio6;
/*
Clase III - Ejercicios:
6 - Recursion: Calcular el producto de dos enteros sin utilizar multiplicación
*/
public class RecursiveMultiplication {
    private long producto(long a, long b) {
        //ver como funciona la recursion
        System.out.println(a + " " + b);
        if (a == 0 || b == 0) {
            return 0;
        }
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            return -producto(Math.abs(a), Math.abs(b));
        } else {
            return a + producto(a, b - 1);
        }
    }

    public static void main(String[] args) {
        int a =10000;
        int b =-10000;

        System.out.println("El producto de " + a + " y " + b + " es: " + new RecursiveMultiplication().producto(a,b));
    }
}
