package tetris.domain;

import java.awt.Color;
import tetris.Palatyyppi;

/**
 * T:n muotoinen pala, joka perii Pala-luokan
 * 
 * @see Pala
 * @author heidvill
 */

public class TPala extends Pala {

    public TPala(int leveys, int korkeus) {
        super(leveys, korkeus);
        vari = Color.ORANGE;
        tyyppi = Palatyyppi.T;
        lisaaRuudut();
    }

    @Override
    public void kierraOikealle() {
        r1.setXY(r4.getX(), r4.getY());
        r4.setXY(r3.getX(), r3.getY());
        if (kaannos == 1) {
            kaannos = 2;
            r3.setXY(r3.getX() - 1, r3.getY() + 1);
        } else if (kaannos == 2) {
            kaannos = 3;
            r3.setXY(r3.getX() - 1, r3.getY() - 1);
        } else if (kaannos == 3) {
            kaannos = 4;
            r3.setXY(r3.getX() + 1, r3.getY() - 1);
        } else {
            kaannos = 1;
            r3.setXY(r3.getX() + 1, r3.getY() + 1);
        }
    }

    private void lisaaRuudut() {
        r1 = new Ruutu(leveys / 2 - 1, 0, vari);
        r2 = new Ruutu(leveys / 2, 0, vari);
        r3 = new Ruutu(leveys / 2 + 1, 0, vari);
        r4 = new Ruutu(leveys / 2, -1, vari);
        ruudut.add(r1);
        ruudut.add(r2);
        ruudut.add(r3);
        ruudut.add(r4);
    }
}
