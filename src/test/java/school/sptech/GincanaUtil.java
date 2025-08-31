package school.sptech;

import java.lang.reflect.Constructor;

public class GincanaUtil {

    public static Object createGincana(String nome, Double premio) throws Exception {
        Constructor<?> constructor = Gincana.class.getDeclaredConstructor(String.class, Double.class);
        return constructor.newInstance(nome, premio);
    }
}
