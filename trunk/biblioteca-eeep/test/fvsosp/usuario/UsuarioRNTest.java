/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.usuario;

import fvsosp.util.Util;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro Saraiva
 */
public class UsuarioRNTest {

    public UsuarioRNTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAutentica() {
        UsuarioRN rn = new UsuarioRN();

        Usuario usuario = rn.pesquisaLogin("testeautentica");

        if (usuario == null) {
            usuario = new Usuario();
            usuario.setLogin("testeautentica");
            usuario.setSenha("testeautenticasenha");

            rn.adiciona(usuario, "testeautenticasenha");
        }

        assertEquals(rn.autentica(usuario), true);

    }

    @Test
    public void testRemover() {
        UsuarioRN rn = new UsuarioRN();

        Usuario usuario = rn.pesquisaLogin("testeremover");

        if (usuario != null) {
            assertEquals(rn.remover(usuario), true);
        }

        usuario = new Usuario();
        usuario.setLogin("testeremover");
        usuario.setSenha("testeremoversenha");

        rn.adiciona(usuario, "testeremoversenha");

        assertEquals(rn.remover(usuario), true);
    }

    @Test
    public void testAtualizar() {
        UsuarioRN rn = new UsuarioRN();

        Usuario usuario = rn.pesquisaLogin("testealterar");

        if (usuario == null) {
            usuario = new Usuario();
            usuario.setLogin("testealterar");
            usuario.setSenha("testealterarsenha");

            rn.adiciona(usuario, "testealterarsenha");
        }
        Usuario usuario2 = new Usuario();
        usuario2 = rn.pesquisaLogin("testealterar");

        usuario2.setLogin("testealterarteste");
        usuario2.setSenha("testealterartestesenha");

        assertEquals(rn.atualizar(usuario2, "testealterarsenha"), true);

        Usuario usuarioALterado = new Usuario();
        usuarioALterado = rn.pesquisaLogin("testealterarteste");

        assertNotNull(usuarioALterado);

        rn.remover(usuarioALterado);
    }

    @Test
    public void testAdiciona() {
        UsuarioRN rn = new UsuarioRN();

        Usuario usuario = rn.pesquisaLogin("testeadiciona");
        if (usuario != null) {
            rn.remover(usuario);
        }
        usuario = new Usuario();
        usuario.setLogin("testeadiciona");
        usuario.setSenha("testeadicionasenha");

        assertEquals(rn.adiciona(usuario, "testeadicionasenha"), true);

        Usuario usuarioAdiciona = new Usuario();
        usuarioAdiciona = rn.pesquisaLogin("testeadiciona");

        assertEquals(usuario.getLogin(), "testeadiciona");
        assertEquals(usuario.getSenha(), Util.md5("testeadicionasenha"));
    }

    @Test
    public void testPesquisaLogin() {
        UsuarioRN rn = new UsuarioRN();

        Usuario usuario = rn.pesquisaLogin("testepesquisalogin");
        if (usuario != null) {
            rn.remover(usuario);
        }
        usuario = new Usuario();
        usuario.setLogin("testepesquisalogin");
        usuario.setSenha("testepesquisaloginsenha");

        rn.adiciona(usuario, "testepesquisaloginsenha");

        Usuario usuarioPesqLogin = rn.pesquisaLogin("testepesquisalogin");
        assertNotNull(usuario);
    }

    @Test
    public void testListar() {
        UsuarioRN rn = new UsuarioRN();

        Usuario usuario = rn.pesquisaLogin("testelistar");
        if (usuario != null) {
            rn.remover(usuario);
        }
        usuario = new Usuario();
        usuario.setLogin("testelistar");
        usuario.setSenha("testelistarsenha");

        rn.adiciona(usuario, "testelistarsenha");

        List<Usuario> usuarios = rn.listar();
        assertTrue(usuarios.size()>0);
    }
}
