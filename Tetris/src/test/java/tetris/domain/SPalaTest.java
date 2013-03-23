package tetris.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SPalaTest {

    private SPala pala;

    public SPalaTest() {
    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }

    @Before
    public void setUp() {
        pala = new SPala(20, 30);
        pala.liiku();
        pala.liiku();
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
    public void palaOikein() {
        assertEquals("[(9,2), (10,2), (10,1), (11,1)]", pala.toString());
    }

    @Test
    public void palaKaantyyOikein() {
        pala.kierraOikealle();
        assertEquals("[(9,0), (9,1), (10,1), (10,2)]", pala.toString());
        
        pala.kierraOikealle();
         assertEquals("[(9,2), (10,2), (10,1), (11,1)]", pala.toString());
    }
}
