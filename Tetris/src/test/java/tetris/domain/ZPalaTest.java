package tetris.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ZPalaTest {

    private ZPala pala;

    public ZPalaTest() {
    }

//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
    @Before
    public void setUp() {
        pala = new ZPala(20);
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
    public void palaKaantyyOikein() {
        pala.kierraOikealle();

        assertEquals("[(10,2), (10,3), (11,1), (11,2)]", pala.toString());
    }
}
