package tetris.domain;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SPalaTest {

    private SPala pala;

    public SPalaTest() {
    }

    @Before
    public void setUp() {
        pala = new SPala(20, 30);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void palaOikein() {
        assertEquals("[(9,0), (10,0), (10,-1), (11,-1)]", pala.toString());
    }

    @Test
    public void palaKaantyyOikein() {
        
        pala.liiku();
        pala.liiku();
        pala.kierraOikealle();
        assertEquals("[(9,0), (9,1), (10,1), (10,2)]", pala.toString());

        pala.kierraOikealle();
        assertEquals("[(9,2), (10,2), (10,1), (11,1)]", pala.toString());
    }
}
