package tetris.domain;

import java.awt.Color;
import java.util.ArrayList;
import tetris.Suunta;

public abstract class Pala {

    protected ArrayList<Ruutu> ruudut;
    protected Suunta suunta;
    protected int leveys;
    protected int kaannos;
    protected int korkeus;
    protected Color vari;
    protected Ruutu r1;
    protected Ruutu r2;
    protected Ruutu r3;
    protected Ruutu r4;

    public Pala(int leveys, int korkeus) {
        ruudut = new ArrayList();
        suunta = Suunta.ALAS;
        this.leveys = leveys;
        this.korkeus = korkeus;
        kaannos = 1;
    }

    public void liiku() {
        if (suunta == Suunta.VASEN) {
            liikuVasemmalle();
        } else if (suunta == Suunta.OIKEA) {
            liikuOikealle();
        } else {
            liikuAlas();
        }
    }

    private void liikuVasemmalle() {
        suunta = Suunta.ALAS;
        if (ruudut.size() < 4) {
            return;
        }
        for (Ruutu ruutu : ruudut) {
            if (ruutu.getX() == 0) {
                return;
            }
        }
        for (Ruutu ruutu : ruudut) {
            ruutu.setX(ruutu.getX() - 1);
        }
    }

    private void liikuOikealle() {
        suunta = Suunta.ALAS;
        if (ruudut.size() < 4) {
            return;
        }
        for (Ruutu ruutu : ruudut) {
            if (ruutu.getX() == leveys - 1) {
                return;
            }
        }
        for (Ruutu ruutu : ruudut) {
            ruutu.setX(ruutu.getX() + 1);
        }
    }

    private void liikuAlas() {
        //tarkista voiko liikkua alaspäin???
        for (Ruutu ruutu : ruudut) {
            if (ruutu.getY() + 1 == korkeus) {
                return;
            }
        }
        for (Ruutu ruutu : ruudut) {
            ruutu.setY(ruutu.getY() + 1);
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

    public Color getVari() {
        return vari;
    }

    public abstract void kierraOikealle();

    public abstract void lisaaRuutu();
}
