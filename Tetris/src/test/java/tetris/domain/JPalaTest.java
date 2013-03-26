
package tetris.domain;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class JPalaTest {
    private JPala pala;
    
    public JPalaTest() {
    }

    @Before
    public void setUp() {
        pala = new JPala(20, 20);
        pala.liiku();
        pala.liiku();
        pala.liiku();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void palaKaantyyOikein(){
        pala.kierraOikealle();
        assertEquals("[(9,1), (10,1), (11,1), (11,2)]", pala.toString());
        
        pala.kierraOikealle();
        assertEquals("[(10,0), (10,1), (10,2), (9,2)]", pala.toString());
        
        pala.kierraOikealle();
        assertEquals("[(11,1), (10,1), (9,1), (9,0)]", pala.toString());
        
        pala.kierraOikealle();
        assertEquals("[(10,2), (10,1), (10,0), (11,0)]", pala.toString());        
    }
}
