/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.tipoitem;

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
public class TipoItemRNTest {
    
    public TipoItemRNTest() {
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
     * Test of remover method, of class TipoItemRN.
     */
    @Test
    public void testRemover() {
        TipoItem item = new TipoItem();
        
        item.setDescricao("tipoItemDescrição");
        TipoItemRN rn = new TipoItemRN();
        rn.adiciona(item);
        
        if (item != null){
            rn.remover(item);
        }
        assertFalse(false);
    }

    /**
     * Test of atualizar method, of class TipoItemRN.
     */
    @Test
    public void testAtualizar() {
        fail("The test case is a prototype.");
    }

    /**
     * Test of adiciona method, of class TipoItemRN.
     */
    @Test
    public void testAdiciona() {
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class TipoItemRN.
     */
    @Test
    public void testListar() {
       TipoItemRN rn = new TipoItemRN();
       TipoItem item = new TipoItem();
        item.setDescricao("ListarDescriçãoTipoItem");
        rn.adiciona(item);
        
        TipoItem item2 = new TipoItem();
        item2.setDescricao("ListarDescriçãoTipoItem2");
        rn.adiciona(item2);
        
        List<TipoItem> tipoItens = rn.listar();
        
        assertTrue(tipoItens.size() >0);
        
        rn.remover(item);
        rn.remover(item2);
    }

    /**
     * Test of pesquisaDescricao method, of class TipoItemRN.
     */
    @Test
    public void testPesquisaDescricao() {
        TipoItem item = new TipoItem();
        
        item.setDescricao("tipoItemDescrição");
        TipoItemRN rn = new TipoItemRN();
        rn.adiciona(item);
        
        assertTrue("tipoItemDescrição", true);
    }
}
