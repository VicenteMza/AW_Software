package aws.bootcamp.clase4.ejs_adicionales.ejercicio5;
/**
 * Clase abstracta que proporciona una implementación de la operación de cálculo.
 */
public abstract class AbstractCalculator {
    /**
     * Calcula el resultado de la operación utilizando dos enteros.
     *
     * @param x El primer número.
     * @param y El segundo número.
     * @return El resultado de la operación.
     */
    public abstract int calculate(int x, int y);
}
