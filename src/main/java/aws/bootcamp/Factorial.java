package aws.bootcamp;

import javax.swing.*;
//2. Metodo que recibe un entero y devuelve el factorial del mismo (¿lo podemos hacer también con tipos genéricos?)
public class Factorial {
    /*
    public static int factorial(int n) {
        return IntStream.iterate(1, i -> i * i).limit(n).reduce(1, (a, b) -> a * b);
    }
    */
    /*
    public static int calcularFactorial(int n) {
        return IntStream.rangeClosed(1, n)
            .reduce(1, (x, y) -> x * y);
    }
     */
    //No recursivo
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }

        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        try {
            String input = JOptionPane.showInputDialog("Ingrese un número para calcular su factorial:");
            int number = Integer.parseInt(input);

            double factorial = factorial(number);

            JOptionPane.showMessageDialog(null, "El factorial de " + number + " es " + factorial);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada no válida. Por favor, ingrese un número válido.");
        }
    }

    //Recursivo
    /*public int fact(int i){
       if (i < 0) throw new RuntimeException("No existe");
       if (i == 1 || i == 0) {
           return 1;
       }

       return i * fact(--i);
    }
    public void prueba(){
        System.out.println(fact(10));
    }
    public static void main(String[] arg){
        new Factorial().prueba();
    }
     */
}