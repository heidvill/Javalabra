package tetris.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import tetris.domain.Pala;
import tetris.domain.Palasailio;
import tetris.domain.Ruutu;
import tetris.gui.Paivitettava;

/**
 * Peli-luokka kokoaa tetriksen kokonaisuudeksi.
 *
 * Peli liikuttaa palaa ja tarkistaa tuleeko täysiä rivejä, jotka pitäisi
 * poistaa.
 *
 * @author heidvill
 */
public class Peli extends Timer implements ActionListener {

    private boolean jatkuu;
    private Paivitettava alusta;
    private Pala pala;
    private Palasailio palasailio;
    private int leveys;
    private int korkeus;

    public Peli(int leveys, int korkeus) {
        super(1000, null);
        palasailio = new Palasailio(leveys, korkeus);
        this.jatkuu = true;
        addActionListener(this);
        setInitialDelay(2000);
        this.pala = palasailio.getUusiPala();
        this.korkeus = korkeus;
        this.leveys = leveys;
    }

    public boolean jatkuu() {
        return jatkuu;
    }

    public void setPiirtoalusta(Paivitettava paivitettava) {
        this.alusta = paivitettava;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//        if (!jatkuu) {
//            return;
//        }
        pala.liiku();
        pala.osuuAlasRuutuun(palasailio);
        if (!pala.isLiikkeessa()) {
            palasailio.lisaaPala(pala);
            pala = palasailio.getUusiPala();
        }
        etsiTaysiaRiveja();
        alusta.paivita();
//        setDelay(1000 / pala.getPituus());
        setDelay(400);
    }

    public Pala getPala() {
        return pala;
    }

    public Palasailio getPalasailio() {
        return palasailio;
    }

    /**
     * Etsii muodostuuko palasäiliön ruuduista täysiä rivejä ja poistaa ne palasäiliöstä.
     * 
     */
    public void etsiTaysiaRiveja() {
        ArrayList<Integer> taydetRivit = new ArrayList<Integer>();
        for (int rivi = 0; rivi < korkeus; rivi++) {
            int ruutuja = 0;
            for (Ruutu ruutu : palasailio.getRuudut()) {
                if (ruutu.getY() == rivi) {
                    ruutuja++;
                }
            }
            if (ruutuja == leveys) {
                taydetRivit.add(rivi);
            }
        }
        palasailio.poistaTaydetRivit(taydetRivit);
    }

    public int getLeveys() {
        return leveys;
    }
}