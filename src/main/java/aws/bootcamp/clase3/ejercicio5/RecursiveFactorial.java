package aws.bootcamp.clase3.ejercicio5;
/*
Clase III - Ejercicios:
5 - Recursion: Método factorial recursivo
 */
public class RecursiveFactorial {
    public static void main(String[] args) {
        int n = 0;
        System.out.println("El factorial de " + n + " es " + new RecursiveFactorial().factorial(n));
    }

    private long factorial(int n) {
        /*if (n < 0) {
            throw new IllegalArgumentException("El número debe ser mayor o igual a 0");
        }
        if (n < 0) {
            return factorial(Math.abs(n));
        }
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return n * factorial(--n);
        }
        */
        return (n == 0 || n == 1) ? 1 : Math.abs(n) * factorial(Math.abs(n) - 1);
    }
}