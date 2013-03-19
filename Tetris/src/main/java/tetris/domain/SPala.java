package tetris.domain;

public class SPala extends Pala {

    private Ruutu r1;
    private Ruutu r2;
    private Ruutu r3;
    private Ruutu r4;
    private boolean kaantynyt;

    public SPala(int leveys) {
        super(leveys);
        kaantynyt = false;
    }

    @Override
   public void kierraOikealle() {
        if (kaantynyt) {
            if (r1.getX() == 0) {
                return;
            }

            r3.setX(r1.getX());
            r3.setY(r1.getY());

            r1.setX(r1.getX() - 1);
            r1.setY(r1.getY() + 1);

            r4.setX(r4.getX() - 2);
            kaantynyt = false;
        } else {
            r1.setX(r3.getX());
            r1.setY(r3.getY());

            r3.setX(r3.getX() + 1);
            r3.setY(r3.getY() + 1);
             // tarkista osuuko alapuolelle!
            r4.setX(r4.getX() + 2);
            kaantynyt = true;
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
