package tetris.domain;

import java.awt.Color;
import tetris.Palatyyppi;

/**
 * I:n muotoinen pala, joka perii Pala-luokan.
 * 
 * @see Pala
 * @author heidvill
 */

public class IPala extends Pala {

    public IPala(int leveys, int korkeus) {
        super(leveys, korkeus);
        vari = Color.CYAN;
        tyyppi = Palatyyppi.I;
        lisaaRuudut();
    }

    @Override
    public void kierraOikealle() {
        if (kaannos == 1) { //käännetään vaakasuuntaan
            kaannos = 2;
            int sarake = -1;
            for (Ruutu ruutu : ruudut) {
                ruutu.setXY(ruutu.getX() + sarake, r2.getY());
                sarake++;
            }
        } else { //käännetään pystyyn
            kaannos = 1;
            int rivi = 1;
            for (Ruutu ruutu : ruudut) {
                ruutu.setXY(r2.getX(), ruutu.getY() + rivi);
                rivi--;
            }
        }
    }

    private void lisaaRuudut() {
        r1 = new Ruutu(leveys / 2, 0, vari);
        r2 = new Ruutu(leveys / 2, -1, vari);
        r3 = new Ruutu(leveys / 2, -2, vari);
        r4 = new Ruutu(leveys / 2, -3, vari);
        ruudut.add(r1);
        ruudut.add(r2);
        ruudut.add(r3);
        ruudut.add(r4);
    }
}
