package tetris.domain;

import java.awt.Color;

public class LPala extends Pala {

    public LPala(int leveys, int korkeus) {
        super(leveys, korkeus);
        vari = Color.PINK;
    }

    @Override
    public void kierraOikealle() {
        if (onkoNeljaPalaa()) {
            if (kaannos == 1) {
                kaannos = 2;
                r4.setX(r4.getX() + 2);
                r3.setXY(r3.getX() + 1, r3.getY() + 1);
                r1.setXY(r1.getX() - 1, r1.getY() - 1);
            } else if (kaannos == 2) {
                kaannos = 3;
                r4.setY(r4.getY() + 2);
                r3.setXY(r3.getX() - 1, r3.getY() + 1);
                r1.setXY(r1.getX() + 1, r1.getY() - 1);
            } else if (kaannos == 3) {
                kaannos = 4;
                r4.setX(r4.getX() - 2);
                r3.setXY(r3.getX() - 1, r3.getY() - 1);
                r1.setXY(r1.getX() + 1, r1.getY() + 1);
            } else {
                kaannos = 1;
                r4.setY(r4.getY() - 2);
                r3.setXY(r3.getX() + 1, r3.getY() - 1);
                r1.setXY(r1.getX() - 1, r1.getY() + 1);
            }
        }
    }

    @Override
    public void lisaaRuutu() {
        if (ruudut.isEmpty()) {
            r1 = new Ruutu(leveys / 2, 0, vari);
            ruudut.add(r1);
        } else if (ruudut.size() == 1) {
            r2 = new Ruutu(leveys / 2, 0, vari);
            ruudut.add(r2);
        } else if (ruudut.size() < 4) {
            r3 = new Ruutu(leveys / 2, 0, vari);
            r4 = new Ruutu(leveys / 2 - 1, 0, vari);
            ruudut.add(r3);
            ruudut.add(r4);
        }
    }
}
