package tetris.domain;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import tetris.Suunta;

public class PalaTest {

    private Pala oPala;

    public PalaTest() {
    }

    @Before
    public void setUp() {
        oPala = new OPala(20, 30);
        oPala.liiku();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void uudenPalanKoordinaatitOikein() {
        assertEquals(2, oPala.getRuudut().size());
        assertEquals("[(10,0), (9,0)]", oPala.toString());
    }

    @Test
    public void palaLiikkuuAlaspainOikein() {
        oPala.liiku();
        assertEquals(4, oPala.getRuudut().size());
        assertEquals("[(10,1), (9,1), (10,0), (9,0)]", oPala.toString());

        oPala.liiku();
        assertEquals("[(10,2), (9,2), (10,1), (9,1)]", oPala.toString());
    }

    @Test
    public void palaLiikkuuVasemmalle() {
        oPala.liiku();
        oPala.liiku();

        oPala.setSuunta(Suunta.VASEN);
        oPala.liiku();

        assertEquals("[(9,2), (8,2), (9,1), (8,1)]", oPala.toString());

    }

    @Test
    public void palaLiikkuuOikealle() {
        oPala.liiku();
        oPala.liiku();

        oPala.setSuunta(Suunta.OIKEA);
        oPala.liiku();

        assertEquals("[(11,2), (10,2), (11,1), (10,1)]", oPala.toString());

    }

    @Test
    public void palaEiVoiLiikkuaVasemmalle() {
        oPala = new OPala(2, 2);

        oPala.liiku();
        oPala.liiku();
        oPala.setSuunta(Suunta.VASEN);
        oPala.liiku();
        oPala.setSuunta(Suunta.VASEN);
        oPala.liiku();

        assertEquals("[(1,1), (0,1), (1,0), (0,0)]", oPala.toString());
    }

    @Test
    public void palaEiVoiLiikkuaOikealle() {
        oPala = new OPala(2, 2);

        oPala.liiku();
        oPala.liiku();
        oPala.setSuunta(Suunta.OIKEA);
        oPala.liiku();
        oPala.setSuunta(Suunta.OIKEA);
        oPala.liiku();

        assertEquals("[(1,1), (0,1), (1,0), (0,0)]", oPala.toString());
    }
}
