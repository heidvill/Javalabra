package tetris.domain;

import java.awt.Color;
import java.util.ArrayList;
import tetris.Palatyyppi;
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
    private boolean liikkeessa;
    protected Palatyyppi tyyppi;

    public Pala(int leveys, int korkeus) {
        ruudut = new ArrayList();
        suunta = Suunta.ALAS;
        this.leveys = leveys;
        this.korkeus = korkeus;
        kaannos = 1;
        liikkeessa = true;
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
        if (!onkoVasemmassaReunassa()) {
            for (Ruutu ruutu : ruudut) {
                ruutu.setX(ruutu.getX() - 1);
            }
        }
    }

    private void liikuOikealle() {
        suunta = Suunta.ALAS;
        if (!onkoOikeassaReunassa()) {
            for (Ruutu ruutu : ruudut) {
                ruutu.setX(ruutu.getX() + 1);
            }
        }
    }

    private void liikuAlas() {
        //jos ollaan jo pohjalla
        for (Ruutu ruutu : ruudut) {
            if (ruutu.getY() + 1 == korkeus) {
                liikkeessa = false;
                return;
            }
        }
        for (Ruutu ruutu : ruudut) {
            ruutu.setY(ruutu.getY() + 1);
        }
    }

    public boolean osuuVasemmalleRuutuun(Palasailio sailio) {
        for (Ruutu ruutu : ruudut) {
            if (ruutu.osuuVasemmalleRuutuun(sailio.getRuudut())) {
                return true;
            }
        }
        return false;
    }

    public boolean osuuOikealleRuutuun(Palasailio sailio) {
        for (Ruutu ruutu : ruudut) {
            if (ruutu.osuuOikealleRuutuun(sailio.getRuudut())) {
                return true;
            }
        }
        return false;
    }

    public boolean osuuAlasRuutuun(Palasailio sailio) {
        for (Ruutu ruutu : ruudut) {
            if (ruutu.osuuAlasRuutuun(sailio.getRuudut())) {
                liikkeessa = false;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return ruudut.toString();
    }

    public boolean isLiikkeessa() {
        return liikkeessa;
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


    public boolean onkoOikeassaReunassa() {
        //jos ollaan jo reunassa
        for (Ruutu ruutu : ruudut) {
            if (ruutu.getX() == leveys - 1) {
                liikuAlas();
                return true;
            }
        }
        return false;
    }

    public boolean onkoVasemmassaReunassa() {
        //jos ollaan jo reunassa
        for (Ruutu ruutu : ruudut) {
            if (ruutu.getX() == 0) {
                liikuAlas();
                return true;
            }
        }
        return false;
    }

    public int getKaannos() {
        return kaannos;
    }

    public void setKaannos(int kaannos) {
        this.kaannos = kaannos;
    }

    public Palatyyppi getTyyppi() {
        return tyyppi;
    }
}
