package aws.bootcamp.clase4.ejs_adicionales.ejercicio5;
/**
 * Una interfaz funcional para representar una función que toma tres argumentos
 * de entrada de tipos diferentes y produce un resultado de un tipo específico.
 *
 * @param <X> El tipo del primer argumento.
 * @param <Y> El tipo del segundo argumento.
 * @param <Z> El tipo del tercer argumento.
 * @param <R> El tipo del resultado.
 */
@FunctionalInterface
public interface TriFunction<X, Y, Z, R> {
    R apply(X x, Y y, Z z);
}