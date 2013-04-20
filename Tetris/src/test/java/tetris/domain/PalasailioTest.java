package tetris.domain;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
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
        assertEquals(4, sailio.getUusiPala().getRuudut().size());

        Pala oPala = new OPala(10, 5);
        sailio.lisaaPala(oPala);
        assertEquals(4, sailio.sailionKoko());
    }

    @Test
    public void palauttaaUudenPalanOikein() {
        Pala uusiPala = sailio.getUusiPala();
        assertEquals(4, uusiPala.getRuudut().size());
    }
    
    @Test
    public void kopioiSeuraavanPalanOikein(){
        for (Palatyyppi tyyppi : Palatyyppi.values()) {
            assertEquals(tyyppi, sailio.kopioiSeuraavaPala(tyyppi).getTyyppi());
        }
    }
}
