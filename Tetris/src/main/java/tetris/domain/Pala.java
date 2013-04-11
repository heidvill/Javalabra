package tetris.domain;

import java.awt.Color;
import java.util.ArrayList;
import tetris.Palatyyppi;
import tetris.Suunta;

/**
 * Tetriksen palan abstraktiluokka, jonka muut palat perivät.
 *
 * @author heidvill
 */
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

    /**
     * Liikuttaa palaa suunnan määräämään suuntaan alas, oikealle tai
     * vasemmalle.
     */
    public void liiku() {
        if (suunta == Suunta.VASEN) {
            liikuVasemmalle();
        } else if (suunta == Suunta.OIKEA) {
            liikuOikealle();
        } else {
            liikuAlas();
        }
    }

    /**
     * Jos palan mikään ruuduista ei ole pelialueen vasemmassa reunassa, niin siirretään palan kaikkia ruutuja yksi askel vasemmalle.
     */
    private void liikuVasemmalle() {
        suunta = Suunta.ALAS;
        if (!onkoVasemmassaReunassa()) {
            for (Ruutu ruutu : ruudut) {
                ruutu.setX(ruutu.getX() - 1);
            }
        }
    }

    /**
     * Jos palan mikään ruuduista ei ole pelialueen oikeassa reunassa, niin siirretään palan kaikkia ruutuja yksi askel oikealle.
     */
    private void liikuOikealle() {
        suunta = Suunta.ALAS;
        if (!onkoOikeassaReunassa()) {
            for (Ruutu ruutu : ruudut) {
                ruutu.setX(ruutu.getX() + 1);
            }
        }
    }

    /**
     * Jos mikään palan ruuduista ei ole pelialueen pohjalla, niin siirretään palan kaikkia ruutuja yksi askel alaspäin.
     * Jos jokin pala on pohjalla asetetaan liikkeessä-attribuutille arvo false.
     */
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

    /**
     * Tarkistaa osuuko pala vasemmalla puolella oleviin pysähtyneiden palojen
     * ruutuihin.
     *
     * @param sailio Palasäiliö, josta saadaan pysähtyneet palat
     * @return True, jos pala osuu toi, muuten False
     */
    public boolean osuuVasemmalleRuutuun(Palasailio sailio) {
        for (Ruutu ruutu : ruudut) {
            if (ruutu.osuuVasemmalleRuutuun(sailio.getRuudut())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Tarkistaa osuuko pala oikealla puolella oleviin pysähtyneiden palojen
     * ruutuihin.
     *
     * @param sailio Palasäiliö, josta saadaan pysähtyneet palat
     * @return True, jos pala osuu, muuten False
     */
    public boolean osuuOikealleRuutuun(Palasailio sailio) {
        for (Ruutu ruutu : ruudut) {
            if (ruutu.osuuOikealleRuutuun(sailio.getRuudut())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Tarkistaa osuuko pala alapuolella oleviin pysähtyneiden palojen
     * ruutuihin.
     *
     * Jos pala osuu toiseen ruutuun, niin asetetaan liikkeessä-attribuutin
     * arvoksi false.
     *
     * @param sailio Palasäiliö, josta saadaan pysähtyneet palat
     * @return True, jos pala osuu, muuten False
     */
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

    /**
     * Tarkistaa onko pala oikeassa reunassa.
     *
     * @return True, jos pala on oikeassa reunassa, muuten False
     */
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

    /**
     * Tarkistaa onko pala vasemmassa reunassa.
     *
     * @return True, jos pala on vasemmassa reunassa, muuten False
     */
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
