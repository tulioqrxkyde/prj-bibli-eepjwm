/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.sessao;

import fvsosp.acervo.Acervo;
import fvsosp.acervo.AcervoRN;
import fvsosp.usuario.Usuario;
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
public class SessaoRNTest {

    public SessaoRNTest() {
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

    /**
     * Test of adicionar method, of class SessaoRN.
     */
   

    @Test
    public void testAtualizar() {
        SessaoRN rn = new SessaoRN();

        Sessao sessao = new Sessao();
        sessao = rn.pesquisarDescricao("TesteAtualizar");

        if (sessao != null) {
            sessao.setDescricao("TesteAtualizarAlterado");
            rn.salvar(sessao);
        }
         assertTrue("TesteAtualizarAlterado", true);      
        


    }

    /**
     * Test of remove method, of class SessaoRN.
     */
    @Test
    public void testRemove() {
        Sessao sessao = new Sessao();
        sessao.setDescricao("sessaotesteremove");

        SessaoRN rn = new SessaoRN();
        rn.salvar(sessao);

        Sessao sessaoTest = rn.pesquisarDescricao("sessaotesteremove");

        assertTrue(rn.remove(sessaoTest));

    }

    /**
     * Test of listar method, of class SessaoRN.
     */
    @Test
    public void testListar() {
        SessaoRN rn = new SessaoRN();

        Sessao sessao = new Sessao();
        sessao = rn.pesquisarDescricao("sessaoTesteListar");
        if (sessao != null) {
            rn.remove(sessao);
        }
        sessao = new Sessao();
        sessao.setDescricao("sessaoTesteListar");
        rn.salvar(sessao);
        
        Sessao sessao2 = new Sessao();
        sessao2.setDescricao("sessaoTesteListar2");
        rn.salvar(sessao2);

        List<Sessao> sessoes = rn.listar();

        assertTrue(sessoes.size() > 0);

        rn.remove(sessao);
        rn.remove(sessao2);
    }

    /**
     * Test of pesquisarDescricao method, of class SessaoRN.
     */
    @Test
    public void testPesquisarDescricao() {
        SessaoRN rn = new SessaoRN();

        Sessao sessao = new Sessao();
        sessao = rn.pesquisarDescricao("TestePesquisarDescrição");
        if (sessao != null) {
            rn.remove(sessao);
        }
        sessao = new Sessao();
        sessao.setDescricao("TestePesquisarDescrição");
        rn.salvar(sessao);

        assertNotNull(sessao);

        rn.remove(sessao);
    }

   
}
