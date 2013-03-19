package tetris.domain;

import com.sun.imageio.spi.RAFImageInputStreamSpi;

public class IPala extends Pala {

    private Ruutu r1;
    private Ruutu r2;
    private Ruutu r3;
    private Ruutu r4;
    private boolean kaantynyt;

    public IPala(int leveys) {
        super(leveys);
        kaantynyt = false;
    }

    @Override
    public void kierraOikealle() {
        
    }

    @Override
    public void lisaaRuutu() {
       if(ruudut.isEmpty()){
            r1 = new Ruutu(leveys/2, 0);
            ruudut.add(r1);
        } else if (ruudut.size()==1){
            r2 = new Ruutu(leveys/2, 0);
            ruudut.add(r2);
        } else if(ruudut.size()==2){
            r3 = new Ruutu(leveys/2, 0);
            ruudut.add(r3);
        } else if(ruudut.size()==3){
            r4 = new Ruutu(leveys/2, 0);
        }
    }
}
