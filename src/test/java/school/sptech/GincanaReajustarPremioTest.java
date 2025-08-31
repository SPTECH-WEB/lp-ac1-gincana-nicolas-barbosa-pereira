package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static school.sptech.GincanaUtil.createGincana;

@DisplayName("Testes de reajuste de premio para a classe Gincana")
public class GincanaReajustarPremioTest {

    @Test
    @DisplayName("Reajusta o premio em 25%. Valor do premio esperado após o reajuste: 2500.0")
    public void testReajustarPremioReajusteValido() throws Exception {
        Object gincana = createGincana("Caça ao Tesouro", 2000.0);

        Method reajustarPremio = Gincana.class.getDeclaredMethod("reajustarPremio", Double.class);
        Boolean reajustou = (Boolean) reajustarPremio.invoke(gincana, 0.25);

        Field premioField = Gincana.class.getDeclaredField("premio");
        premioField.setAccessible(true);
        Double premio = (Double) premioField.get(gincana);

        assertEquals(2500.0, premio);
        assertTrue(reajustou);
    }

    @Test
    @DisplayName("Tentativa de reajustar o premio com valor de reajuste negativo. Reajuste deve falhar e premio deve permanecer inalterado")
    public void testReajustarPremioReajusteNegativo() throws Exception {
        Object gincana = createGincana("Caça ao Tesouro", 2000.0);

        Method reajustarPremio = Gincana.class.getDeclaredMethod("reajustarPremio", Double.class);
        Boolean reajustou = (Boolean) reajustarPremio.invoke(gincana, -0.25);

        Field premioField = Gincana.class.getDeclaredField("premio");
        premioField.setAccessible(true);
        Double premio = (Double) premioField.get(gincana);

        assertEquals(2000.0, premio);
        assertFalse(reajustou);
    }

    @Test
    @DisplayName("Tentativa de reajustar o premio com valor de reajuste zero. Reajuste deve falhar e premio deve permanecer inalterado")
    public void testReajustarPremioReajusteZero() throws Exception {
        Object gincana = createGincana("Caça ao Tesouro", 2000.0);

        Method reajustarPremio = Gincana.class.getDeclaredMethod("reajustarPremio", Double.class);
        Boolean reajustou = (Boolean) reajustarPremio.invoke(gincana, 0.0);

        Field premioField = Gincana.class.getDeclaredField("premio");
        premioField.setAccessible(true);
        Double premio = (Double) premioField.get(gincana);

        assertEquals(2000.0, premio);
        assertFalse(reajustou);
    }

    @Test
    @DisplayName("Tentativa de reajustar o premio com valor de reajuste nulo. Reajuste deve falhar e premio deve permanecer inalterado")
    public void testReajustarPremioReajusteNulo() throws Exception {
        Object gincana = createGincana("Caça ao Tesouro", 2000.0);

        Method reajustarPremio = Gincana.class.getDeclaredMethod("reajustarPremio", Double.class);
        Boolean reajustou = (Boolean) reajustarPremio.invoke(gincana, (Object) null);

        Field premioField = Gincana.class.getDeclaredField("premio");
        premioField.setAccessible(true);
        Double premio = (Double) premioField.get(gincana);

        assertEquals(2000.0, premio);
        assertFalse(reajustou);
    }

}