package tetris.domain;

import java.util.ArrayList;
import tetris.Suunta;

public class ZPala extends Pala {

    private Suunta suunta;
    private ArrayList<Ruutu> ruudut;
    private int leveys;
    private Ruutu r1;
    private Ruutu r2;
    private Ruutu r3;
    private Ruutu r4;
    private boolean kaantynyt;
    
    public ZPala(int leveys) {
        ruudut = new ArrayList();
        suunta = Suunta.ALAS;
        this.leveys = leveys;
        kaantynyt = false;
        lisaaRuutu();
    }

    @Override
    public void liiku() {
        if (suunta == Suunta.VASEN) {
            for (Ruutu ruutu : ruudut) {
                if (ruutu.getX() == 0) {
                    return;
                }
            }
            for (Ruutu ruutu : ruudut) {
                ruutu.setX(ruutu.getX() - 1);
            }
            suunta = Suunta.ALAS;
        } else if (suunta == Suunta.OIKEA) {
            for (Ruutu ruutu : ruudut) {
                if (ruutu.getX() == leveys - 1) {
                    return;
                }
            }
            for (Ruutu ruutu : ruudut) {
                ruutu.setX(ruutu.getX() + 1);
            }
            suunta = Suunta.ALAS;
        } else {
            //tarkista voiko liikka alaspäin???
            for (Ruutu ruutu : ruudut) {
                ruutu.setY(ruutu.getY() + 1);
            }
        }

        lisaaRuutu();

    }

    @Override
    void kierraOikealle() {
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
            
            r3.setX(r3.getX()-1);
            r3.setY(r3.getY()+1);
            
            r4.setX(r4.getX()+2);
            kaantynyt = true;
        }
    }

    @Override
    void lisaaRuutu() {
        if (ruudut.isEmpty()) {
            r1 = new Ruutu(leveys / 2, 0);
            r2 = new Ruutu(leveys / 2 + 1, 0);
            ruudut.add(r1);
            ruudut.add(r2);
        } else if (ruudut.size() < 4) {
            r3 = new Ruutu(leveys / 2, 0);
            r4 = new Ruutu(leveys / 2, 1);
            ruudut.add(r3);
            ruudut.add(r4);
        }

    }

    public Suunta getSuunta() {
        return suunta;
    }

    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }
}
