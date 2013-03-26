
package tetris.domain;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TPalaTest {
    private TPala pala;
    
    public TPalaTest() {
    }
    
    @Before
    public void setUp() {
        pala = new TPala(16, 30);
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
        assertEquals("[(8,1), (8,2), (8,3), (9,2)]", pala.toString());
        
        pala.kierraOikealle();
        assertEquals("[(9,2), (8,2), (7,2), (8,3)]", pala.toString());
        
        pala.kierraOikealle();
        assertEquals("[(8,3), (8,2), (8,1), (7,2)]", pala.toString());
        
        pala.kierraOikealle();
        assertEquals("[(7,2), (8,2), (9,2), (8,1)]", pala.toString());
    }
}
