package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static school.sptech.GincanaUtil.createGincana;

@DisplayName("Testes de transferência para a classe Gincana")
public class GincanaTransferirTest {

    @Test
    @DisplayName("Transferência de 15 inscritos de uma gincana com 30 inscritos para uma gincana com 15 inscritos. Quantidades de inscritos esperadas: origem 15; destino 30")
    public void testTransferirQuantidadeValido() throws Exception {
        Object gincanaOrigem = createGincana("Caça ao Tesouro", 2500.0);
        Object gincanaDestino = createGincana("Imagem e Ação", 3400.0);

        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        qtdInscritoField.set(gincanaOrigem, 30);
        qtdInscritoField.set(gincanaDestino, 15);

        Method transferir = Gincana.class.getDeclaredMethod("transferir", Gincana.class, Integer.class);
        transferir.invoke(gincanaOrigem, gincanaDestino, 15);

        qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);

        Integer qtdInscritoOrigem = (Integer) qtdInscritoField.get(gincanaOrigem);
        Integer qtdInscritoDestino = (Integer) qtdInscritoField.get(gincanaDestino);

        assertEquals(15, qtdInscritoOrigem);
        assertEquals(30, qtdInscritoDestino);
    }

    @Test
    @DisplayName("Tentativa de transferir 45 inscritos (valor superior a qtdInscrito) de uma gincana com 30 inscritos. Quantidades de inscritos esperados: origem 30; destino 5")
    public void testTransferirValorSuperiorAQtdAluno() throws Exception {
        Object gincanaOrigem = createGincana("Caça ao Tesouro", 2500.0);
        Object gincanaDestino = createGincana("Imagem e Ação", 3400.0);

        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        qtdInscritoField.set(gincanaOrigem, 30);
        qtdInscritoField.set(gincanaDestino, 5);

        Method transferir = Gincana.class.getDeclaredMethod("transferir", Gincana.class, Integer.class);
        transferir.invoke(gincanaOrigem, gincanaDestino, 45);

        qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);

        Integer qtdInscritoOrigem = (Integer) qtdInscritoField.get(gincanaOrigem);
        Integer qtdInscritoDestino = (Integer) qtdInscritoField.get(gincanaDestino);

        assertEquals(30, qtdInscritoOrigem);  // Sem alteração na origem
        assertEquals(5, qtdInscritoDestino);  // Sem alteração no destino
    }

    @Test
    @DisplayName("Tentativa de transferir 5 inscritos de uma gincana com 30 inscritos para uma gincana inativa. A quantidade de inscritos da gincana origem deve permanecer inalterado.")
    public void testTransferirParaGincanaInativa() throws Exception {
        Object gincanaOrigem = createGincana("Caça ao Tesouro", 2500.0);
        Object gincanaDestino = createGincana("Imagem e Ação", 3400.0);

        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        qtdInscritoField.set(gincanaOrigem, 30);
        qtdInscritoField.set(gincanaDestino, 5);

        Field ativaField = Gincana.class.getDeclaredField("ativa");
        ativaField.setAccessible(true);
        ativaField.set(gincanaDestino, false);

        Method transferir = Gincana.class.getDeclaredMethod("transferir", Gincana.class, Integer.class);
        transferir.invoke(gincanaOrigem, gincanaDestino, 5);

        qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);

        Integer qtdInscritoOrigem = (Integer) qtdInscritoField.get(gincanaOrigem);
        Integer qtdInscritoDestino = (Integer) qtdInscritoField.get(gincanaDestino);

        assertEquals(30, qtdInscritoOrigem);  // Transferência falha, sem alteração na origem
        assertEquals(5, qtdInscritoDestino);  // Sem alteração no destino
    }

    @Test
    @DisplayName("Tentativa de transferir 5 inscritos de uma gincana inativa para uma gincana ativa. A quantidade de inscritos da gincana origem deve permanecer inalterado.")
    public void testTransferirDeGincanaInativa() throws Exception {
        Object gincanaOrigem = createGincana("Caça ao Tesouro", 2500.0);
        Object gincanaDestino = createGincana("Imagem e Ação", 3400.0);

        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        qtdInscritoField.set(gincanaOrigem, 30);
        qtdInscritoField.set(gincanaDestino, 5);

        Field ativaField = Gincana.class.getDeclaredField("ativa");
        ativaField.setAccessible(true);
        ativaField.set(gincanaOrigem, false);

        Method transferir = Gincana.class.getDeclaredMethod("transferir", Gincana.class, Integer.class);
        transferir.invoke(gincanaOrigem, gincanaDestino, 5);

        qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);

        Integer qtdInscritoOrigem = (Integer) qtdInscritoField.get(gincanaOrigem);
        Integer qtdInscritoDestino = (Integer) qtdInscritoField.get(gincanaDestino);

        assertEquals(30, qtdInscritoOrigem);  // Transferência falha, sem alteração na origem
        assertEquals(5, qtdInscritoDestino);  // Sem alteração no destino
    }

    @Test
    @DisplayName("Tentativa de transferir zero inscritos de uma gincana com 30 inscritos. Quantidades de inscritos esperados: origem 30; destino 5")
    public void testTransferirValorZero() throws Exception {
        Object gincanaOrigem = createGincana("Caça ao Tesouro", 2500.0);
        Object gincanaDestino = createGincana("Imagem e Ação", 3400.0);

        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        qtdInscritoField.set(gincanaOrigem, 30);
        qtdInscritoField.set(gincanaDestino, 5);

        Method transferir = Gincana.class.getDeclaredMethod("transferir", Gincana.class, Integer.class);
        transferir.invoke(gincanaOrigem, gincanaDestino, 0);

        qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);

        Integer qtdInscritoOrigem = (Integer) qtdInscritoField.get(gincanaOrigem);
        Integer qtdInscritoDestino = (Integer) qtdInscritoField.get(gincanaDestino);

        assertEquals(30, qtdInscritoOrigem);  // Sem alteração na origem
        assertEquals(5, qtdInscritoDestino);  // Sem alteração no destino
    }

    @Test
    @DisplayName("Tentativa de transferir quantidade negativa de inscritos (-5) de uma gincana com 30 inscritos. Quantidades de inscritos esperados: origem 30; destino 5")
    public void testTransferirQuantidadeNegativa() throws Exception {
        Object gincanaOrigem = createGincana("Caça ao Tesouro", 2500.0);
        Object gincanaDestino = createGincana("Imagem e Ação", 3400.0);

        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        qtdInscritoField.set(gincanaOrigem, 30);
        qtdInscritoField.set(gincanaDestino, 5);

        Method transferir = Gincana.class.getDeclaredMethod("transferir", Gincana.class, Integer.class);
        transferir.invoke(gincanaOrigem, gincanaDestino, -5);

        qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);

        Integer qtdInscritoOrigem = (Integer) qtdInscritoField.get(gincanaOrigem);
        Integer qtdInscritoDestino = (Integer) qtdInscritoField.get(gincanaDestino);

        assertEquals(30, qtdInscritoOrigem);  // Sem alteração na origem
        assertEquals(5, qtdInscritoDestino);  // Sem alteração no destino
    }

    @Test
    @DisplayName("Tentativa de transferir 5 inscritos de uma gincana com 30 inscritos para uma gincana nula. Quantidade de inscritos esperado: origem 30")
    public void testTransferirParaGincanaNula() throws Exception {
        Object gincanaOrigem = createGincana("Caça ao Tesouro", 2500.0);

        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        qtdInscritoField.set(gincanaOrigem, 30);

        Method transferir = Gincana.class.getDeclaredMethod("transferir", Gincana.class, Integer.class);
        transferir.invoke(gincanaOrigem, null, 5);

        qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);

        Integer qtdInscritoOrigem = (Integer) qtdInscritoField.get(gincanaOrigem);

        assertEquals(30, qtdInscritoOrigem);  // Sem alteração na origem, pois o destino é nulo
    }

    @Test
    @DisplayName("Tentativa de transferir valor nulo de uma gincana com 30 inscritos. Quantidades de inscritos esperados: origem 30; destino 5")
    public void testTransferirValorNulo() throws Exception {
        Object gincanaOrigem = createGincana("Caça ao Tesouro", 2500.0);
        Object gincanaDestino = createGincana("Imagem e Ação", 3400.0);

        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        qtdInscritoField.set(gincanaOrigem, 30);
        qtdInscritoField.set(gincanaDestino, 15);

        Method transferir = Gincana.class.getDeclaredMethod("transferir", Gincana.class, Integer.class);
        transferir.invoke(gincanaOrigem, gincanaDestino, (Object) null);

        qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);

        Integer qtdInscritoOrigem = (Integer) qtdInscritoField.get(gincanaOrigem);
        Integer qtdInscritoDestino = (Integer) qtdInscritoField.get(gincanaDestino);

        assertEquals(30, qtdInscritoOrigem);  // Sem alteração na origem
        assertEquals(15, qtdInscritoDestino);  // Sem alteração no destino
    }
}