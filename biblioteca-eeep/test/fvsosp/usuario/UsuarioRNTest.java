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

        rn.remover(usuario);

    }

    @Test
    public void testRemover() {
        UsuarioRN rn = new UsuarioRN();

        Usuario usuario = rn.pesquisaLogin("testeremover");

        if (usuario != null) {
            assertEquals(rn.remover(usuario), true);
        }

        //insere um usuario para remover
        usuario = new Usuario();
        usuario.setLogin("testeremover");
        usuario.setSenha("testeremoversenha");

        rn.adiciona(usuario, "testeremoversenha");

        //verifica se conseguiu remover o usuario de login testeremover
        assertEquals(rn.remover(usuario), true);

    }

    @Test
    public void testAtualizar() {
        UsuarioRN rn = new UsuarioRN();

        //pesquisa um usuario com o login testealterar
        Usuario usuario = rn.pesquisaLogin("testealterar");

        if (usuario == null) {
            //se não existir ele adiciona no banco de dados
            usuario = new Usuario();
            usuario.setLogin("testealterar");
            usuario.setSenha("testealterarsenha");

            rn.adiciona(usuario, "testealterarsenha");
        }
        //cria usuario dois e carrega um usario com login testealterar
        Usuario usuario2 = new Usuario();
        usuario2 = rn.pesquisaLogin("testealterar");
        
        //modifica o usuario que antes tinha testalterar como login
        usuario2.setLogin("testealterarteste");
        usuario2.setSenha("testealterartestesenha");

        //atualiza o usuario de login testealterar para login testealterarsenha
        assertEquals(rn.atualizar(usuario2, "testealterarsenha"), true);

        //carrega o usuário testealterartest
        Usuario usuarioALterado = new Usuario();
        usuarioALterado = rn.pesquisaLogin("testealterarteste");

        //verifica se o usarioAlterado é não nulo
        assertNotNull(usuarioALterado);

        //remove o usuarioALterar
        rn.remover(usuarioALterado);
    }

    @Test
    public void testAdiciona() {
        UsuarioRN rn = new UsuarioRN();

        //pesquisa se já existe um usuário cadastrado com o login testeadiciona
        Usuario usuario = rn.pesquisaLogin("testeadiciona");
        if (usuario != null) {
            //se existir ele remove
            rn.remover(usuario);
        }
        
        usuario = new Usuario();
        usuario.setLogin("testeadiciona");
        usuario.setSenha("testeadicionasenha");
        //adiciona o primeiro usuário
        assertEquals(rn.adiciona(usuario, "testeadicionasenha"), true);
             
        //2º usário com as mesmas caracterísitcas do primeiro
        usuario = new Usuario();
        usuario.setLogin("testeadiciona");
        usuario.setSenha("testeadicionasenha");
        //não pode deixar adicionar dois usuários com o mesmo login
        assertEquals(rn.adiciona(usuario, "testeadicionasenha"), false);

        //pesquisa pelo usuario testeadiciona
        Usuario usuarioAdiciona = new Usuario();
        usuarioAdiciona = rn.pesquisaLogin("testeadiciona");

        //verifica se possui login e senha predefinidos anteriormente
        assertEquals(usuario.getLogin(), "testeadiciona");
        assertEquals(usuario.getSenha(), Util.md5("testeadicionasenha"));

        rn.remover(usuarioAdiciona);
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

        //carrega o usuario com login testepesquisalogin
        Usuario usuarioPesqLogin = rn.pesquisaLogin("testepesquisalogin");
        //verifica se foi encontrado o usuario pesquisado
        assertNotNull(usuario);

        rn.remover(usuario);
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
        
        Usuario usuario2 = new Usuario();
        usuario2.setLogin("testelistar2");
        usuario2.setSenha("testelistarsenha2");
        
        rn.adiciona(usuario2, "testelistarsenha2");
        
        //carrega uma lista de usuarios
        List<Usuario> usuarios = rn.listar();
        //verifica se o tamanho da lista é maior que 0
        assertTrue(usuarios.size() > 0);

        rn.remover(usuario);
        rn.remover(usuario2);
    }
}
