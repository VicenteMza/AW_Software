package aws.bootcamp;

import javax.swing.*;

//3 - Metodo que recibe un entero en formato decimal y devuelve un double en formato binario
public class DecimalToBinary {
    public static double decimalToBinary(int decimal) {
        // Valida la entrada decimal.
        if (decimal < 0) {
            throw new IllegalArgumentException("El valor decimal debe ser no negativo.");
        }

        // Inicializa el valor binario convertido.
        StringBuilder binary = new StringBuilder();

        // Itera sobre el valor decimal.
        for (int i = 31; i >= 0; i--) {

            // Obtiene el bit actual.
            int bit = (decimal & (1 << i)) != 0 ? 1 : 0;

            // Agrega el bit actual al valor binario convertido.
            binary.append(bit);
        }

        // Devuelve el valor binario convertido.
        return Double.parseDouble(binary.toString());
    }
    public static void main(String[] args) {
        try {
            String input = JOptionPane.showInputDialog("Ingrese un numero entero:");
            int num = Integer.parseInt(input);

            double num1 = decimalToBinary(num);

            JOptionPane.showMessageDialog(null, "El binario double de: " + num + " es " + num1);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Se debe ingresar una numero entero");
            System.out.println(e);
        }
    }
}