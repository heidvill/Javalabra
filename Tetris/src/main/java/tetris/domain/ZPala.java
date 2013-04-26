package tetris.domain;

import java.awt.Color;
import tetris.Palatyyppi;

/**
 * Z:n muotoinen pala, joka perii Pala-luokan.
 *
 * @see Pala
 * @author heidvill
 */
public class ZPala extends Pala {

    public ZPala(int leveys, int korkeus) {
        super(leveys, korkeus);
        vari = Color.GREEN;
        tyyppi = Palatyyppi.Z;
        lisaaRuudut();
    }

    @Override
    public void kierraOikealle() {
        if (kaannos == 2) {
            kaannos = 1;
            r2.setXY(r4.getX(), r4.getY());
            r4.setXY(r4.getX() - 1, r4.getY() - 1);
            r3.setX(r3.getX() - 2);
        } else {
            kaannos = 2;
            r4.setXY(r2.getX(), r2.getY());
            r2.setXY(r2.getX() - 1, r2.getY() + 1);
            r3.setX(r3.getX() + 2);
        }
    }

    /**
     * Luo ruudut palaan oikeisiin koordinaatteihin.
     */
    private void lisaaRuudut() {
        r1 = new Ruutu(leveys / 2, 0, vari);
        r2 = new Ruutu(leveys / 2 + 1, 0, vari);
        r3 = new Ruutu(leveys / 2 - 1, -1, vari);
        r4 = new Ruutu(leveys / 2, -1, vari);
        ruudut.add(r1);
        ruudut.add(r2);
        ruudut.add(r3);
        ruudut.add(r4);
    }
}
