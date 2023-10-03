package aws.bootcamp.clase4.ejs_adicionales;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
3 - Utilizando el metodo anterior, obtenga una lista de numeros entre 2 limites y proceda a transformarlos en String para
despues obtener una cadena como la siguiente:
           10 -> 11 -> 12 -> 13 -> 14 -> 15 ...
Y como haría para obtener un String concatenando n veces el número a concatenar?, ej:

122333444455555....
*/
public class Ejercicio3 {
    public static void main(String[] args) {
        Integer desde = 10;
        Integer hasta = 20;

        Ejercicio3 ej = new Ejercicio3();
        Predicate<Integer> predicatePares = n -> n % 2 == 0;
        Predicate<Integer> predicateMayor15 = n -> n > 15;

        // Prueba del método obtenerListaSecuencialCondicionada
//        List<Integer> listaCondicionada = ej.obtenerListaSecuencialCondicionada(desde, hasta, predicatePares);
//        System.out.println("Lista con condición: " + listaCondicionada);
//
//        List<Predicate<Integer>> condicionales = List.of(predicatePares, predicateMayor15);
//        listaCondicionada = ej.obtenerListaSecuencialCondicionadaMultiple(null, null, null);
//        System.out.println("Predicados enviedos en una List: " + listaCondicionada);
//
//        Predicate[] condiciones = new Predicate[]{predicatePares, predicateMayor15};
//        List<Integer> lFiltrada = ej.ObtenerListaSecuencialCondicionadaMultiple(null, null, null);
//        System.out.println("Predicados en un vertor: " + lFiltrada);
//
//        List<Integer> lFilt = ej.ObtenerListaSecuencialCondicionadaMultiple(null, null, null);
//        System.out.println("Predicados en un vertor enviado desde la llamada al metodo: " + lFilt);

        // Concatenar números n veces
        String resultadoConcatenado = ej.concatenarNumeros(ej.obtenerListaSecuencial(10, 30));
        System.out.println("Concatenación de números: " + resultadoConcatenado);

        int n = 10;
        System.out.println("Concatenación de números "+ n+ " veces: " + ej.concatenatingNumberNTimes(n));

    }
    /**
     * Concatena los números de la lista especificada en un solo String, separados por un guion medio ("->").
     */
    private String concatenarNumeros(List<Integer> numeros) {
                return numeros
                        .stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(" -> "));
    }
    /**
     * Concatena el número especificado el número de veces especificado.
     */
    private String concatenatingNumberNTimes(int number) {
        return IntStream.rangeClosed(1, number)
                .mapToObj(i -> String.valueOf(i).repeat(i))
                .collect(Collectors.joining());
    }

    /**
     * Este método filtra una lista de números secuenciales en función de un predicado.
     * Si el predicado es null, devuelve la lista sin filtrar.
     */
    private List<Integer> obtenerListaSecuencialCondicionada(Integer desde, Integer hasta, Predicate<Integer> condicion) {

        return obtenerListaSecuencial(desde, hasta)
                .stream()
                .filter(n -> condicion == null || condicion.test(n))
                .collect(Collectors.toList());
    }
    /**
     * Este método filtra una lista de números secuenciales en función de una lista de predicados.
     * Si la lista de predicados es null, devuelve la lista sin filtrar.
     */
    private List<Integer> obtenerListaSecuencialCondicionadaMultiple(Integer desde, Integer hasta, List<Predicate<Integer>> condiciones) {
        return condiciones != null ? obtenerListaSecuencial(desde, hasta)
                .stream()
                .filter(n -> condiciones.stream().allMatch(condicion -> condicion.test(n)))
                .collect(Collectors.toList())
                : obtenerListaSecuencial(desde, hasta);
    }
    /**
     * Este método entra en conflicto con el método anterior debido a que el compilador no puede distinguir el llamado
     * entre ambos métodos. Esto ocurre porque tanto 'Predicate<Integer>... condiciones' como 'Predicate<Integer>[] condiciones'
     * se manejan prácticamente de la misma manera como si fueran matrices, lo que crea ambigüedad en la invocación.
     */
    /*private List<Integer> ObtenerListaSecuencialCondicionadaMultiple(int desde, int hasta, Predicate<Integer>[] condiciones) {
        return obtenerListaSecuencial(desde, hasta)
                .stream()
                .filter(n -> Arrays.stream(condiciones).allMatch(condicion -> condicion.test(n)))
                .collect(Collectors.toList());

    }
    */
    /**
     * Este método filtra una lista de números secuenciales en función de un arreglo de predicados.
     * Si el arreglo de predicados es null, devuelve la lista sin filtrar.
     */

    private List<Integer> ObtenerListaSecuencialCondicionadaMultiple(Integer desde, Integer hasta, Predicate<Integer>... condiciones) {
        return condiciones != null
                ? obtenerListaSecuencial(desde, hasta)
                .stream()
                .filter(n -> Arrays.stream(condiciones).allMatch(condicion -> condicion != null && condicion.test(n)))
                .collect(Collectors.toList())
                : obtenerListaSecuencial(desde, hasta);
    }
    /**
     * Este método genera una lista de números secuenciales en el rango especificado.
     * Si los valores 'desde' o 'hasta' son nulos, se utilizan los valores predeterminados (10 y 20).
     */
    private List<Integer> obtenerListaSecuencial(Integer desde, Integer hasta) {
        desde = Optional.ofNullable(desde).orElse(10);
        hasta = Optional.ofNullable(hasta).orElse(20);
        return IntStream.rangeClosed(desde, hasta)
                .boxed()
                .collect(Collectors.toList());
    }
}