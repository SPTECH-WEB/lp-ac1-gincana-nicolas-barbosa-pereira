package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static school.sptech.GincanaUtil.createGincana;

@DisplayName("Testes de remoção de inscritos para a classe Gincana")
public class GincanaRemoverTest {

    @Test
    @DisplayName("Remove 5 inscritos de uma gincana com 30 inscritos. Quantidade de inscritos esperado após remover: 25")
    public void testRemoverQtdInscritoValida() throws Exception {
        Object gincana = createGincana("Caça ao Tesouro", 2500.0);

        // Iniciando a gincana com um qtdInscrito de 30 para os testes
        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        qtdInscritoField.set(gincana, 30);

        Method remover = Gincana.class.getDeclaredMethod("remover", Integer.class);
        Integer qtdRemovido = (Integer) remover.invoke(gincana, 5);

        qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        Integer qtdInscrito = (Integer) qtdInscritoField.get(gincana);

        assertEquals(25, qtdInscrito);
        assertEquals(5, qtdRemovido);
    }

    @Test
    @DisplayName("Tentativa de remover 45 inscritos em uma gincana com qtdInscrito de 30. Remoção deve falhar e qtdInscrito deve permanecer 30")
    public void testRemoverQtdMaiorQueQtdInscrito() throws Exception {
        Object gincana = createGincana("Caça ao Tesouro", 2500.0);

        // Iniciando a gincana com um qtdInscrito de 30 para os testes
        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        qtdInscritoField.set(gincana, 30);

        Method remover = Gincana.class.getDeclaredMethod("remover", Integer.class);
        Integer qtdRemovido = (Integer) remover.invoke(gincana, 45);

        qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        Integer qtdInscrito = (Integer) qtdInscritoField.get(gincana);

        assertEquals(30, qtdInscrito);
        assertNull(qtdRemovido); // Deve retornar null quando o qtdInscrito é insuficiente
    }

    @Test
    @DisplayName("Tentativa de remover zero inscritos em uma gincana com 30 inscritos. Remoção deve falhar e qtdInscrito deve permanecer 30")
    public void testRemoverQtdZero() throws Exception {
        Object gincana = createGincana("Caça ao Tesouro", 2500.0);

        // Iniciando a gincana com um qtdInscrito de 30 para os testes
        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        qtdInscritoField.set(gincana, 30);

        Method remover = Gincana.class.getDeclaredMethod("remover", Integer.class);
        Integer qtdRemovido = (Integer) remover.invoke(gincana, 0);

        qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        Integer qtdInscrito = (Integer) qtdInscritoField.get(gincana);

        assertEquals(30, qtdInscrito);
        assertNull(qtdRemovido); // Deve retornar null quando a quantidade a remover é zero
    }

    @Test
    @DisplayName("Tentativa de remover quantidade negativa de inscritos (-5) em uma gincana com 30 inscritos. Remoção deve falhar e qtdInscrito deve permanecer 30")
    public void testRemoverQtdNegativo() throws Exception {
        Object gincana = createGincana("Caça ao Tesouro", 2500.0);

        // Iniciando a gincana com um qtdInscrito de 30 para os testes
        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        qtdInscritoField.set(gincana, 30);

        Method remover = Gincana.class.getDeclaredMethod("remover", Integer.class);
        Integer qtdRemovido = (Integer) remover.invoke(gincana, -5);

        qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        Integer qtdInscrito = (Integer) qtdInscritoField.get(gincana);

        assertEquals(30, qtdInscrito);
        assertNull(qtdRemovido); // Deve retornar null quando a quantidade a remover é negativa
    }

    @Test
    @DisplayName("Tentativa de remover quantidade com valor nulo em uma gincana com 30 inscritos. Remoção deve falhar e qtdInscrito deve permanecer 30")
    public void testRemoverQtdNulo() throws Exception {
        Object gincana = createGincana("Caça ao Tesouro", 2500.0);

        // Iniciando a gincana com um qtdInscrito de 30 para os testes
        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        qtdInscritoField.set(gincana, 30);

        Method remover = Gincana.class.getDeclaredMethod("remover", Integer.class);
        Integer qtdRemovido = (Integer) remover.invoke(gincana, (Object) null);

        qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        Integer qtdInscrito = (Integer) qtdInscritoField.get(gincana);

        assertEquals(30, qtdInscrito);
        assertNull(qtdRemovido); // Deve retornar null quando a quantidade a remover é nula
    }

    @Test
    @DisplayName("Tentativa de remover 5 inscritos em uma gincana inativa com 30 inscritos. Remoção deve falhar e qtdInscrito deve permanecer 30")
    public void testRemoverGincanaInativa() throws Exception {
        Object gincana = createGincana("Caça ao Tesouro", 2500.0);

        // Iniciando a gincana com um qtdInscrito de 30
        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        qtdInscritoField.set(gincana, 30);

        Field ativaField = Gincana.class.getDeclaredField("ativa");
        ativaField.setAccessible(true);
        ativaField.set(gincana, false);

        Method remover = Gincana.class.getDeclaredMethod("remover", Integer.class);
        Integer qtdRemovido = (Integer) remover.invoke(gincana, 5);

        qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        Integer qtdInscrito = (Integer) qtdInscritoField.get(gincana);

        assertEquals(30, qtdInscrito);
        assertNull(qtdRemovido); // Deve retornar null quando a gincana está inativa
    }
}