package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static school.sptech.GincanaUtil.createGincana;

@DisplayName("Testes de inscrição para a classe Gincana")
public class GincanaInscreverTest {

    @Test
    @DisplayName("Inscrição de 30 participantes em uma gincana com zero inscritos. Quantidade de inscritos esperado: 30")
    public void testInscreverQtdPositivo() throws Exception {
        Object gincana = createGincana("Caça ao Tesouro", 2500.0);

        Method inscrever = Gincana.class.getDeclaredMethod("inscrever", Integer.class);
        inscrever.invoke(gincana, 30);

        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        Integer qtdInscrito = (Integer) qtdInscritoField.get(gincana);

        assertEquals(30, qtdInscrito);
    }

    @Test
    @DisplayName("Tentativa de inscrever -30 participantes em uma gincana com zero inscritos. Quantidade de inscritos esperado: 0 (inscrição inválida)")
    public void testInscreverQtdNegativo() throws Exception {
        Object gincana = createGincana("Caça ao Tesouro", 2500.0);

        Method inscrever = Gincana.class.getDeclaredMethod("inscrever", Integer.class);
        inscrever.invoke(gincana, -30);

        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        Integer qtdInscrito = (Integer) qtdInscritoField.get(gincana);

        assertEquals(0, qtdInscrito); // Quantidade de inscritos deve permanecer a mesma
    }

    @Test
    @DisplayName("Tentativa de inscrever zero participantes em uma gincana com zero inscritos. Quantidade de inscritos esperado: 0 (inscrição inválida)")
    public void testInscreverQtdZero() throws Exception {
        Object gincana = createGincana("Caça ao Tesouro", 2500.0);

        Method inscrever = Gincana.class.getDeclaredMethod("inscrever", Integer.class);
        inscrever.invoke(gincana, 0);

        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        Integer qtdInscrito = (Integer) qtdInscritoField.get(gincana);

        assertEquals(0, qtdInscrito); // Quantidade de inscritos deve permanecer a mesma
    }

    @Test
    @DisplayName("Tentativa de inscrever quantidade com valor nulo de inscritos em uma gincana com zeros inscritos. Quantidade de inscritos esperado: 0 (inscrição inválida)")
    public void testInscreverQtdNulo() throws Exception {
        Object gincana = createGincana("Caça ao Tesouro", 2500.0);

        Method inscrever = Gincana.class.getDeclaredMethod("inscrever", Integer.class);
        inscrever.invoke(gincana, (Object) null);

        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        Integer qtdInscrito = (Integer) qtdInscritoField.get(gincana);

        assertEquals(0, qtdInscrito); // Quantidade de inscritos deve permanecer a mesma
    }

    @Test
    @DisplayName("Inscrição de 30 participantes em uma gincana inativa com zero inscritos. Quantidade de inscritos esperado: 0 (inscrição não realizada devido à gincana inativa)")
    public void testInscreverGincanaInativa() throws Exception {
        Object gincana = createGincana("Caça ao Tesouro", 2500.0);

        Field ativaField = Gincana.class.getDeclaredField("ativa");
        ativaField.setAccessible(true);
        ativaField.set(gincana, false);

        Method inscrever = Gincana.class.getDeclaredMethod("inscrever", Integer.class);
        inscrever.invoke(gincana, 30);

        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        Integer qtdInscrito = (Integer) qtdInscritoField.get(gincana);

        assertEquals(0, qtdInscrito);
    }
}