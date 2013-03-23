
package tetris.domain;

import java.awt.Color;

public class TPala extends Pala{
    private Ruutu r1;
    private Ruutu r2;
    private Ruutu r3;
    private Ruutu r4;

    public TPala(int leveys, int korkeus) {
        super(leveys, korkeus);
        vari = Color.ORANGE;
    }

    @Override
    public void kierraOikealle() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void lisaaRuutu() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
