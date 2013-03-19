package tetris.domain;

import tetris.Suunta;

public class OPala extends Pala {

    public OPala(int leveys) {
        super(leveys);
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
