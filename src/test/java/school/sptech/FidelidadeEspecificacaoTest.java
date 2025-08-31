package school.sptech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes de especificação para a classe Gincana")
public class FidelidadeEspecificacaoTest {

    @Test
    @DisplayName("Construtor deve ser public, ter nome 'Gincana', aceitar um argumento do tipo String e um argumento do tipo Double")
    public void testConstrutorGincana() {
        try {
            Constructor<?> construtor = Gincana.class.getDeclaredConstructor(String.class, Double.class);
            assertTrue(Modifier.isPublic(construtor.getModifiers()), "Falha: Construtor 'Gincana' deve ser public");
        } catch (NoSuchMethodException e) {
            fail("Construtor 'Gincana(String, Double)' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Campo 'nome' deve ser private e do tipo String")
    public void testCampoNome() {
        try {
            Field campoNome = Gincana.class.getDeclaredField("nome");
            assertTrue(Modifier.isPrivate(campoNome.getModifiers()), "Falha: Campo 'nome' deve ser private");
            assertEquals(String.class, campoNome.getType(), "Falha: Campo 'nome' deve ser do tipo String");
        } catch (NoSuchFieldException e) {
            fail("Campo 'nome' não encontrado: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Campo 'premio' deve ser private e do tipo Double")
    public void testCampoPremio() {
        try {
            Field campoPremio = Gincana.class.getDeclaredField("premio");
            assertTrue(Modifier.isPrivate(campoPremio.getModifiers()), "Falha: Campo 'premio' deve ser private");
            assertEquals(Double.class, campoPremio.getType(), "Falha: Campo 'premio' deve ser do tipo Double");
        } catch (NoSuchFieldException e) {
            fail("Campo 'premio' não encontrado: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Campo 'qtdInscrito' deve ser private e do tipo Integer")
    public void testCampoQtdInscrito() {
        try {
            Field campoQtdInscrito = Gincana.class.getDeclaredField("qtdInscrito");
            assertTrue(Modifier.isPrivate(campoQtdInscrito.getModifiers()), "Falha: Campo 'qtdInscrito' deve ser private");
            assertEquals(Integer.class, campoQtdInscrito.getType(), "Falha: Campo 'qtdInscrito' deve ser do tipo Integer");
        } catch (NoSuchFieldException e) {
            fail("Campo 'qtdInscrito' não encontrado: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Campo 'ativa' deve ser private e do tipo Boolean")
    public void testCampoAtiva() {
        try {
            Field campoAtiva = Gincana.class.getDeclaredField("ativa");
            assertTrue(Modifier.isPrivate(campoAtiva.getModifiers()), "Falha: Campo 'ativa' deve ser private");
            assertEquals(Boolean.class, campoAtiva.getType(), "Falha: Campo 'ativa' deve ser do tipo Boolean");
        } catch (NoSuchFieldException e) {
            fail("Campo 'ativa' não encontrado: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Método 'setPremio' não deve existir para o campo 'premio'")
    public void testNaoExistenciaDeSetPremio() {
        try {
            Gincana.class.getDeclaredMethod("setPremio", Double.class);
            fail("Falha: Método 'setPremio' não deveria existir");
        } catch (NoSuchMethodException e) {
            // Sucesso: Método 'setPremio' não existe
        }
    }

    @Test
    @DisplayName("Método 'setQtdInscrito' não deve existir para o campo 'qtdInscrito'")
    public void testNaoExistenciaDeSetQtdInscrito() {
        try {
            Gincana.class.getDeclaredMethod("setQtdInscrito", Integer.class);
            fail("Falha: Método 'setQtdInscrito' não deveria existir");
        } catch (NoSuchMethodException e) {
            // Sucesso: Método 'setQtdInscrito' não existe
        }
    }

    @Test
    @DisplayName("Método 'setAtiva' não deve existir para o campo 'ativa'")
    public void testNaoExistenciaDeSetAtiva() {
        try {
            Gincana.class.getDeclaredMethod("setAtiva", Boolean.class);
            fail("Falha: Método 'setAtiva' não deveria existir");
        } catch (NoSuchMethodException e) {
            // Sucesso: Método 'setAtiva' não existe
        }
    }

    @Test
    @DisplayName("Método 'inscrever' deve ser public, ter nome 'inscrever', aceitar um argumento do tipo Integer e retornar void")
    public void testMetodoInscrever() {
        try {
            Method metodoInscrever = Gincana.class.getDeclaredMethod("inscrever", Integer.class);
            assertTrue(Modifier.isPublic(metodoInscrever.getModifiers()), "Falha: Método 'inscrever' deve ser public");
            assertEquals(void.class, metodoInscrever.getReturnType(), "Falha: Método 'inscrever' deve retornar void");
        } catch (NoSuchMethodException e) {
            fail("Método 'inscrever' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Método 'remover' deve ser public, ter nome 'remover', aceitar um argumento do tipo Integer e retornar Integer")
    public void testMetodoRemover() {
        try {
            Method metodoRemover = Gincana.class.getDeclaredMethod("remover", Integer.class);
            assertTrue(Modifier.isPublic(metodoRemover.getModifiers()), "Falha: Método 'remover' deve ser public");
            assertEquals(Integer.class, metodoRemover.getReturnType(), "Falha: Método 'remover' deve retornar Integer");
        } catch (NoSuchMethodException e) {
            fail("Método 'remover' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Método 'desativar' deve ser public, ter nome 'desativar', não aceitar argumentos e retornar Integer")
    public void testMetodoDesativar() {
        try {
            Method metodoDesativar = Gincana.class.getDeclaredMethod("desativar");
            assertTrue(Modifier.isPublic(metodoDesativar.getModifiers()), "Falha: Método 'desativar' deve ser public");
            assertEquals(Integer.class, metodoDesativar.getReturnType(), "Falha: Método 'desativaar' deve retornar Integer");
        } catch (NoSuchMethodException e) {
            fail("Método 'desativar' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Método 'transferir' deve ser public, ter nome 'transferir', aceitar dois argumentos (Gincana e Integer) e retornar void")
    public void testMetodoTransferir() {
        try {
            Method metodoTransferir = Gincana.class.getDeclaredMethod("transferir", Gincana.class, Integer.class);
            assertTrue(Modifier.isPublic(metodoTransferir.getModifiers()), "Falha: Método 'transferir' deve ser public");
            assertEquals(void.class, metodoTransferir.getReturnType(), "Falha: Método 'transferir' deve retornar void");
        } catch (NoSuchMethodException e) {
            fail("Método 'transferir' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Método 'reajustarPremio' deve ser public, ter nome 'reajustarpremio', aceitar um argumento Double e retornar Boolean")
    public void testReajustarPremio() {
        try {
            Method metodoReajustarPremio = Gincana.class.getDeclaredMethod("reajustarPremio", Double.class);
            assertTrue(Modifier.isPublic(metodoReajustarPremio.getModifiers()), "Falha: Método 'reajustarPremio' deve ser public");
            assertEquals(Boolean.class, metodoReajustarPremio.getReturnType(), "Falha: Método 'reajustarPremio' deve retornar Boolean");
        } catch (NoSuchMethodException e) {
            fail("Método 'reajustarPremio' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Método 'getNome' deve ser public, ter nome 'getNome', não aceitar argumentos e retornar String")
    public void testMetodoGetNome() {
        try {
            Method metodoGetNome = Gincana.class.getDeclaredMethod("getNome");
            assertTrue(Modifier.isPublic(metodoGetNome.getModifiers()), "Falha: Método 'getNome' deve ser public");
            assertEquals(String.class, metodoGetNome.getReturnType(), "Falha: Método 'getNome' deve retornar String");
        } catch (NoSuchMethodException e) {
            fail("Método 'getNome' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Método 'getPremio' deve ser public, ter nome 'getPremio', não aceitar argumentos e retornar Double")
    public void testMetodoGetPremio() {
        try {
            Method metodoGetPremio = Gincana.class.getDeclaredMethod("getPremio");
            assertTrue(Modifier.isPublic(metodoGetPremio.getModifiers()), "Falha: Método 'getPremio' deve ser public");
            assertEquals(Double.class, metodoGetPremio.getReturnType(), "Falha: Método 'getPremio' deve retornar Double");
        } catch (NoSuchMethodException e) {
            fail("Método 'getPremio' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Método 'getQtdInscrito' deve ser public, ter nome 'getQtdInscrito', não aceitar argumentos e retornar Integer")
    public void testMetodoGetQtdInscrito() {
        try {
            Method metodoGetQtdInscrito = Gincana.class.getDeclaredMethod("getQtdInscrito");
            assertTrue(Modifier.isPublic(metodoGetQtdInscrito.getModifiers()), "Falha: Método 'getQtdInscrito' deve ser public");
            assertEquals(Integer.class, metodoGetQtdInscrito.getReturnType(), "Falha: Método 'getQtdInscrito' deve retornar Integer");
        } catch (NoSuchMethodException e) {
            fail("Método 'getQtdInscrito' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Método 'getAtiva' deve ser public, ter nome 'getAtiva', não aceitar argumentos e retornar Boolean")
    public void testMetodoGetAtiva() {
        try {
            Method metodoGetAtiva = Gincana.class.getDeclaredMethod("getAtiva");
            assertTrue(Modifier.isPublic(metodoGetAtiva.getModifiers()), "Falha: Método 'getAtiva' deve ser public");
            assertEquals(Boolean.class, metodoGetAtiva.getReturnType(), "Falha: Método 'getAtiva' deve retornar Boolean");
        } catch (NoSuchMethodException e) {
            fail("Método 'getAtiva' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Método 'setNome' deve ser public, ter nome 'setNome', aceitar um argumento do tipo String e retornar void")
    public void testMetodoSetNome() {
        try {
            Method metodoSetNome = Gincana.class.getDeclaredMethod("setNome", String.class);
            assertTrue(Modifier.isPublic(metodoSetNome.getModifiers()), "Falha: Método 'setNome' deve ser public");
            assertEquals(void.class, metodoSetNome.getReturnType(), "Falha: Método 'setNome' deve retornar void");
        } catch (NoSuchMethodException e) {
            fail("Método 'setNome' não encontrado ou com assinatura incorreta: " + e.getMessage());
        }
    }
}