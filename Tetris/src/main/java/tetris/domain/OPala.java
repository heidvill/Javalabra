package tetris.domain;

import java.util.ArrayList;
import tetris.Suunta;

public class OPala implements Pala {

    ArrayList<Ruutu> ruudut;
    private int leveys;
    private Suunta suunta;

    public OPala() {
        ruudut = new ArrayList();
    }

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
                ruutu.setY(ruutu.getY() - 1);
            }
        }

    }

    public void kierraOikealle() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void lisaaRuutu() {
        if (ruudut.size() < 4) {
            ruudut.add(new Ruutu(leveys / 2, 0));
            ruudut.add(new Ruutu(leveys / 2 - 1, 0));
        }
    }

    public Suunta getSuunta() {
        return suunta;
    }

    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }
}
