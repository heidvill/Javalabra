package tetris.domain;

import java.awt.Color;
import tetris.Palatyyppi;

/**
 * S:n muotoinen pala, joka perii Pala-luokan
 *
 * @see Pala
 * @author heidvill
 */
public class SPala extends Pala {

    public SPala(int leveys, int korkeus) {
        super(leveys, korkeus);
        vari = Color.BLUE;
        tyyppi = Palatyyppi.S;
        lisaaRuudut();
    }

    @Override
    public void kierraOikealle() {
        if (kaannos == 1) {
            kaannos = 2;
            r4.setXY(r2.getX(), r2.getY());
            r1.setY(r1.getY() - 2);
            r2.setXY(r2.getX() - 1, r2.getY() - 1);
        } else {
            kaannos = 1;
            r1.setY(r1.getY() + 2);
            r2.setXY(r4.getX(), r4.getY());
            r4.setXY(r4.getX() + 1, r4.getY() - 1);
        }
    }

    private void lisaaRuudut() {
        r1 = new Ruutu(leveys / 2 - 1, 0, vari);
        r2 = new Ruutu(leveys / 2, 0, vari);
        r3 = new Ruutu(leveys / 2, -1, vari);
        r4 = new Ruutu(leveys / 2 + 1, -1, vari);
        ruudut.add(r1);
        ruudut.add(r2);
        ruudut.add(r3);
        ruudut.add(r4);
    }
}
