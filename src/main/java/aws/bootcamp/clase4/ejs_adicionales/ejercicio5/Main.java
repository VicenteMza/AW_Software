package aws.bootcamp.clase4.ejs_adicionales.ejercicio5;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        MyFunction myFunction = (x, y) -> 2 * x + 3 * y;
        System.out.println("Operación que implementa una intefaz funcional: " + myFunction.apply(5, 7));

        Calculator calc = new Calculator();
        System.out.println("Operacion desde metodo abstracto: " + calc.calculate(5, 7));

        BiFunction<Integer, Integer, Integer> biFun = (x, y) -> 2 * x + 3 * y;
        System.out.println("Operación desde BiFunction: " + biFun.apply(5, 7));

        Function<Integer, Function<Integer, Integer>> func = x -> y-> 2*x +3*y;
        System.out.println("Operación usando Function (Currying): " + func.apply(5).apply(7));

        TriFunction<Long, Long, Long,Long> triFun = (x, y ,z) -> 2*x + 3*y + 4*z;
        System.out.println("Operación usando tres Fuction: " + triFun.apply(5L, 7L, 9L));

        Function<Long[], Long> function = parameters -> 2*parameters[0] + 3*parameters[1] + 4*parameters[2];
        System.out.println("Opercion usada desde el metodo eval: " + eval(function, 5L, 7L, 9L, 10L));
    }
    public static Long eval(Function<Long[], Long> f, Long... parameters) {
        return f.apply(parameters);
    }

}