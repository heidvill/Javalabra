
package tetris.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PalasailioTest {
    private Palasailio sailio;
    
    public PalasailioTest() {
    }

    @Before
    public void setUp() {
        sailio = new Palasailio(20, 20);
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void lisaaPalatOikein() {
         assertEquals(7, sailio.sailionKoko());
         assertEquals(0, sailio.getPala(0).getRuudut().size());
     }
}