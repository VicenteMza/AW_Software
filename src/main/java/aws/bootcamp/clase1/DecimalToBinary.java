package aws.bootcamp.clase1;

import javax.swing.*;

//3 - Metodo que recibe un entero en formato decimal y devuelve un double en formato binario
public class DecimalToBinary {
    public static double decimalToBinary(int decimal) {
        // Valida la entrada decimal.
        if (decimal < 0) {
            throw new IllegalArgumentException("El valor decimal debe ser no negativo.");
        }
        StringBuilder binary = new StringBuilder();

        for (int i = 31; i >= 0; i--) {

            // Obtiene el bit actual.
            int bit = (decimal & (1 << i)) != 0 ? 1 : 0;
            binary.append(bit);
        }
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