package tetris.domain;

import java.awt.Color;

public class IPala extends Pala {

    private Ruutu r1;
    private Ruutu r2;
    private Ruutu r3;
    private Ruutu r4;

    public IPala(int leveys, int korkeus) {
        super(leveys, korkeus);
        vari = Color.CYAN;
    }

    @Override
    public void kierraOikealle() {
        if(kaannos==1){ //käännetään vaakasuuntaan
            kaannos = 2;
            int sar = -1;
            for (Ruutu ruutu : ruudut) {
                ruutu.setXY(ruutu.getX()+sar, r2.getY());
                sar++;
            }
        }else{ //käännetään pystyyn
            kaannos = 1;
            int rivi = 1;
            for (Ruutu ruutu : ruudut) {
                ruutu.setXY(r2.getX(), ruutu.getY()+rivi);
                rivi--;
            }
        }
        
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
            ruudut.add(r4);
        }
    }
}
