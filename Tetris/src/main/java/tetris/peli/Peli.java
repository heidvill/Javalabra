package tetris.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import tetris.domain.Pala;
import tetris.domain.Palasailio;
import tetris.gui.Paivitettava;

public class Peli extends Timer implements ActionListener {

//    private int leveys;
//    private int korkeus;
    private boolean jatkuu;
    private Paivitettava paivitettava;
    private Pala pala;
    private Palasailio palasailio;
//    private Omena omena;

    public Peli(int leveys, int korkeus) {
        super(1000, null);
        palasailio = new Palasailio(leveys, korkeus);
        
//        this.leveys = leveys;
//        this.korkeus = korkeus;
        this.jatkuu = true;

        addActionListener(this);
        setInitialDelay(2000);
        Random r = new Random();
        this.pala = palasailio.getPala(r.nextInt(palasailio.sailionKoko()));
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
//        if (pala.osuu(omena)) {
//            pala.kasva();
//            omena = new Omena(new Random().nextInt(leveys), new Random().nextInt(korkeus));
//        }
//        if (pala.osuuItseensa()) {
//            jatkuu = false;
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

//    public Omena getOmena() {
//        return omena;
//    }

//    public void setOmena(Omena omena) {
//        this.omena = omena;
//    }
}