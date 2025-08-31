package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static school.sptech.GincanaUtil.createGincana;

@DisplayName("Testes de desativação de gincana para a classe Gincana")
public class GincanaDesativarTest {

    @Test
    @DisplayName("Desativar gincana com quantidade de inscritos positivo.")
    public void testDesativarGincanaComInscrito() throws Exception {
        Object gincana = createGincana("Caça ao Tesouro", 2500.0);

        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        qtdInscritoField.set(gincana, 30);

        Method desativar = Gincana.class.getDeclaredMethod("desativar");
        Integer qtdInscritoFinal = (Integer) desativar.invoke(gincana);

        Integer qtdInscrito = (Integer) qtdInscritoField.get(gincana);
        Field ativaField = Gincana.class.getDeclaredField("ativa");
        ativaField.setAccessible(true);
        Boolean ativa = (Boolean) ativaField.get(gincana);

        assertEquals(30, qtdInscritoFinal);
        assertEquals(0, qtdInscrito, "A quantidade de inscritos da gincana deve ser zerada após a desativação");
        assertFalse(ativa); // Verifica se a gincana foi inativada
    }

    @Test
    @DisplayName("Desativar gincana com zero inscritos. Quantidade de inscritos esperado: 0")
    public void testDesativarGincanaComZeroAluno() throws Exception {
        Object gincana = createGincana("Caça ao Tesouro", 2500.0);

        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        qtdInscritoField.set(gincana, 0);

        Method desativar = Gincana.class.getDeclaredMethod("desativar");
        Integer qtdInscritoFinal = (Integer) desativar.invoke(gincana);

        Integer qtdInscrito = (Integer) qtdInscritoField.get(gincana);
        Field ativaField = Gincana.class.getDeclaredField("ativa");
        ativaField.setAccessible(true);
        Boolean ativa = (Boolean) ativaField.get(gincana);

        assertEquals(0, qtdInscritoFinal);
        assertEquals(0, qtdInscrito, "A quantidade de inscritos da gincana deve ser zerado após a desativação");
        assertFalse(ativa); // Verifica se a gincana foi inativada
    }

}