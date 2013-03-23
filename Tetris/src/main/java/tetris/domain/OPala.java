package tetris.domain;

import java.awt.Color;

public class OPala extends Pala {

    public OPala(int leveys, int korkeus) {
        super(leveys, korkeus);
        vari = Color.YELLOW;
    }

    public void kierraOikealle() {
           }

    public void lisaaRuutu() {
        if (ruudut.size() < 4) {
            ruudut.add(new Ruutu(leveys / 2, 0));
            ruudut.add(new Ruutu(leveys / 2 - 1, 0));
        }
    }
}
