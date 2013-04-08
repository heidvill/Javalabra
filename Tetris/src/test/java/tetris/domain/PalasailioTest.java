
package tetris.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.Palatyyppi;

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
         assertEquals(0, sailio.sailionKoko());
         assertEquals(4, sailio.getUusiPala(0).getRuudut().size());
         
         Pala oPala = new OPala(10, 5);
         sailio.lisaaPala(oPala);
         assertEquals(4, sailio.sailionKoko());
     }
     
     @Test
     public void palauttaaUudenPalanOikein(){
         for (int i = 0; i < 7; i++) {
             Pala uusiPala = sailio.getUusiPala(i);
             assertEquals(Palatyyppi.values()[i], uusiPala.getTyyppi());             
         }
     }
}
