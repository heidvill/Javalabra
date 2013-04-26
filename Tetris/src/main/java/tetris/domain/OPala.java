package tetris.domain;

import java.awt.Color;
import tetris.Palatyyppi;

/**
 * O:n muotoinen pala, joka perii Pala-luokan.
 *
 * @see Pala
 * @author heidvill
 */
public class OPala extends Pala {

    public OPala(int leveys, int korkeus) {
        super(leveys, korkeus);
        vari = Color.YELLOW;
        tyyppi = Palatyyppi.O;
        lisaaRuudut();
    }

    @Override
    public void kierraOikealle() {
    }

    /**
     * Luo ruudut palaan oikeisiin koordinaatteihin.
     */
    private void lisaaRuudut() {
        for (int i = 0; i > -2; i--) {
            ruudut.add(new Ruutu(leveys / 2, i, vari));
            ruudut.add(new Ruutu(leveys / 2 - 1, i, vari));
        }
    }
}
