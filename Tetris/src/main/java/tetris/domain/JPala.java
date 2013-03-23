package tetris.domain;

import java.awt.Color;

public class JPala extends Pala {
    private Ruutu r1;
    private Ruutu r2;
    private Ruutu r3;
    private Ruutu r4;

    public JPala(int leveys, int korkeus) {
        super(leveys, korkeus);
        vari = Color.MAGENTA;
    }

    @Override
    public void kierraOikealle() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void lisaaRuutu() {
        if(ruudut.isEmpty()){
            r1 = new Ruutu(leveys/2, 0);
            ruudut.add(r1);
        }else if(ruudut.size()==1){
            r2 = new Ruutu(leveys/2, 0);
            ruudut.add(r2);
        } else if(ruudut.size()<4){
            
        }
    }
}
