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
    private Paivitettava paivitettava;
    private Pala pala;
    private Palasailio palasailio;
    private ArrayList<Ruutu> paikoillaanOlevat;
    private Random random;

    public Peli(int leveys, int korkeus) {
        super(1000, null);
        palasailio = new Palasailio(leveys, korkeus);
        paikoillaanOlevat = new ArrayList();
        this.jatkuu = true;
        addActionListener(this);
        setInitialDelay(2000);
        this.random = new Random();
        this.pala = palasailio.getPala(random.nextInt(palasailio.sailionKoko()));
    }

    public boolean jatkuu() {
        return jatkuu;
    }

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!jatkuu) {
            return;
        }
        pala.liiku();
        if (!pala.isLiikkeessa()) {
            for (Ruutu ruutu : pala.getRuudut()) {
                paikoillaanOlevat.add(ruutu);
            }
            pala = palasailio.getPala(random.nextInt(palasailio.sailionKoko()));
        }

//        if (!ruudut.isEmpty()) {
//            for (Ruutu r : pala.getRuudut()) {
//                for (Ruutu ruutu : ruudut) {
//                    if (r.osuuAlas(ruutu)) {
//                        for (Ruutu r1 : pala.getRuudut()) {
//                            ruudut.add(r1);
//                        }
//                        pala = palasailio.getPala(random.nextInt(palasailio.sailionKoko()));
//                    }
//                }
//            }
//        }

        paivitettava.paivita();
//        setDelay(1000 / pala.getPituus());
        setDelay(500);
    }

    public Pala getPala() {
        return pala;
    }

    public void setPala(Pala pala) {
        this.pala = pala;
    }

    public ArrayList<Ruutu> getPaikoillaanOlevat() {
        return paikoillaanOlevat;
    }
}