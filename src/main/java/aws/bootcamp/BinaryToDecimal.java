package aws.bootcamp;

import javax.swing.*;
import java.util.regex.Pattern;

//4 - Metodo que recibe un double en formato binario y devuelve un entero en formato decimal.
public class BinaryToDecimal {
    public static int binaryToDecimal(String binary) {
        int length = binary.length();
        int decimal = 0;

        for (int i=0; i < length; i ++){
            char digit = binary.charAt(i);
            int digitValue = Character.getNumericValue(digit);

            int potency = length - i - 1;
            decimal += digitValue * Math.pow(2, potency);
        }

        return decimal;
    }
    public static double fraccionToDecimal(String fractionalpart) {
        double decimalPartFractional = 0.0;

        for (int i = 0; i < fractionalpart.length(); i++) {
            char digito = fractionalpart.charAt(i);
            int valorDigito = Character.getNumericValue(digito);
            decimalPartFractional += valorDigito / Math.pow(2, i + 1);
        }

        return decimalPartFractional;
    }

    public static boolean isValidBinary(String binary){
        return Pattern.matches("^[01]+$", binary);
    }
    public static String[] splitBinary(String binary) {
        if (!binary.contains(".")) {
            return null;
        }
        return binary.split("\\.");
    }

    public static void main(String[] args) {
        String binary;
        String parteEntera = null;
        String parteFraccion = null;
        do {
            binary = JOptionPane.showInputDialog("Ingrese un número binario:");

            if (binary == null) {
                JOptionPane.showMessageDialog(null, "Ingreso cancelado.");
                return;
            }
            if (!binary.contains(".")) {
                JOptionPane.showMessageDialog(null, "Ingrese un número binario con punto decimal.");
                continue;
            }
            String[] parts = splitBinary(binary);
            parteEntera = parts[0].toString();
            parteFraccion = parts[1].toString();
            if (isValidBinary(parteEntera) && isValidBinary(parteFraccion)) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Ingreso no válido - Ingrese solo 0 y 1.");
            }
        } while (true);

        int decimalNumber = binaryToDecimal(parteEntera);
        double fractionalNumber = fraccionToDecimal(parteFraccion);
        JOptionPane.showMessageDialog(null, "Binario: " + binary + "\nEntero: " + decimalNumber
                + "\nFraccion: " + fractionalNumber);
    }
}