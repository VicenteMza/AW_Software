package aws.bootcamp.clase4;

import java.util.Optional;
import java.util.function.Predicate;

public class OptionalBoolean {
    private final Predicate<Boolean> PREDICATE = p -> p != null && p;

    public static void main(String[] args) {
        Boolean p1 = true;
        Boolean p2 = null;
        Boolean p3 = true;
        boolean result = new OptionalBoolean().evaluateBooleansWhitPredicate(p1, p2, p3);
        System.out.println("Resultado con Optional: " + result);

        boolean result2 = new OptionalBoolean().evaluateBooleansWhitOptional(p1, p2, p3);
        System.out.println("Resultado usando Predicate: " + result2);

    }

    private boolean evaluateBooleansWhitOptional(Boolean p1, Boolean p2, Boolean p3) {
        // Manejo de valores nulos y los consideramos como FALSE
        return Optional.ofNullable(p1).orElse(false)
                && Optional.ofNullable(p2).orElse(false)
                && Optional.ofNullable(p3).orElse(false);
    }
    private boolean evaluateBooleansWhitPredicate(Boolean p1, Boolean p2, Boolean p3) {
        return PREDICATE.test(p1) && PREDICATE.test(p2) && PREDICATE.test(p3);
    }
}