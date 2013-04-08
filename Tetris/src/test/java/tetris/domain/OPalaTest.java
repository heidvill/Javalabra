
package tetris.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class OPalaTest {
    private Pala pala;
    
    public OPalaTest() {
    }
    
    @Before
    public void setUp() {
        pala = new OPala(10, 5);
        pala.liiku();
        
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void palaKaantyyOikein() {
     assertEquals("[(5,1), (4,1), (5,0), (4,0)]", pala.toString());
     
     pala.kierraOikealle();
     assertEquals("[(5,1), (4,1), (5,0), (4,0)]", pala.toString());
     
     }
}
