
package tetris.peli;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliTest {
    
    private Peli peli;
    
    public PeliTest() {
    }

    
    @Before
    public void setUp() {
        peli = new Peli(10, 5);
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void luoPelinOikein() {
     assertEquals(0, peli.getPalasailio().sailionKoko());
     assertEquals(4, peli.getPala().getRuudut().size());
     }
}
