package tetris.domain;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ZPalaTest {

    private ZPala pala;

    public ZPalaTest() {
    }

    @Before
    public void setUp() {
        pala = new ZPala(20, 30);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void palaKaantyyOikein() {
        pala.liiku();
        pala.kierraOikealle();
        assertEquals("[(10,1), (10,2), (11,0), (11,1)]", pala.toString());

        pala.kierraOikealle();
        assertEquals("[(10,1), (11,1), (9,0), (10,0)]", pala.toString());
        assertEquals(4, pala.ruudut.size());
    }
}
