package tetris.peli;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import tetris.Suunta;
import tetris.domain.IPala;
import tetris.domain.OPala;
import tetris.domain.Pala;
import tetris.domain.Palasailio;
import tetris.domain.Ruutu;

public class PeliTest {

    private Peli peli;

    public PeliTest() {
    }

    @Before
    public void setUp() {
        peli = new Peli(10, 5);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void luoPelinOikein() {
        assertEquals(0, peli.getPalasailio().sailionKoko());
        assertEquals(4, peli.getPala().getRuudut().size());
    }

    @Test
    public void taysiRiviHaviaa() {
        Palasailio sailio = peli.getPalasailio();

        sailio.lisaaPala(palaVasempaanReunaan());
        sailio.lisaaPala(palaKeskelle());
        assertEquals(8, peli.getPalasailio().getRuudut().size());

        sailio.lisaaPala(palaOikeaanReunaan());
        assertEquals(12, peli.getPalasailio().getRuudut().size());

        peli.etsiTaysiaRiveja();
        assertEquals(2, peli.getPalasailio().getRuudut().size());
    }

    @Test
    public void palaEiLiikuToisenPalanPaalleOikealle() {
        Palasailio sailio = peli.getPalasailio();
        sailio.lisaaPala(palaOikeaanReunaan());
        sailio.lisaaPala(palaVasempaanReunaan());

        Pala pala = palaMelkeinAlhaalla();
        assertEquals("[(4,2), (5,2), (6,2), (7,2)]", pala.toString());

        assertTrue(!pala.osuuOikealleRuutuun(sailio));

        pala.liiku();
        pala.setSuunta(Suunta.OIKEA);
        pala.liiku();

        assertTrue(pala.osuuOikealleRuutuun(sailio));
    }

    @Test
    public void palaEiLiikuToisenPalanPaalleVasemmalle() {
        Palasailio sailio = peli.getPalasailio();
        sailio.lisaaPala(palaOikeaanReunaan());
        sailio.lisaaPala(palaVasempaanReunaan());

        Pala pala = palaMelkeinAlhaalla();
        pala.liiku();
        assertTrue(!pala.osuuVasemmalleRuutuun(sailio));

        pala.liiku();
        assertTrue(pala.osuuVasemmalleRuutuun(sailio));
    }

    @Test
    public void palaEiLiikuToisenPalanPaalleYlhaalta() {
        Palasailio sailio = peli.getPalasailio();
        sailio.lisaaPala(palaOikeaanReunaan());
        sailio.lisaaPala(palaVasempaanReunaan());

        Pala pala = palaMelkeinAlhaalla();

        pala.liiku();
        assertTrue(!pala.osuuAlasRuutuun(sailio));

        pala.setSuunta(Suunta.VASEN);
        pala.liiku();
        assertTrue(pala.osuuAlasRuutuun(sailio));
    }

    private Pala palaOikeaanReunaan() {
        Pala pala3 = new OPala(10, 5);

        for (int j = 0; j < 5; j++) {
            pala3.setSuunta(Suunta.OIKEA);
            pala3.liiku();
        }
        for (int j = 0; j < 3; j++) {
            pala3.liiku();
        }
        return pala3;
    }

    private Pala palaMelkeinAlhaalla() {
        Pala pala2 = new IPala(10, 5);
        pala2.kierraOikealle();
        int i = 4;
        for (Ruutu ruutu : pala2.getRuudut()) {
            ruutu.setXY(i, 2);
            i++;
        }
        return pala2;
    }

    private Pala palaKeskelle() {
        Pala pala = palaMelkeinAlhaalla();
        pala.liiku();
        pala.liiku();
        return pala;
    }

    private Pala palaVasempaanReunaan() {
        Pala pala1 = new IPala(10, 5);
        pala1.kierraOikealle();
        int i = 0;
        for (Ruutu ruutu : pala1.getRuudut()) {
            ruutu.setXY(i, 4);
            i++;
        }

        return pala1;
    }
}
