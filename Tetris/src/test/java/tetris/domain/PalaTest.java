package tetris.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.Suunta;

public class PalaTest {

    private Pala pala;

    public PalaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pala = new OPala(20);

    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void uudenPalanKoordinaatitOikein() {
        assertEquals(2, pala.getRuudut().size());
        assertEquals("[(10,0), (9,0)]", pala.toString());
    }

    @Test
    public void palaLiikkuuAlaspainOikein() {
        pala.liiku();
        assertEquals(4, pala.getRuudut().size());
        assertEquals("[(10,1), (9,1), (10,0), (9,0)]", pala.toString());
    }

    @Test
    public void palaLiikkuuKaksiKertaa() {
        pala.liiku();
        pala.liiku();
        assertEquals("[(10,2), (9,2), (10,1), (9,1)]", pala.toString());
    }

    @Test
    public void palaLiikkuuVasemmalle() {
        pala.liiku();
        pala.liiku();

        pala.setSuunta(Suunta.VASEN);
        pala.liiku();

        assertEquals("[(9,2), (8,2), (9,1), (8,1)]", pala.toString());

    }

    @Test
    public void palaLiikkuuOikealle() {
        pala.liiku();
        pala.liiku();

        pala.setSuunta(Suunta.OIKEA);
        pala.liiku();

        assertEquals("[(11,2), (10,2), (11,1), (10,1)]", pala.toString());

    }

    @Test
    public void palaEiVoiLiikkuaVasemmalle() {
        pala = new OPala(2);

        pala.liiku();
        pala.setSuunta(Suunta.VASEN);
        pala.liiku();
        pala.setSuunta(Suunta.VASEN);
        pala.liiku();

        assertEquals("[(1,1), (0,1), (1,0), (0,0)]", pala.toString());
    }

    @Test
    public void palaEiVoiLiikkuaOikealle() {
        pala = new OPala(2);

        pala.liiku();
        pala.setSuunta(Suunta.OIKEA);
        pala.liiku();
        pala.setSuunta(Suunta.OIKEA);
        pala.liiku();

        assertEquals("[(1,1), (0,1), (1,0), (0,0)]", pala.toString());
    }
}
