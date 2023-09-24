package aws.bootcamp.clase1;

import javax.swing.*;

public class IsCapicua {
//1 - Número entero capicua.
//	Construir un metodo que reciba un entero como parámetro y devuelva boolean indicando si es capicúa o no dicho número.
//	(Version No Recursiva y Recursiva)
    public static void main(String[] args) {
        try {
        String in = JOptionPane.showInputDialog("Ingrese un número:");
        if (in == null) return;
        int num = Integer.parseInt(in);

            boolean isCapicua = isCapicua(num);
            if (isCapicua) {
                JOptionPane.showMessageDialog(null, num + " es un número capicúa.");
            } else {
                JOptionPane.showMessageDialog(null, num + " no es un número capicúa.");
            }
        }catch (NumberFormatException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Ingreso no valida");
        }
    }
    //Usando String
  /* public static boolean isCapicua(int numero) {
        String numeroStr = Integer.toString(numero);
        String numeroReversoStr = new StringBuilder(numeroStr).reverse().toString();
        return numeroStr.equals(numeroReversoStr);
    }*/
    public static boolean isCapicua(int num){
        int reverseNumber = 0;
        int original = num;

        while (num > 0 ){
            int digito = num %10;
            reverseNumber = reverseNumber * 10 +digito;
            num /= 10;
        }
        return original == reverseNumber;
    }
}