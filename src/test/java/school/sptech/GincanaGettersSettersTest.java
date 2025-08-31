package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static school.sptech.GincanaUtil.createGincana;

@DisplayName("Testes para os getters e setters da classe Gincana")
public class GincanaGettersSettersTest {

    @Test
    @DisplayName("Getter 'getNome' deve retornar o nome correto")
    public void testGetNome() throws Exception {
        Object Gincana = createGincana("Caça ao Tesouro", 2500.0);

        Method getNome = Gincana.class.getDeclaredMethod("getNome");
        String nome = (String) getNome.invoke(Gincana);
        assertEquals("Caça ao Tesouro", nome);
    }

    @Test
    @DisplayName("Setter 'setNome' deve alterar o nome corretamente")
    public void testSetNome() throws Exception {
        Object Gincana = createGincana("Caça ao Tesouro", 2500.0);

        Method setNome = Gincana.class.getDeclaredMethod("setNome", String.class);
        setNome.invoke(Gincana, "Imagem e Ação");

        Method getNome = Gincana.class.getDeclaredMethod("getNome");
        String nome = (String) getNome.invoke(Gincana);
        assertEquals("Imagem e Ação", nome);
    }

    @Test
    @DisplayName("Getter 'getPremio' deve retornar o premio correto")
    public void testGetPremio() throws Exception {
        Object Gincana = createGincana("Caça ao Tesouro", 2500.0);

        Field premioField = Gincana.class.getDeclaredField("premio");
        premioField.setAccessible(true);
        premioField.set(Gincana, 2800.0);

        Method getPremio = Gincana.class.getDeclaredMethod("getPremio");
        Double premio = (Double) getPremio.invoke(Gincana);
        assertEquals(2800.0, premio);
    }

    @Test
    @DisplayName("Getter 'getQtdInscrito' deve retornar a quantidade de inscritos correta")
    public void testGetQtdInscrito() throws Exception {
        Object Gincana = createGincana("Caça ao Tesouro", 2500.0);

        Field qtdInscritoField = Gincana.class.getDeclaredField("qtdInscrito");
        qtdInscritoField.setAccessible(true);
        qtdInscritoField.set(Gincana, 30);

        Method getQtdInscrito = Gincana.class.getDeclaredMethod("getQtdInscrito");
        Integer qtdInscrito = (Integer) getQtdInscrito.invoke(Gincana);
        assertEquals(30, qtdInscrito);
    }

    @Test
    @DisplayName("Getter 'getAtiva' deve retornar o status ativo corretamente")
    public void testGetAtiva() throws Exception {
        Object Gincana = createGincana("Caça ao Tesouro", 2500.0);

        Field ativaField = Gincana.class.getDeclaredField("ativa");
        ativaField.setAccessible(true);
        ativaField.set(Gincana, false);

        Method getAtiva = Gincana.class.getDeclaredMethod("getAtiva");
        Boolean ativa = (Boolean) getAtiva.invoke(Gincana);
        assertFalse(ativa);

        ativaField.set(Gincana, true);
        ativa = (Boolean) getAtiva.invoke(Gincana);
        assertTrue(ativa);
    }
}