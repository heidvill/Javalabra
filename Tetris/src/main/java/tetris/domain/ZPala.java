package tetris.domain;


public class ZPala extends Pala {

    private Ruutu r1;
    private Ruutu r2;
    private Ruutu r3;
    private Ruutu r4;
    private boolean kaantynyt;

    public ZPala(int leveys) {
        super(leveys);
        kaantynyt = false;
    }

    @Override
    public void kierraOikealle() {
        if (kaantynyt) {
            if (r1.getX() == 0) {
                return;
            }
            r2.setX(r4.getX());
            r2.setY(r4.getY());

            r4.setX(r4.getX() - 1);
            r4.setY(r4.getY() - 1);

            r3.setX(r3.getX() - 2);

            kaantynyt = false;
        } else {
            r4.setX(r2.getX());
            r4.setY(r2.getY());
            
            //tarkista osuuko alapuolelle!
            r2.setX(r2.getX() - 1);
            r2.setY(r2.getY() + 1);

            r3.setX(r3.getX() + 2);
            kaantynyt = true;
        }
    }

    @Override
    public void lisaaRuutu() {
        if (ruudut.isEmpty()) {
            r1 = new Ruutu(leveys / 2, 0);
            r2 = new Ruutu(leveys / 2 + 1, 0);
            ruudut.add(r1);
            ruudut.add(r2);
        } else if (ruudut.size() < 4) {
            r3 = new Ruutu(leveys / 2 - 1, 0);
            r4 = new Ruutu(leveys / 2, 0);
            ruudut.add(r3);
            ruudut.add(r4);
        }

    }
}
