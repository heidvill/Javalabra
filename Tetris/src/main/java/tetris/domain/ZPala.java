package tetris.domain;

import java.awt.Color;

public class ZPala extends Pala {

    public ZPala(int leveys, int korkeus) {
        super(leveys, korkeus);
        vari = Color.GREEN;
    }

    @Override
    public void kierraOikealle() {
        if (onkoNeljaPalaa()) {
            if (kaannos == 2) {
                if (r1.getX() == 0) {
                    return;
                }
                kaannos = 1;
                r2.setXY(r4.getX(), r4.getY());
                r4.setXY(r4.getX() - 1, r4.getY() - 1);
                r3.setX(r3.getX() - 2);
            } else {
                kaannos = 2;
                r4.setXY(r2.getX(), r2.getY());
                //tarkista osuuko alapuolelle!
                r2.setXY(r2.getX() - 1, r2.getY() + 1);
                r3.setX(r3.getX() + 2);
            }
        }
    }

    @Override
    public void lisaaRuutu() {
        if (ruudut.isEmpty()) {
            r1 = new Ruutu(leveys / 2, 0, vari);
            r2 = new Ruutu(leveys / 2 + 1, 0, vari);
            ruudut.add(r1);
            ruudut.add(r2);
        } else if (ruudut.size() < 4) {
            r3 = new Ruutu(leveys / 2 - 1, 0, vari);
            r4 = new Ruutu(leveys / 2, 0, vari);
            ruudut.add(r3);
            ruudut.add(r4);
        }

    }
}
