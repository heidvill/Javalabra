package tetris.domain;

import java.awt.Color;

public class SPala extends Pala {

    public SPala(int leveys, int korkeus) {
        super(leveys, korkeus);
        vari = Color.BLUE;
    }

    @Override
    public void kierraOikealle() {
        if (ruudut.size() < 4) {
            return;
        }
        if (kaannos==1) {
            kaannos = 2;
            //tarkista osuuko oikealle
            r4.setXY(r2.getX(), r2.getY());
            r1.setY(r1.getY() - 2);
            r2.setXY(r2.getX() - 1, r2.getY() - 1);
        } else {
            kaannos = 1;
            r1.setY(r1.getY() + 2);
            r2.setXY(r4.getX(), r4.getY());
            // tarkista osuuko alapuolelle!
            r4.setXY(r4.getX() + 1, r4.getY() - 1);
        }
    }

    @Override
    public void lisaaRuutu() {
        if (ruudut.isEmpty()) {
            r1 = new Ruutu(leveys / 2 - 1, 0);
            r2 = new Ruutu(leveys / 2, 0);
            ruudut.add(r1);
            ruudut.add(r2);
        } else if (ruudut.size() < 4) {
            r3 = new Ruutu(leveys / 2, 0);
            r4 = new Ruutu(leveys / 2 + 1, 0);
            ruudut.add(r3);
            ruudut.add(r4);
        }

    }
}
