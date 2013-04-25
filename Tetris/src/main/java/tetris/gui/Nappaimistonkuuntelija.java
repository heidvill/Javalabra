package tetris.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tetris.Palatyyppi;
import tetris.Suunta;
import tetris.domain.*;
import tetris.peli.Peli;

/**
 * Tetriksen näppäimistönkuuntelija tekee käyttäjän näppäimen painalluksen
 * mukaisen toiminnon.
 *
 * @author heidvill
 */
public class Nappaimistonkuuntelija implements KeyListener {

    private Peli peli;

    public Nappaimistonkuuntelija(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Pala pala = peli.getPala();
        if (!peli.jatkuu()) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                peli.uusiPeli();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (voikoKaantaaOikealle()) {
                pala.kierraOikealle();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (voikoKaantaaVasemmalle()) {
                pala.kierraVasemmalle();
                pala.setSuunta(Suunta.ALAS);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (!pala.osuuVasemmalleRuutuun(peli.getPalasailio())) {
                pala.setSuunta(Suunta.VASEN);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (!pala.osuuOikealleRuutuun(peli.getPalasailio())) {
                pala.setSuunta(Suunta.OIKEA);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            peli.setDelay(50);
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    /**
     * Tekee liikkuvasta palasta kopion, jolla voi testata voiko palaa kääntää.
     *
     * @return kopioitu pala
     */
    private Pala kopioiPala() {
        Pala kopio = null;
        Palatyyppi tyyppi = peli.getPala().getTyyppi();
        int leveys = peli.getLeveys();
        int korkeus = peli.getKorkeus();
        if (tyyppi == Palatyyppi.I) {
            kopio = new IPala(leveys, korkeus);
        } else if (tyyppi == Palatyyppi.J) {
            kopio = new JPala(leveys, korkeus);
        } else if (tyyppi == Palatyyppi.L) {
            kopio = new LPala(leveys, korkeus);
        } else if (tyyppi == Palatyyppi.O) {
            kopio = new OPala(leveys, korkeus);
        } else if (tyyppi == Palatyyppi.S) {
            kopio = new SPala(leveys, korkeus);
        } else if (tyyppi == Palatyyppi.T) {
            kopio = new TPala(leveys, korkeus);
        } else {
            kopio = new ZPala(leveys, korkeus);
        }
        for (int i = 0; i < 4; i++) {
            Ruutu kopionRuutu = kopio.getRuudut().get(i);
            Ruutu palanRuutu = peli.getPala().getRuudut().get(i);

            kopionRuutu.setXY(palanRuutu.getX(), palanRuutu.getY());
        }

        kopio.setKaannos(peli.getPala().getKaannos());

        return kopio;
    }

    /**
     * Tarkistaa voiko palaa kääntää oikealle.
     *
     * @return True, jos palaa voi kääntää. Jos pala menee alueen ulkopuolelle
     * tai osuu muihin paloihin, palautetaan False.
     */
    private boolean voikoKaantaaOikealle() {
        Pala kopio = kopioiPala();
        kopio.kierraOikealle();

        if (!onkoKaantoSallittu(kopio)) {
            return false;
        }
        return true;
    }

    /**
     * Tarkistaa voiko palaa kääntää vasemmalle.
     *
     * @return True, jos palaa voi kääntää. Jos pala menee alueen ulkopuolelle
     * tai osuu muihin paloihin, palautetaan False.
     */
    private boolean voikoKaantaaVasemmalle() {
        Pala kopio = kopioiPala();
        kopio.kierraVasemmalle();
        if (!onkoKaantoSallittu(kopio)) {
            return false;
        }
        return true;
    }

    /**
     * Tarkistaa meneekö pala pelialueen ulkopuolelle tai osuu muihin paloihin.
     *
     * @param kopio pala, jonka sijaintia pelialueella tutkitaan
     * @return True jos palan sijainti on sallittu, False, jos pala on alueen
     * ulkopuolella tai osuu muihin paloihin.
     */
    private boolean onkoKaantoSallittu(Pala kopio) {
        for (Ruutu ruutu : kopio.getRuudut()) {
            if (ruutu.getX() < 0 || ruutu.getX() >= peli.getLeveys()) {
                return false;
            }
        }
        if (kopio.osuuAlasRuutuun(peli.getPalasailio())) {
            return false;
        }
        return true;
    }
}
