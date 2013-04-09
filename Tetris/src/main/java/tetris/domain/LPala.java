package tetris.domain;

import java.awt.Color;
import tetris.Palatyyppi;

/**
 * L:n muotoinen pala, joka perii Pala-luokan.
 *
 * @see Pala
 * @author heidvill
 */
public class LPala extends Pala {

    public LPala(int leveys, int korkeus) {
        super(leveys, korkeus);
        vari = Color.PINK;
        tyyppi = Palatyyppi.L;
        lisaaRuudut();
    }

    @Override
    public void kierraOikealle() {
        if (kaannos == 1) {
            kaannos = 2;
            r4.setX(r4.getX() + 2);
            r3.setXY(r3.getX() + 1, r3.getY() + 1);
            r1.setXY(r1.getX() - 1, r1.getY() - 1);
        } else if (kaannos == 2) {
            kaannos = 3;
            r4.setY(r4.getY() + 2);
            r3.setXY(r3.getX() - 1, r3.getY() + 1);
            r1.setXY(r1.getX() + 1, r1.getY() - 1);
        } else if (kaannos == 3) {
            kaannos = 4;
            r4.setX(r4.getX() - 2);
            r3.setXY(r3.getX() - 1, r3.getY() - 1);
            r1.setXY(r1.getX() + 1, r1.getY() + 1);
        } else {
            kaannos = 1;
            r4.setY(r4.getY() - 2);
            r3.setXY(r3.getX() + 1, r3.getY() - 1);
            r1.setXY(r1.getX() - 1, r1.getY() + 1);
        }
    }

    private void lisaaRuudut() {
        r1 = new Ruutu(leveys / 2, 0, vari);
        r2 = new Ruutu(leveys / 2, -1, vari);
        r3 = new Ruutu(leveys / 2, -2, vari);
        r4 = new Ruutu(leveys / 2 - 1, -2, vari);
        ruudut.add(r1);
        ruudut.add(r2);
        ruudut.add(r3);
        ruudut.add(r4);
    }
}
