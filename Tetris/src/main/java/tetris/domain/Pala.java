package tetris.domain;

import java.util.ArrayList;
import tetris.Suunta;

public abstract class Pala {

    protected ArrayList<Ruutu> ruudut;
    protected Suunta suunta;
    protected int leveys;

    public Pala(int leveys) {
        ruudut = new ArrayList();
        suunta = Suunta.ALAS;
        this.leveys = leveys;

        lisaaRuutu();
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
                if (ruutu.getX() == leveys-1) {
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
    public String toString() {
        return ruudut.toString();
    }

    public ArrayList<Ruutu> getRuudut() {
        return ruudut;
    }

    public Suunta getSuunta() {
        return suunta;
    }

    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }

    public abstract void kierraOikealle();

    public abstract void lisaaRuutu();
}
