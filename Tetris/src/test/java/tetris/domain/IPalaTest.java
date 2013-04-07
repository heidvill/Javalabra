package tetris.domain;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class IPalaTest {

    private IPala pala;

    public IPalaTest() {
    }

    @Before
    public void setUp() {
        pala = new IPala(20, 20);

    }

    @After
    public void tearDown() {
    }
    
    

    @Test
    public void palaKaantyyOikein() {
        pala.liiku();
        pala.liiku();
        pala.liiku();
        pala.kierraOikealle();
        assertEquals("[(9,2), (10,2), (11,2), (12,2)]", pala.toString());

        pala.kierraOikealle();
        assertEquals("[(10,3), (10,2), (10,1), (10,0)]", pala.toString());
    }
}
