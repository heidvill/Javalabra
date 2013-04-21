package tetris.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tetris.Palatyyppi;
import tetris.Suunta;
import tetris.domain.*;
import tetris.peli.Peli;

/**
 * Tetriksen näppäimistönkuuntelija tekee käyttäjän näppäimen painalluksen
 * mukaisen toiminnon
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
        if(!peli.jatkuu()){
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                peli.uusiPeli();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (voikoKaantaaOikealle()) {
                pala.kierraOikealle();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            
            pala.setSuunta(Suunta.ALAS);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (!pala.osuuVasemmalleRuutuun(peli.getPalasailio())) {
                pala.setSuunta(Suunta.VASEN);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (!pala.osuuOikealleRuutuun(peli.getPalasailio())) {
                pala.setSuunta(Suunta.OIKEA);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    private Pala kopioiPala() {
        Pala kopio = null;
        Palatyyppi tyyppi = peli.getPala().getTyyppi();
        if (tyyppi == Palatyyppi.I) {
            kopio = new IPala(0, 0);
        } else if (tyyppi == Palatyyppi.J) {
            kopio = new JPala(0, 0);
        } else if (tyyppi == Palatyyppi.L) {
            kopio = new LPala(0, 0);
        } else if (tyyppi == Palatyyppi.O) {
            kopio = new OPala(0, 0);
        } else if (tyyppi == Palatyyppi.S) {
            kopio = new SPala(0, 0);
        } else if (tyyppi == Palatyyppi.T) {
            kopio = new TPala(0, 0);
        } else {
            kopio = new ZPala(0, 0);
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
     * Tarkistaa voiko palaa kääntää oikealle
     * 
     * @return True, jos palaa voi kääntää, jos pala menee alueen ulkopuolelle tai osuu muihin paloihin, palautetaan False
     */
    public boolean voikoKaantaaOikealle() {
        Pala kopio = kopioiPala();
        kopio.kierraOikealle();

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
