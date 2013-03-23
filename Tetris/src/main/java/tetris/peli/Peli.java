package tetris.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;
import tetris.domain.IPala;
import tetris.domain.JPala;
import tetris.domain.LPala;
import tetris.domain.Pala;
import tetris.domain.SPala;
import tetris.domain.ZPala;
import tetris.gui.Paivitettava;

public class Peli extends Timer implements ActionListener {

//    private int leveys;
//    private int korkeus;
    private boolean jatkuu;
    private Paivitettava paivitettava;
    private Pala pala;
//    private Omena omena;

    public Peli(int leveys, int korkeus) {
        super(1000, null);

//        this.leveys = leveys;
//        this.korkeus = korkeus;
        this.jatkuu = true;

        addActionListener(this);
        setInitialDelay(2000);
        this.pala = new JPala(leveys / 2, korkeus);
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