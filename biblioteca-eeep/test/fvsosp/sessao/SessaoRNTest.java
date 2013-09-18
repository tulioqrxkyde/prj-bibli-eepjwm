/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.sessao;

import fvsosp.acervo.Acervo;
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
    public void testAdicionar() {
               
        Sessao sessao = new Sessao();
        sessao.setDescricao("sessaoteste");
        
        SessaoRN rn = new SessaoRN();
        rn.salvar(sessao);
        
        Sessao sessaoTest = rn.pesquisarDescricao("sessaoteste") ;
        
        assertNotNull(sessaoTest);
        
        sessao = new Sessao();
        sessao.setDescricao("sessaoteste");
        
        assertFalse(rn.salvar(sessao));
        
        rn.remove(sessaoTest);
    }

    /**
     * Test of atualizar method, of class SessaoRN.
     */
    @Test
    public void testAtualizar() {
       fail();
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
        fail();
    }

    /**
     * Test of pesquisarDescricao method, of class SessaoRN.
     */
    @Test
    public void testPesquisarDescricao() {
        fail();
    }

    /**
     * Test of pesquisarAcervos method, of class SessaoRN.
     */
    @Test
    public void testPesquisarAcervos() {
        fail();
    }
}
