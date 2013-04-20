
package tetris.peli;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PistelaskuriTest {
    private Pistelaskuri laskuri;
    
    public PistelaskuriTest() {
    }
    
    @Before
    public void setUp() {
        laskuri = new Pistelaskuri();
        
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void luoLaskurinOikein() {
     assertEquals(0, laskuri.getPisteet());
     assertEquals(1, laskuri.getTaso());
     }
     
     @Test
     public void pisteetKasvaaOikein() {
     assertEquals(0, laskuri.getPisteet());
     
     laskuri.kasvataPisteitaPalalla();
     assertEquals(4, laskuri.getPisteet());
     
     laskuri.kasvataPisteitaRiveilla(0);
     assertEquals(4, laskuri.getPisteet());
     
     laskuri.kasvataPisteitaRiveilla(1);
     assertEquals(44, laskuri.getPisteet());
     
     laskuri.kasvataPisteitaRiveilla(2);
     assertEquals(144, laskuri.getPisteet());
     
     laskuri.kasvataPisteitaRiveilla(3);
     assertEquals(444, laskuri.getPisteet());
     
     laskuri.kasvataPisteitaRiveilla(4);
     assertEquals(1644, laskuri.getPisteet());     
     
     assertEquals(2, laskuri.getTaso());
     }
}