package tetris.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;
import tetris.domain.Pala;
import tetris.domain.Palasailio;
import tetris.domain.Ruutu;
import tetris.gui.Paivitettava;

public class Peli extends Timer implements ActionListener {

    private boolean jatkuu;
    private Paivitettava alusta;
    private Pala pala;
    private Palasailio palasailio;
    private Random random;
    private int leveys;
    private int korkeus;

    public Peli(int leveys, int korkeus) {
        super(1000, null);
        palasailio = new Palasailio(leveys, korkeus);
        this.jatkuu = true;
        addActionListener(this);
        setInitialDelay(2000);
        this.random = new Random();
        this.pala = palasailio.getUusiPala(random.nextInt(7));
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
        etsiTaysiaRiveja();
        if (!pala.isLiikkeessa()) {
            palasailio.lisaaPala(pala);
            pala = palasailio.getUusiPala(random.nextInt(7));
        }

        alusta.paivita();
//        setDelay(1000 / pala.getPituus());
        setDelay(300);
    }

    public Pala getPala() {
        return pala;
    }

    public Palasailio getPalasailio() {
        return palasailio;
    }

    public void etsiTaysiaRiveja() {
        ArrayList<Integer> taydetRivit = new ArrayList<Integer>();
        for (int rivi = 0; rivi < korkeus; rivi++) {
            int ruutuja = 0;
            for (Ruutu ruutu : palasailio.getRuudut()) {
                if (ruutu.getY() == rivi) {
                    ruutuja++;
                }
            }
            if(ruutuja==leveys){
                taydetRivit.add(rivi);
            }
        }
        palasailio.poistaTaydetRivit(taydetRivit);
    }
}