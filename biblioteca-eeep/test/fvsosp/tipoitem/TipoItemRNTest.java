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
        System.out.println("remover");
        TipoItem tp = null;
        TipoItemRN instance = new TipoItemRN();
        boolean expResult = false;
        boolean result = instance.remover(tp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizar method, of class TipoItemRN.
     */
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        TipoItem tp = null;
        TipoItemRN instance = new TipoItemRN();
        boolean expResult = false;
        boolean result = instance.atualizar(tp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adiciona method, of class TipoItemRN.
     */
    @Test
    public void testAdiciona() {
        System.out.println("adiciona");
        TipoItem tp = null;
        TipoItemRN instance = new TipoItemRN();
        boolean expResult = false;
        boolean result = instance.adiciona(tp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class TipoItemRN.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        TipoItemRN instance = new TipoItemRN();
        List expResult = null;
        List result = instance.listar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pesquisaDescricao method, of class TipoItemRN.
     */
    @Test
    public void testPesquisaDescricao() {
        System.out.println("pesquisaDescricao");
        String descricao = "";
        TipoItemRN instance = new TipoItemRN();
        List expResult = null;
        List result = instance.pesquisaDescricao(descricao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
