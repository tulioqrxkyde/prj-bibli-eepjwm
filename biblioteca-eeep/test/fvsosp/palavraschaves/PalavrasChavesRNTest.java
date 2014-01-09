/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fvsosp.palavraschaves;

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
 * @author diener
 */
public class PalavrasChavesRNTest {
    
    public PalavrasChavesRNTest() {
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
     * Test of adicionar method, of class PalavrasChavesRN.
     */
    @Test
    public void testAdicionar() {
        PalavrasChavesRN rn = new PalavrasChavesRN();
        PalavrasChaves palavraChave = new PalavrasChaves();
        
        palavraChave.setDescricao("PalavrasChavesTesteAdicionar");
        rn.adicionar(palavraChave);
        palavraChave=null;
        palavraChave=rn.pesquisarDescricaoEq("PalavrasChavesTesteAdicionar");
        assertEquals("PalavrasChavesTesteAdicionar", palavraChave.getDescricao());
        
        palavraChave.setDescricao("PalavrasChavesTesteAlterado");
        rn.adicionar(palavraChave);
        palavraChave=null;
        
        palavraChave=rn.pesquisarDescricaoEq("PalavrasChavesTesteAlterado");
        assertEquals("PalavrasChavesTesteAlterado", palavraChave.getDescricao());
        
        rn.remove(palavraChave);
    }

    /**
     * Test of remove method, of class PalavrasChavesRN.
     */
    @Test
    public void testRemove() {
        PalavrasChavesRN rn = new PalavrasChavesRN();
        PalavrasChaves palavraschaves = new PalavrasChaves();
        
        palavraschaves.setDescricao("PalavrasChavesTesteRemover");
        rn.adicionar(palavraschaves);
        
        palavraschaves=null;
        
        palavraschaves = rn.pesquisarDescricaoEq("PalavrasChavesTesteRemover");
        
        assertTrue(rn.remove(palavraschaves));
            
        
        
    }

    /**
     * Test of listar method, of class PalavrasChavesRN.
     */
    @Test
    public void testListar() {
        PalavrasChavesRN rn = new PalavrasChavesRN();
        
        PalavrasChaves palavrasChaves1 = new PalavrasChaves();
        
        palavrasChaves1.setDescricao("PalavraChavesListar1");
        rn.adicionar(palavrasChaves1);
        
         PalavrasChaves palavrasChaves2 = new PalavrasChaves();
        
        palavrasChaves2.setDescricao("PalavraChavesListar2");
        rn.adicionar(palavrasChaves2);
        
        List<PalavrasChaves> PalavrasChavesList = rn.listar();
        
        assertTrue(PalavrasChavesList.size() >0);
        
        rn.remove(palavrasChaves1);
        rn.remove(palavrasChaves2);
        
    }

   
}
