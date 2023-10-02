package aws.bootcamp.clase3.ejercicio7;

import java.util.function.Function;

/*
Clase III - Ejercicios:
7 - Recursión: Método que recibe un String y lo devuelve invertido.
*/
public class InvertString {
    Function<String, String> reverse;
    private String reverseText(String str) {
        reverse = s -> s.isEmpty() ? s : reverse.apply(s.substring(1)) + s.charAt(0);
        return reverse.apply(str);
    }
    /*private String ReverseText(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return ReverseText(str.substring(1)) + str.charAt(0);
    }*/
        public static void main(String[] args) {
        InvertString m = new InvertString();
            System.out.println(m.reverseText("Bootcamp"));
            System.out.println(m.reverseText("Java"));
            System.out.println(m.reverseText("Vicente"));
        }
}