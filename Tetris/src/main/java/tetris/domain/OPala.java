package tetris.domain;

import java.awt.Color;
import tetris.Palatyyppi;

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

   // @Override
    private void lisaaRuudut() {
        for(int i = 0; i>-2; i--){
            ruudut.add(new Ruutu(leveys / 2, i, vari));
            ruudut.add(new Ruutu(leveys / 2 - 1, i, vari));
        }
    }
}
