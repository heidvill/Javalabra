package tetris.peli;

/**
 * Laskuri pitää kirjaa pisteistä ja tasosta.
 *
 * @author heidvill
 */
public class Pistelaskuri {

    private int pisteet;
    //   private int tasot;
    int riveja;

    public Pistelaskuri() {
        pisteet = 0;
        //       tasot = 0;
        riveja = 0;
    }

    /**
     * Kasvattaa pistemäärää täysien rivien määrän mukaan.
     *
     * @param riveja kertoo monta riviä oli täysi
     */
    public void kasvataPisteitaRiveilla(int riveja) {
        this.riveja += riveja;
        int kerroin = 0;
        if (riveja == 1) {
            kerroin = 40;
        } else if (riveja == 2) {
            kerroin = 100;
        } else if (riveja == 3) {
            kerroin = 300;
        } else if (riveja == 4) {
            kerroin = 1200;
        }
        pisteet += kerroin * getTaso();
        // kasvataTasoja();
    }

    /**
     * Kasvattaa pistemäärää pysähtyneen palan mukaan. Aina kun pala pysähtyy
     * pelialueen pohjalle, siitä saa 4 pistettä.
     */
    public void kasvataPisteitaPalalla() {
        pisteet += 4;
    }

    public int getPisteet() {
        return pisteet;
    }

    /**
     * Taso nousee joka kymmenennen rivin täyttymisen jälkeen
     * @return taso, joka on täysien rivien määrä jaettuna kymmenellä
     */
    public int getTaso() {
        return riveja / 10 + 1;
    }
}
